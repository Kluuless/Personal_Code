#for loops are similar to while loops, but they keep count of a variable so
#you don't have to. Syntax is 'for <var> in range(start, stop, step):'
#<var> is the variable name for the counting variable.
#start is the initial value of <var>.
#stop is the value of <var> that will stop the loop.
#step is the value that <var> increases by.
#most people use i as <var>, but it can be any variable.
#when people nest for loops, they typically have the inner loop use j for <var>.
#if 1 argument is given to range(), it will make stop = number, start = 0, step = 1
#if 2 arguments are given to range(), it will make start = arg1, stop = arg2, step = 1
for_loop_example1 = False
for i in range(10): #start = 0, stop = 10, step = 1
    for_loop_example1 = not for_loop_example1
    #print(for_loop_example1) #uncomment to see the values!
#the above loop will switch the value of the variable 10 times.

for_loop_example2 = [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]] #a 4x4 grid of 0s
for i in range(len(for_loop_example2)): #start = 0, stop = 4, step = 1
    for j in range(len(for_loop_example2[i])): #start = 0, stop = 4, step = 1
        if (i + j) % 2 == 0: #if the sums are even
            for_loop_example2[i][j] = i + j
            #print(i,j,i+j) #uncomment to see the values!
#the above loop will make every other entry in the list an increasing even number

for_loop_example3 = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
for_loop_example4 = []
for_loop_example5 = []
for i in range(3,9): #start = 3, stop = 9, step = 1
    for_loop_example4.append(for_loop_example3[i])
for i in range(5,15,3): #start = 5, stop = 15, step = 3 
    for_loop_example5.append(for_loop_example3[i])
#the first for loop above copies all elements from index 3 to 8 (stops at 9)
#into for_loop_example4, resulting in [3,4,5,6,7,8]
#the second for loop above copies every 3 elements from index 5 to 14 (stops at 15)
#into for_loop_example5, resulting in [5,8,11,14]


#for each loops are like for loops, except <var> represents a member of another
#variable you give it. This other variable is usually a string or list.
#thus, <var> will represent either a single character from the list or
#an element of the list. When the loop iterates, <var> becomes the next character
#or element from the string or list.
#Syntax is 'for <var> in <other_var>:'
for_loop_example6 = 0
for element in for_loop_example3:
    for_loop_example6 += element

nums = "0123456789"
for_loop_example7 = 0
for char in nums:
    for_loop_example += int(char)

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(concat_example1)
