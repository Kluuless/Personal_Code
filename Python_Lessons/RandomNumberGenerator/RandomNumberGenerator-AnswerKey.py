#  Step 1:
#    Import the bindFunction and makeWindow functions from Framework.py. Also
#    import anything else you might want to use in future functions.
from Framework import bindFunction,makeWindow
from random import randint

#  Step 2:
#    Define your functions (all ranges are boundary-inclusive):
#     - coin(): generates either "Heads" or "Tails (or "Heads!" or "Tails!")
#               randomly
#     - d4(): generates a random number from 1 to 4
#     - d6(): generates a random number from 1 to 6
#     - d8(): generates a random number from 1 to 8
#     - d10(): generates a random number from 1 to 10
#     - d12(): generates a random number from 1 to 12
#     - d20(): generates a random number from 1 to 20
#     - dRange(start,end): generates a random number from start to end
def coin(): return ("Heads!","Tails!")[randint(0,1)]
def d4(): return randint(1,4)
def d6(): return randint(1,6)
def d8(): return randint(1,8)
def d10(): return randint(1,10)
def d12(): return randint(1,12)
def d20(): return randint(1,20)
def dRange(start,end): return randint(start,end)

#  Step 3:
#    Bind your functions that you created to the buttons by making use of the
#    Framework functions imported in step 1:
#     - bindFunction(button, f) takes a string and a function and makes it so
#       that when you click that button, the function is run.
#       Available buttons are:
#        - "Coin Flip"
#        - "d4"
#        - "d6"
#        - "d8"
#        - "d10"
#        - "d12"
#        - "d20"
#        - "Range"
#    - makeWindow() creates the window and everything on it (call this function
#      before binding any functions to buttons!)
makeWindow()
bindFunction("Coin Flip",coin)
bindFunction("d4",d4)
bindFunction("d6",d6)
bindFunction("d8",d8)
bindFunction("d10",d10)
bindFunction("d12",d12)
bindFunction("d20",d20)
bindFunction("Range",dRange)

