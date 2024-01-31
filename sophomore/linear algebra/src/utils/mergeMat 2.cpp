#include "../include/linalg.h"
#include <cassert>

Mat mergeMat(Mat A, Mat B, int dim)
{
    // merge horizontally
    if (dim == 0)
    {
        assert(A.row == B.row);
        Mat C(A.row, A.col + B.col);

        // for (int k = 0; k < A.row * (A.col + B.col); k++)
        for (int i = 0; i < A.row; i++)
        {
            for (int j = 0; j < (A.col + B.col); j++)
            {
                if (j < A.col)
                {
                    C[i][j] = A[i][j];
                }
                else
                {
                    // printf("[%d][%d,%d]\n", j, i, j - (B.col + A.col - 1));
                    C[i][j] = B[i][j - (B.col + A.col - 1)];
                }
            }
        }
        return C;
    }
    // merge vertically
    else
    // else if (dim == 1)
    {
        assert(A.col == B.col);
        Mat C(A.row + B.row, A.col);

        // FIXME falut logic for now
        // for (int i = 0; i < A.row + B.row; i++)
        // {
        //     for (int j = 0; j < A.col; j++)
        //     {
        //         if (i < A.row)
        //         {
        //             C[i][j] = A[i][j];
        //         }
        //         else
        //         {
        //             C[i][j] = B[i][j];
        //         }
        //     }
        // }
        return C;
    }
}
