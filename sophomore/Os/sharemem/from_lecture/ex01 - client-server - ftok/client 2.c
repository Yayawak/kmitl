#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>
#include "h.h"

int main(void)
{
    printf("running client\n");
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
    while (memPtr->status != filled);

    // printf("Server has attached to shared memory ...\n");
    printf("client recieving data in shm\n");
    for (int i = 0; i < buffersize; i++)
    {
        int cur = memPtr->data[i];
        printf("get %d\n", cur);
    }

    memPtr->status = taken;
    printf("client exits...\n");

    return (0);
}