import matplotlib.pyplot as plt
import numpy as np
import matplotlib as mpl
import math
mpl.use('tkagg')


# xl = 1
# xu = 2
# x = np.arange(1, 2, 0.05)
# x = np.arange(-5, 5, 0.05)

# def fn(x):
#     return x ** 3 - 3

# y = fn(x)
# # print(x)

# plt.plot(x, y)
# plt.show()


def fn(x):
    # return math.e ** x
    return (x + 10) ** (1/4)

# def fixed_simple(fn):
def fixed_simple(fn, start_guess_x=0):
    x = start_guess_x
    X = []
    Y = []
    for i in range(10):
        X += [i]
        x = fn(x)
        Y += [x]
        # print(x)
    print(X)
    print(Y)
    # plt.scatter(X, Y)
    # plt.plot(X, Y, color='red')
    plt.plot(X, Y, color='red')
    plt.show()
    return Y[-1]

root = fixed_simple(fn)
print("test on ", root)

