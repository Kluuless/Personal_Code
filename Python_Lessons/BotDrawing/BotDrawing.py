import tkinter as tk
from random import randint

win = tk.Tk()
win.geometry("800x800")
win.title("Bot Drawing")

tiles = {"Up":tk.PhotoImage(file="Imgs/BotUp.png"),
         "Right":tk.PhotoImage(file="Imgs/BotRight.png"),
         "Down":tk.PhotoImage(file="Imgs/BotDown.png"),
         "Left":tk.PhotoImage(file="Imgs/BotLeft.png"),
         "Black":tk.PhotoImage(file="Imgs/BlackTile.png"),
         "Gray":tk.PhotoImage(file="Imgs/GrayTile.png"),
         "White":tk.PhotoImage(file="Imgs/WhiteTile.png"),
         "Maroon":tk.PhotoImage(file="Imgs/MaroonTile.png"),
         "Red":tk.PhotoImage(file="Imgs/RedTile.png"),
         "Pink":tk.PhotoImage(file="Imgs/PinkTile.png"),
         "Brown":tk.PhotoImage(file="Imgs/BrownTile.png"),
         "Orange":tk.PhotoImage(file="Imgs/OrangeTile.png"),
         "Yellow":tk.PhotoImage(file="Imgs/YellowTile.png"),
         "Green":tk.PhotoImage(file="Imgs/GreenTile.png"),
         "Lime":tk.PhotoImage(file="Imgs/LimeTile.png"),
         "Dark Blue":tk.PhotoImage(file="Imgs/DarkBlueTile.png"),
         "Blue":tk.PhotoImage(file="Imgs/BlueTile.png"),
         "Light Blue":tk.PhotoImage(file="Imgs/LightBlueTile.png"),
         "Purple":tk.PhotoImage(file="Imgs/PurpleTile.png")}

board = []
boardColors = []
for i in range(20):
    board.append([])
    boardColors.append([])
    for j in range(20):
        board[i].append(tk.Button(bd=0,image=tiles["White"]))
        board[i][j].place(x=i*40,y=j*40)
        boardColors[i].append("White")

def changeTile(x,y,color):
    board[x][y].configure(image=tiles[color])
def changeBoardColor(x,y,color):
    boardColors[x][y] = color

changeTile(0,0,"Down")
running = False

