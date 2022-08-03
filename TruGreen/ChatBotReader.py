import tkinter as tk
import os

#ChatBot Data
#By: Kyle Luu

#represents a row in the spreadsheet. Contains a dictionary with the data,
#each column representing a field in the dictionary. Column header of file
#determines the key names.
class ChatData:
    #init using list of column header and list of data (len of both are same)
    def __init__(self, cols, data):
        self.data = {}
        for c in range(len(cols)):
            self.data[cols[c]] = data[c]

    def __repr__(self):
        try: return self.data["ConversationId"]
        except: return self.data[self.data.keys()[0]]

    def __str__(self):
        try: return self.data["ConversationId"] + ": " +\
                    self.data["ChatConversation"]
        except: return self.data[self.data.keys()[0]]

    def __eq__(self,o):
        try: return self.data == o.data
        except: return False

    def __getitem__(self,i):
        return self.data[i]

    def get(self,i):
        try: return self.data[i]
        except: return None

    #formats the data so newlines are added behind all occurrences of
    #"Bot says:" and all "User says:". Also adds a tab behind all
    #occurrences of "User says:". Returns True if successful, False
    #otherwise.
    def format(self):
        try:
            conv = self.data["ChatConversation"]
            conv = conv.replace(" Bot says:","\nBot says:")
            conv = conv.replace(" User says:","\n\tUser says:")
            if conv[:2] == '""': conv = conv[2:]
            if conv[::-1][:2] == ", ": conv = conv[:-2]
            conv = conv.replace('""','"')
            self.data["ChatConversation"] = conv
            return True
        except:
            return False
            
#----- END OF ChatData CLASS DEFINITION -----#

#--- INPUT FILE PARSING (TURN INTO ChatData OBJECTS) ---#
def parseFile(data,inputData):
    #--- FIRST, IT TURNS DATA INTO LIST, EACH ROW OF FILE IS AN ELEMENT ---#
    datalist = [] #holds the list of entries until all have been split
    q = False #if inside pair of quotations
    datum = '' #what has been currently read in the line
    for c in range(len(data)):
        #newlines or commas inside quotes are not delimiters
        if not q and (data[c:c+2] == ',"' or (c == 0 and data[c] == '"')):
            q = True
            datum += ',"'
            c += 1
        elif q and (data[c:c+2] == '",' or data[c:c+2] == '"\n'):
            q = False
            datum += ',"'
            c += 1
        elif not q and data[c] == '\n': #newline not inside quotation pairs
            datalist.append(datum)
            datum = ""
        else: datum += data[c]
    if len(datum) > 0:
        if datum[::-1][0] == '"': datum = datum[:len(datum)-1]
        datalist.append(datum) #if file doesn't end in newline

    #--- SECOND, IT TURNS EACH ELEMENT OF LIST (THE ROWS) INTO ANOTHER ---#
    #--- LIST, EACH ENTRY IS A COLUMN OF CSV FILE.                     ---#
    if len(datalist) == 0: datalist = []
    else:
        for d in range(len(datalist)):
            datum = ""
            row = []
            q = False
            for c in range(len(datalist[d])):
                if not q and (datalist[d][c:c+2] == ',"' or (c == 0 and datalist[d][c] == '"')):
                    q = True
                    row.append(datum)
                    datum = ""
                    c += 1
                elif q and datalist[d][c:c+2] == '""':
                    datum += '"'
                    c += 1
                elif q and (datalist[d][c:c+2] == '",' or data[c:c+2] == '"\n'):
                    q = False
                    row.append(datum)
                    datum = ""
                    c += 1
                elif not q and datalist[d][c] == ',':
                    if len(datum) > 0:
                        if datum[::-1][0] in '",': datum = datum[:len(datum)-1]
                        if datum[:2] == '""': datum = datum[2:]
                    row.append(datum)
                    datum = ""
                else: datum += datalist[d][c]
            if len(datum) > 0:
                if datum[::-1][0] in '",': datum = datum[:len(datum)-1]
                if datum[:2] == '""': datum = datum[2:]
                row.append(datum)
            datalist[d] = row
            

    #--- THIRD, CONVERT ELEMENTS EXCEPT FIRST (THE HEADER) INTO        ---#
    #--- ChatData OBJECTS WITH FORMATTED CONVERSATIONS IF              ---#
    #--- inputData == True. ELSE, TURN INTO DICTIONARY                 ---#
    if inputData:
        for d in range(len(datalist)): #turn into ChatData objects
            try:
                if d != 0: datalist[d] = ChatData(datalist[0],datalist[d])
            except:
                print(datalist[0],datalist[d],len(datalist[0]),len(datalist[d]))
                print("Error:")
                for a in datalist[d][::-1]:
                    print(a)
                print()
        for i in datalist: #formats the conversations
            if type(i) == type(ChatData([],[])):
                i.format()
    else:
        outDict = {}
        for d in range(len(datalist)): #turn into dictionary
            if len(datalist[d]) > 1: outDict[datalist[d][0]] = datalist[d][1]
            else: outDict[datalist[d][0]] = ""
        datalist = outDict
    
    return datalist

