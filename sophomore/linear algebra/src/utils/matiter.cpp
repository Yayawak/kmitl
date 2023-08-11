#include "../include/linalg.h"

// void matIter(Mat *m, void (*f)(Mat*))
void matiter(Mat *m, void (*f)(float *))
{
    for (int i = 0; i < m->row; i++)
        for (int j = 0; j < m->col; j++)
        {
            f(&(m->data[i][j]));
        }
}

void matiterij(Mat *m, void (*f)(float *, int i, int j))
{
    for (int i = 0; i < m->row; i++)
        for (int j = 0; j < m->col; j++)
        {
            f(&(m->data[i][j]), i, j);
        }
}
