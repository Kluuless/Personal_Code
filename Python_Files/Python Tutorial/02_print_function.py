#the print() function will print any variable given to it
#Try it out in the file 01_variable_basics.py!

print('Hello world!')

#you can pass in variables as arguments too.
word = "coolio!"
print(word)

#you don't even need to pass in strings.
print(0)
print(False)
print([0.1,0.2,0.3,0.4,0.5])

#if you want to pass in multiple arguments, separate them by commas
one = 1
two = 2
three = 3
print(one,two,three)

#you may need to do this if the variables are different types
sentence = "The current year is"
year = 2020
print(sentence,year)

#after the given variable(s) is printed, it will automatically print a newline
#'\n'. If you don't want this, add an argument 'end=<end_str>' to the end.
#Instead of printing a newline after, it will print <end_str>.
print(1,end=' End of first print! ')
print(2,3,4,end=' End of second print! ')
print(5,end='End of third print!\n')

#print() will automatically separate each argument with a space ' '. To change
#this, put 'sep=<sep_str>' at the end of the arguments. Instead of separating
#the arguments with ' ', it will do it with <sep_str>.
print(1,2,3,4,5,sep='/') #will separate numbers with '/' instead of ' '

#sep and end can be combined.
print("One","Two","Three",sep=', ',end=", That's the last print!\n")
