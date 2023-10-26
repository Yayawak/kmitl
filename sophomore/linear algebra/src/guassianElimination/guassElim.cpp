#include "../include/linalg.h"
#include <algorithm>
#include <chrono>
#include <thread>
#include <vector>

#define __TEST__
#ifdef __TEST__

static Mat getTestCase()
{
    std::cout << "Enter Coefficient Matrix\n";
    // Mat *coefMat = recieveMatFromUserInput();
    Mat coefMat = Mat(3, 3);
    coefMat[0][0] = 2;
    coefMat[0][1] = 3;
    coefMat[0][2] = 4;

    coefMat[1][0] = 5;
    coefMat[1][1] = 6;
    coefMat[1][2] = 7;

    coefMat[2][0] = 8;
    coefMat[2][1] = 9;
    coefMat[2][2] = 3;
    prettyprint(&coefMat);

    std::cout << "\nEnter B Matrix\n";
    Mat BMat = Mat(3, 1);
    BMat[0][0] = 1;
    BMat[1][0] = 2;
    BMat[2][0] = 3;
    prettyprint(&BMat);

    Mat CombinedMat = mergeMat(coefMat, BMat, 0);
    return (CombinedMat);
}

#endif

static Mat getCombinedMatrixFromInput()
{


    std::cout << "Enter Coefficient Matrix\n";
    Mat *coefMat = recieveMatFromUserInput();
    prettyprint(coefMat);

    std::cout << "\nEnter B Matrix\n";
    Mat *BMat = recieveMatFromUserInput();
    prettyprint(BMat);

    Mat CombinedMat = mergeMat(*coefMat, *BMat, 0);
    return (CombinedMat);
}

static Mat forward(Mat CombinedMat)
{
    // Mat CombinedMat = getCombinedMatrixFromInput();
    prettyprint(&CombinedMat);

    // for (int c = 0; c < coefMat.col; c++)
    for (int c = 0; c < CombinedMat.col - 1; c++)
    {
        for (int r = c; r < CombinedMat.row; r++)
        {
            printf("processing on (r,c) = (%d,%d) ....\n", r, c);

            float pivot = CombinedMat[r][r];
            float entry = CombinedMat[r][c];
            if (c == r)
            {
                // for (int i = 0; i < coefMat.col; i++)
                for (int i = 0; i < CombinedMat.col; i++)
                {
                    // coefMat[r][i] /= pivot;    
                    CombinedMat[r][i] /= pivot;    
                }
                // BMat[r][c] /= pivot;
                // prettyprint(&CombinedMat);
                // prettyprint(&CombinedMat, true);
            }
            else
            {
                SMat pivotMat(1, CombinedMat.col);

                int i = 0;
                for (; i < CombinedMat.col; i++)
                {
                    pivotMat[0][i] = CombinedMat[c][i];
                }
                // prettyprint(&pivotMat);
                pivotMat = pivotMat * entry;
                // prettyprint(&pivotMat);

                i = 0;
                for (; i < CombinedMat.col; i++)
                {
                    CombinedMat[r][i] -= pivotMat[0][i];
                }
                // prettyprint(&pivotMat);
                // prettyprint(&CombinedMat);

                // prettyprint(&pivotMat, true);
                // prettyprint(&CombinedMat, true);
            }
            // std::cout << "================================\n\n";

            // this_thread::sleep_for(chrono::nanoseconds((int)pow(10, 9)));
        }
    }

    std::cout << "\n\nEND OF PROCESSING.\n";
    prettyprint(&CombinedMat, true);
    std::cout << "*************************************************\n";
    // "a" + "b";

    return (CombinedMat);
}

// ? return vector of n rows (x0, x1, x2, ...)
static Mat backward(Mat combinedMatrix)
{
    Mat solutionMat(combinedMatrix.row, 1);
    // return ;

    const int n = combinedMatrix.row;
    float x_n = combinedMatrix[n - 1][combinedMatrix.col - 1] / combinedMatrix[n - 1][n - 1];

    std::cout << "x_n = " << x_n << std::endl;
    
    for (int r = n - 1; r >= 0; --r)
    {
        const float y = combinedMatrix[r][combinedMatrix.col - 1];
        const float diagElement = combinedMatrix[r][r];
        // NOTE sum of old x
        float sum = 0.f;
        for (int j = r + 1; j < n; ++j)
        {
            sum += combinedMatrix[r][j] * solutionMat[j][0];
        }
        // printf("(y,sum,diag) = (%f,%f,%f)\n", y, sum, diagElement);
        float x_i = (y - sum) / (diagElement);
        // std::cout << "x " << r << " = " << x_i << std::endl;
        solutionMat[r][0] = x_i;
    }
    return (solutionMat);
}

Mat guassianElimination()
{
    // Mat combinedMatrixInput = getCombinedMatrixFromInput();
    Mat combinedMatrixInput = getTestCase();
    // Mat combinedMatrixInput = *randmat(6, 7);
    // Mat combinedMatrixInput = *randmat(8, 9);
    Mat U = forward(combinedMatrixInput);
    Mat solutionMat = backward(U);

    std::cout << "SOLUTION VECTOR : \n";
    prettyprint(&solutionMat);
    return (solutionMat);
}