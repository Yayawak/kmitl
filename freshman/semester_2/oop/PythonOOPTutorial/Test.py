# class Character:
#     pass

# c1 = Character()
# c1.name = "me"
# c1.velocity = 5
# print(c1.name)


# class Character:
#     name = "name"
#     velocity = "vel"

# c2 = Character()
# print(c2.name)
# print(c2.velocity)

# class Character:
#     def __init__(self, name, velocity):
#         self.name = name
#         self.velocity = velocity

# c3 = Character("killua", 99)
# print(c3.name)
# print(c3.velocity)

class Character:
    def __init__(self, name):
        self._name = name
    def __getattr__(self, atr: str):
        return self.__dict__[f"_{atr}"].upper()
    def __setattr__(self, atr, value):
        self.__dict__[f"_{atr}"] = str(value)

ironMan = Character("ironman", 0)
ironMan.name = "Man Iron ron"
# print(ironMan.name) # MAN IRON RON

class Character:
    def __init__(self, name):
        self._name = name
    def get_name(self):
        return self._name
    def set_name(self, name):
        self._name = name.upper() # attached behavior
ironMan.set_name("Man Iron ron")
print(ironMan.get_name())

class Character:
    def __init__(self, name):
        self._name = name
    @property
    def name(self):
        return self._name
    @name.setter
    def name(self, name):
        self._name = name.upper()

ironMan.name = "Man Iron ron"
print(ironMan.name) # MAN IRON RON
