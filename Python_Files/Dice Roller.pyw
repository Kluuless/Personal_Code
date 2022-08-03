from tkinter import *
from random import randint

# # # # # # # # # # # # MAIN WINDOW SETUP # # # # # # # # # # # 
win = Tk()
win.title("D&D Dice Roller")
win.geometry("400x255")

# # # # # # # # # # # # DICE BUTTON SETUP # # # # # # # # # # # 
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

###setup for d? dice###
num = Entry(win)
num.config(width=5)
num.place(x=120,y=92)

# # # # # # # # # # # # DICE ROLLER FUNCTION # # # # # # # # # # 
def rollDie():
    global v, result, num, prevRolls, amount, p, a

    for ch in amount.get():
        if ch not in "0123456789":
            error("Please enter a positive integer.")
            return
    if amount.get() == "": amount.insert(0,"1")
    elif eval(amount.get()) > 100 or eval(amount.get()) < 1:
        error("Please enter a number between 1 and 100.")
        return
    elif v.get() == "d?":
        for ch in num.get():
            if ch not in "0123456789":
                error("Please enter a positive integer.")
                return
        if eval(num.get()) < 1:
            error("Please enter a positive integer.")
            return
    for ch in bonus.get():
        if ch not in "0123456789":
            error("Please enter a positive integer.\nUse - bonuses to subtract.")
            return
        
    ###Rolls the dice and totals it###
    die = v.get()[1:]
    if die == "?": die = num.get()
    indRolls = []
    for i in range(int(amount.get())):
        number = randint(1,int(die))
        number2 = 0
        if "no" not in a.get().lower():
            number2 = randint(1,int(die))
        if a.get() == "Advantage": indRolls.append([number,number2]);
        elif a.get() == "Disadvantage": indRolls.append([number,number2]);
        else: indRolls.append(number);
    total = 0
    if a.get() == "Advantage":
        for roll in indRolls:
            if roll[0] > roll[1]: total += roll[0]
            else: total += roll[1]
    elif a.get() == "Disadvantage":
        for roll in indRolls:
            if roll[0] < roll[1]: total += roll[0]
            else: total += roll[1]
    else: total = sum(indRolls)
    oldTotal = 0

    ###makes the string representing the history###
    #display the dice type and amount#
    prevRoll = "[" + amount.get() + "d" + str(die)
    if a.get() != "No Advantage": prevRoll = a.get()[:3] + " " + prevRoll
    if bonus.get() != "":
        oldTotal = total
        total = eval(str(total) + p.get() + bonus.get())
        prevRoll += " " + p.get() + " " + bonus.get()
    prevRoll += "]: " + str(total)

    #display the individual rolls#
    if a.get() == "No Advantage":
        if amount.get() != "1":
            prevRoll += " = (" + str(indRolls)[1:-1] + ")"
        elif bonus.get() != "": prevRoll += " = " + str(indRolls[0])
    elif a.get() == "Advantage":
        prevRoll += " = ("
        for roll in indRolls:
            if roll[0] >= roll[1]: prevRoll += "{*" + str(roll[0]) + "*, " + str(roll[1]) + "}"
            else: prevRoll += "{" + str(roll[0]) + ", *" + str(roll[1]) + "*}"
            prevRoll += ", "
        prevRoll = prevRoll[:-2] + ")"
    else:
        prevRoll += " = ("
        for roll in indRolls:
            if roll[0] <= roll[1]: prevRoll += "{*" + str(roll[0]) + "*, " + str(roll[1]) + "}"
            else: prevRoll += "{" + str(roll[0]) + ", *" + str(roll[1]) + "*}"
            prevRoll += ", "
        prevRoll = prevRoll[:-2] + ")"

    #bonuses#
    if bonus.get() != "":
        prevRoll += " " + p.get() + " " + bonus.get()

    #adds roll to list#    
    prevRolls.append(prevRoll)

    #display the roll, keeps history 14 entries long#
    if len(prevRolls) == 15: prevRolls.pop(0)

    #display the total separately#
    result.config(text="Result: " + str(total),anchor=CENTER)

    #display the history
    hist = ""
    for roll in prevRolls[::-1]: hist += roll + "\n"
    history.config(text=hist)

# # # # # # # # # # # DICE AMOUNT WIDGETS SETUP # # # # # # # # # # # 
amountLabel = Label(win,text="Amount:")
amountLabel.place(x=20,y=11)
amount = Entry(win)
amount.insert(0,"1")
amount.config(width=13)
amount.place(x=75,y=10)

# # # # # # # # # # # # BONUS WIDGETS SETUP # # # # # # # # # # # # #
bonusLabel = Label(win,text="Bonus:")
bonusLabel.place(x=20,y=125)
p = StringVar()
p.set("+")
posOrNeg = OptionMenu(win,p,"+","-")
posOrNeg.place(x=60,y=120)
bonus = Entry(win)
bonus.config(width=5)
bonus.place(x=120,y=125)

# # # # # # # # # # # # ADVANTAGE BUTTONS SETUP # # # # # # # # # # #
a = StringVar()
nadv = Radiobutton(win,text="No Advantage",variable=a,value="No Advantage")
nadv.place(x=20,y=185)
yadv = Radiobutton(win,text="Advantage",variable=a,value="Advantage")
yadv.place(x=20,y=205)
dadv = Radiobutton(win,text="Disadvantage",variable=a,value="Disadvantage")
dadv.place(x=20,y=225)

# # # # # # # # # # # # DICE ROLLER WIDGET SETUP # # # # # # # # # #  
roll = Button(win,text="Roll the dice",command=rollDie)
roll.place(x=20,y=160)
result = Label(win,text="Result: ",anchor=CENTER)
result.place(x=100,y=162)

# # # # # # # # # # # # ROLL HISTORY WIDGET SETUP # # # # # # # # # #
prevRolls = []
historyLabel = Label(win,text="Dice history:")
historyLabel.place(x=180,y=10)
history = Label(win,text="",justify=LEFT)
history.place(x=180,y=35)

# # # # # # # # # # # # HISTORY CLEARING BUTTON # # # # # # # # # # # 
def clearHistory():
    global prevRolls
    prevRolls = []
    history.config(text="")
clearHist = Button(win,text="Clear History",command=clearHistory)
clearHist.place(x=260,y=8)

###Auto-select first option###
d20.select()
nadv.select()

# # # # # # # # # # # # # # # Error Window # # # # # # # # # # # # # #
def error(message=""):
    errWin = Tk()
    errWin.title("Error")
    errLabel = Label(errWin,text=message,justify=CENTER,anchor=CENTER)
    errLabel.pack()
    errWin.geometry(str(len(message)*6//(message.count("\n")+1))+"x"+str(message.count("\n")*20+50))
    rtnBtn = Button(errWin,text="Got it",justify=CENTER,command=errWin.destroy)
    rtnBtn.pack()
    mainloop()

###mainloop()###
mainloop()
