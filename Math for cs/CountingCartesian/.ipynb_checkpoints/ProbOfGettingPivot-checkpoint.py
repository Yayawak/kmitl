import numpy as np

print("Enter k")
k = int(input())
print("k = ", k)
# k = 1
n = 2*k + 1
print("n = ", n)

# np.random.seed(9)
# np.random.set_state()
rand_arr_size_n = np.random.randint(0, 100, size=[n])
rand_lst_size_n = rand_arr_size_n.tolist()
rand_lst_size_n

def cartesian_product(lst, n):
    if n == 1:
        return [[x] for x in lst]
    l = []
    for x in lst:
        for t in cartesian_product(lst, n - 1):
            l += [[x] + t]
    return l

def get_mid_idx(n):
    return int((n+1) / 2) - 1

def get_mid(prim_list):
    x = prim_list
    mid_from_primitive_sorted = sorted(x)[get_mid_idx(len(x))]
    return  mid_from_primitive_sorted

def getMidFromSortedList(prim_list):
    mid_by_sorted_lst = []
    for row in cartesian_product(prim_list, n=len(prim_list)):
        idx = get_mid_idx(n)
        # print("Us : ", row, '\t\t', "S : ", sorted(row), '\t\t', "m = ", sorted(row)[idx])

        m = sorted(row)[idx]
        mid_by_sorted_lst += [m]
        # print(f"us : {row}\t  s : {sorted(row)} m = {row[1]}")
    return mid_by_sorted_lst

def countMid(arr, mid):
    count_m = 0
    for x in arr:
        if x == mid:
            count_m += 1
    return count_m

def getAmountAllCases(mid_by_sorted_lst):
       return len(mid_by_sorted_lst) 
    
def getProbOfMid(mid_by_sorted_lst, prim_list):
    ne = countMid(mid_by_sorted_lst, get_mid(prim_list))
    print("N(E) = ", ne)
    ns = getAmountAllCases(mid_by_sorted_lst)
    print("N(S) = ", ns)
    return ne / ns 


rlsn = rand_lst_size_n

mid_by_sorted_lst = getMidFromSortedList(rlsn)
mbsl = mid_by_sorted_lst

number_of_mid_case = countMid(mbsl, get_mid(rlsn))

prob_mid = getProbOfMid(mbsl, rlsn)

print("Number of mid cases appears on middle range : ", number_of_mid_case)
print("Probabibility of getting pivot from middle range {} %".format(round(prob_mid * 100, 2)) )