#this code will represent a dog in the data
#string, int, float, boolean, list

class Dog():
    #Attributes:
    #color: list of string
    #name: string
    #owner: string
    #age: int
    #location: string
    #personality trait: list of string
    #mood: string
    #hungry: boolean
    #weight: float
    #children: list of Dog

    #Initialize
    def __init__(self, color, name, owner, age, location, personality_trait, mood, hungry, weight):
        #Attributes
        self.color = color
        self.name = name
        self.owner = owner
        self.age = age #in human years
        self.location = location
        self.personality_trait = personality_trait
        self.mood = mood
        self.hungry = hungry
        self.hours_since_eaten = 0.0
        self.weight = weight
        self.children = [] #if list is empty, no children

    #Methods:
    def rename(self, new_name):
        self.name = new_name

    #gains weight if hungry and returns True, otherwise False
    def eat(self, pounds_of_food):
        if self.hungry:
            self.weight += pounds_of_food
            self.hours_since_eaten = 0.0
            self.hungry = False
            return True
        else:
            return False

    def wait(self, hours):
        self.hours_since_eaten += hours
        if self.hours_since_eaten >= 4:
            self.hungry = True

#Initializing a dog:
dog1 = Dog("brown", "Fidough", "Nathan", 10, "Pokeball", ["Adventurous","Easily Excited","Very Playful"], "not grumpy", False, 24.0)

#Using the dog:
dog1.rename("Dachsbun")
dog1.wait(12)
dog1.eat(8.8)

#Viewing/printing the attributes:
print("Name:",dog1.name)
print("Weight",dog1.weight)
print("Is Hungry:",dog1.hungry)
