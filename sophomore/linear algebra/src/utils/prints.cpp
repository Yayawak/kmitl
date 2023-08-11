#include "../include/linalg.h"
#include <string.h>
#include <string>

void printmat(Mat *m)
{
    // printf("row = %d\n", m->row);
    // printf("col = %d\n", m->col);
    printf("dimension = [%d,%d]\n", m->row, m->col);
    for (int i = 0; i < m->row; i++)
        for (int j = 0; j < m->col; j++)
            printf("mat[%d][%d] = %f\n", i, j, m->data[i][j]);
}

// comfort with 1 tab (8 dashes)
static string get8dash(int n)
{
    int i;
    // string base = "________";
    string base;

    i = 0;
    while (i < n)
    {
        base.append("________");
        i++;
    }
    return base;
}
void prettyprint(Mat *m)
{
    // printf("row = %d\n", m->row);
    // printf("col = %d\n", m->col);
    printf("dimension = [%d,%d]\n", m->row, m->col);

    // cout << endl << "_________________________" << endl;
    cout << get8dash(m->row)<< endl;
    for (int i = 0; i < m->row; i++)
    {
        cout << "| ";
        for (int j = 0; j < m->col; j++)
        {
            // float show = std::round(
            //     (*m)(i, j) * std::pow(10, 3) / std::pow(10, 3));
            // cout << m->data[i][j] << "\t|";
            // cout << show << "\t|";
            // printf("%.3f\t|", (*m)(i, j));
            printf("%.2f\t|", (*m)(i, j));
        }
        // cout << endl << "_________________________" << endl;
        cout << endl << get8dash(m->row) << endl;
        cout << endl;
    }
}
