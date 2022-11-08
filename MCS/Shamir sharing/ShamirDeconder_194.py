from __future__ import division
from __future__ import print_function
import numpy as np
from scipy.interpolate import lagrange
from numpy.polynomial.polynomial import Polynomial

_PRIME = 1723

def _extended_gcd(a, b):
    
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
    
    inv, _ = _extended_gcd(den, p)
    return num * inv

def _lagrange_interpolate(x, x_s, y_s, p):

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


def recover_secret(shares, prime=_PRIME):
    """
    Recover the secret from share points
    (x, y points on the polynomial).
    """
    if len(shares) < 2:
        raise ValueError("need at least two shares")
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
	#print('Polynomial :',P)
    #print('Secret recovered from a different minimum subset of shares: ',
          #recover_secret(shares[-minimum:]))

def main():
    """Main function"""

    minimum = int(input("minimum member to unlock:"))
    
    x = []
    y = []

    for i in range(minimum) :
        n = int(input("enter coordinate x:"))
        x.append(n)
        m = int(input("enter coordinate y:"))
        y.append(m)
      

    tmp = zip(x,y)
    shares = list(tmp)

    print('Polynomial :',poly(x,y))
    print(shares)
    print('Secret recovered from minimum subset of shares:             ',
          recover_secret(shares[:minimum]))
	


if __name__ == '__main__':
    main()