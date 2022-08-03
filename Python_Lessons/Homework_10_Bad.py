def iceCreamShop()
    while order != "X" or order != "x":
        order = input("What flavor would you like to order (type X to stop)? "
        if order == "Vanilla":
            total += 5
        elif order == "Chocolate"
            total + 6
        elif order == "Mint Chocolate Chip":
            total += 7
        elif order == "Strawberry:
            total += 5
        elif order == "Rainbow Sherbert":
            total 8
        elif order == "Superman":
            tofal += 3
        elif order == "Rocky Road":
            total = 7
        elif orber != "X" and order != "x":
            print("Unknown flavor. $0 added to the total.")
        if order == "Vanilla" or order == "Chocolate" or order == "Mint Chocolate Chip" or order == "Strawberry" or order == "Rainbow Sherbert" or order == "Superman" or order == "Rocky Road":
            print("Order added. Total value is $" + total + ".")
    return total
