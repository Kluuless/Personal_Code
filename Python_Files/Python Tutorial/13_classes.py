#Classes are the way to define your own data types. Similar to strings and
#lists. They are useful if you can think of a way to describe an object using
#any other data type. A good analogy would be to make a data type that
#represents a dog. You have to think about what defines a dog. Some of the
#obvious things would be age, owner, name, breed, hunger, and so on. As a
#programmer, you get to choose what to include and what not to include.
#each object you make has its own member variables, called attributes. In
#addition, you may also have member functions, called methods. As a programmer,
#you get to define these.

#To use your own object type, you first need to define it. Think of this as the
#blueprint for how to make your object and what it can do.

#To make a class, follow the syntax:
#class <class_name>

#When created, an object contains no attributes. They need to be initialized.
#This is done through a special kind of method called a Constructor.

#All a constructor does is initialize the attributes of an object. To do make
#the constructor, make define a function with the header as follows:
# "def __init__(self, <args>):"
#Note that there are two underscores (the "_" character) before and after init.
#you can replace <args> with any amount of input variables (or not at all). It
#all depends on how many objects you want to have the user be able to set.
#You may also define functions that have default parameters, if the user forgets
#to supply them (see the 09_defining_functions.py file for more). It is
#recommended to supply default parameters for all values the user gets to change.

#Any method you define must include "self" (without quotations) as the first
#(and sometimes only) argument. In addition, every time you want to use an
#attribute in a method, you must put "self." (without quotations) before the
#attribute name. Yes, it gets repetitive, but that's just how Python works.

#In the constructor, you initialize the variable similar to how you declare one
#in another function, with the key difference being that you must include the
#"self." at the beginning.

#If it's going to be a big class, one that will take a long time to develop, or
#one that will be used by others, make sure to comment the code so readers can
#figure out what each thing does.

#Here's an example of a dog class:

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

#Now that the object Dog has been defined, we can now make objects of type Dog.
#To do that, call the constructor method and assign that to a variable. The
#constructor method is called using the following syntax:
#<class_name>(<constructor_arg1>,<constructor_arg2>,...,<constructor_argn>)
#When calling the constructor, the "self" argument should not be supplied.

#Once the object is initialized (the constructor was called), you can now access
#the methods associated with that object by doing the following:
#<obj>.<method_name>(<args>)

#Here's some examples using the Dog class defined above.
dog1 = Dog(4,"Joe","Bud","German Shepherd",False)
dog2 = Dog(2,"Sally","Princess","Poodle",True)
dog3 = Dog(14,"Gus","Gus Jr.","Golden Retriever")
default_dog = Dog()

#Note that all these dogs share the same attribute names, but their values are
#different and tied to the actual objects.

dogs = [dog1,dog2,dog3,default_dog]

#calls printAttributes on each of the dogs in the list
for dog in dogs:
    dog.printAttributes()

dog1.grow(3) #Grows Bud by 3 years
dog2.grow() #Grows Princess by 1 year
dog2.feed() #Feeds Princess
dog3.changeOwner("Jane") #Changes Gus Jr.'s owner to Jane

print("After changes are made:")
for dog in dogs:
    dog.printAttributes()

#technically, after an object is initialized, you can modify them by doing
#<obj>.<attribute> = <value>
#It is generally looked down upon except for specific circumstances, and
#python doesn't prohibit doing it. There is a convention of putting underscores
#after an attribute name if you do not wish others to modify it without the
#use of methods.
#1 underscore means "Please don't touch this attribute"
#2 underscores means "If I find out that you touched this attribute, I'm gonna
    #get angry."

#Thus, this is completely allowed by Python:
dog3.age = 50000000
#However, if the attribute were named dog3.age_ or dog3.age__, the programmer of
#the code is asking you not to do that.
dog3.printAttributes()

#Feel free to mess around with this in the interpreter, printing any value or
#method you want or calling methods.
