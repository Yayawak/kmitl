#include "../include/linalg.h"

// NOTE this function -> replace b vector to a matrix map
void matdrain(Mat *map, Vec3 *pos, float value)
{
    // (*map)((*pos)[0], ((*pos)[1])) = value;
    (*map)(pos->x, pos->y) = value;
}

void matdrain(Mat *map, Mat *pos, float value)
{
    // (*map)((*pos)(1, 0), (*pos)(0, 0)) = value;
    // (*map)((int)(*pos)(1, 0), (int)(*pos)(0, 0)) = value;
    (*map)((*pos)(0, 0), (*pos)(1, 0)) = value;
}