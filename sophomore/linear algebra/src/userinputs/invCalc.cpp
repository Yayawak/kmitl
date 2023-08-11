#include "../include/linalg.h"

void inverseCalculator()
{
    cout << "You Want Inverse OF a MATRIX." << endl;
    Mat *M = recieveMatFromUserInput();
    // Mat *M = randmat(3, 3);
    prettyprint(M);

    // int d = det(M);
    cout << "Your Inverse Matrix IS : " << endl;
    prettyprint(inverseMatrix(M));
}
