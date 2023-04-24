
class Character:
    def intro(self):
        print("introduction of character")
    def sing(self):
        print("some character sing")
class HammingBird(Character):
    def sing(self):
        print("hamming sing")
class Hamilton(Character):
    def sing(self):
        print("hamilton sing")

chars = [Character(), HammingBird(), Hamilton()]
for character in chars:
    character.sing()
    # some character sing
    # hamming sing
    # hamilton sing
