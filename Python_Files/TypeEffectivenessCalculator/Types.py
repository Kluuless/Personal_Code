class Type:
    def __init__(self, name):
        self.name = name
        self.superE = []
        self.notVeryE = []
        self.doesntE = []
        self.weaknesses = []
        self.resistances = []
        self.immunities = []

    def addSuperE(self, other_type):
        self.superE.append(other_type)
        other_type.weaknesses.append(self)

    def addNotVeryE(self, other_type):
        self.notVeryE.append(other_type)
        other_type.resistances.append(self)

    def addDoesntE(self, other_type):
        self.doesntE.append(other_type)
        other_type.immunities.append(self)

    def attack(self, other_type1, other_type2 = None):
        total = 1.0
        if other_type1 in self.superE: total *= 2.0
        elif other_type1 in self.notVeryE: total *= 0.5
        elif other_type1 in self.doesntE: total *= 0.0
        if other_type2 == None: pass
        elif other_type2 in self.superE: total *= 2.0
        elif other_type2 in self.notVeryE: total *= 0.5
        elif other_type2 in self.doesntE: total *= 0.0
        return total

    def defend(self, other_type):
        if other_type in self.immunities: return 0.0
        elif other_type in self.resistances: return 0.5
        elif other_type in self.weaknesses: return 2.0
        else: return 1.0

    def __str__(self):
        return self.name

    def __repr__(self):
        return self.name

types = {}
for t in ["Bug","Dark","Dragon","Electric","Fairy","Fighting","Fire","Flying",\
          "Ghost","Grass","Ground","Ice","Normal","Poison","Psychic","Rock",\
          "Steel","Water"]:
    types[t] = Type(t)

(bug,dark,dragon,electric,fairy,fighting,fire,flying,ghost,grass,ground,ice,\
 normal,poison,psychic,rock,steel,water) = types.values()

bug.addSuperE(dark)
bug.addSuperE(grass)
bug.addSuperE(psychic)
bug.addNotVeryE(fairy)
bug.addNotVeryE(fighting)
bug.addNotVeryE(fire)
bug.addNotVeryE(flying)
bug.addNotVeryE(ghost)
bug.addNotVeryE(poison)
bug.addNotVeryE(steel)

dark.addSuperE(ghost)
dark.addSuperE(psychic)
dark.addNotVeryE(fighting)
dark.addNotVeryE(dark)
dark.addNotVeryE(fairy)

dragon.addSuperE(dragon)
dragon.addNotVeryE(steel)
dragon.addDoesntE(fairy)


electric.addSuperE(flying)
electric.addSuperE(water)
electric.addNotVeryE(grass)
electric.addNotVeryE(electric)
electric.addNotVeryE(dragon)
electric.addDoesntE(ground)

fairy.addSuperE(dark)
fairy.addSuperE(dragon)
fairy.addSuperE(fighting)
fairy.addNotVeryE(fire)
fairy.addNotVeryE(poison)
fairy.addNotVeryE(steel)

fighting.addSuperE(dark)
fighting.addSuperE(ice)
fighting.addSuperE(normal)
fighting.addSuperE(rock)
fighting.addSuperE(steel)
fighting.addNotVeryE(bug)
fighting.addNotVeryE(fairy)
fighting.addNotVeryE(flying)
fighting.addNotVeryE(poison)
fighting.addNotVeryE(psychic)
fighting.addDoesntE(ghost)

fire.addSuperE(bug)
fire.addSuperE(grass)
fire.addSuperE(ice)
fire.addSuperE(steel)
fire.addNotVeryE(dragon)
fire.addNotVeryE(fire)
fire.addNotVeryE(rock)
fire.addNotVeryE(water)

flying.addSuperE(bug)
flying.addSuperE(fighting)
flying.addSuperE(grass)
flying.addNotVeryE(electric)
flying.addNotVeryE(rock)
flying.addNotVeryE(steel)

ghost.addSuperE(ghost)
ghost.addSuperE(psychic)
ghost.addNotVeryE(dark)
ghost.addDoesntE(normal)

grass.addSuperE(ground)
grass.addSuperE(rock)
grass.addSuperE(water)
grass.addNotVeryE(bug)
grass.addNotVeryE(dragon)
grass.addNotVeryE(fire)
grass.addNotVeryE(flying)
grass.addNotVeryE(grass)
grass.addNotVeryE(poison)
grass.addNotVeryE(steel)

ground.addSuperE(electric)
ground.addSuperE(fire)
ground.addSuperE(poison)
ground.addSuperE(rock)
ground.addSuperE(steel)
ground.addNotVeryE(bug)
ground.addNotVeryE(grass)
ground.addDoesntE(flying)

ice.addSuperE(dragon)
ice.addSuperE(flying)
ice.addSuperE(grass)
ice.addSuperE(ground)
ice.addNotVeryE(fire)
ice.addNotVeryE(ice)
ice.addNotVeryE(steel)
ice.addNotVeryE(water)

normal.addNotVeryE(rock)
normal.addNotVeryE(steel)
normal.addDoesntE(ghost)

poison.addSuperE(fairy)
poison.addSuperE(grass)
poison.addNotVeryE(ghost)
poison.addNotVeryE(ground)
poison.addNotVeryE(poison)
poison.addNotVeryE(rock)
poison.addDoesntE(steel)

psychic.addSuperE(fighting)
psychic.addSuperE(poison)
psychic.addNotVeryE(psychic)
psychic.addNotVeryE(steel)
psychic.addDoesntE(dark)

rock.addSuperE(bug)
rock.addSuperE(fire)
rock.addSuperE(flying)
rock.addSuperE(ice)
rock.addNotVeryE(fighting)
rock.addNotVeryE(ground)
rock.addNotVeryE(steel)

steel.addSuperE(fairy)
steel.addSuperE(ice)
steel.addSuperE(rock)
steel.addNotVeryE(fire)
steel.addNotVeryE(ice)
steel.addNotVeryE(steel)
steel.addNotVeryE(water)

water.addSuperE(fire)
water.addSuperE(ground)
water.addSuperE(rock)
water.addNotVeryE(dragon)
water.addNotVeryE(grass)
water.addNotVeryE(water)

def getEffectiveness(type1, type2=None):
    effectiveness = {}
    for t in types.keys():
        effectiveness[t] = types[t].attack(type1,type2)
    return dict(sorted(effectiveness.items(), key=lambda item: item[1],reverse=True))
    
