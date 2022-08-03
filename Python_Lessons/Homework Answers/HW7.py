def menu(item1, item2, drink):
    total = 0
    if item1 == "Fried Rice":
        total += 10
    elif item1 == "Orange Chicken":
        total += 12
    elif item1 == "Lo Mein":
        total += 11
    elif item1 == "Egg Rolls":
        total += 8
    elif item1 == "Peking Duck":
        total += 19
    else:
        print("Unknown item 1.")
    if item2 == "Fried Rice":
        total += 10
    elif item2 == "Orange Chicken":
        total += 12
    elif item2 == "Lo Mein":
        total += 11
    elif item2 == "Egg Rolls":
        total += 8
    elif item2 == "Peking Duck":
        total += 19
    elif item2 == "None":
        total += 0
    else:
        print("Unknown item 2.")
    if drink == "Water":
        total += 1
    elif drink == "Fountain Drink":
        total += 2
    elif drink == "Homemade Lemonade":
        total += 2
    elif drink == "Strawberry Banana Smoothie":
        total += 3
    elif drink == "Watermelon Smoothie":
        total += 3
    elif drink == "None":
        total += 0
    else:
        print("Unknown drink.")
    return total

def menuSecretAnswer(item1, item2, drink):
    menuItems = {"Fried Rice":10, "Orange Chicken":12, "Lo Mein":11, \
                 "Egg Rolls":8, "Peking Duck":19}
    drinks = {"Water":1, "Fountain Drink":2, "Homemade Lemonade":2, \
              "Strawberry Banana Smoothie":3, "Watermelon Smoothie":3}

    total = 0
    if item1 in menuItems.keys():
        total += menuItems[item1]
    else:
        print("Unknown item 1.")
    if item2 in menuItems.keys() or item2 == "None":
        total += menuItems.get(item2,0)
    else:
        print("Unknown item 2.")
    if drink in drinks.keys() or drink == "None":
        total += drinks.get(drink,0)
    else:
        print("Unknown drink.")
    return total

def numbers(num1, num2):
    result = ""
    if num2 - num1 >= 5:
        result += "bigger"
    if num2 == num1 * 2:
        result += "double"
    if num2 - num1 < 10 and num2 - num1 > 0:
        result += "close"
    if (num2 - 2) % num1 == 0:
        result += "twoPlus"
    return result

def worth(coin1, coin2, coin3, coin4, coin5):
    total = 0
    if coin1 == "Penny":
        total += 1
    elif coin1 == "Nickel":
        total += 5
    elif coin1 == "Dime":
        total += 10
    elif coin1 == "Quarter":
        total += 25
    else:
        print("Unknown coin 1.")
    if coin2 == "Penny":
        total += 1
    elif coin2 == "Nickel":
        total += 5
    elif coin2 == "Dime":
        total += 10
    elif coin2 == "Quarter":
        total += 25
    elif coin2 == "None":
        total += 0
    else:
        print("Unknown coin 2.")
    if coin3 == "Penny":
        total += 1
    elif coin3 == "Nickel":
        total += 5
    elif coin3 == "Dime":
        total += 10
    elif coin3 == "Quarter":
        total += 25
    elif coin3 == "None":
        total += 0
    else:
        print("Unknown coin 3.")
    if coin4 == "Penny":
        total += 1
    elif coin4 == "Nickel":
        total += 5
    elif coin4 == "Dime":
        total += 10
    elif coin4 == "Quarter":
        total += 25
    elif coin4 == "None":
        total += 0
    else:
        print("Unknown coin 4.")
    if coin5 == "Penny":
        total += 1
    elif coin5 == "Nickel":
        total += 5
    elif coin5 == "Dime":
        total += 10
    elif coin5 == "Quarter":
        total += 25
    elif coin5 == "None":
        total += 0
    else:
        print("Unknown coin 5.")
    return total

def worthSecretAnswer(coin1, coin2, coin3, coin4, coin5):
    coinWorth = {"Penny":1, "Nickel":5, "Dime":10, "Quarter":25}
    coins = [coin1,coin2,coin3,coin4,coin5]
    total = 0
    for coin in range(len(coins)):
        if coins[coin] in coinWorth.keys() or (coin != 0 and coins[coin] == "None"):
            total += coinWorth.get(coins[coin],0)
        else:
            print("Unknown coin " + str(coin + 1) + ".")
    return total
