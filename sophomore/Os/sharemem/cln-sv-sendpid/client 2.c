#include <stdlib.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include "h.h"

int main(void)
{
    printf("running client\n");
    key_t shmkey;
    int shm_id;
    int *memPtr;

    shmkey = ftok(".", 'x');
    shm_id = shmget(shmkey, 1 * sizeof(int), IPC_CREAT | 0666);
    memPtr = shmat(shm_id, NULL, 0);

    printf("client recieving pid of server in shm\n");
    int ppid = *memPtr;
    printf("pid from server is %d\n", ppid);

    printf("now senging end signal back to server\n");

    *memPtr = clientAcceptedData;
    // kill(SIGUSR1, ppid);

    printf("client exits...\n");
    return (0);
}