import tkinter as tk
from random import random as rand
from random import randint

window = tk.Tk()
window.geometry("500x300")
window.resizable(False,False)
window.title("Block-Catcher Game")
canvas = tk.Canvas(window,bg="white",height=300,width=500)

scoreLabel = tk.Label(window,text="Score: 0")
scoreLabel.place(x=0,y=280)

bar = canvas.create_rectangle(485,0,495,60,fill="green")
def mouseMove(event): canvas.moveto(bar,485,event.y-30)

score = 0
targets = []
def gameLoop():
    global score,targets
    if rand() < 0.05:
        yCoord = randint(0,290)
        targets.append(canvas.create_rectangle(0,yCoord,10,yCoord+10,fill="red"))
    for target in targets:
        canvas.move(target,5,0)
        barCoords = canvas.coords(bar)
        targetCoords = canvas.coords(target)
        if targetCoords[2]-barCoords[0] in range(0,20) and targetCoords[3]-barCoords[1] in range(0,70):
            canvas.delete(target)
            score += 1
            targets.remove(target)
        if targetCoords[0] >= 500:
            canvas.delete(target)
            score -= 1
            targets.remove(target)
    scoreLabel.configure(text="Score: "+str(score))
    window.after(100,gameLoop)

window.bind('<Motion>',mouseMove)

canvas.pack()
gameLoop()
window.mainloop()
