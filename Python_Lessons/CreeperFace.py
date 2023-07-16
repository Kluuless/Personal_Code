import turtle

t = turtle.Turtle()
s = turtle.getscreen()
s.colormode(255)

ps = 35 #ps stands for pixel size

t.pu()
t.right(90)
t.forward(ps*4)
t.right(90)
t.forward(ps*4)
t.right(180)
t.pd()

t.fillcolor(29,181,60)
t.begin_fill()
for i in range(4):
    t.forward(ps*8)
    t.left(90)
t.end_fill()
t.forward(ps)
t.fillcolor("black")
t.begin_fill()
for i in range(4):
    t.forward(ps*2)
    if (i == 0 or i == 3):
        t.left(90)
    else:
        t.right(90)
t.forward(ps)
t.left(90)
t.forward(ps*4)
t.left(90)
t.forward(ps)
t.right(90)
t.forward(ps*3)
for i in range(8):
    if i < 3 or i > 4:
        t.right(90)
    t.forward(ps*2)
t.forward(ps)
t.right(90)
t.forward(ps)
t.left(90)
t.forward(ps*4)
t.end_fill()











