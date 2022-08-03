from random import randint

upper_bound = 100000

number = randint(1,upper_bound)

guess = 0
turns = 0
while guess != number:
    guess = input("Guess a number 1 to " + str(upper_bound) + ": ")
    try:
        guess = int(guess)
        if guess < number:
            print("Your guess was too small.")
        elif guess > number:
            print("Your guess was too large.")
    except:
        print("Only enter integers from 1 to " + str(upper_bound) + ".")
    turns += 1
addS = ""
if turns > 1: addS = "s"
print("Correct! You guessed the correct number in",turns,"turn"+addS+"!")
