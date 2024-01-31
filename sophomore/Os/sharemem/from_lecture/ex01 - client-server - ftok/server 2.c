#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>
#include "h.h"

// // void client_process(int sharedMem[]);
// void client_process(int *shmToIntPtr)
// {
//     printf("Client (child) has recieved [%d, %d, %d, %d]\n",
//         shmToIntPtr[0], shmToIntPtr[1],
//         shmToIntPtr[2], shmToIntPtr[3]);
// }

int main(void)
{
    key_t shmkey;
    int shm_id;
    struct Memory *memPtr;

    shmkey = ftok(".", 'x');
    shm_id = shmget(shmkey, sizeof(struct Memory), IPC_CREAT | 0666);
    // int key = 555;
    // shm_id = shmget(key, 4 * sizeof(int), IPC_CREAT | 0666);

    memPtr = shmat(shm_id, NULL, 0);

    // if (*shmToIntPtr == -1)
    // {

    // }
    // printf("Server has attached to shared memory ...\n");
    printf("filled data in shm\n");
    memPtr->status = notready;
    for (int i = 0; i < buffersize; i++)
    {
        memPtr->data[i] = i * 2;
        // memPtr->data[i] = 2;
    }
    memPtr->status = filled;
    // shmToIntPtr[0] = 1;
    // shmToIntPtr[1] = 2;
    // shmToIntPtr[2] = 3;
    // shmToIntPtr[3] = 4;
    // printf("Server has filled [%d, %d, %d, %d]\n",
    //     shmToIntPtr[0], shmToIntPtr[1],
    //     shmToIntPtr[2], shmToIntPtr[3]);
    

    while (memPtr->status != taken)
    {
        printf("server is sleeping\n");
        sleep(1);
    }

    shmdt((void *)memPtr);
    shmctl(shm_id, IPC_RMID, NULL);
    printf("Server has removed its shared memeory...\n");
    printf("Server exits...\n");

    return (0);
}