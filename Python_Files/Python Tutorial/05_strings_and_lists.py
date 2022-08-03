#can use + to concatenate strings (combine them)
#you have to cast variables of other types to string using str() to concatenate
concat_example1 = "Hello " + "world!" #becomes 'Hello world!'
concat_example2 = "One plus one equals " + str(2) #'One plus one equals 2'

#to add an item to the end of a list, use the function list.append(var)
append_example = [1,2,3]
append_example.append(4) #list becomes [1,2,3,4]

#to add an item somewhere else in the list, use list.insert(index,var)
#list indices start at 0 and count up. The 53rd element is at index 52 for example.
insert_example = [1,3]
insert_example.insert(1,2) #list becomes [1,2,3]

#to find an item in a list, use list.index(var)
#this also works with strings, use string.index(var)
letters_list = ["A","B","C","D","E"]
index_example1 = letters_list.index("C") #becomes 2
nums_list = [1,2,3,3,3,4,5,2]
index_example2 = nums_list.index(3) #becomes 2
index_example3 = nums_list.index(2) #becomes 1
letters_str = "ABCDE"
index_example4 = letters_str.index("E") #becomes 4
index_example5 = letters_str.index("BCD") #becomes 1

#remove values from list with pop(index)
#index will default to 0 unless specified
pop_example1 = ['0','1','2','3','4']
pop_example2 = pop_example1.pop() #list becomes ['1','2','3','4'], variable becomes '0'
pop_example3 = pop_example1.pop(2) #list becomes ['1','2','4'], variable becomes '3'

#remove specific values from list with remove(var)
remove_example1 = ["A","B","C","D","E"]
remove_example2 = remove_example1.remove("D") #list becomes ["A","B","C","E"], variable becomes "D"

#other useful list functions are
#list.clear() which removes all elements from list
#list.copy() which returns a copy of the list
#list.count(var) which returns an int representing the amount of occurences of var in the list
#list.reverse() which revereses the list
#list.sort() which sorts the list
#sum(<list>) to add up all elements of the list

#can access specific list elements using the [index] operator
#this also works for strings
list_access_example1 = ["A","B","C","D","E"]
list_access_example2 = list_access_example1[0] #'A'
list_access_example2 = list_access_example1[4] #'E'
list_access_example2 = list_access_example1[integer_example1 + 2] #'C'
string_access_example1 = "ABCDE"
string_access_example2 = string_access_example1[2] #'C'

#can access a range of the list using a splicing operator: [start:stop:step]
#it starts at the index start and ends at the index before stop, alternating
#every step amount
#default for start is 0, stop is the end of the list, and step is 1
#can use negative numbers to go from the end of the list
#this also works for strings
list_splice_example1 = ["A","B","C","D","E"]
list_splice_example2 = list_splice_example1[2:] #["C","D","E"]
list_splice_example3 = list_splice_example1[:-2] #["A","B","C"]
list_splice_example4 = list_splice_example1[1:3] #["B","C"]
list_splice_example5 = list_splice_example1[::2] #["A","C","E"]
list_splice_example2 = list_splice_example1[::-1] #["E","D","C","B","A"]
string_splice_example1 = "ABCDEFGHIJKL"
string_splice_example2 = string_splice_example1[1:10:3] #"BEH"

#can call len() on a string or list to get its length as an integer
len_list_example_1 = len(list_splice_example1) #should be 5
len_list_example_2 = len([]) #should be 0
len_list_example_3 = len(string_access_example1) #should be 5
len_list_example_4 = len("Hello, how are you doing today?") #should be 31

#can use the "in" operator to see if the value is in the list or string
in_example1 = "ello" in "monticello" #true, 'ello' is in 'monticELLO'
in_example2 = 12 in [6,3,2,5,4,7] #false, 12 is not in the list

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(concat_example1)
