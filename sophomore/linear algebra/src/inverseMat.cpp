#include "include/linalg.h"

Mat* inverseMatrix(Mat* m)
{
    float determinant = det(m);
    if (determinant == 0)
    {
        std::cout << "Singular Matrix -> no det & no inverse" << std::endl;
        return (NULL);
    }
    // return ((1 / determinant) * cofactorMatrix(m));
    // prettyprint((transpose(cofactorMatrix(m))));
    // return ((*transpose(cofactorMatrix(m))) * (1.f / determinant));
    // Mat *ret = null;
    // Mat ret = (*transpose(cofactorMatrix(m))) * (1.f / determinant);
    Mat *ret = new Mat(1, 1);

    *ret = (*transpose(cofactorMatrix(m))) * (1.f / determinant);
    return (ret);
}