#Example of where print functions can be useful:
def plus1div2(argument):
    result = argument + 1
    result /= 2
    return result

def plus1div2print(argument):
    print("Adding 1 to the argument: ",end="")
    result = argument + 1
    print(result)
    print("Dividing argument by 2: ", end="")
    result /= 2
    print(result)
    return result

def conversionExample():
    print(1 + 1, type(1+1)) # prints 2, an integer
    print(str(1) + str(1), type(str(1) + str(1))) # prints “11”, a string
    print(int(str(1) + str(1)), type(int(str(1) + str(1)))) # prints 11, an integer
