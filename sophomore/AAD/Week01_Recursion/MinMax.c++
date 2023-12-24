#ifndef MnMx_H
#define MnMx_H
#include <stdio.h>
#include <math.h>

typedef struct MinMaxSolution
{
    int min;
    int max;

    MinMaxSolution(int mn, int mx)
    {
        min = mn;
        max = mx;
        // print();
    }

    void print()
    {
        printf("min = %d, max = %d\n", min, max);
    }

} MinMaxSolution;



// static MinMaxSolution findMinMax(int a[], int l, int h, const int n)
static MinMaxSolution findMinMax(int a[], int l, int h)
{
    // printf("l = %d, h = %d, n = %d\n", l, h, n);
    // printf("l = %d, h = %d\n", l, h);
    // for (int i = l; i <= h; i++)
    //     // printf("%d, ", a[l + i]);
    //     printf("%d, ", a[i]);
    // printf("\n\n");

    // * cant use sizeof n = sizeof(arr) / 8
    // printf("n = %d\n\n", n);
    // if (n == 2)
    // {
        if (l == h)
        {
            return MinMaxSolution(a[l], a[h]);
        }
        else if (h == l + 1)
        {
            // printf("compare %d & %d\n", a[l], a[h]);
            if (a[l] > a[h])
                return MinMaxSolution(a[h], a[l]);
            else
                return MinMaxSolution(a[l], a[h]);
        }
        else
        {
            int m = (h + l) / 2;
            MinMaxSolution sol1 = findMinMax(a, l, m);
            MinMaxSolution sol2 = findMinMax(a, m + 1, h);
            int max = (sol1.max > sol2.max) ? sol1.max : sol2.max;
            int min = (sol1.min < sol2.min) ? sol1.min : sol2.min;
            MinMaxSolution ret = MinMaxSolution(min, max);
            return ret;
        }
}

MinMaxSolution findMinMax(int a[], int n)
{
    return findMinMax(a, 0, n - 1);
    // return findMinMax(a, 0, n, n);
}

#endif