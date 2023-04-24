# functional programming
# |
# v
# print("hello")
from abc import ABC


# class Character(ABC):
from multipledispatch import dispatch
class Character:
    def __init__(self, name, velocity):
        self._name = name
        self._velocity = velocity
    # def __str__(self):
    #     return f"name = {self.name}, velocity = {self.velocity}"
    # def __eq__(self, other):
    #     if (self.name == other.name and self.velocity == other.velocity):
    #         return True
    #     else:
    #         return False
    # def __len__(self):
    #     return len(self.minions)

    # def move(self):
    #     self.velocity += 1
    # def get_name(self):
    #     return self._name
    # def set_name(self, name):
    #     self._name = name.upper() # attached behavior
    # def get_velocity(self):
    #     return self._velocity
    # def set_velocity(self, velocity):
    #     self._velocity = velocity

    # @property
    # def name(self):
    #     return self._name
    # @name.setter
    # def name(self, name):
    #     self._name = name.upper()
    # def __getattribute__(self, atr: str):
    def __getattr__(self, atr: str):
        return self.__dict__[f"_{atr}"].upper()
    def __setattr__(self, atr, value):
        self.__dict__[f"_{atr}"] = str(value)

ironMan = Character("ironman", 0)
# ironMan.set_name("Man Iron ron")
# print(ironMan.get_name())

ironMan.name = "Man Iron ron"
print(ironMan.name)




class Animal:
    def __init__(self, name):
        self.name = name
    def jump(self):
        print(f"my name is {self.name}, and i'm jumping")

class Pet(Character):
    def __init__(self, petName, vel):
        super().__init__(petName, velocity=vel)
    # override
    def move(self):
        self._velocity += 2

# dog_1 = Pet("พี่เตี้ยสจล", 0)
# dog_1.move()
# print(dog_1._velocity) # 2 not 1


# functional

def functionA():
    print('A')

# functionA()

# ironMan = Character("ironman", 0)
# ironMan.move()
# print(ironMan.velocity) # 1
# ironMan.move(5)
# print(ironMan.velocity) # 6
# ironMan.move(1.5)
# print(ironMan.velocity) # 7.5
