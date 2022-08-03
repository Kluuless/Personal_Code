import tkinter as Tk

#An Arrow object contains the following attributes:
# - window: the tkinter window that the arrow is on
# - direction: the direction the arrow is facing:
#              0 = up, 1 = right, 2 = down, 3 = left
# - image: the tkinter.PhotoImage object used in the label
# - object: the tkinter.Label object that contains the image
# - coords: the coordinates of the object in the format [x,y]
# - velocity: the speed at which the arrow falls
# - alive: whether the arrow has been destroyed or not

#An Arrow object contains the following methods:
# - __init__(window,direction=0,x=0,velocity=1):
#          initializes all the fields of the Arrow, makes the Label object
# - moveDown():
#          moves the arrow down (distance is dependent on velocity). If the
#          arrow makes it to the bottom of the window, it is destroyed.
# - destroy():
#          destroys the arrow.
global IDs
IDs = 0
timesToTopLine = {}

global dimensions
global updateTime

def updateGlobals(dim, ut):
    global dimensions, updateTime
    dimensions = dim
    updateTime = ut

class Arrow:
    #directions: 0 up, 1 right, 2 down, 3 left
    def __init__(self,window,shrink=3,direction=0,x=0,velocity=1):
        global IDs
        self.window = window
        fileName = "../Resources/Arrows/"
        if direction == 0:
            fileName += "up.png"
        elif direction == 1:
            fileName += "right.png"
        elif direction == 2:
            fileName += "down.png"
        else:
            fileName += "left.png"
        self.image = Tk.PhotoImage(file=fileName)
        self.image = self.image.subsample(shrink,shrink)
        self.object = Tk.Label(window,image=self.image)
        self.direction = direction
        self.coords = [x,0.0]
        self.midY = (225//shrink)//2
        self.velocity = velocity
        self.object.place(x=self.coords[0],y=self.coords[1])
        self.alive = True
        self.id = (IDs := IDs + 1)

    def moveDown(self):
        global score
        if self.coords[1] <= self.window.winfo_height():
            self.coords[1] += self.velocity
            self.midY += self.velocity
            self.object.place(x=self.coords[0],y=self.coords[1])
        else:
            self.destroy()

    def destroy(self):
        global score
        self.object.destroy()
        self.alive = False
