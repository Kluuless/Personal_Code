def menu():
    item1 = input("Enter first item: ")
    item2 = input("Enter second item: ")

    total = 0
    if item1 == "Hot Dog":
        total  += 3
    elif item1 == "Slice of Pizza":
        total += 2
    elif item1 == "Hamburger":
        total += 5
    elif item1 == "Fountain Drink":
        total += 3
    elif item1 == "Water Bottle":
        total += 1
    else:
        print("Unknown first item.")

    if item2 == "Hot Dog":
        total  += 3
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
        print("Unknown second item.")

    print("Order of",item1,"and",item2,"costs $" + str(total))

def menuSecretAnswer():
    item1 = input("Enter first item: ")
    item2 = input("Enter second item: ")
    menu = {"Hot Dog":3, "Slice of Pizza":2, "Hamburger":5,
            "Fountain Drink":3, "Water Bottle":1}
    if item1 not in menu.keys(): print("Unknown first item.")
    else: total += menu[item1]
    if item2 not in menu.keys() and item2 != "None": print("Unknown second item.")
    else: total += menu.get(item2,0)
    print("Order of",item1,"and",item2,"costs $" + str(total))

def zipZapZop(number):
    result = ""
    if number % 3 == 0:
        result += "Zip "
    if number % 4 == 0:
        result += "Zap "
    if number % 5 == 0:
        result += "Zop"
    print(result)
