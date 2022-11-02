import random
import functools
import os



# 12th Mersenne Prime
# (for this application we want a known prime number as close as
# possible to our security level; e.g.  desired security level of 128
# bits -- too large and all the ciphertext is large; too small and
# security is compromised)
# The 13th Mersenne Prime is 2**521 - 1

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

def make_random_shares(secret, minimum, shares, prime):
    """
    Generates a random shamir pool for a given secret, returns share points.
    """
    if minimum > shares:
        raise ValueError("Pool secret would be irrecoverable.")
    poly = [secret] + [_RINT(prime - 1) for i in range(minimum - 1)]
    points = [(i, _eval_at(poly, i, prime))
              for i in range(1, shares + 1)]
    return (points, poly)


# ENCODER

def receive_secret():
    S = int(input("Enter your secret : "))
    threshold = int(input("Enter your minimum threshold to unlock : "))
    # p = int(input("Enter you prime"))
    p = 1723
    shares, poly = make_random_shares(S, minimum=threshold,
                                shares=6,
                               prime=p)
    path = "Output/EncoderOutput.txt"
    if not os.path.exists("Output"):
        os.makedirs("Output")
    with open(path, 'a+', encoding='utf-8') as f:
        f.write("Secret is : " + str(S) + "\n")
        f.write("Threshold value is : " + str(threshold))
        f.write("Shares from encryption are : \t")
        f.write(" ".join([str(elem) for elem in shares]) + "\n")
        f.write("polynomial is : \t")
        f.write(" ".join([str(elem) for elem in poly]) + "\n")
        f.write("\n\n")


    print('Secret:', S)
    print('Shares from encryption :', shares)
    print("Polynomial is ", poly)
    


def main():
    """Main function"""
    # secret = 1234
    # p = 2723

    receive_secret()
    
#    shares, _ = make_random_shares(1234, minimum=3, shares=6, prime=p)

if __name__ == '__main__':
    main()