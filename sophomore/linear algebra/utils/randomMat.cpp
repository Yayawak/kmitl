#include "../include/linalg.h"
#include <algorithm>
#include <random>

Mat *randmat(int r, int c, int start, int end)
{
    std::random_device rd;
    std::mt19937 gen(rd()); // Mersenne Tiwster 19937 geneator
    std::uniform_real_distribution<> dis(start, end); // includsive

    Mat* newM = new Mat(r, c);

    // int k = 0;
    for (int i = 0; i < r; i++)
    {
        for (int j = 0; j < c; j++)
        {
            (*newM)[i][j] = dis(gen);
            // (*newM)[i].push_back(5);
            // k++;
        }
    }
    // cout << "k = " << k << endl;
    return (newM);
}

Mat *randmat(int r, int c)
{
    return randmat(r, c, 0, 100);
}
