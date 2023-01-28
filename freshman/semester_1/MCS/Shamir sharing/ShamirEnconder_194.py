import random
import functools

_PRIME = 1723

_RINT = functools.partial(random.SystemRandom().randint, 0)

def _eval_at(poly, x, prime):
    """Evaluates polynomial (coefficient tuple) at x, used to generate a
    shamir pool in make_random_shares below.
    """
    accum = 0
    for coeff in reversed(poly):
        accum *= x
        accum += coeff
        accum %= prime
    return accum

def make_random_shares(secret, minimum, shares, prime=_PRIME):
    """
    Generates a random shamir pool for a given secret, returns share points.
    """
    if minimum > shares:
        raise ValueError("Pool secret would be irrecoverable.")
    poly = [secret] + [_RINT(prime - 1) for i in range(minimum - 1)]
    points = [(i, _eval_at(poly, i, prime)) for i in range(1, shares + 1)]
    return points,poly

def build_polynomial(poly):
    result = ''
    for i in range(0,len(poly)):
	    tmp = str(poly[i]) + 'x^'+ str(i) + ' + '
            #if i != len(poly):
                #tmp = tmp + ' + '
        result = result+tmp
        # result += tmp
    return result

def main():
    """Main function"""
    secret = int(input("Enter your secret :"))
    #567
    minimum = int(input("Enter your minimum member to recover :"))
    shares = int(input("How many people you sharing with :"))

    share,poly_1 = make_random_shares(secret, minimum, shares)

    print('Secret: ', secret)
    print('Shares:')
    if share:
        for shar in share:
            print('  ', shar)

    #print(poly_1)
    print('Polynomial: ', build_polynomial(poly_1))
    print("---------------------------------------------")

if __name__ == '__main__':
    main()
