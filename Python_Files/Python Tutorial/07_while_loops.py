#while loops repeat what's in its code block until the boolean argument given
#becomes false. These can be nested like if statements.
condition1 = True
while_example1 = 0
while condition1:
    while_example1 += 1
    condition1 = while_example1 <= 10
    #print(condition1,while_example1) #uncomment this line to see the variables printed!
#this block of code will increase while_example2 until it is greater than 10

while_example2 = 0
while while_example2 <= 10:
    while_example2 += 1
    #print(while_example2) #uncomment this line to see the variables
#this while loop does the same thing as the previous loop, but simpler

while_example3 = []
condition2 = 0
condition3 = 0
while condition2 < 10:
    condition2 += 1
    while_example3.append([])
    while condition3 < 10:
        condition3 += 1
        #print(condition2,condition3) #uncomment this line to see the indices!
        if (condition2 + condition3) % 2 == 0: #if the sums is even
            while_example3[condition2-1].append("_")
        else: #if the sum is odd
            while_example3[condition2-1].append("X")
#this block of code makes a 10x10 list and fills every other entry with an 'X'

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(while_example1)
