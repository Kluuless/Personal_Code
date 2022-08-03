from tkinter import *
import os
import random

#gets all files in the randomlists directory
files = os.listdir("randomlists/")

#makes the main window
win = Tk()
win.geometry("225x100")
win.title("File List Randomizer")

#makes and places the text before the textbox
filenamelabel = Label(win, text="File Name:")
filenamelabel.place(x=10,y=10)

#makes and places the dropdown menu
sVar = StringVar(win)
sVar.set(files[0])
filenamemenu = OptionMenu(win, sVar, *files)
filenamemenu.place(x=75,y=5)

#output text
result = Label(win,text="")
result.place(x=80,y=70)

#finds the file and picks a random line in it
def get():
    try: #opening the file could throw an exception
        file = open("randomlists\\" + sVar.get(),"r") #opens the file for reading
        choices = file.read() #reads the file
        choices = choices.split("\n") #turns giant string into list, elements separated by newline '\n'
        result.config(text=choices[random.randint(0,len(choices)-1)]) #changes output to be a random element from the list
        file.close() #closes the file
    except: #catches the exception if the file is not found
        result.config(text="File not found.")

#binds the return key to the same function as the button
win.bind("<Return>", lambda x : get())

#binds the button to the get() function and places it
button = Button(win,text="Choose One!",command=get)
button.place(x=65,y=40)

#the widget with the text that reads 'The result is: '
resultlabel = Label(win, text="The result is: ")
resultlabel.place(x=10,y=70)

#runs the main loop
win.mainloop()
