#include "../include/linalg.h"

Mat *matfill(int row, int col, float value)
{
    Mat *m = new Mat(row, col);
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            (*m)(i, j) = value;
        }
    }
    return (m);
}