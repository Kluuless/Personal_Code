### --- BASIC SETUP --- ###
#Import the turtle module
import turtle

#Create the turtle
t = turtle.Turtle()

#Get the screen
s = turtle.getscreen()

#Call s.colormode(255)
s.colormode(255)


### --- BASIC FUNCTIONS --- ###
#Define a function that takes 3 arguments, width, height, and color and draws a
#rectangle with dimensions width x height and has the specified color. If color
#is None, do not set a background color. The outline should match the bg color.
#Call the function rectangle(width, height, color).
def rectangle(width, height, color, bg_color):
    t.setheading(90)
    t.color(color)
    t.fillcolor(bg_color)
    t.pendown()
    

#Define a function that takes 2 arguments, size and color, and draws a circle
#with the specified size and color. Use the built-in turtle circle-drawing
#function.
#Call the function circle(size, color).



### --- BUILDING BLOCKS --- ###
#Using the basic functions, define a function that creates a question mark block
#like the one in question_mark_block.png.
#Call the function question_mark_block(size).


#Using the basic functions (mostly just circles), define a function that creates
#a cloud like the one in cloud.png.


#Do the same thing for all of the other images:
#block
#brick
#bush
#goomba
#mario
#mountain


### --- PUTTING IT TOGETHER --- ###
#Using the building blocks, re-create Mario1-1.png, but without the text at the
#top. You do not need to define a function for this if you don't want to.


def mario(size):
    def send_instructions(instructions):
        actions = {'f': t.forward, 'r': t.right, 'l': t.left, \
                   'b': t.begin_fill, 'e': t.end_fill}
        mem1 = None
        t.begin_fill()
        for c in instructions:
            if mem1 != None:
                actions[mem1](int(c)*(size if mem1=='f' else 90)) 
                mem1 = None
            elif c in 'frl': mem1 = c
            else: actions[c]()
        t.end_fill()
        
    change_color = {'r': lambda : t.fillcolor(216,40,0), \
                    'o': lambda : t.fillcolor(252,152,56), \
                    'b': lambda : t.fillcolor(136,112,0)}
    def tp(x_units,y_units):
        t.penup()
        t.goto(t.xcor()+size*x_units,t.ycor()+size*y_units)
        t.pendown()

    #overalls
    t.setheading(90)
    change_color['r']()
    send_instructions('f8r1f9r1f3l1f1r1f3r1f3l1f1r1f3l1f1r1f4')
    tp(-3,0)
    #right boot (our left side)
    t.setheading(90)
    change_color['b']()
    send_instructions('f2r1f1l1f1r1f1l1f1r1f1r1f1l1f1r1f1r1f1l1f1r1f2l1f1r1f1')
    tp(-1,4)
    #right hand (our left side)
    t.setheading(0)
    change_color['o']()
    send_instructions('f1r1f1l1f1l1f1r1f1l1f1l1f1r1f1l1f2l1f2')
    tp(1,2)
    #right arm (our left side)
    t.setheading(90)
    change_color['b']()
    send_instructions('f1r1f1l1f1r1f5r1f1l1f2r1f1l1f3l1f2r1f1r1f1r1f2r1f1l1f3l1f3r1f1l1f1r1f1r1f1l1f4r1f1l1f1')
    tp(9,-2)
    #buttons
    change_color['o']()
    send_instructions('f1r1f1r1f1r1f1')
    tp(2,1)
    send_instructions('f1l1f1l1f1l1f1')
    tp(4,2)
    #left boot (our right side)
    change_color['b']()
    send_instructions('f1l1f2r1f1l1f3l1f2l1f5')
    tp(0,6)
    #left arm (on left side)
    change_color['b']()
    send_instructions('l1f3l1f5l1f1l1f1r1f1l1f1r1f1l1f3')
    #left hand (on left side)
    change_color['o']()
    send_instructions('f3l1f3l1f3l1f3l1')
    tp(-5,0)
    #head
    send_instructions('r1f1r1f1l1f1r1f1l1f2r1f1r1f3r1f1l1f2r1f2l1f2l1f1r1f1l1f1l1f1r1f1r1f3r1f2r1f1r1f4l1f7l1f1l1f3r1f1r1f1l1f3')
    change_color['b']()
    send_instructions('l1f1l1f2l1f2r1f1l1f2r1f1r1f4r1f1r1f1l1f3')
    tp(-6,0)
    send_instructions('r1f3r1f1r1f1l1f1l1f1r1f1r1f3r1f2l1f1l1f3l1f2l1f3l1f1r1f1')
    #hat
    change_color['r']()
    send_instructions('f1r1f1l1f1r1f5r1f1l1f3r1f1r1f9')
    
