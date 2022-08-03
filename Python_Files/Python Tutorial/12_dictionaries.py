#Another very handy data type is the dictionary. It functions similar to the
#list or an array with one 'key' difference. It doesn't require the
#use integers as indices. Instead, you can make them whatever other data type
#you want, usually strings. Because of this difference, the indices are instead
#called keys.

#The syntax for dictionaries is as follows:
#{<key_1>: <value_1>, <key_2>: <value_2>, <key_3>: <value_3>}
#A dictionary may have more or less than 3 different key/value pairs.

#Here's an example of a dictionary:
dict_example1 = {"This":0,"Is":6,"A":14,"Dictionary":2}

#To access an element of a dictionary, it is the same as a list, using
#the brackets [].
dict_out_example1 = dict_example1["This"] #represents the value 0

#A more secure way to access elements of a dictionary is through the
#<dict>.get() method. It can take 1 or 2 arguments. When 1 is supplied,
#it looks for that key and returns the corresponding value. If a second
#value is supplied, it will return that instead if there doesn't exist
#that key in the dictionary.
dict_out_example2 = dict_example1.get("A") #becomes 14
dict_out_example3 = dict_example2.get("Dictionary",4) #becomes 2, since "Dictionary" exists
dict_out_example4 = dict_example3.get("Boo",73) #becomes 73, since "Boo" does not exist

#To add an element to the dictionary, just do the following:
#<dict>[<new_key>] = <new_value>
dict_example1["Example"] = -4.3

#other list/string operators also work in dictionaries, like the 'in' operator.
#in addition, dictionaries have some unique functions, like
#<dict>.keys() to return a list containing the keys.

#A situation in which dictionaries help is in the counting of letters in a string.
def chars1(string):
    letters = {}
    for ch in string:
        letters[ch] = letters.get(ch,0)+1
    return letters
    

#use this to print out values
print(dict_out_example1)
