#this function asks the user for a number, then tells them if it's even
def even():
    number = int(input("Enter a number. "))
    if number % 2 == 0:
        print("Even!")

#this function asks the user for a number, then tells them if it's even or odd
def evenOrOdd():
    number = int(input("Enter a number. "))
    if number % 2 == 0:
        print("Even!")
    else:
        print("Odd!")

#this function asks the user for a color, then tells them about that color
def color():
    color = input("Type a color! ")
    if color == "Black":
        print("The darkest one!")
    elif color == "White":
        print("The lightest one!")
    elif color == "Orange":
        print("Both a fruit and a color!")
    elif color == "Blue":
        print("The color of the sky and... that’s it!")
    elif color == "Green":
        print("Nature’s color!")
    elif color == "Pink":
        print("Love!")
    elif color == "Red":
        print("Apples, Cherries, and Strawberries!")
    elif color == "Brown":
        print("The soil and... chocolate!")
    elif color == "Purple":
        print("Eggplants, Grapes, and Plums!")
    elif color == "Yellow":
        print("The sun! Also corn and bananas!")
    else:
        print("Unknown color. Try capitalizing the first letter.")
