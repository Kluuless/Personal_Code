#functions are a set of code that you can 'define' and use later.
#the syntax is 'def <func_name>(arg1,arg2,...,argx):'
#you can define as many arguments as you want, but there may be memory
#problems if you go above 7. Avoid this by just inputting lists instead.
#you do not need to specify the type of each argument, but you should remain
#aware of what you want each argument's type to be.
#using the type(<var>) function may help if you want to leave it ambiguous.
def ex_func1(arg1,arg2,arg3):
    print(arg1,arg2,arg3,sep='/')
ex_func1("One","Two","Three")

#if you want to be able to use a value that the function creates or manipulates
#you can 'return' it using the 'return <var>' keyword. Now, if you assign a
#variable to the function call, it will instead assign it to whatever the
#function returns. Functions with multiple return statements (if you use if
#statements) need not return the same type of variable.

def ex_func2(arg1):
    if type(arg1) == type(True): #if the argument is a boolean
        return False
    elif type(arg1) == type(0): #if the argument is an integer
        return 0
    elif type(arg1) == type(""): #string
        return ""
    elif type(arg1) == type([]): #list
        return []
    else:
        return None
var1 = ex_func2(False) #modify the argument to change var1's value!

#Python will terminate the function call right when the return statement is
#used, so code after return statements aren't run!
def ex_func3():
    return False
    #Any code here won't be run!
    #return True

#Sometimes, if you're going to be calling the same function many times mostly
#the same way, but with occasional differences, you may want to set a default
#value for the parameters (arguments) of the function. Basically, if you make
#a parameter default to a specific value, someone calling the function can leave
#out that argument and it will automatically assume they meant to input the
#value specified at the time of calling. To set a default parameter, when
#defining a function, put " = <value>" after each parameter you want to set a
#default value for.
def ex_func4(arg1, arg2, arg3 = 2, arg4 = 7): #arg3 defaults to 2, arg4 to 7
    return sum([arg1,arg2,arg3,arg4])/4 #returns the average

#In addition, all parameters that have a default parameter
#must be listed last in the order of the arguments.
#i.e. You cannot have "def ex_func4(arg1 = 0, arg2, arg3, arg4):", since all
#default parameters have to be listed last.

#here are some example of function calls. Remember that when calling ex_func4(),
#arg3 and arg4 don't have to be supplied, but arg1 and arg2 have to.
#if you want to specify arg4 without specifying arg3, when you call the function,
#you can include "arg4 = <value>" when calling the function to specify the value.
var2 = ex_func4(1,1,1,1) #average of 1,1,1,1, which is 1
var3 = ex_func4(4,6) #arg 1 = 4, arg2 = 6, arg3 = 2, arg4 = 7, and the average is 4.75
var4 = ex_func4(0,0,arg4=0) #arg1 = 0, arg2 = 0, arg3 = 2, arg4 = 0, avg = 0.5
var5 = ex_func4(4,5,6) #arg1 = 4, arg2 = 5, arg3 = 6, arg4 = 7, avg = 5.5

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(var1)
