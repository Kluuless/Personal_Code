#These methods are not the only right answers. As long as the results
#match the tests, any other answers are valid.

#Challenge 1: make a function called average() that inputs a list and
#outputs the list's average. Assume all inputs are of integer lists.



#Challenge 1 Tests:
print("Challenge 1 Tests:")
print("Should be 0.0:",average([-2,-1,0,1,2]))
print("Should be 0.0:",average([]))
print("Should be 44.8:",average([50,48,10,13,103]))
print('\n')

#Challenge 2: make a function named printGrid() that inputs an integer n
#and prints a grid of nxn 0s.



#Challenge 2 Tests:
print("Challenge 2 Tests:")
print("Should be:\n000\n000\n000")
print("Answer:")
printGrid(3)
print("Should be:\n00000\n00000\n00000\n00000\n00000")
print("Answer:")
printGrid(5)
print('\n')


#Challenge 3: make a function called everyN() that inputs a string s and
#an integer n and returns n copies of a string that contains every nth
#character of s.



#Challenge 3 Tests:
print("Challenge 3 Tests:")
print("Should be 'acegikmoqsuwyacegikmoqsuwy':",everyN('abcdefghijklmnopqrstuvwxyz',2))
print("Should be 'Hl r!Hl r!Hl r!':",everyN('Hello, World!',3))
print("Should be 'Oh No!':",everyN('Oh No!',1))
