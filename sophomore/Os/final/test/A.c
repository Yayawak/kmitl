#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void sig6hand(int signumber)
{
    // while (1)
    // {
    //     printf("sigsig handling\n");
    // }
    // signal(signumber, SIG_IGN);
    printf("SIG USER DEFINED\n");
    signal(signumber, sig6hand);
}

int main(void)
{
    pid_t parent_id = getpid();
    printf("current pid = %d\n", parent_id);

    signal(SIGUSR1, sig6hand);

    
    // pid_t pid = fork();
    // if (pid == 0)
    int A[] = {1, 2};
    if ()
    {
        // while (1)
        // {
        //     printf("xxxxxx69\n");
        // }
        sleep(2);
        // printf("yyyyyyyyyy\nlinear algebra\n");

        // kill(getppid(), SIGKILL);
        raise(SIGUSR1);
    }
    // else if (pid > 0)
    // {
    //     // ! mommy
    //     while (1)
    //     {
    //         printf("xxx\n");
    //     }
    // }
    // while (1);
    return (0);
}