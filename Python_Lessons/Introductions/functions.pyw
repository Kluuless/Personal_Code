#below are functions with no arguments and no return values
def printHelloWorld():
    print('Hello World!')

def print7():
    print("7")

def printMyName():
    print("Kyle Luu")

#how to call the above functions:
printHelloWorld()
print7()
printMyName()

#below are functions with arguments and no return values
def duplicateTwice(string1):
    print(string1 * 2)

def addNot(string1):
    print(string + "... NOT!")

#how to call the above functions:
duplicateTwice("Hello world!")
duplicateTwice("XO")
addNot("You look great")
addNot("1 + 1 = 11")

#below are functions with both arguments and return values
def addOne(num1):
    return num1 + 1

def plus2mod3(num1):
    return (num1 + 2) % 3

#how to call the above functions:
eight_addOne = addOne(8)
zero_point_five_addOne = addOne(0.5)
three_plus2mod3 = plus2mod3(3)
17_plus2mod3 = plus2mod3(17)
