#ifndef LINALG
#define LINALG

#define RESET   "\033[0m"
#define BLACK   "\033[30m"      /* Black */
#define RED     "\033[31m"      /* Red */
#define GREEN   "\033[32m"      /* Green */
#define YELLOW  "\033[33m"      /* Yellow */
#define BLUE    "\033[34m"      /* Blue */
#define MAGENTA "\033[35m"      /* Magenta */
#define CYAN    "\033[36m"      /* Cyan */
#define WHITE   "\033[37m"      /* White */
#define BOLDBLACK   "\033[1m\033[30m"      /* Bold Black */
#define BOLDRED     "\033[1m\033[31m"      /* Bold Red */
#define BOLDGREEN   "\033[1m\033[32m"      /* Bold Green */
#define BOLDYELLOW  "\033[1m\033[33m"      /* Bold Yellow */
#define BOLDBLUE    "\033[1m\033[34m"      /* Bold Blue */
#define BOLDMAGENTA "\033[1m\033[35m"      /* Bold Magenta */
#define BOLDCYAN    "\033[1m\033[36m"      /* Bold Cyan */
#define BOLDWHITE   "\033[1m\033[37m"      /* Bold White */

#include <iostream>
#include <vector>
#include <cstdio>
#include <cmath>
using namespace std;

typedef vector<float> Row;

typedef struct SMat {
    public:
        int row;
        int col;
        vector<Row> data;

        // SMat(int c, int r);
        SMat(int r, int c);
        Row &operator[](int i);
        // Row *operator[](int i);
        float &operator()(int i, int j);
        // float *operator()(int r, int c);
        // SMat* operator*(float scalar);
        SMat operator*(float scalar);
        // SMat* operator+()
} Mat;

// void M()
// {
//     // Row(5);
// }

typedef struct SVec3 : public SMat
{
    // SVec3(int x, int y, int z);
    public:
        float x;
        float y;
        float z;
        SVec3(float x, float y, float z);
        // float *operator[](int dim);
        SVec3 operator+(SVec3 other);
        SVec3 operator*(float scale);
    // NOTE : should not use this operator vec[0] , vec[1] what is we use vec[9] it's will bad
    // private:
    //     float &operator[](int dim);
} Vec3;



Mat *randmat(int r, int c, int start, int end);
Mat *randmat(int r, int c);
void printmat(Mat *m);
void prettyprint(Mat *m);
void prettyprint(Mat *m, bool isVisualize);
void prettyprint(Mat *m, bool isVisualize, int intervalDrawingMillisec);
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
Mat *matfill(int row, int col, float value);
Mat *zeros(int row, int col);
Mat *ones(int row, int col);
Vec3 *matToVec(Mat *m);
void matdrain(Mat *map, Vec3 *pos, float value);
void matdrain(Mat *map, Mat *pos, float value);
Mat guassianElimination();
Mat mergeMat(Mat A, Mat B, int dim);

#endif