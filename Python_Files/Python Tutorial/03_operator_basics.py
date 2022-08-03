#to manipulate a number, you can use simple math operators +, -, /, *.
#you can also group things with parentheses.
#the operator ** represents the exponent operator (instead of ^)
#the // operator divides, but removes the remainder of the division
#the % operator divides, but only keeps the remainder of the division
#you can use both integers and floats, but the result will be a float
#if both things before and after the operator are ints, the result will be an int
#can use variables in place of numbers
math_operator_example1 = 1 + 3 #is an integer
math_operator_example2 = 4.23 - 67.987 #is a float
math_operator_example3 = 7 * 4.3 #is a float
math_operator_example4 = integer_example2 + integer_example3
math_operator_example5 = integer_example3 + 42635
math_operator_example6 = 52 // 10 #this is equal to 5, since the remainder is discarded
math_operator_example7 = (718 + 5) % 100 #this is equal to 23, since only the remainder is kept

#there are operators to compare numbers:
#less than: <
#greater than: >
#less than or equal to: <=
#greater than or equal to: >=
#equal to: ==
#not equal to: !=
comparison_example1 = 1 < 3 #the variable will represent a boolean with value True
comparison_example2 = 4.3 <= 7 #True
comparison_example3 = math_operator_example1 > 4.1 #False
comparison_example4 = integer_example1 >= float_example1 #True
comparison_example5 = 4 == 4.0 #True
comparison_example6 = (5 + 3) != 8.0 #False

#to compare two boolean types, use operators 'and', 'or'
#'and' returns True if both values are True and False otherwise
#'or' returns True if one or both values are True, and False if both are False
#to invert switch to the other boolean type, use operator 'not'
true_and_true = True and True #True
true_and_false = True and False #False
false_and_true = False and True #False
false_and_false = False and False #False
true_or_true = True or True #True
true_or_false = True or False #True
false_or_true = False or True #True
false_or_false = False or False #False
not_true = not True #False
not_false = not False #True
bool_oper_example1 = (1 < 3) and (2 < 3) #becomes True and True, which is True
bool_oper_example2 = (3 >= 0) or (1 - 3 == 7) #becomes True or False, which is True

#because of the nature of the 'and' statements, if the first given value is false,
#python doesn't even bother checking the other statement and returns False anyway.
#this is known as short-circuiting.
#the same thing happens in 'or' statements if the first value given is true.
#python doesn't even bother checking the other statement and returns True anyway.
#this is because 'False and anything" is always false, and "True or anything" is always true.
short_circuit1 = True and (1/0 == "Infinity")
short_circuit2 = False or (1/0 == "Infinity")

#can use == and != to compare data types that aren't just numbers
comparison_example7 = True == False #False
comparison_example8 = [1,2,3,4] != [1,2,3,4,5] #True
comparison_example9 = 'Seven' == 'seven' #False, S is capitalized in first one

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(math_operator_example1)
