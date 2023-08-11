#include "../include/linalg.h"

Mat* transpose(Mat *m)
{
    Mat* T = new Mat(m->col, m->row);
    for (int i = 0; i < m->row; i++)
    {
        for (int j = 0; j < m->col; j++)
        {
            (*T)(j, i) = (*m)(i, j);
        }
    }
    return (T);
}
