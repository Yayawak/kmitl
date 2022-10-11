# Lab 1: Logical Equivalent

# ให้นักศึกษาเพิ่มเติมโค้ดด้านล่าง
# ชื่อ-สกุล: อภิสิทธิ์ ทวีบุญ
# รหัสนักศึกษา: 65050988

######## ห้ามแก้ไขโค้ดส่วนนี้ ########
# ********** เริ่มต้น **************

import numpy as np
from functools import partial
import re

class Infix(object):
    def __init__(self, func):
        self.func = func
    def __or__(self, other):
        return self.func(other)
    def __ror__(self, other):
        return Infix(partial(self.func, other))
    def __call__(self, v1, v2):
        return self.func(v1, v2)

@Infix
def implies(p, q) :
    return not p or q

@Infix
def iff(p, q) :
    return (p |implies| q) and (q |implies| p)

# ********** สิ้นสุด **********


############# เขียนฟังก์ชันต่อไปนี้  ##############
###### ห้ามแก้ไข function definitions #########


# ฟังชั่นก์สร้างตาราง Truth Table
# input: expression
# output: truth table as a list of lists
# หมายเหตุ ตัวแปรในประพจน์มีเพียง a และ b เท่านั้น



def truth_table(exp):
    tt = [[], [], [], []]
    for i, [a,b] in enumerate([[0,0], [0,1], [1,0], [1,1]]):
        tt[i] = [a, b, eval(exp)]
        
    tt.insert(0, ["a", "b", "eval(expression)"])
    return np.array(tt, dtype=object)

truth_table("not a and b")

def areEquivalent(expr1, expr2):
    tt1 = truth_table(expr1)
    tt2 = truth_table(expr2)
    return np.all(tt1==tt2)

def main():
    # test equivalency
    print("first exprssion : ")
    expr1 = input()
    
    print("second exprssion : ")
    expr2 = input()
    
    
    # expr1 = 'not a or b'
    # expr2 = 'a | implies | b'
    # print(type(expr2))
    equivalent = areEquivalent(expr1, expr2)
    if equivalent:
        print(f"\nThe expressions \n\t\'{expr1}\'\n &\n\t \'{expr2}\'\n are equivalent!")
    else:
        print(f"\nThe expressions \n\t\'{expr1}\'\n &\n\t \'{expr2}\'\n are NOT equivalent!")

# ลองเปิด de morgan's laws แล้วทำตามดูนะ
if __name__ == '__main__':
    main()