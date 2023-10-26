#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <stdlib.h>
#include <unistd.h> // fork

// ! i thinks mom and child can access same variable (same pointer to mem)
int notDone = 1;
int cnt = 0;

void sighanlder(int sig)
{
    // ignore this sig
    signal(SIGALRM, SIG_IGN);
    // use do wihle loop of mom
    notDone = 0;
}

int main(void)
{
    pid_t pid = fork();

    signal(SIGALRM, sighanlder);
    if (pid == 0)
    {
        sleep(4);
        printf("I'm child fake killing mom by sendign SIGALRM\n");
        kill(getppid(), SIGALRM);
        exit(0);
    }
    // parent take infinty loop until child send sig alarm
    else
    {
        printf("parent wait for SIGALRM\n");
        while (notDone) cnt++;
    }

    // ? use opration count insterad of time (alternativly)
    printf("it takes %d\n", cnt);
    return (0);
}