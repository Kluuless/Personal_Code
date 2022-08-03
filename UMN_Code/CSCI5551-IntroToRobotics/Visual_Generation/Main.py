#!usr/bin/env python3
import rospy

import sys
import tkinter as Tk
import random
import gc
import time
import Arrow
import FileRead
from ScreenCap import checkScreenRegion, setBounds
import laser_interface
import threading

            

#=-=-=-=-=-= ROS CONFIG =-=-=-=-=-=
rospy.init_node("visual_generator")


#=-=-=-=-=-= READ CONFIG FILE =-=-=-=-=-=
configs = FileRead.readFile("config.json")
updateCount = 0

#=-=-=-=-=-= CREATE MAIN WINDOW =-=-=-=-=-=
window = Tk.Tk()
width = configs["width"] #how many arrow-length's worth of pixels for width
height = configs["height"] #how many arrow-length's worth of pixels for height
dimensions = [225*width//configs["shrink"],225*height//configs["shrink"]] #dimensions of the window
window.geometry(str(dimensions[0]) + "x" + str(dimensions[1]))
window.resizable(False, False)
window.title("Arrow Game")

#=-=-=-=-=-=-= MISCELLANEOUS VARIABLES =-=-=-=-=-
global score

xCoords = [] #the possible spawn locations of arrows
for i in range(width):
    xCoords.append(i*(225//configs["shrink"]))
xInUse = []
updateTime = configs["update frequency"] #how often the game updates
Arrow.updateGlobals(dimensions, updateTime)
speed = (configs["speed minimum"],configs["speed maximum"]) #the range of speeds arrows can move in
killWindow = configs["kill bar width"] #how wide the window is to destroy the arrows
global score #the score of the game
score = 0
maxArrows = configs["maximum arrows"] #maximum arrows that can be alive at a time
spawnFreq = (configs["spawn minimum"],configs["spawn maximum"])
game_length = configs["game length"] #the amount of time the game runs for

#=-=-=-=-=-= CREATE CANVAS =-=-=-=-=-=
canvas = Tk.Canvas(window,bg="white",width=dimensions[0],height=dimensions[1])
canvas.place(x=0,y=0)
#Kill line:
bottomLineY = dimensions[1]-50
bottomLine = canvas.create_line(0,bottomLineY,dimensions[0],bottomLineY)
topLineY = bottomLineY-killWindow
topLine = canvas.create_line(0,topLineY,dimensions[0],topLineY)
setBounds(topLineY, bottomLineY)

    
def getTkCoords():
    x = window.winfo_x()
    y = window.winfo_y()
    return (x, y, x+window.winfo_width(), y+window.winfo_height())

#=-=-=-=-=-= Threading speedup? =-=-=-=-=-=
runScreenCap = 0
def doCV():
    global runScreenCap
    while True:
        if runScreenCap > 0:
            checkScreenRegion(getTkCoords())
            runScreenCap -= 1
t = threading.Thread(target=doCV, args=())
t.setDaemon(True)
t.start()

#=-=-=-=-=-= WIDGETS =-=-=-=-=-=
if not configs["hide ui"]:
    scoreLabel = Tk.Label(window, text="Score: 0")
    scoreLabel.place(x=(dimensions[0]-50),y=(dimensions[1]-20))
    timeRemainingLabel = Tk.Label(window, text="Time Remaining: ")
    timeRemainingLabel.place(x=0,y=(dimensions[1]-20))

#=-=-=-=-=-= SPAWN ARROWS =-=-=-=-=-=
arrows = []
def spawnArrow():
    try:   
        xCoord = xCoords[random.randint(0,len(xCoords)-1)]
        xCoords.remove(xCoord)
        xInUse.append(xCoord)
        xInUse.sort()
        arrows.append(Arrow.Arrow(window, configs["shrink"], random.randint(0,3), \
                              xCoord, \
                              random.random()*(speed[1]-speed[0])+speed[0]))
    except ValueError:
        print("too many arrows")

#=-=-=-=-=-= UPDATE FUNCTION =-=-=-=-=-=
startTime = time.time()
last_spawn = 0
next_spawn = startTime + random.randint(spawnFreq[0],spawnFreq[1])/1000
def update():
    global score, last_spawn, next_spawn, updateCount, topLineY, bottomLineY, runScreenCap
    timeRemaining = game_length - (time.time()-startTime)
    if timeRemaining >= 0 and len(arrows) < maxArrows and \
       time.time() >= next_spawn:
        spawnArrow()
        last_spawn = time.time()
        next_spawn = last_spawn +  random.randint(spawnFreq[0],spawnFreq[1])/1000
    if timeRemaining < 0:
        print("Thanks for playing DDR, your score was: ", score)
        exit(0)
    for a in arrows:
        a.moveDown()
        if not a.alive:
            arrows.remove(a)
            xInUse.remove(a.coords[0])
            xCoords.append(a.coords[0])
            score -= 1
    if not configs["hide ui"]: scoreLabel.config(text="Score: " + str(score))
    if not configs["hide ui"] and timeRemaining >= 0:
        timeRemainingLabel.config(text="Time Remaining: " + str(timeRemaining))
    
    #Arrow vision test
    if updateCount % configs['updates_per_capture'] == 0:
        runScreenCap += 1
    
    updateCount += 1
    gc.collect()
    window.after(updateTime,update)

#=-=-=-=-=-= KEYBINDS & ARROW DESTROYING =-=-=-=-=-=
def check(direction):
    global score, xCoords, xInUse,topLineY,bottomLineY
    for a in arrows:
        if a.direction == direction and int(a.midY) in range(topLineY-25,bottomLineY-25):
            xInUse.remove(a.coords[0])
            xCoords.append(a.coords[0])
            a.destroy()
            score += 2
            arrows.remove(a)         
    score -= 1
#keybind section:
window.bind("<Up>", lambda x: check(0))
window.bind("<Right>", lambda x: check(1))
window.bind("<Down>", lambda x: check(2))
window.bind("<Left>", lambda x: check(3))

#Arrow vision test
window.bind("<Enter>, ")

#=-=-=-=-=-= WRAP-UP =-=-=-=-=-=-=
window.after(updateTime,update) #starts the update loop
window.mainloop() #main loop

