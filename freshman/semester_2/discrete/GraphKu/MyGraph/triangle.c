#include <stdio.h>

int ft_abs(int x)
{
    return (x >= 0) ? x : -x;
}

void print_triangle(int row, int col) {
    // int col = 12;
    // int row = 6;
    int midCol = col % 2 == 0 ? (col / 2 - 1) : (col / 2);
    char* black = "\033[0;30m";
    char* red = "\033[0;31m";
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            if (ft_abs(midCol - j) > i)
            {
                printf("%s_", black);
            }
            else {
                printf("%s*", red);
            }
        }
        printf("\n");
    }
    printf("\n");
}

int main() {
    int col = 5;
    while (col < 14) {
        // print_triangle(8, col);
        print_triangle(col - 3, col);
        col += 2;
    }
}
// if (j % 2 == 0) {
// if ((col / 2) - 2 > j) {
// if ((col / 2) - 1 > j) {
// if ((j < i) || (j > i)) {
// if ((j < 3) || (j > 3)) {
// if (midCol - j > 1)
