#include "../include/linalg.h"
#include <cstdio>

Vec3 *matToVec(Mat *m)
{
    if (m->row != 3 && m->col != 1)
    {
        fprintf(stderr, "Error : Can't convert Matrix to vector with [r,c] = [%d, %d]\n", m->row, m->col);
        exit(-5);
    }
    Vec3 *v = new Vec3((*m)(0, 0), (*m)(1, 0), (*m)(2, 0));
    // return (v);
    return (NULL);
}

// Mat *vecToMat(Vec3 *v)
// {
//     // Mat *m = new Mat(3, 1);
//     Vec3 *v = new Vec3((*m)(0, 0), (*m)(1, 0), (*m)(2, 0));
//     return (v);
// }