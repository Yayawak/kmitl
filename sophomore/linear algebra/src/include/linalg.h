#ifndef LINALG
#define LINALG


#include <iostream>
#include <vector>
#include <cstdio>
#include <cmath>
using namespace std;

typedef struct SMat {
    int row;
    int col;
    typedef vector<float> Row;
    vector<Row> data;

    SMat(int c, int r);
    Row &operator[](int i);
    float &operator()(int i, int j);
    // float *operator()(int r, int c);
    SMat* operator*(float scalar);
} Mat;




Mat *randmat(int r, int c, int start, int end);
Mat *randmat(int r, int c);
void printmat(Mat *m);
void prettyprint(Mat *m);
static bool isMultiplicable(Mat *a, Mat *b);
Mat *matmul(Mat *a, Mat *b);
bool isSquare(Mat *m);
float det(Mat *m);
Mat *recieveMatFromUserInput();
void matiter(Mat *m, void (*f)(float *));
void matiterij(Mat *m, void (*f)(float *, int i, int j));
void detcalc();
Mat *cofactorMatrix(Mat *m);
Mat *transpose(Mat *m);
Mat* inverseMatrix(Mat* m);
void inverseCalculator();
Mat* flatToMat(int row, int col, float flattenArray[]);
void binaryPrint(Mat *m);



#endif