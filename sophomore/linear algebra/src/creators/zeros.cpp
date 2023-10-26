#include "../include/linalg.h"

Mat *zeros(int row, int col)
{
    return (matfill(row, col, 0));
}