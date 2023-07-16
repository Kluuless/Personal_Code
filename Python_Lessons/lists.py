#Creating lists
#Syntax: variable_name = [elements,of,a,list]
#Lists can have numbers
list1 = [0,1,2,3,4]
print("List 1:",list1)

#Lists can have strings
list2 = ["a","b","c","d","e"]
print("List 2:",list2)

#Lists can have booleans
list3 = [True,False,True,True,False]
print("List 3:",list3)

#Lists can have multiple values of different data types
list4 = [0,False,"",1,True,"Hello world!",-43.21]
print("List 4:",list4)

#Lists can also be empty
list5 = []
print("List 5:",list5)

#Making lists by using variables saves the values to the list
a = 42
b = "42"
c = True
list6 = [a,b,c]
print("List 6:",list6)

#What happens when we change a variable but not the list?
b = "String"
print("List's second index changed from '42' to 'String'")
print("List 6:",list6,"Variable b:",b)
list6 = [a,b,c]
print("List updated")
print("List 6:",list6)

#Accessing elements of the list
#Indices (the plural of index) start at 0
#The first element in the list is index 0,
#  second element is at index 1,
#  third element is at index 2,
#  and so on
#Syntax: list_variable[index]
print("list6[0]:",list6[0])
print("List3[2]:",list3[2])
print("List2[4]:",list2[4])
print("List1[1]:",list1[1])
print("Accessing index outside of list throws error")
#Negative Indices access elements at the end of the list
print("List1[-1]:",list1[-1])
print("List1[-2]:",list1[-2])
print("List1[-3]:",list1[-3])

#Adding things to the list
#list_variable.append(element) adds element to the end
list2.append("Pho")
list2.append("Buon Bo Hue")
list2.append("Banh Xeo")
print("Pho, Buon Bo Hue, and Banh Xeo appended to list:",list2)

#list_name.insert(index, element) inserts element at index
#Shifts the other elements down to make space for the element
list2.insert(0,"Banh Mi Sandwich")
print("Banh Mi Sandwich inserted at index 0:",list2)
list2.insert(4,"Buon Mum")
print("Buon Mum inserted at index 4:",list2)

#Change elements of the list
#Syntax: list_variable[index] = new_element
list2[1] = "Spring Rolls"
list2[6] = "Egg Rolls"
print("List index 1 changed to Spring Rolls and index 6 to Egg Rolls:")
print(list2)

#Remove elements of the list
#Remove by index: list_variable.pop(index)
list2.pop(3)
list2.pop(2)
print("List indices 2 and 3 popped:")
print(list2)

#Remove specific element: list_variable.remove(element)
list2.remove("d")
print("List element 'd' removed from list:")
print(list2)