def goomba(size):
    t.setheading(225)
    #body
    t.fillcolor(252,188,176) #pinkish color
    t.begin_fill()
    t.circle(size*8,90)
    t.circle(size*4,90)
    t.circle(size*8,90)
    t.end_fill()
    t.penup()
    #move to right foot (our left)
    t.left(90)
    t.forward(size*14)
    t.left(45)
    t.forward(size*2)
    t.right(90)
    t.forward(size*2)
    t.left(120)
    #right foot (our left)
    t.fillcolor("black")
    t.pendown()
    t.begin_fill()
    t.circle(size*4.5,90)
    t.circle(size*2.25,90)
    t.circle(size*4.5,90)
    t.circle(size*2.25,90)
    t.end_fill()
    t.penup()
    #move to left foot (our right)
    t.setheading(0)
    t.forward(size*12)
    t.left(90)
    t.forward(size*0.5)
    t.right(45)
    t.forward(size*3)
    t.left(135)
    #left foot (our right)
    t.pendown()
    t.begin_fill()
    t.circle(size*3,90)
    t.circle(size*1.5,90)
    t.circle(size*3,90)
    t.circle(size*1.5,90)
    t.end_fill()
    t.penup()
    #move to head
    t.right(90)
    t.forward(size*10)
    t.right(90)
    t.forward(size*3.4)
    t.left(135)
    #head
    t.fillcolor(200,76,12) #orangish brownish color
    t.pendown()
    t.begin_fill()
    t.forward(size*6)
    t.circle(size*6,90)
    t.forward(size*6)
    t.circle(size*4,180)
    t.right(45)
    t.forward(size*5.75)
    t.right(45)
    t.circle(size*4,180)
    t.end_fill()
    t.penup()
    #move to left eye (our right)
    t.forward(size)
    t.left(45)
    t.forward(size*12)
    t.left(45)
    #left eye (our right)
    t.fillcolor(252,188,176) #pinkish color
    t.pendown()
    t.begin_fill()
    t.circle(size*3,90)
    t.circle(size*1.5,90)
    t.circle(size*3,45)
    t.end_fill()
    t.fillcolor("black")
    t.penup()
    t.left(55)
    t.forward(size*2.75)
    t.left(80)
    t.pendown()
    t.begin_fill()
    t.circle(size*1.8,90)
    t.circle(size*0.9,90)
    t.circle(size*1.8,45)
    t.end_fill()
    t.penup()
    t.right(125)
    t.forward(size*0.5)
    t.left(35)
    t.forward(size*2.5)
    t.right(90)
    t.fillcolor(252,188,176) #pinkish color
    t.pendown()
    t.begin_fill()
    t.circle(size*3,45)
    t.circle(size*1.5,90)
    t.circle(size*3,90)
    t.end_fill()
    t.penup()
    t.left(80)
    t.forward(size*3.1)
    t.left(55)
    t.fillcolor("black")
    t.pendown()
    t.begin_fill()
    t.circle(size*1.8,45)
    t.circle(size*0.9,90)
    t.circle(size*1.8,90)
    t.end_fill()
    t.penup()
    #move to eyebrow
    t.setheading(90)
    t.forward(size*1.7)
    t.right(90)
    t.forward(size*2.5)
    t.left(180)
    t.pendown()
    #eyebrow
    t.begin_fill()
    t.circle(size*2,37)
    t.forward(size*3.8)
    t.circle(size*-3,72)
    t.forward(size*3.8)
    t.circle(size*2,37)
    t.setheading(270)
    t.forward(size*0.5)
    t.left(90)
    t.circle(size*-2,37)
    t.forward(size*3.75)
    t.circle(size*3,74)
    t.forward(size*3.8)
    t.circle(size*-2.1,38)
    t.end_fill()
    
    

t.speed(6)
t.penup()
t.forward(30)
t.pendown()
t.left(45)
mario(20)
t.penup()
t.goto(-200,200)
t.pendown()
goomba(15)
