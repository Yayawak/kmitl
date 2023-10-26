#include "../include/linalg.h"
#include <chrono>
#include <cstdlib>
#include <string.h>
#include <string>
#include <thread>

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


void prettyprint(Mat *m, bool isVisualize, int intervalDrawingMillisec = 100)
{
    // printf("row = %d\n", m->row);
    // printf("col = %d\n", m->col);
    // printf("dimension = [%d,%d]\n", m->row, m->col);
    printf("dim(%d,%d)\n", m->row, m->col);

    // cout << endl << "_________________________" << endl;
    cout << get8dash(m->col)<< endl;
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
            if (isVisualize)
            {
                // NOTE this is for debugging purposes (on guassElemenation)
                const char *color = (
                    ((*m)(i, j) == 0.0f)
                    // ? &GREEN[0] : &RED[0]);
                    ? &GREEN[0] : 
                    (*m)(i, j) == 1.0f ? &BLUE[0] :
                    &RED[0]);
                printf("%s%.2f\t%s|", color, (*m)(i, j), RESET);
                this_thread::sleep_for(std::chrono::milliseconds(intervalDrawingMillisec / 2));
            }
            else
            {
                printf("%.2f\t|", (*m)(i, j));
            }
        }
        if (isVisualize)
            this_thread::sleep_for(std::chrono::milliseconds(intervalDrawingMillisec / 2));
        // cout << endl << "_________________________" << endl;
        cout << endl << get8dash(m->col) << endl;
        cout << endl;
    }
    std::cout << "\n";
}
void prettyprint(Mat *m, bool isVisualize)
{
    // prettyprint(m, isVisualize, 50 / 10); // fast
    // prettyprint(m, isVisualize, 50 / 5);
    prettyprint(m, isVisualize, 50 / 2);
}

void prettyprint(Mat *m)
{
    prettyprint(m, false, -1);
}

void binaryPrint(Mat *m)
{
    // GetStdHandle(STD)
    for (int i = 0; i < m->row; i++)
    {
        // cout << "| ";
        for (int j = 0; j < m->col; j++)
        {
            // printf("%.2f\t|", (*m)(i, j));
            float v = (*m)(i, j);
            if (v == 0)
            {
                std::cout << BLUE << "+" << RESET;
            }
            else
            {
                std::cout << RED << "x" << RESET;
            }
            std::cout << " ";
        }
        // cout << endl << get8dash(m->col) << endl;
        cout << endl;
    }
}