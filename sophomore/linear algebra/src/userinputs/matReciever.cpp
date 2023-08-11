#include "../include/linalg.h"

static vector<float> getRowCol()
{
    vector<float> rc(2);

    cout << "How many Row of matrix : ";
    cin >> rc[0];
    cout << "How many Column of matrix : ";
    cin >> rc[1];

    cout << "R : " << rc[0] << "\tC : " << rc[0] << endl;
    return (rc);
}

static void enterEntry(float *a, int i, int j)
{
    cout << "Enter Entry(" << i << "," << j << ") : ";
    cin >> *a;
}

Mat *recieveMatFromUserInput()
{
    // vector<int> rc = getRowCol();
    vector<float> rc = getRowCol();
    // Mat m(rc[0], rc[1]);
    Mat *m = new Mat(rc[0], rc[1]);
    // for (int i = 0;)
    matiterij(m, enterEntry);
    return (m);
}

