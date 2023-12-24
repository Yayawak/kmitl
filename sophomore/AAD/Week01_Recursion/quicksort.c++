#ifndef QS_H
#define QS_H
#include <stdio.h>

// return k
// static void swap(int *x, int *y)
// {
//     printf("Swapped %d & %d\n", *x, *y);
//     int temp = *x;
//     *x = *y;
//     *y = temp;
// }
static void swap(int a[], int i, int j)
{
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

// return k
static int partition(int a[], int m, int p)
{
    printf("m = %d, p = %d\n", m, p);
    // int i = m;
    // int t = a[m];
    int pivot = a[m];

    int i = m + 1;
    int j = p;
    // while (i <= p)
    while (i <= j)
    {
        while (i <= p && a[i] < pivot)
            i++;
        while (j >= m + 1 && a[j] > pivot)
            j--;
        if (i <= j)
        {
            // swap(&a[i], &a[j]);
            swap(a, i, j);
            i++;
            j--;
        }
        // printf("m = %d, p = %d\n", m, p);
        // do {
        //     i++;
        // }
        // while (a[i] < t);

        // do {
        //     p--;
        // }
        // while (a[p] > t);
        // printf("after shifted m&p -> m = %d, p = %d\n", m, p);


        // if (i < p)
        //     swap(&a[i], &a[p]);
        // else
        //     swap(&a[m], &a[p]);
    }
    // swap(&a[m], &a[j]);
    swap(a, m, j);
    // printf("returned k = %d\n\n", p);
    // return p; // p = k
    return j; // p = k
}

void quicksort(int a[], int i, int j)
{
    if (i < j)
    {
        int p = j + 1;
        int k = partition(a, i, p);
        quicksort(a, i, k - 1);
        quicksort(a, k + 1, j);

    }
}


#endif