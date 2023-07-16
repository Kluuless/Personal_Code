import tkinter as tk

global coin,dice,result,range1StringVar,range2StringVar,rangeGenerate,rangeResult,upperBound,lowerBound
result = None
range1StringVar = None
range2StringVar = None
rangeGenerate = None
rangeResult = None
dice = {"d4":None,"d6":None,"d8":None,"d10":None,"d12":None,"d20":None}

def makeWindow():
    global coin,dice,result,range1StringVar,range2StringVar,rangeGenerate,rangeResult,upperBound,lowerBound
    
    win = tk.Tk()
    win.geometry("315x260")
    win.title("Random Number Generator")

    result = tk.Label(font=("Arial",24),width=16)
    result.place(x=2,y=106)
    resultLabel = tk.Label(text="Result:")
    resultLabel.place(x=5,y=105)

    coin = tk.Button(text="Coin Flip",width=42,command=lambda:result.configure(text="Coin Flip not set!",fg="Red"))
    coin.place(x=5,y=5)

    dice["d4"] = tk.Button(text="d4",width=20,command=lambda:result.configure(text="d4 not set!",fg="Red"))
    dice["d4"].place(x=5,y=31)

    dice["d6"] = tk.Button(text="d6",width=20,command=lambda:result.configure(text="d6 not set!",fg="Red"))
    dice["d6"].place(x=5,y=56)

    dice["d8"] = tk.Button(text="d8",width=20,command=lambda:result.configure(text="d8 not set!",fg="Red"))
    dice["d8"].place(x=5,y=81)

    dice["d10"] = tk.Button(text="d10",width=20,command=lambda:result.configure(text="d10 not set!",fg="Red"))
    dice["d10"].place(x=159,y=31)

    dice["d12"] = tk.Button(text="d12",width=20,command=lambda:result.configure(text="d12 not set!",fg="Red"))
    dice["d12"].place(x=159,y=56)

    dice["d20"] = tk.Button(text="d20",width=20,command=lambda:result.configure(text="d20 not set!",fg="Red"))
    dice["d20"].place(x=159,y=81)

    range1Label = tk.Label(text="Lower Bound:")
    range1Label.place(x=5,y=145)
    range1StringVar = tk.StringVar()
    range1StringVar.set("1")
    range1Text = tk.Entry(width=24,textvariable=range1StringVar,justify=tk.CENTER)
    range1Text.place(x=5,y=165)

    range2Label = tk.Label(text="Upper Bound:")
    range2Label.place(x=159,y=145)
    range2StringVar = tk.StringVar()
    range2StringVar.set("100")
    range2Text = tk.Entry(width=24,textvariable=range2StringVar,justify=tk.CENTER)
    range2Text.place(x=159,y=165)

    rangeGenerate = tk.Button(text="Generate From Range",width=42,command=lambda:rangeResult.configure(fg="red",text="Unset from "+str(lowerBound())+" to "+str(upperBound())+"!"))
    rangeGenerate.place(x=5,y=190)

    rangeResult = tk.Label(font=("Arial",24),width=16,justify=tk.CENTER)
    rangeResult.place(x=2,y=216)
    rangeResultLabel = tk.Label(text="Result:")
    rangeResultLabel.place(x=5,y=216)

def bindFunction(button,f):
    global coin,dice,rangeGenerate,result,rangeResult
    if button == "Coin Flip":
        def flip():
            r = f()
            try:
                if r.lower() in ["heads","heads!"]: result.configure(fg="green",text=r)
                elif r.lower() in ["tails","tails!"]: result.configure(fg="red",text=r)
                else: result.configure(fg="red",text="Invalid Result ("+r+")")
            except:
                result.configure(fg="red",text="Invalid Result ("+str(r)+")")
        coin.configure(command=flip)
    elif button in dice.keys():
        def roll():
            maxRoll = int(button[1:])
            r = f()
            try:
                if r==1: result.configure(fg="red",text=str(r))
                elif r in range(2,maxRoll): result.configure(fg="black",text=str(r))
                elif r==maxRoll: result.configure(fg="green",text=str(r))
                else: result.configure(fg="red",text="Invalid Result ("+r+")")
            except:
                result.configure(fg="red",text="Invalid Result ("+str(r)+")")
        while dice[button] == None: pass
        dice[button].configure(command=roll)
    elif button == "Range":
        def roll():
            try:
                minRoll = int(range1StringVar.get())
                maxRoll = int(range2StringVar.get())
                r = None if maxRoll < minRoll else f(minRoll,maxRoll)
                if r==None:
                    rangeResult.configure(fg="red",text="Error: Upper Bound < Lower Bound",font=("Arial",12),width=33)
                    rangeResult.place(x=5,y=235)
                elif r==minRoll: rangeResult.configure(fg="red",text=str(r))
                elif r in range(minRoll+1,maxRoll): rangeResult.configure(fg="black",text=str(r))
                elif r==maxRoll: rangeResult.configure(fg="green",text=str(r))
                else: rangeResult.configure(fg="red",text="Invalid Result ("+r+")")
                if r != None:
                    rangeResult.configure(font=("Arial",24),width=16)
                    rangeResult.place(x=5,y=215)
            except:
                rangeResult.configure(fg="red",text="Error: Upper/Lower Bounds must be Integers")
                rangeResult.configure(font=("Arial",12),width=34)
                rangeResult.place(x=2,y=235)
        rangeGenerate.configure(command=roll)
    else:
        print("Error trying to bind function to button: " + str(button))
