from typing import Union, List
# สร้างเมทริกซ์ขนาด 15x15 และกำหนดค่าเริ่มต้นทุกตำแหน่งเป็น 100 (ร้อยละ 100 เพราะเป็นส่วนรู)
paper_matrix = [[100] * 15 for _ in range(15)]

# ข้อมูล input จำนวนครั้งการยิงและคู่ลำดับ x, y ของจุดโดนยิงในแต่ละครั้ง
num_shots = 8
shot_data = [(4, 11), (2, 8), (14, 2), (7, 7), (8, 6), (2, 5), (3, 4), (4, 3)]

s = "1 1 4 5 13 1 5 12 12 8 11 4 13 13 5 7"
# shot
s = s.split(" ")
X = [int(s[i]) for i in range(len(s)) if i % 2 == 0]
Y = [int(s[i]) for i in range(len(s)) if i % 2 == 1]
print("X", X)
print("Y ", Y)
print(list(zip(X, Y)))
shot_data = list(zip(X, Y))


# def getmanhattan_score(p0, p1)
def getchessdist_score(p0: List[int], p1 : List[int]) -> int:
    """Kuy isus"""
    # diff = abs(p0[0] - p1[0])
    return max(abs(p0[0] - p1[0]), abs(p0[1] - p1[1]))


def getscore(p: List[int]) -> int:
    dist:int = getchessdist_score([7, 7], p)
    ret:int
    if (dist == 0):
        ret = 10
    elif (dist == 1):
        ret = 9
    elif (dist == 2):
        ret = 8
    elif (dist == 3):
        ret = 7
    elif (dist > 3 and dist < 8):
        ret = 5
    elif (dist >= 8):
        ret = 0
    return ret

# print("diff manhattan ", getchessdist_score([7, 7], [8, 8]))
# print("diff manhattan ", getchessdist_score([7, 7], [9, 8]))
# print("diff manhattan ", getchessdist_score([7, 7], [10, 8]))
# print("diff manhattan ", getchessdist_score([7, 7], [10, 14]))

# print("score", getscore([7,7]))
# print("score", getscore([8,7]))
# print("score", getscore([9,7]))
# print("score", getscore([10,7]))
# print("score", getscore([11,7]))
# print("score", getscore([12,7]))
# print("score", getscore([13,7]))
# print("score", getscore([14,7]))
# print("score", getscore([15,7]))

accum = 0
for shot in shot_data:
    x, y = shot
    score = getscore([x, y])
    accum += score

print("average score = ", accum / len(shot_data))


# ประมวลผลข้อมูลการยิงและคำนวณความเสียหาย
for shot in shot_data:
    x, y = shot
    paper_matrix[y][x] -= 25

    for dx in range(-1, 2):
        for dy in range(-1, 2):
            if 0 <= x + dx < 15 and 0 <= y + dy < 15:
                paper_matrix[y + dy][x + dx] -= 25

# คำนวณค่าความเสียหายรวมของกระดาษเป้ายิง
total_damage = sum(sum(row) for row in paper_matrix)

# คำนวณคะแนนโดยนับจำนวนคะแนนที่ได้จากการยิงแต่ละครั้งและหารด้วยจำนวนครั้งการยิง
total_score = sum([10 if damage == 0 else 9 if damage == 25 else 8 if damage == 50 else 7 if damage == 75 else 5 for damage in sum(paper_matrix, [])])
average_score = total_score / num_shots

print(total_damage)
print(average_score)