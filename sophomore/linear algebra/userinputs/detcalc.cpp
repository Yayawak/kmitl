#include "../include/linalg.h"

void detcalc()
{
    cout << "You Want DETERMINANT OF MATRIX." << endl;
    Mat *M = recieveMatFromUserInput();
    // Mat *M = randmat(3, 3);
    prettyprint(M);

    int d = det(M);
    cout << "Your DETERMINANT IS : " << d << endl;
}
