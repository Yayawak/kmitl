#include "../include/linalg.h"
#include <string.h>
#include <string>

void printmat(Mat *m)
{
    printf("row = %d\n", m->row);
    printf("col = %d\n", m->col);
    for (int i = 0; i < m->row; i++)
        for (int j = 0; j < m->col; j++)
            printf("mat[%d][%d] = %d\n", i, j, m->data[i][j]);
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
    printf("row = %d\n", m->row);
    printf("col = %d\n", m->col);

    // cout << endl << "_________________________" << endl;
    cout << get8dash(m->row)<< endl;
    for (int i = 0; i < m->row; i++)
    {
        cout << "| ";
        for (int j = 0; j < m->col; j++)
        {
            cout << m->data[i][j] << "\t|";
        }
        // cout << endl << "_________________________" << endl;
        cout << endl << get8dash(m->row) << endl;
        cout << endl;
    }
}
