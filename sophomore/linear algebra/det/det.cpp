#include "../include/linalg.h"

int det(Mat *m)
{
    int n;
    int determinant;

    if (!isSquare(m))
    {
        cout << "Error : Not Square Matrix -> can't find Det.";
        return (0);
    }
    n = m->row;
    if (n == 2)
        return (((*m)(0, 0) * (*m)(1, 1)) - ((*m)(0, 1) * (*m)(1, 0)));

    determinant = 0;
    for (int i = 0; i < n; i++)
    {
        Mat minorM(n - 1, n - 1);
        for (int j = 1; j < n; j++)
        {
            // NOTE : use column 0 as pivot column
            int colIdx = 0;
            for (int k = 0; k < n; k++)
            {
                if (k != i)
                    minorM[j - 1][colIdx++] = (*m)(j, k);
            }
        }
        determinant += pow(-1, i) * (*m)(0, i) * det(&minorM);
    }
    return (determinant);
}

