from scipy.interpolate import lagrange
from numpy.polynomial.polynomial import Polynomial
import numpy as np
import os

def _extended_gcd(a, b):
    """
    Division in integers modulus p means finding the inverse of the
    denominator modulo p and then multiplying the numerator by this
    inverse (Note: inverse of A is B such that A*B % p == 1). This can
    be computed via the extended Euclidean algorithm
    http://en.wikipedia.org/wiki/Modular_multiplicative_inverse#Computation
    """
    x = 0
    last_x = 1
    y = 1
    last_y = 0
    while b != 0:
        quot = a // b
        a, b = b, a % b
        x, last_x = last_x - quot * x, x
        y, last_y = last_y - quot * y, y
    return last_x, last_y

def _divmod(num, den, p):
    """Compute num / den modulo prime p

    To explain this, the result will be such that: 
    den * _divmod(num, den, p) % p == num
    """
    inv, _ = _extended_gcd(den, p)
    return num * inv

def _lagrange_interpolate(x, x_s, y_s, p):
    """
    Find the y-value for the given x, given n (x, y) points;
    k points will define a polynomial of up to kth order.
    """
    k = len(x_s)
    assert k == len(set(x_s)), "points must be distinct"
    def PI(vals):  # upper-case PI -- product of inputs
        accum = 1
        for v in vals:
            accum *= v
        return accum
    nums = []  # avoid inexact division
    dens = []
    for i in range(k):
        others = list(x_s)
        cur = others.pop(i)
        nums.append(PI(x - o for o in others))
        dens.append(PI(cur - o for o in others))
    den = PI(dens)
    num = sum([_divmod(nums[i] * den * y_s[i] % p, dens[i], p)
               for i in range(k)])
    return (_divmod(num, den, p) + p) % p

def recover_secret(shares, prime, minimum):
    """
    Recover the secret from share points
    (points (x,y) on the polynomial).
    """
    if len(shares) < minimum:
        raise ValueError(f"need at least {minimum} shares")
    x_s, y_s = zip(*shares)
    return _lagrange_interpolate(0, x_s, y_s, prime)

def poly(x,y):
    x_1 = np.array(x)
    y_1 = np.array(y)
    poly = lagrange(x_1, y_1)
    P_coeff = np.array(Polynomial(poly).coef)
    reverse_P_coeff = P_coeff[::-1]
    P = Polynomial(reverse_P_coeff)
    return P
    #return reverse_P_coeff



shares = []
def recieve_shares_from_keyboard():
    x = []
    y = []
    p = 1723
    minimum = int(input("Enter threshold to unlock secret : "))
    for i in range(minimum):
        share = input("Enter you coordination : ").split()
        share = [int(share[0]), int(share[1])] # x, y => int
        shares.append(share)
        
        x.append(int(share[0]))
        y.append(int(share[1]))
    
    _pl = [coef % p for coef in poly(x, y)]
    pl = " ".join([str(_) for _ in _pl])
    # pl = " ".join([str(_) for _ in poly(x, y)])
    print("polynomial coefficients is : ", pl)
    S = recover_secret(shares[:minimum], p, minimum)
    print("Secret recoverd from minimum subset of shares :\t", S)
    
    path = "Output/DecoderOutput.txt"
    if not os.path.exists("Output"):
        os.makedirs("Output")
    with open(path, 'a+', encoding='utf-8') as f:
        f.write("Secret is : " + str(S) + "\n")
        f.write("Decrypted with threshold = " + str(minimum))
        f.write("polynomial is : \t" + pl + "\n")
        f.write("\n\n")


        
    # print(shares)

def main():
    recieve_shares_from_keyboard()

if __name__ == '__main__':
    main()