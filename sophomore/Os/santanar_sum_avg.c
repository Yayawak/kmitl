#include <stdio.h>
#include <stdlib.h>

void    endprog(int sum, float avg)
{
    printf("sum is %d\n", sum);
    printf("avg is %.2f\n", avg);
    exit(1);
}

int main(void)
{
    int n, sum;
    char    *s;

    n = 0;
    sum = 0;

    while (1)
    {
        printf("enter a number : ");
        s = malloc(10);
        scanf("%s", s);
        if (s[0] == '0' || s[0] == '-')
        {
            endprog(sum, (float)sum / n);
        }
        sum += atoi(s);
        n++;
    }
    return (0);
}

