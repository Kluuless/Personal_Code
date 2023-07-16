from random import randint
# ----- Number Guessing Game ------
# This game generates a random number between 1 and 100 (inclusive).
#
# The user then has to guess the number. If they enter a number that is out of
# bounds, the game will tell them that. If they enter a number that is not the
# randomly-generated number, it will tell them whether their guess was too high
# or too low. At the end, when they have guessed the number correctly, it will
# tell them how many guesses they took to get it right.

# Kyle Luu - August 8th, 2022
# ---------------------------------



# ---- VARIABLE INITIALIZATION ----
lower_bound = 1 #the lower bound of what the number can be
upper_bound = 1000 #the upper bound of what the number can be
number = randint(lower_bound,upper_bound) #the randomly-generated number
guess = 0 #what the user's guess is
turns = 0 #how many turns it took for the user to guess the correct number

# ------------ LOOP ---------------
#the loop stops when the user guesses the number correctly
while guess != number:
    # increment the turn counter
    turns += 1
    
    # prompt the user for a guess
    prompt = "Guess a number between " + str(lower_bound) + " and " + \
             str(upper_bound) + " (inclusive): "
    guess = input(prompt)

    # turn the guess into an integer. If unable to, let user know
    try:
        guess = int(guess) # converts guess to integer
        
        # let the user know if guess is out-of-bounds
        if guess < lower_bound or guess > upper_bound:
            print("Your guess is out-of-bounds. Enter a number in the bounds.")
        # let the user know if the guess is too high
        elif guess > number:
            print("Your guess was too high!")
        # let the user know if the guess is too low
        elif guess < number:
            print("Your guess was too low!")
    except: #if guess is not able to be converted to an integer
        print("Please enter a valid integer.")

# ------------ RESULTS ------------
print("You guessed the right number!")
print("It took you",turns,"to get it right.")