#----- GUI CREATION -----#
#--- Variable/Function Declarations ---#
win,inLabel,inText,inError,inData,currentChat,inButton,outLabel = \
    None,None,None,None,None,1,None,None
outText,outError,outData,outButton,forwardButton,previousButton = \
    None,None,None,None,None,None
saveError,IDEntry,ChatConvo,criticalSectionLabel,criticalSectionEntry = \
    None,None,None,None,None
indexEntry,indexTotal,indexButton = None,None,None
def getIn(): pass
def getOut(): pass
def moveChat(forward): pass
def moveTo(): pass

#--- Main GUI Logic ---#
win = tk.Tk()
win.geometry("700x500")
win.title("ChatBot Hand-Off Reader")
win.grid_rowconfigure(0,weight=0)
win.grid_rowconfigure(1,weight=1)
win.grid_rowconfigure(2,weight=0)
win.grid_rowconfigure(3,weight=0)
win.grid_columnconfigure(0,weight=0)
win.grid_columnconfigure(1,weight=1)

inLabel = tk.Label(win,text="Input File:")
inLabel.grid(row=0,column=0,sticky=tk.SW,padx=10)

inText = tk.Entry(win,width=15)
inText.insert(0,"Input File")
inText.grid(row=1,column=0,sticky=tk.NW,padx=11)

inError = tk.Label(win,text="No errors")
inError.place(x=10,y=75)

def getIn(): #Retrieves the input file name
    global inData
    try:
        file = open(inText.get(),"r")
        inData = parseFile(file.read(),True)
        file.close()
        currentChat = 1
        inError.configure(text="File loaded.")
        indexTotal.configure(text="/"+str(len(inData)-1))
        ChatConvo.configure(state="normal")
        ChatConvo.delete(1.0,tk.END)
        ChatConvo.insert(tk.INSERT,inData[currentChat]["ChatConversation"])
        ChatConvo.configure(state="disabled")
        IDEntry.configure(text="Conversation with ID "+inData[currentChat]["ConversationId"]+":")
        indexEntry.delete(0,tk.END)
        indexEntry.insert(0,str(currentChat))
    except FileNotFoundError: inError.configure(text="Loading error.")

inButton = tk.Button(win,text="Load File",width=12,command=getIn)
inButton.place(x=10,y=50)

outLabel = tk.Label(win,text="Output File:")
outLabel.place(x=10,y=100)

outText = tk.Entry(win,width=15)
outText.insert(0,"output.csv")
outText.place(x=10,y=120)

outError = tk.Label(win,text="No errors")
outError.place(x=10,y=170)

