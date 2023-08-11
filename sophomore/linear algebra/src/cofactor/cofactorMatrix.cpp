#include "../include/linalg.h"
#include <chrono>
#include <cstdio>
#include <iostream>
#include <thread>

static void getMinorMatrix(Mat *M, int excludeRow,
    int excludeCol, Mat *minorMat
    ) {
    int n = M->row;
    int minorRow = 0;
    int minorCol = 0;

    for (int r = 0; r < n; r++) 
    {
        if (r != excludeRow) 
        {
            for (int c = 0; c < n; c++) 
            {
                if (c != excludeCol) 
                {
                    // printf("minorMat[%d,%d]\n", minorRow, minorCol);
                    (*minorMat)(minorRow, minorCol++) = (*M)(r, c);
                }
            }
            minorCol = 0;
            minorRow++;
        }
    }
}

// static Mat *cofactorMatrix(Mat *M, bool _playAnimation) 
// {
//     int n = M->row;
//     Mat *cofM = new Mat(n, n);
//     if (_playAnimation)
//         system("clear");
//     for (int i = 0; i < n; i++) 
//     {
//         for (int j = 0; j < n; j++) 
//         {
//             Mat minorMatrix(n - 1, n - 1);
//             getMinorMatrix(M, i, j, &minorMatrix);
//             int cofactor = det(&minorMatrix);
//             if ((i + j) % 2 == 1)
//             {
//                 cofactor = -cofactor;
//             }
//             (*cofM)(i, j) = cofactor;
//             if (_playAnimation)
//             {
//                 prettyprint(cofM);
//                 std::this_thread::sleep_for(std::chrono::nanoseconds(1000000000 / 2));
//                 system("clear");
//             }
//         }
//     }
//     return (cofM);

// }

Mat *cofactorMatrix(Mat *M) 
{
    int n = M->row;
    Mat *cofM = new Mat(n, n);
    for (int i = 0; i < n; i++) 
    {
        for (int j = 0; j < n; j++) 
        {
            Mat minorMatrix(n - 1, n - 1);
            getMinorMatrix(M, i, j, &minorMatrix);
            int cofactor = det(&minorMatrix);
            if ((i + j) % 2 == 1)
            {
                cofactor = -cofactor;
            }
            (*cofM)(i, j) = cofactor;
        }
    }
    return (cofM);
}