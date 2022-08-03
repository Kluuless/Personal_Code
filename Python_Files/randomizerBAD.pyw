from tkinter import *
import os
import random
files = os.listdir("randomlists/")
win = Tk()
win.geometry("225x100")
win.title("File List Randomizer")
filenamelabel = Label(win, text="File Name:")
filenamelabel.place(x=10,y=10)
sVar = StringVar(win)
sVar.set(files[0])
filenamemenu = OptionMenu(win, sVar, *files)
filenamemenu.place(x=75,y=5)
result = Label(win,text="")
result.place(x=80,y=70)
def get():
    try:
        file = open("randomlists\\" + sVar.get(),"r")
        choices = file.read()
        choices = choices.split("\n")
        result.config(text=choices[random.randint(0,len(choices)-1)])
        file.close()
    except:
        result.config(text="File not found.")
win.bind("<Return>", lambda x : get())
button = Button(win,text="Choose One!",command=get)
button.place(x=65,y=40)
resultlabel = Label(win, text="The result is: ")
resultlabel.place(x=10,y=70)
win.mainloop()
