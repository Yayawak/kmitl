#include "../include/linalg.h"

static bool isMultiplicable(Mat *a, Mat *b)
{
    return ((a->col == b->row) && (a->row == b->col));
}

Mat *matmul(Mat *a, Mat *b)
{
    // int partialSum = 0;
    if (!isMultiplicable(a, b))
        return (NULL);
    Mat *newM = new Mat(a->row, b->col);
    for (int xa = 0; xa < a->col; xa++)
    {
        for (int yb = 0; yb < b->row; yb++)
        {
            for (int k = 0; k < b->row; k++)
                (*newM)[xa][yb] += a->data[xa][k] * b->data[k][yb];
                // (*newM)[xa][yb] += a[xa][k] * b[k][yb];
        }
    }
    return (newM);
}
