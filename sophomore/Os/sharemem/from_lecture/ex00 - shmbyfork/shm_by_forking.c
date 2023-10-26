#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>


// void client_process(int sharedMem[]);
void client_process(int *shmToIntPtr)
{
    printf("Client (child) has recieved [%d, %d, %d, %d]\n",
        shmToIntPtr[0], shmToIntPtr[1],
        shmToIntPtr[2], shmToIntPtr[3]);
}

int main(void)
{
    int shm_id;
    int *shmToIntPtr;
    pid_t pid;
    int status;

    shm_id = shmget(IPC_PRIVATE, 4 * sizeof(int), IPC_CREAT | 0666);
    // int key = 555;
    // shm_id = shmget(key, 4 * sizeof(int), IPC_CREAT | 0666);

    if (shm_id < 0)
    {
        fprintf(stderr, "Error shmget (server).\n");
        exit(-1);
    }

    shmToIntPtr = (int *) shmat(shm_id, NULL, 0);

    // if (*shmToIntPtr == -1)
    // {

    // }
    printf("Server has attached to shared memory ...\n");

    shmToIntPtr[0] = 1;
    shmToIntPtr[1] = 2;
    shmToIntPtr[2] = 3;
    shmToIntPtr[3] = 4;
    printf("Server has filled [%d, %d, %d, %d]\n",
        shmToIntPtr[0], shmToIntPtr[1],
        shmToIntPtr[2], shmToIntPtr[3]);
    
    printf("Now server is going to fork a child process...\n");

    // ? -------------------------------------
    sleep(3);
    printf("delay a sec ...\n");

    pid = fork();
    
    if (pid == 0) // child
    {
        printf("\n\n\n");
        client_process(shmToIntPtr);
        exit(0);
    }

    // wait(&status);
    wait(NULL);
    shmdt((void *)shmToIntPtr);
    shmctl(shm_id, IPC_RMID, NULL);
    printf("Server has removed its shared memeory...\n");
    printf("Server exits...\n");

    return (0);
}