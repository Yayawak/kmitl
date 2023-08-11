#include "stdlib.h"
#include "unistd.h"
#include "fcntl.h"
#include "stdio.h"

int main()
{
    pid_t cpid; // child pid
    pid_t gcpid; // grand son pid

    cpid = fork();
    if (cpid < 0)
    {
        fprintf(stderr, "Fork failed\n");
        exit(-1);
    }
    else if (cpid == 0)
    {
        gcpid = fork();
        if (gcpid == 0) // grand child
        {
            printf("Can you see this 3 ?\n");
            exit(0);
        }
        // execlp("/bin/ls", "ls", NULL); // A
        execlp("/bin/type", "type", NULL); // A
        // execlp("/bin/123444ls", "ls", NULL); // A
        printf("can you this this 2\n"); // B
    }
    else
    {
        printf("Can you see this 1 ?\n"); // C
        wait(NULL);
        printf("recieved child complete\n");
        exit(0);
    }
    return (0);
}