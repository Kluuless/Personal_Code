#You've probably noticed how each data type prior to 13_classes.py have each
#allowed the use of different operators, such as +, -, in, sum(), **, etc.
#Well, you can change your classes to allow that too. It is called overriding
#an operator. There are different keywords for overriding the different
#operators, but a quick google search can show you what to name the method when
#trying to override an operator. **ALL** method overrides have to return a
#specific kind of type. For example, if you're overriding ==, you have to
#return a boolean value (either True or False). When overriding /, you have to
#return a float.
#Here's a list of different operators you can override and the corresponding
#method headers (not an exhaustive list):
#       + | def __add__(self, other):
#       - | def __sub__(self, other):
#       * | def __mul__(self, other):
#       / | def __truediv__(self, other):
#      // | def __floordiv__(self, other):
#       % | def __mod__(self,other):
#      ** | def __pow__(self, other):
#       < | def __lt__(self, other):
#       > | def __gt__(self, other):
#      <= | def __le__(self, other):
#      >= | def __ge__(self, other):
#      == | def __eq__(self, other):
#      != | def __ne__(self, other):
#      -= | def __isub__(self, other):
#      += | def __iadd__(self, other):
#      *= | def __imul__(self, other):
#      /= | def __idiv__(self, other):
#     //= | def __ifloordiv__(self, other):
#      %= | def __imod__(self, other):
#     **= | def __ipow__(self, other):
#  -<var> | def __neg__(self, other):
#   str() | def __str__(self):
#   int() | def __int__(self):
# float() | def __float__(self):
#  bool() | def __bool__(self):
#  list() | def __list__(self):
#  dict() | def __dict__(self):
#   len() | def __len__(self):
#   abs() | def __abs__():              //this one is for absolute value
#  repr() | def __repr__():             //this one is what the object represents
#  

class Dog:
    #constructor for the dog.
    def __init__(self,age=1,owner="Owner",name="Name",breed="Breed",hunger=False):
        self.age = age #represents the dog's age in years
        self.owner = owner #represents the dog's owner
        self.name = name #represents the dog's name
        self.breed = breed #represents the dog's breed
        self.hungry = hunger #represents if the dog is hungry

    #prints all the attributes of the dog.
    def printAttributes(self):
        print("Name:",self.name)
        print("Age:",self.age)
        print("Breed:",self.breed)
        print("Hungry:",self.hungry)
        print("Owner:",self.owner)
        print()

    #ages the dog by an amount and it becomes hungry.
    def grow(self, amount = 1):
        self.age += amount
        self.hungry = True

    #returns the value representing if the dog is hungry.
    def isHungry(self):
        return self.hungry

    #makes the dog not hungry.
    def feed(self):
        self.hungry = False

    #changes the dog's owner to someone else.
    def changeOwner(self, newOwner):
        self.owner = newOwner
