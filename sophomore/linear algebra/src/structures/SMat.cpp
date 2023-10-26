#ifndef SMat_H
#define SMat_H
#include "../include/linalg.h"
#include <math.h>


SMat::SMat(int r, int c) : col(c), row(r), data(r, Row(c))
{
    // std::cout << "init Mat\n";
    for (int i = 0; i < r; i++)
    {
        // each row have c columns
        data[i] = Row(c);
        // data.push_back(Row(c));
    }
}

// SMat::Row& SMat::operator[](int i)
Row& SMat::operator[](int i)
// Row& SMat::SMat::operator[](int i)
{
    return data[i];
}

float& SMat::operator()(int i, int j)
// SMat::float& operator()(int i, int j)
{
    return data[i][j];
}

// Mat* Mat::operator*(float scalar)
Mat Mat::operator*(float scalar)
{
    Mat ret(row, col);
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            // (*ret)(i, j) = (*this)(i, j) * scalar;
            (ret)(i, j) = (*this)(i, j) * scalar;
        }
    }
    return (ret);
}

#endif