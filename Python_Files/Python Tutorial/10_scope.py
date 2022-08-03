#You can declare a variable at any time without even assigning a value to it.
#Assigning a value to a variable the first time is called initializing it.
#variables only exist in the indent block in which they are made and all
#inner indent block. As soon as the indent block ends, the variable is destroyed
#(the contents can be returned in functions).
#For example,
x = True
if x:
    y = "Hello!"
else:
    z = "Goodbye!"

#In that if statement, x can be accessed anywhere. However, the variable y is
#created in the if part of the if statement and can only be accessed there.
#if the if statement ever goes into the False block, y doesn't exist anymore,
#thus, trying to access the variable y will result in an error. The reverse is
#true for z. Neither y nor z exist outside of the if statement, since they are
#declared in the if statement. For example,
a=3
if (a%2) == 0: #if a is even
    b = a//2
    #c doesn't exist here, but a and b do!
else:
    c = a*2
    #b doesn't exist here, but a and c do!
#b and c don't exist here!

#In order for the example above to have b and c exist outside of the if
#statement and exist in both indent blocks, you must declare them outside of the
#if statement, like the following:
num1 = 14
num2 = 0 #These variables are declared
num3 = 0 #These variables are declared
#the if statement initializes num2 and num3
if str(num1)[0] == "1": #if the first digit is 1
    num3 = eval(str(num1)[1:]) #num3 is the remaining digits if num1
else:
    num2 = eval(str(num1)[1]) #num2 is the first digit of num1

#While the examples have only shown if statements, these also apply to loops and
#functions.

#Functions are a special case, where variables declared outside of their indent
#block cannot easily be accessed. There is a way, and it is through global
#global variables. Global variables exist everywhere in the code, but must be
#identified as global first (using the "global" keyword).

#To use a global variable inside of a function, it also needs to be declared as
#global. This is because if you declare a variable inside of a function that
#shares its name with another variable, future calls of the variable will only
#use the one declared inside the function. Once the function block ends, the one
#declared outside the function is used, as the one inside no longer exists.

#Here's an example of a function that uses global variables and one that doesn't:
not_global = 0 #initializes outer variable to 0
print("not_global before call:",not_global)
def Not_Global():
    not_global = 1 #initializes inner variable to 1
    print("not_global during call:",not_global)
Not_Global() #calls the function
print("not_global after call:",not_global)

global global_var #tells the interpreter to use the global version of global_var
global_var = 0 #initializes the global variable to 0
print("global_var before call:",global_var)
def Global():
    global global_var #tells the function to use the global version of global_var
    global_var = 1 #changes the global variable to 1
    print("global_var during call:",global_var)
Global() #calls the function
print("global_var after call:",global_var)
