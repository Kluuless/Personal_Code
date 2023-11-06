import tkinter as tk

#make a window
win = tk.Tk()
win.geometry("400x300")
win.title("This is the heading")
win.resizable(False,False)

#Text on the screen
label = tk.Label(win, text="This is a label!")
label.place(x=50,y=120) #reminder that x=0,y=0 is at the top left corner of the window
label.configure(font=("Comic Sans MS",15,"bold"))

#function that the button will call
#cannot have values passed in!
def buttonFn():
    win.title("Button was pressed!")
    label.configure(text="You pressed the button...")

#button
button = tk.Button(win, text="Button!", command=buttonFn)
button.place(x=100,y=2)

#image
img = tk.Label(win)
img.place(x=50,y=50)
photo_img = tk.PhotoImage(file="ShinyRowlet.png")
img.configure(image=photo_img)
