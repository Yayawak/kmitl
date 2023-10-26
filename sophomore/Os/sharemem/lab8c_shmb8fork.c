#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
// #include <unicode/utf.h>

int main(void)
{
    int *count;

    int shmid;
    // key_t key;

    // a
    // ? q5.1 -> answer is b
    shmid = shmget(IPC_CREAT, sizeof(int), 0666 | IPC_CREAT);

    // ? q5.2
    count = (int *)shmat(shmid, NULL, 0);

    // * initialization
    count[0] = 5;

    pid_t pid;
    // child process
    if ((pid = fork()) == 0)
    {
        int temp = count[0]; sleep(1); temp--;
        // ? Q5.3
        count[0] = temp;
        printf("child decrements value at %p\n", &count);
        exit(0);
    }
    wait(0);

    int temp = count[0]; sleep(1); temp++;
    count[0] = temp;
    printf("parent increments value at %p\n", &count);
    sleep(1);
    printf("final answer is %d\n", count[0]);

    shmdt(count);
    shmctl(shmid, IPC_RMID, 0);

    return (0);
}

// ? Q5.4 answer is 5