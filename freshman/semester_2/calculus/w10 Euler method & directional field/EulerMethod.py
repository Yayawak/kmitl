import math, random
import matplotlib.pyplot as plt
import numpy as np

class Vector2:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def __add__(self, v2):
        v3 = Vector2(self.x + v2.x, self.y + v2.y)
        return v3
    def __repr__(self):
        return f"Vector2({self.x}, {self.y})"
    def copy(self):
        return Vector2(self.x, self.y)
    

class EulerMethod:
    def __init__(self, slope_expression, init_value_vector):
        self.slope_expression = slope_expression
        self.init_value_vector = init_value_vector
        
    def slope_fn(self, prevVec):
        # return (3 * (vec.x ** 2)) * (2 - vec.y)
        # return eval(self.slope_expression)
        return self.slope_expression(prevVec)
    # (3 * (vec.x ** 2)) * (2 - vec.y)
    
    def __getNextVec(self, prevVec, deltaX):
        y =  prevVec.y + self.slope_fn(prevVec) * deltaX
        x = prevVec.x + deltaX
        return Vector2(x, y)

    def approximateY(self, x, deltaX, isPlot):
        tempVec = self.init_value_vector.copy()
        # p = plt.plot([tempVec.x], [tempVec.y])
        xArr = [tempVec.x]
        yArr = [tempVec.y]
        while (tempVec.x < x):
            tempVec = self.__getNextVec(tempVec, deltaX)
            # p = plt.plot([tempVec.x], [tempVec.y])
            xArr += [tempVec.x]
            yArr += [tempVec.y]
            # print(tempVec)
        # plt.plot(xArr, yArr)
        if isPlot:
            plt.figure(figsize=(6,2))
            c = random.choice(['g', 'orange', 'm', 'b', 'y', 'C9'])
            plt.scatter(xArr, yArr, s=10, c=c)
            plt.axhline(y=yArr[-1], color='r', linestyle='--')
            plt.show()
        
        return tempVec.y
    
if __name__ == "__main__":
    # "(3 * (vec.x ** 2)) * (2 - vec.y)"
    
    em = EulerMethod(
        lambda vec: (3 * (vec.x ** 2)) * (2 - vec.y)
        , 
           Vector2(0, 3)
                )
    h = 0.1
    x = 3
    apxY = em.approximateY(x, h, isPlot=True)
    print(f"if x = {x} --> approximated y = {apxY}")