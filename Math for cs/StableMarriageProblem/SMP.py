import numpy as np
womenOrd_with_preference = \
"""
1 3 4 2 1 6 7 5
2 6 4 2 3 5 1 7
3 6 3 5 7 2 4 1
4 1 6 3 2 4 7 5
5 1 6 5 3 4 7 2
6 1 7 3 4 5 6 2
7 5 6 2 4 3 7 1"""
menOrd_with_preference = \
"""1 4 5 3 7 2 6 1
2 5 6 4 7 3 2 1
3 1 6 5 4 3 7 2
4 3 5 6 7 2 4 1
5 1 7 6 4 3 5 2
6 6 3 7 5 2 4 1
7 1 7 4 2 6 5 3"""
def strMatrix2List(ord_with_pref="", n_row=0):
    k = ord_with_pref.split()
    k = np.array([int(ki) for ki in k])
    ord_with_pref = k.reshape(n_row,-1)
    ord_with_pref = [ list(row) for row in ord_with_pref ]
    return ord_with_pref

def SMP_v3(womenOrder_with_herPreference_str,
            menOrder_with_hisPreference_str, n=0):
    women = []
    men = []
    women =strMatrix2List(womenOrder_with_herPreference_str
                ,n)
    men = strMatrix2List(menOrder_with_hisPreference_str,
                n)
    wi = [-1]*n
    mi = [1]*n
    while -1 in wi:
        for m0 in range(n):
            w0 = men[m0][mi[m0]] - 1
            if(wi[w0] < 0):
                wi[w0] = m0
            else:
                p0 = women[w0][1:].index(wi[w0]+1)
                p1 = women[w0][1:].index(m0+1)
                if p1<p0: # new men
                    mi[wi[w0]] = mi[wi[w0]] + 1
                    wi[w0] = m0
                elif p0<p1: # same man
                    mi[m0] = mi[m0] + 1
    for w in range(n):
        print(w+1, wi[w]+1)
SMP_v3(womenOrd_with_preference,
    menOrd_with_preference, 7)
