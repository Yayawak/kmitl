#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>
#include "h.h"
#include <stdbool.h>

bool isServerRecivedEndSignalFromClient = 0;

int main(void)
{
    key_t shmkey;
    int shm_id;
    // struct Memory *memPtr;
    int* memPtr;

    shmkey = ftok(".", 'x');
    shm_id = shmget(shmkey, 1 * sizeof(int), IPC_CREAT | 0666);

    memPtr = shmat(shm_id, NULL, 0);

    // printf("Server has attached to shared memory ...\n");
    *memPtr = getpid();
    printf("filling pid (%d) to server shared mem...\n", *memPtr);
    

    // while (!isServerRecivedEndSignalFromClient);
    while (*memPtr != clientAcceptedData);


    shmdt((void *)memPtr);
    shmctl(shm_id, IPC_RMID, NULL);
    printf("Server has removed its shared memeory...\n");
    printf("Server exits...\n");

    return (0);
}