class Bot():
    def __init__(self):
        self.x=0
        self.y=0
        self.xBC = 0
        self.yBC = 0
        self.looking="Down"
        self.lookingBC="Down"
        self.color="White"
        self.colorBC="White"
        self.time = 0

    def move(self):
        changeBoardColor(self.xBC,self.yBC,self.colorBC)
        if self.lookingBC == "Up":
            changeBoardColor(self.xBC,(self.yBC+19)%20,"Up")
            self.yBC = (self.yBC+19)%20
        elif self.lookingBC == "Right":
            changeBoardColor((self.xBC+1)%20,self.yBC,"Right")
            self.xBC = (self.xBC+1)%20
        elif self.lookingBC == "Down":
            changeBoardColor(self.xBC,(self.yBC+1)%20,"Down")
            self.yBC = (self.yBC+1)%20
        else:
            changeBoardColor((self.xBC+19)%20,self.yBC,"Left")
            self.xBC = (self.xBC+19)%20
        def tempFunc():
            changeTile(self.x,self.y,self.color)
            if self.looking == "Up":
                changeTile(self.x,(self.y+19)%20,"Up")
                self.y = (self.y+19)%20
            elif self.looking == "Right":
                changeTile((self.x+1)%20,self.y,"Right")
                self.x = (self.x+1)%20
            elif self.looking == "Down":
                changeTile(self.x,(self.y+1)%20,"Down")
                self.y = (self.y+1)%20
            else:
                changeTile((self.x+19)%20,self.y,"Left")
                self.x = (self.x+19)%20
        self.time += 500
        win.after(self.time,tempFunc)

    def turnRight(self):
        if self.lookingBC == "Up":
            self.lookingBC = "Right"
            changeBoardColor(self.xBC,self.yBC,"Right")
        elif self.lookingBC == "Right":
            self.lookingBC = "Down"
            changeBoardColor(self.xBC,self.yBC,"Down")
        elif self.lookingBC == "Down":
            self.lookingBC = "Left"
            changeBoardColor(self.xBC,self.yBC,"Left")
        else:
            self.lookingBC = "Up"
            changeBoardColor(self.xBC,self.yBC,"Up")
        def tempFunc():
            if self.looking == "Up":
                self.looking = "Right"
                changeTile(self.x,self.y,"Right")
            elif self.looking == "Right":
                self.looking = "Down"
                changeTile(self.x,self.y,"Down")
            elif self.looking == "Down":
                self.looking = "Left"
                changeTile(self.x,self.y,"Left")
            else:
                self.looking = "Up"
                changeTile(self.x,self.y,"Up")
        self.time += 250
        win.after(self.time,tempFunc)

    def turnLeft(self):
        if self.lookingBC == "Up":
            self.lookingBC = "Left"
            changeBoardColor(self.xBC,self.yBC,"Left")
        elif self.lookingBC == "Left":
            self.lookingBC = "Down"
            changeBoardColor(self.xBC,self.yBC,"Down")
        elif self.lookingBC == "Down":
            self.lookingBC = "Right"
            changeBoardColor(self.xBC,self.yBC,"Right")
        else:
            self.lookingBC = "Up"
            changeBoardColor(self.xBC,self.yBC,"Up")
        def tempFunc():
            if self.looking == "Up":
                self.looking = "Left"
                changeTile(self.x,self.y,"Left")
            elif self.looking == "Left":
                self.looking = "Down"
                changeTile(self.x,self.y,"Down")
            elif self.looking == "Down":
                self.looking = "Right"
                changeTile(self.x,self.y,"Right")
            else:
                self.looking = "Up"
                changeTile(self.x,self.y,"Up")
        self.time += 250
        win.after(self.time,tempFunc)

    def lookingAt(self):
        if self.lookingBC == "Up": return boardColors[self.xBC][(self.yBC+19)%20]
        elif self.lookingBC == "Right": return boardColors[(self.xBC+1)%20][self.yBC]
        elif self.lookingBC == "Down": return boardColors[self.xBC][(self.yBC+1)%20]
        else: return boardColors[(self.xBC+19)%20][self.yBC]

    def change(self,color):
        if self.lookingBC == "Up": changeBoardColor(self.xBC,(self.yBC+19)%20,color)
        elif self.lookingBC == "Right": changeBoardColor((self.xBC+1)%20,self.yBC,color)
        elif self.lookingBC == "Down": changeBoardColor(self.xBC,(self.yBC+1)%20,color)
        else: changeBoardColor((self.xBC+19)%20,self.yBC,color)
        def tempFunc():
            if self.looking == "Up": changeTile(self.x,(self.y+19)%20,color)
            elif self.looking == "Right": changeTile((self.x+1)%20,self.y,color)
            elif self.looking == "Down": changeTile(self.x,(self.y+1)%20,color)
            else: changeTile((self.x+19)%20,self.y,color)
        self.time += 100
        win.after(self.time,tempFunc)

    def switch(self,color):
        self.colorBC = color
        self.time += 50
        def tempFunc():
            self.color = color
        win.after(self.time,tempFunc)

    def run(bot):
        global running
        # This is where you do the drawing
        # Here are your options:
        # - bot.move(), moves the bot forward 1 tile
        # - bot.turnLeft(), turns the bot left
        # - bot.turnRight(), turns the bot right
        # - bot.lookingAt(), returns the color of the tile in front of the bot
        # - bot.change(color), changes the color of the tile in front of the bot
        # - bot.switch(color), makes it so that when the bot moves, the tile it leaves is a different color
        #####PUT CODE BELOW HERE
        colors = ["Pink","Red","Maroon","Brown","Orange","Yellow","Lime","Green","Dark Blue","Blue","Light Blue","Purple"]
        for c in colors:
            bot.switch(c)
            for i in range(20):
                bot.move()
            bot.turnLeft()
            bot.move()
            bot.turnRight()
        #####PUT CODE ABOVE HERE
        running = False

bot = Bot()

def run(event):
    global running
    if not running:
        running = True
        bot.run()
        
win.bind('<Button-1>',run)

win.mainloop()
