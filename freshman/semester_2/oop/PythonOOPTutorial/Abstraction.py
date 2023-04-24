from abc import ABC, abstractmethod

class Character(ABC):
    @abstractmethod
    def attack():
        pass

class จระเข้(Character()):
    def attack():
        print("ฟาดหาง")

class ผึ้ง(Character()):
    def attack():
        print("ต่อยหน้าคุณ")

class กบ(Character()):
    def attack():
        print("เลียหน้าคุณ")
