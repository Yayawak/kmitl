#include "../include/linalg.h"

static vector<int> getRowCol()
{
    // int row;
    // int col;
    vector<int> rc(2);

    cout << "How many Row of matrix : ";
    // cin >> row;
    cin >> rc[0];
    cout << "How many Column of matrix : ";
    cin >> rc[1];

    cout << "R : " << rc[0] << "\tC : " << rc[0] << endl;
    // cout << "R : " << row << "\tC : " << col << endl;
    return (rc);
}


static void enterEntry(int *a, int i, int j)
{
    cout << "Enter Entry(" << i << "," << j << ") : ";
    cin >> *a;
}


Mat *recieveMatFromUserInput()
{
    vector<int> rc = getRowCol();
    // Mat m(rc[0], rc[1]);
    Mat *m = new Mat(rc[0], rc[1]);
    // for (int i = 0;)
    matiterij(m, enterEntry);
    return (m);
}

