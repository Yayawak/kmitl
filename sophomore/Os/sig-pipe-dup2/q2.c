#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdlib.h>
#include <unistd.h> // fork

// ! i thinks mom and child can access same variable (same pointer to mem)
// int notDone = 1;
// int cnt = 0;

// ! You can't catch sigkill
// void sigkillhanlder(int sig)
// {
//     // ignore this sig
//     signal(SIGKILL, SIG_IGN);
//     printf("handlign 6kill.\n");
//     // use do wihle loop of mom
//     // notDone = 0;
// }

int main(void)
{
    pid_t pid = fork();

    // signal(SIGKILL, sigkillhanlder);
    if (pid == 0)
    {
        printf("child wait for mom's SIGKILL\n");
        // while (notDone);
        while (1);

        printf("This line of child should not be executed\n");
        // ! if it's really 6q it's kill not should you anything it's like silent assassin.
        // printf("except that mom kill me by SIGKILL\n");
        exit(0);
    }
    else
    {
        printf("getpid() = %d\n", getpid());
        printf("I'm mom and i want to see that 'pid variable is what' = %d\n", pid);
        printf("ok i known that i'm tracking my child pid should be %d\n", pid);
        sleep(4);
        // * send pid of child even though the code of pid is on mom side
        kill(pid, SIGKILL);
        // exit(0);
    }

    // ? use opration count insterad of time (alternativly)
    // printf("it takes %d\n", cnt);
    return (0);
}