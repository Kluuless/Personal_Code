from tkinter import *

win = Tk()
win.geometry("270x160")
win.title("Distance Calculator")

###~~~~~ENTRIES~~~~~##
#Velocity
velLabel = Label(win, text="Initial Velocity (ft/s):")
velLabel.place(x=10,y=10)

velEntry = Entry(win)
velEntry.place(x=125,y=10)
velEntry.insert(0,"0")

#Acceleration
accelLabel = Label(win, text="Acceleration (ft/s/s):")
accelLabel.place(x=10,y=30)

accelEntry = Entry(win)
accelEntry.place(x=125,y=30)
accelEntry.insert(0,"-32.152")

#Time Elapsed
timeLabel = Label(win, text="Time Elapsed (s):")
timeLabel.place(x=10,y=50)

timeEntry = Entry(win)
timeEntry.place(x=125,y=50)
timeEntry.insert(0,"0")

##~~~~~RESULTS~~~~~##
#Distance
distResult = Label(win,text="0.0 ft")
distResult.place(x=110,y=110)

#Final Velocity
velResult = Label(win,text="0.0 ft/s")
velResult.place(x=90,y=130)

def get():
    accel = accelEntry.get()
    vel = velEntry.get()
    time = timeEntry.get()
    try:
        accel = eval(accel)
        vel = eval(vel)
        time = eval(time)
        distance = vel*time + 0.5*accel*time*time
        distResult.config(text=str(round(distance,3))+" ft")
        finalVel = accel*time + vel
        velResult.config(text=str(round(finalVel,3))+" ft/s")
    except:
        result.config(text="Please enter a number.")

##~~~~~Key Binding~~~~~##
def getEvent(event):
    get()

win.bind("<Return>",getEvent)

button = Button(win,text="Calculate!",command=get)
button.place(x=100,y=80)

distResultLabel = Label(win, text="Distance Traveled:")
distResultLabel.place(x=10,y=110)

velResultLabel = Label(win, text="Final Velocity:")
velResultLabel.place(x=10,y=130)

win.mainloop()
