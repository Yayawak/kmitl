#include <iostream>
#include <string>
#include <math.h>
#include "Bst.c++"
#include "MinMax.c++"
#include "quicksort.c++"

int main()
{
    //* 988
    // int *arr = {12, 15, 32, 75, 16, 45, 39, 86, 23, 18};
    // int arr[] = {12, 15, 32, 75, 16, 45, 39, 86, 23, 18};
    // int arr[] = {12, 15, 32, 75, 16, 45, 39, 86, 23, 18};
    int arr[] = {12, 98, 32, 75, 16, 45, 39, 86, 23, 98};
    size_t n = sizeof(arr) / sizeof(int);
    printf("N = %lu\n", n);

    Tree *t = new Tree();

    for (int i = 0; i < n; i++)
    {
        addDataToBst(t, arr[i]);
    }
    // printT(t->root);
    // std::cout << t << "\n";
    // std::cout << "std\n";
    // MinMaxSolution mnmxSolution = findMinMax(arr, n);
    // mnmxSolution.print();

    for (int i = 0; i < n; i++)
        printf("%d, ", arr[i]);
    printf("\n");
    quicksort(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
        printf("%d, ", arr[i]);
    printf("\n");

    // printf("%d\n", 5 / 2);

    return 0;
}