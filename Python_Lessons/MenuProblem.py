def menu():
    item1 = input("Enter first item: ")
    item2 = input("Enter second item: ")
    total = 0
    #CODE HERE
    if item1 == "Hot Dog":
        total += 3
    elif item1 == "Slice of Pizza":
        total += 2
    elif item1 == "Hamburger":
        total += 5
    elif item1 == "Fountain Drink":
        total += 3
    elif item1 == "Water Bottle":
        total += 1
    else:
        print("Not on the menu")

    if item2 == "Hot Dog":
        total += 3
    elif item2 == "Slice of Pizza":
        total += 2
    elif item2 == "Hamburger":
        total += 5
    elif item2 == "Fountain Drink":
        total += 3
    elif item2 == "Water Bottle":
        total += 1
    elif item2 == "None":
        total += 0
    else:
        print("Not on the menu")
    print(total)
