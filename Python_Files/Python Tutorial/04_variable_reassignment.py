#use the type() function to get a variable's type
type_var1 = type(0)
type_var2 = type(0.0)
type_var3 = type(True)
type_var4 = type("Hello")
type_var5 = type([])
type_var6 = type(print(end='')) #functions are considered their own type!

#can reassign variables to other ones, even with other types
reassign_var = 0
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function
reassign_var = 'Zero'
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function
reassign_var = []
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function
reassign_var = False
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function

#can assign to other variables or operations on other variables
reassign_var = 0
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function
reassign_var = float_example1 + 1 #1.0
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function
reassign_var = reassign_var == 1.0 #True
#print(type(reassign_var),reassign_var)) #uncomment this line to run the print function

#when reassigning a number, since var = var + num, var = var - num,
#var = var * num and var = var / num (as well as **, //, and %) assignments
#are so commonly used, they can be replaced with var += num, var -= num, etc
#this is known as an update assignment
update_example = 0
#print(type(update_example)) #uncomment this line to run the print function
update_example += 5 #0+5, or 5
#print(type(update_example)) #uncomment this line to run the print function
update_example -= 3 #5-3, or 2
#print(type(update_example)) #uncomment this line to run the print function
update_example **= 4 #2^4, or 16
#print(type(update_example)) #uncomment this line to run the print function
update_example /= 4.0 #16/4.0, or 4.0
#print(type(update_example)) #uncomment this line to run the print function

#can any type into string type by using str(var) function
#this is known as casting
str_cast_example1 = str(1) #becomes '1'
str_cast_example2 = str([True,False,False,True]) #becomes '[True, False, False, True]'

#can convert a string of only integers into an integer using the int(string) function
int_cast_example1 = int('1432')
int_cast_example2 = int('-4')
#int_cast_example3 = int('Fourteen') #this doesn't work

#can convert a string into float by using float(string) function
float_cast_example1 = float('1492') #becomes 1492.0
float_cast_example2 = float('17.38') #1738

#can have python interpret a string of numbers using eval(var) function
eval_example1 = eval('1') #integer
eval_example2 = eval('-73.29') #float
eval_example3 = eval('1+4-2') #int representing value 3

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(type_var1)
