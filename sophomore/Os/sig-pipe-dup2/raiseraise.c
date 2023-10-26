#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

// ? global vars
signed long prev_computed;
signed long i;

void sighandler(int sig)
{
    printf("\nRecieved a signal ");
    printf("SIGUSR1. the max n is ");
    printf("%ld! = %ld\n", i - 1, prev_computed);
    exit(0);
}

void overflowMaker()
{
    signed long cur_value;

    printf("2 power n : \n");
    signal(SIGUSR1, sighandler);

    prev_computed = 1;
    // ! This is factorial computation lol
    for (i = 1l; ; i++)
    {
        cur_value = prev_computed * i;

        if (cur_value < prev_computed)
        {
            raise(SIGUSR1);
        }
        prev_computed = cur_value;
    }

}

int main(void)
{
    overflowMaker();
    return (0);
}
