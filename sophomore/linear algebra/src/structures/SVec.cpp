#ifndef Vec3_H
#define Vec3_H
#include "../include/linalg.h"

// FIXME : Not cllaed SMat constructor properly
SVec3::SVec3(float x, float y, float z) : SMat::SMat(3, 1), x(x), y(y), z(z)
// SVec3::SVec3(float x, float y, float z) : SMat::SMat{3, 1}, x(x), y(y), z(z)
{
    // row = 3;
    // std::cout << "Init vec3 \n";
    // col = 1;
    // Row rx(1);
    // Row ry(1);
    // Row rz(1);
    // rx[0] = x;
    // ry[0] = y;
    // rz[0] = z;
    // data[0] = rx;
    // data[1] = ry;
    // data[2] = rz;o
    // printf("init vector (x,y,z) = (%f,%f,%f)\n", x, y, z);
    
    this->x = x;
    this->y = y;
    this->z = z;
    

    data[0][0] = x;
    data[1][0] = y;
    data[2][0] = z;
    
}

// float& SVec3::operator[](int dim)
// // float* SVec3::operator[](int dim)
// {
//     if (dim > row - 1)
//     {
//         fprintf(stderr, "Error Getting Element Out of Bound Vector3\n");
//         exit(-4);
//     }
//     if (dim == 0)
//     {

//     }
//     else if (dim == 1)
//     {

//     }
//     else if (dim == 2)
//     {

//     }
//     // return (&data[dim][0]);
//     return (data[dim][0]);
// }

SVec3 SVec3::operator*(float scale)
{
    // printf("before scaling vector. (x,y,z) = (%f,%f,%f)\n", x, y, z);
    SVec3 ret(x * scale, y * scale, z * scale);
    return (ret);
}

SVec3 SVec3::operator+(SVec3 otherVector)
{
    SVec3 ret(otherVector.x + x, otherVector.y + y, otherVector.z + z);
    return (ret);
}



#endif