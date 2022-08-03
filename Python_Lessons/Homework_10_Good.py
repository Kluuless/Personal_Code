#totals up orders for ice cream
def iceCreamShop():
    #initialize the variables
    order = ""
    total = 0

    #loop to keep prompting user for orders
    while order != "X" and order != "x":
        #ask the user for what flavor to order
        order = input("What flavor would you like to order (type X to stop)? ")

        #adds the correct price to the total
        if order == "Vanilla": total += 5
        elif order == "Chocolate": total += 6
        elif order == "Mint Chocolate Chip": total += 6
        elif order == "Strawberry": total += 5
        elif order == "Rainbow Sherbert": total += 8
        elif order == "Superman": total += 8
        elif order == "Rocky Road": total += 7
        elif order == "Mango": total += 6
        elif order != "X" and order != "x": print("Unknown flavor. $0 added to the total.")

        #notifies the user of successful order and total after order
        if order == "Vanilla" or order == "Chocolate" or \
           order == "Mint Chocolate Chip" or order == "Strawberry" or \
           order == "Rainbow Sherbert" or order == "Superman" or \
           order == "Rocky Road" or order == "Mango":
            print("Order added. Total value is $" + str(total) + ".")

    #gives the user the final, total cost
    return total
