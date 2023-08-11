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


// // template <typename T>
// typedef struct SMat {
// // class Mat {
//     int row;
//     int col;
//     typedef vector<int> Row;
//     vector<Row> data;
//     // int data[][];

//     SMat(int c, int r);
//     // col(c), row(r), data(r, Row(c))
//     // {
//     //     for (int i = 0; i < r; i++)
//     //     {
//     //         data[i] = Row(c);
//     //         // data.push_back(Row(c));
//     //     }

//     // }
//     // col(c), row(r), data(r, vector<int>(col)) { }

//     Row &operator[](int i);
//     // {
//     //     return data[i];
//     // }
//     int &operator()(int i, int j);
//     // {
//     //     return data[i][j];
//     // }
// } Mat;

#endif