#include "../include/linalg.h"

Mat* flatToMat(int row, int col, float flattenArray[])
{
    Mat *ret = new Mat(row, col);
    int i = 0;
    for (int r = 0; r < row; r++)
    {
        for (int c = 0; c < col; c++)
        {
            // std::cout << r << "," << c << std::endl;
            (*ret)(r, c) = flattenArray[i];
            i++;
        }
    }
    return (ret);
}