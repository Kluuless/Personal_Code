from tkinter import *
from random import randint

win = Tk()
win.title("D&D Dice Roller")
win.geometry("400x200")

dice = ("d4","d6","d8","d10","d100","d12","d20","d?")
v = StringVar()
v.set("Test")

d4 = Radiobutton(win,text=dice[0],variable=v,value=dice[0])
d4.place(x=20,y=30)
d6 = Radiobutton(win,text=dice[1],variable=v,value=dice[1])
d6.place(x=20,y=50)
d8 = Radiobutton(win,text=dice[2],variable=v,value=dice[2])
d8.place(x=20,y=70)
d10 = Radiobutton(win,text=dice[3],variable=v,value=dice[3])
d10.place(x=20,y=90)
d100 = Radiobutton(win,text=dice[4],variable=v,value=dice[4])
d100.place(x=80,y=30)
d12 = Radiobutton(win,text=dice[5],variable=v,value=dice[5])
d12.place(x=80,y=50)
d20 = Radiobutton(win,text=dice[6],variable=v,value=dice[6])
d20.place(x=80,y=70)
dRand = Radiobutton(win,text=dice[7],variable=v,value=dice[7])
dRand.place(x=80,y=90)

num = Entry(win)
num.config(width=5)
num.place(x=120,y=92)
prevRolls = []

def rollDie():
    global v, result, num, prevRolls, amount, p
    
    die = v.get()[1:]
    if die == "?": die = num.get()
    indRolls = []
    for i in range(int(amount.get())):
        number = randint(1,int(die))
        indRolls.append(number)
    total = sum(indRolls)
    oldTotal = 0
    
    prevRoll = amount.get() + "d" + str(die)
    if bonus.get() != "":
        oldTotal = total
        total = eval(str(total) + p.get() + bonus.get())
        prevRoll += " " + p.get() + " " + bonus.get()

    prevRoll += ": " + str(total)
    
    if amount.get() != "1":
        prevRoll += " = (" + str(indRolls)[1:-1] + ")"
    elif bonus.get() != "": prevRoll += " = " + str(indRolls[0])
    
    if bonus.get() != "":
        prevRoll += " " + p.get() + " " + bonus.get()
        
    prevRolls.append(prevRoll)
    
    if len(prevRolls) == 11: prevRolls.pop(0)
    result.config(text="Result: " + str(total),anchor=CENTER)

    hist = ""
    for roll in prevRolls[::-1]: hist += roll + "\n"
    history.config(text=hist)

amountLabel = Label(win,text="Amount:")
amountLabel.place(x=20,y=11)
amount = Entry(win)
amount.insert(0,"1")
amount.config(width=13)
amount.place(x=75,y=10)

bonusLabel = Label(win,text="Bonus:")
bonusLabel.place(x=20,y=125)
p = StringVar()
p.set("+")
posOrNeg = OptionMenu(win,p,"+","-")
posOrNeg.place(x=60,y=120)
bonus = Entry(win)
bonus.config(width=5)
bonus.place(x=120,y=125)

roll = Button(win,text="Roll the dice",command=rollDie)
roll.place(x=20,y=160)
result = Label(win,text="Result: ",anchor=CENTER)
result.place(x=100,y=162)

historyLabel = Label(win,text="Dice history:")
historyLabel.place(x=180,y=10)
history = Label(win,text="",justify=LEFT)
history.place(x=180,y=35)

def clearHistory():
    global prevRolls
    prevRolls = []
    history.config(text="")

clearHist = Button(win,text="Clear History",command=clearHistory)
clearHist.place(x=260,y=8)

d4.select()

mainloop()