def getOut():
    global outData
    file = None
    try:
        file = open(outText.get(),"r")
        outError.configure(text="File loaded.")
    except FileNotFoundError:
        outError.configure(text="File created.")
        outName = outText.get()
        if outName[::-1][:4] != 'vsc.':
            outName += ".csv"
            outText.insert(len(outText.get()),".csv")
        file = open(outName,"x")
        file.close()
        file = open(outName,"r")
    outData = parseFile(file.read(),False)
    criticalSectionEntry.delete(0,tk.END)
    criticalSectionEntry.insert(0,outData.get(inData[currentChat]["ConversationId"],""))
    file.close()

outButton = tk.Button(win,text="Load File",width=12,command=getOut)
outButton.place(x=10,y=145)

def moveChat(forward,save=True):
    global currentChat,inData,outData
    #grab/format critical section
    if (outData,inData) != (None,None):
        critData = criticalSectionEntry.get()
        outData[inData[currentChat]["ConversationId"]] = critData

        #save data
        if save:
            file = None
            try:
                file = open(outText.get(),"w")
                outDataText = ""
                for k in outData.keys():
                    entry = outData[k]
                    if "," in outData[k]:
                        entry.replace('"','""')
                        entry = '"' + entry + '"'
                    outDataText += k + "," + entry + "\n"
                file.write(outDataText[:-1])
                file.close()
                saveError.configure(text="No Errors.")
            except:
                saveError.configure("Error saving to file.")

    #move to next/previous conversation
    if forward: currentChat = (currentChat%(len(inData)-1))+1
    else: currentChat = len(inData)-(((len(inData)-currentChat)%(len(inData)-1))+1)
    indexEntry.delete(0,tk.END)
    indexEntry.insert(0,str(currentChat))
    if inData != None:
        ChatConvo.configure(state="normal")
        ChatConvo.delete(1.0,tk.END)
        ChatConvo.insert(tk.INSERT,inData[currentChat]["ChatConversation"])
        ChatConvo.configure(state="disabled")
        IDEntry.configure(text="Conversation with ID "+inData[currentChat]["ConversationId"]+":")
    criticalSectionEntry.delete(0,tk.END)
    if outData == None: criticalSectionEntry.insert(0,"Output not loaded.")
    else: criticalSectionEntry.insert(0,outData.get(inData[currentChat]["ConversationId"],""))
    

forwardButton = tk.Button(win,text="Next",width=12, \
                       command=(lambda : moveChat(True)))
forwardButton.place(x=10,y=220)

previousButton = tk.Button(win,text="Previous",width=12, \
                           command=(lambda : moveChat(False)))
previousButton.place(x=10,y=245)

saveError = tk.Label(win,text="No Errors")
saveError.place(x=10,y=271)

IDEntry = tk.Label(win,text="Conversation with ID <placeholder>:")
IDEntry.grid(row=0,column=1,sticky=tk.SW,padx=10)

ChatConvo = tk.Text(win,width=70,height=25)
ChatConvo.insert(tk.INSERT,"File not loaded.")
ChatConvo.grid(row=1,column=1,sticky=tk.NSEW,pady=3,padx=10)
ChatConvo.configure(state="disabled")

criticalSectionLabel = tk.Label(win,text="Enter the critical section:")
criticalSectionLabel.grid(row=2,column=1,sticky=tk.SW,padx=10)

criticalSectionEntry = tk.Entry(win,width=94)
criticalSectionEntry.grid(row=3,column=1,sticky=tk.EW,pady=5,padx=10)
criticalSectionEntry.insert(0,"Output not loaded.")

indexEntry = tk.Entry(win,width=7,justify=tk.RIGHT)
indexEntry.place(x=10,y=320)
indexTotal = tk.Label(win,text="/?")
indexTotal.place(x=60,y=320)

def moveTo(idx):
    try:
        target = int(idx)
        while currentChat != target:
            moveChat((target-currentChat+len(inData))%len(inData)<=(len(inData)//2),False)
    except:
        indexEntry.delete(0,tk.END)
        indexEntry.insert(0,currentChat)

indexButton = tk.Button(win,text="Load Entry",width=12,command=(lambda : moveTo(indexEntry.get())))
indexButton.place(x=10,y=345)

win.bind("<Return>",lambda x : moveChat(True,True))

win.mainloop()
