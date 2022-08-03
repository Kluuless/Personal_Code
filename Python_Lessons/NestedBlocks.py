def addnumbers():
    total = 0
    while True:
        number = input()
        if 'x' == number or 'X' == number:
            return total
        else:
            number = int(number)
            total += number

def menu(dish, topping1, topping2):
    total = 0
    if dish == "Pizza":
        if topping1 == "Pepperoni": total += 3
        elif topping1 == "Sausage": total += 2
        else: total += 2
        if topping2 == "Pepperoni": total += 3
        elif topping2 == "Sausage": total += 2
        else: total += 2
        total += 15
    else:
        if topping1 == "Ketchup": total += 1
        elif topping1 == "Mustard": total += 1
        else: total += 2
        if topping2 == "Ketchup": total += 1
        elif topping2 == "Mustard": total += 1
        else: total += 2
        total += 3
    return total
