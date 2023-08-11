#include "src/include/linalg.h"
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
    int a[] = {1, 2, 3, 4};
    vector<int> firstRow(a, a + (sizeof(a) / sizeof(a[0])));
    // firstRow[0] = 1;
    // Mat m(2, 2);
    // m.data[0][0] = 9;
    Mat* A = new Mat(2, 2);
    (*A)(0, 0) = -2;
    (*A)(0, 1) = 1;
    (*A)(1, 0) = 0;
    (*A)(1, 1) = 4;

    Mat B(2, 2);
    B(0, 0) = 6;
    B(0, 1) = 5;
    B(1, 0) = -7;
    B(1, 1) = 1;

    Mat C(3, 3);
    C(0, 0) = 2;
    C(0, 1) = 3;
    C(0, 2) = 4;
    C(1, 0) = 3;
    C(1, 1) = 9;
    C(1, 2) = 8;
    C(2, 0) = 1;
    C(2, 1) = 3;
    C(2, 2) = 8;
    // Mat* m = randmat(4, 4, 0, 10);

    // printf("test : %d\n", m->data[2][0]);
    // printmat(m);

    // prettyprint(A);
    prettyprint(&C);
    Mat *cof_C = cofactorMatrix(&C);
    prettyprint(cof_C);

    // prettyprint(transpose(cof_C));
    printf("det of C = %f\n", det(&C));
    prettyprint(inverseMatrix(&C));

    // prettyprint(matmul(A, &B));
    // cout << "det of A is : " << det(&B) << endl;

}

int main(void)
{
    // detcalc();
    // gtk
    // testmat();
    inverseCalculator();
    return (0);
}
