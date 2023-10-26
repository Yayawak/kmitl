#include "src/include/linalg.h"
#include <chrono>
#include <cstdlib>
#include <thread>
#include <vector>
// #include <gtk/gui.h>
// #include <gtk/gtk.h>
// #include <gtk/gtk.h>
// #include <gtkmm.h>
// #include "opt/homebrew/Cellar/gtkmm/2.24.5_8/include/gtkmm-2.4/gtkmm.h"
// #include <OpenGL/OpenGL.h>
// #include "/opt/homebrew/Cellar/gtk+3/3.24.38/include/gtk-3.0/gtk/gtk.h"

static void testmat()
{
    // vector<int> firstRow = vector<int>();
    // int a[] = {1, 2, 3, 4};
    // vector<int> firstRow(a, a + (sizeof(a) / sizeof(a[0])));
    // // firstRow[0] = 1;
    // // Mat m(2, 2);
    // // m.data[0][0] = 9;
    // Mat* A = new Mat(2, 2);
    // (*A)(0, 0) = -2;
    // (*A)(0, 1) = 1;
    // (*A)(1, 0) = 0;
    // (*A)(1, 1) = 4;

    // Mat B(2, 2);
    // B(0, 0) = 6;
    // B(0, 1) = 5;
    // B(1, 0) = -7;
    // B(1, 1) = 1;

    // Mat C(3, 3);
    // C(0, 0) = 2;
    // C(0, 1) = 3;
    // C(0, 2) = 4;
    // C(1, 0) = 3;
    // C(1, 1) = 9;
    // C(1, 2) = 8;
    // C(2, 0) = 1;
    // C(2, 1) = 3;
    // C(2, 2) = 8;
    // Mat* m = randmat(4, 4, 0, 10);

    // printf("test : %d\n", m->data[2][0]);
    // printmat(m);

    // prettyprint(A);
    // prettyprint(&C);
    // Mat *cof_C = cofactorMatrix(&C);
    // prettyprint(cof_C);

    // prettyprint(transpose(cof_C));
    // printf("det of C = %f\n", det(&C));
    // prettyprint(inverseMatrix(&C));

    // prettyprint(matmul(A, &B));
    // cout << "det of A is : " << det(&B) << endl;

}

static int test_matmul(float sensitivity)
{
    // std::cout << "Testing matrix multiplication\n";
    float p_inputs[] = {
        1, 0, 0, 0,
        // sensitivity, 0, 0, 0,
        0, 1, 0, 0,
        // 0, sensitivity, 0, 0,
        0, 0, 1, 0,
    };
    // float flatpos[] = {0, 2, 3, 1};
    Mat *pinholeCam = flatToMat(3, 4, p_inputs);
    // Mat *pos3D = flatToMat(4, 1, flatpos);
    // prettyprint(pinholeCam);
    // prettyprint(pos3D);

    // std::cout << "matmul : \n";
    // Mat *pos2d = matmul(pinholeCam, pos3D);
    // Vec3 *vecPos2d = matToVec(pos2d);
    
    // prettyprint(pos2d);
    // FIXME this function still bug on vec3
    // prettyprint(vecPos2d);
    // Vec3 

    int size = 40;
    // Mat *map = zeros(20, 20);
    Mat *map = zeros(size, size);
    // Mat *map = zeros(10, 10);
    // Mat *map = zeros(40, 40);
    // prettyprint(map);
    // matdrain(map, vecPos2d, 1);
    
    //SECTION making data (3d positions)
    float x = 0;
    float stepX = 0.1f; // essential as y
    // binaryPrint(map);
    while (x < size)
    {
        // float y = 10 * sin(x * 0.51f);
        float y = 10 * sin(x * sensitivity);
        // int z = x * 1.1f;
        // float z = x * 0.1f;
        float z = 1; // no essential 
        // float z = x;
        if (y > size)  break;
        if (x > size)  break;
        // if (x > 20) 
        // printf("[%f, %f, %f]\n", x, y, z);
        // (int)
        float flatpos[] = {x, y, z, 1.0f};
        Mat *pos3D = flatToMat(4, 1, flatpos);
        Mat *pos2d = matmul(pinholeCam, pos3D);
        Vec3 *vecPos2d = matToVec(pos2d);

        matdrain(map, pos2d, 1);

        x += stepX;
    }

    std::cout << "---------------------\n";
    binaryPrint(map);
    return (0);
}

int main(void)
{
    // detcalc();
    // gtk
    // testmat();
    // inverseCalculator();

    // float senst = 0.01f;
    // while (true)
    // {
    //     if (senst > 1.f)
    //         senst = 0;
    //     test_matmul(senst);
    //     senst += 0.01f;
    //     this_thread::sleep_for(std::chrono::nanoseconds(100000000 / 2));
    //     system("clear");
    // }
    guassianElimination();

    return (0);
}
