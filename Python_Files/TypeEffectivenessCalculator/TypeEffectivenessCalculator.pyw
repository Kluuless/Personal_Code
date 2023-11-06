from Types import getEffectiveness,types
import tkinter

#Main Window
win = tkinter.Tk()
win.geometry("420x210")
win.title("Pokemon Type Effectiveness")
win.tk_setPalette(background="white",activeBackground="lightgray")

#Initialize Option Menu Options
types1_str = ["Bug","Dark","Dragon","Electric","Fairy","Fighting","Fire",\
             "Flying","Ghost","Grass","Ground","Ice","Normal","Poison",\
             "Psychic","Rock","Steel","Water"]
types2_str = types1_str.copy()
types2_str.insert(0,"None")

type1 = tkinter.StringVar(name="Type 1")
type1.set("Normal")
type2 = tkinter.StringVar(name="Type 2")
type2.set("None")

#Type effectiveness color code
color_code = {0.0: "Black", 0.25: "Dark Red", 0.5: "Red", 1.0: "Gray", 2.0: "Green", 4.0: "Light Green"}

#Event that runs (when types are changed)
def checkTypes(*args):
    #reset widgets that change
    type_error.config(text="")
    type1_img_label.place(x=30,y=125)
    type2_img_label.place(x=110,y=125)

    #warn users about possible levitate Pokemon
    if (type1.get(),type2.get()) in levitate_types or \
       (type2.get(),type1.get()) in levitate_types:
            type_error.config(text="If the target Pokemon has the\n'Levitate' ability, Ground-type\neffectiveness will be 0.")
            type1_img_label.place(x=30,y=150)
            type2_img_label.place(x=110,y=150)

    #no Pokemon are two of the same type
    if type1.get() == type2.get():
        type2.set("None")
        type_error.config(text="No Pokemon is two of the same type!")
        type_error.after(5000,checkTypes)

    #update effectiveness numbers
    effectiveness = getEffectiveness(types[type1.get()],None if type2.get()=="None" else types[type2.get()])
    for r in results:
        e = effectiveness[r[0].cget("text")[:-1]]
        r[1].config(text=str(e),fg=color_code[e])

    #update images below type selection
    type1_img = tkinter.PhotoImage(file="imgs/"+type1.get()+".png")
    type1_img_label.configure(image=type1_img)
    type1_img_label.image = type1_img
    type2_img = None if type2.get() == "None" else tkinter.PhotoImage(file="imgs/"+type2.get()+".png")
    type2_img_label.configure(image=type2_img)
    type2_img_label.image = type2_img

#Widgets for choosing types
type1_label = tkinter.Label(win,text="Type 1:")
type1_label.place(x=5,y=5)
type1_menu = tkinter.OptionMenu(win,type1,*types1_str,command=checkTypes)
type1_menu.config(width=25,relief="groove",borderwidth=0,activebackground="lightgray")
type1_menu.config(highlightbackground="black",highlightthickness=1)
type1_menu.place(x=5,y=25)
type2_label = tkinter.Label(win,text="Type 2:")
type2_label.place(x=5,y=55)
type2_menu = tkinter.OptionMenu(win,type2,*types2_str,command=checkTypes)
type2_menu.config(width=25,relief="groove",borderwidth=0,activebackground="lightgray")
type2_menu.config(highlightbackground="black",highlightthickness=1)
type2_menu.place(x=5,y=75)

#Widgets showing images of selected type
type1_img = tkinter.PhotoImage(file="imgs/Normal.png")
type1_img_label = tkinter.Label(win,image=type1_img)
type2_img = None
type2_img_label = tkinter.Label(win,image=type2_img)

#Widgets showing errors or warnings
type_error = tkinter.Label(win,fg="red",width=28,anchor="c")
type_error.place(x=0,y=100)

#Widgets showing type effectiveness
results_label = tkinter.Label(win,text="Move Effectiveness:")
results_label.place(x=260,y=5)
results = []
for i in range(len(types1_str)):
    results.append([tkinter.Label(win,text=types1_str[i]+":",width=7,anchor="e"),
                    tkinter.Label(win,text=""),
                    tkinter.Label(win),None])
    results[i][0].place(x=225+(i//(len(types1_str)//2))*110,y=25+(i%(len(types1_str)//2)*20))
    results[i][1].place(x=280+(i//(len(types1_str)//2))*110,y=25+(i%(len(types1_str)//2)*20))
    results[i][3] = tkinter.PhotoImage(file="imgs/"+types1_str[i]+".png")
    results[i][3] = results[i][3].subsample(3)
    results[i][2].configure(image=results[i][3])
    results[i][2].image = results[i][3]
    results[i][2].place(x=205+(i//(len(types1_str)//2))*110,y=25+(i%(len(types1_str)//2)*20))

#All typings of Pokemon that can have the Levitate ability
levitate_types = (("Ghost","Poison"),("Poison","None"),("Poison","Fairy"),
                  ("Ghost","None"),("Psychic","None"),("Ground","Dragon"),
                  ("Rock","Psychic"),("Ground","Psychic"),("Dragon","Psychic"),
                  ("Steel","Psychic"),("Grass","None"),("Electric","Ghost"),
                  ("Electric","Fire"),("Electric","Water"),("Electric","Ice"),
                  ("Electric","Grass"),("Ghost","Dragon"),("Electric","None"),
                  ("Ice","None"),("Dark","Dragon"),("Bug","Electric"))

checkTypes("")
win.mainloop()
