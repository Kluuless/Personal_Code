#if statements take a boolean value and if it's true, executes the
#block of code below it (indented).
#can string together if statements using 'elif'
#use 'else' for cases not caught by if statements
#if statements can be nested (put one in another)
if_example1 = None #equivalent to null
if True:
    if_example1 = True #this statement WILL be called
else:
    if_example1 = False #this statement will NOT be called

num = 0
if_example2 = None
if num == 0:
    if_example2 = 'Zero' #this statement WILL be called
elif num == 1:
    if_example2 = 'One' #this statement will NOT be called
elif num == 2:
    if_example2 = 'Two' #this statement will NOT be called
elif num > 0: #if if_example3 is 0 or 1, it would have been caught in
                      #one of the earlier if/elif blocks, skipping this one.
                      #thus, this only represents ints >= 3
    if_example2 = 'Positive'
else: #don't need to do elif num < 0 because every other case is accounted for;
      #if it has made it this far, num is definitely < 0
    if_example2 = 'Negative'
    
condition1 = False
condition2 = True
if_example3 = None
if condition1:
    if condition2:
        if_example3 = "True True"
    else:
        if_example3 = "True False"
else:
    if condition2:
        if_example3 = "False True"
    else:
        if_example3 = "False False"

#use the print() function to test these values out!
#feel free to print() other things you want to test as well!
print(if_example1)
