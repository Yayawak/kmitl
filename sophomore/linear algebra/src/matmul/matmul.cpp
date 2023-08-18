#include "../include/linalg.h"

static bool isMultiplicable(Mat *a, Mat *b)
{
    bool isValid = (a->col == b->row);
    if (!isValid)
    {
        printf("A's dim = [%d,%d]\n", a->row, a->col);
        printf("B's dim = [%d,%d]\n", b->row, b->col);
        std::cout << "Matrix multiplication failed due to invalid dimension multiplication.";
        exit(-3);
    }
    return isValid;
}

Mat *matmul(Mat *a, Mat *b)
{
    // int partialSum = 0;
    if (!isMultiplicable(a, b))
        return (NULL);
    // std::cout << "HERE\n";
    Mat *newM = new Mat(a->row, b->col);
    // for (int yb = 0; yb < b->row; yb++)
    // {
    //     for (int xa = 0; xa < a->col; xa++)
    //     {
    //         for (int k = 0; k < b->row; k++)
    //             (*newM)[yb][xa] += a->data[xa][k] * b->data[k][yb];
    //             // (*newM)[xa][yb] += a[xa][k] * b[k][yb];
    //     }
    // }
    // NOTE this is work in 3x3 and squrares ones (but not for rectangular)
    // for (int xa = 0; xa < a->col; xa++)
    // {
    //     for (int yb = 0; yb < b->row; yb++)
    //     {
    //         for (int k = 0; k < b->row; k++)
    //             (*newM)[xa][yb] += a->data[xa][k] * b->data[k][yb];
    //             // (*newM)[yb][xa] += a->data[xa][k] * b->data[k][yb];
    //             // (*newM)[xa][yb] += a[xa][k] * b[k][yb];
    //     }
    // }
    //LINK : i'm really proud of myself that i'm doing this by my own thought expiriment
    for (int arow = 0; arow < a->row; arow++)
    {
        for (int bcol = 0; bcol < b->col; bcol++)
        {
            for (int innerSumIndex = 0; innerSumIndex < a->col; innerSumIndex++)
            {
                (*newM)(arow, bcol) += (*a)(arow, innerSumIndex) * (*b)(innerSumIndex, bcol);
            }
        }
    }
    return (newM);
}
