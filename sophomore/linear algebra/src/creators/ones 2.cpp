#include "../include/linalg.h"

Mat *ones(int row, int col)
{
    return (matfill(row, col, 1));
}