import tkinter as Tk

win = Tk.Tk() #make the window
winSizeX = 400
winSizeY = 150
win.geometry(str(winSizeX) + "x" + str(winSizeY)) #resize using pixel measurements
win.title("Test Title") #sets the title of the window

text1 = Tk.Label(win,text="This is a textbox!") #makes the label
text1.place(x=winSizeX//10,y=winSizeY//3) #places the label at 1/10th of the way in

tbox1 = Tk.Entry(win) #makes the textbox
tbox1.place(x=winSizeX//10,y=winSizeY*2//3) #places the textbox

def getEvent(event): #calls the changeText() function when the key is pressed
    changeText()

def changeText(): #changes the text to match the textbox when function is called
    text1.configure(text=tbox1.get())

button1 = Tk.Button(win,text="This is a button!",command=changeText) #makes the button, calls changeText() when pushed
button1.place(x=winSizeX//2,y=winSizeY//3) #places the button

win.bind("<Return>",getEvent) #binds the return key to the getEvent() key

#runs the main loop
win.mainloop()
