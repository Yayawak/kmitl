#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

char *str;
int isLoop = 1;

void sigmanager(int sig)
{
    signal(sig, SIG_IGN);
    // printf("from handler\n");
    printf("ppid = %s, btw sigusr1 = %d\n", str, sig);
    // printf("%s\n", str);
    // ! exit server (q2) loop
    isLoop = 0;

    signal(sig, sigmanager);
}

int main(void)
{
    signal(SIGUSR1, sigmanager);

    key_t key = ftok("hash_this", 65);
    // key_t key = ftok(".", 65);

// 1. shmget() จองพ้ืนที่ได้ id ของ memory 
// 2. shmat() เชื่อมตวั แปรไปที่ id พ้ืนที่ที่จอง 
// 3. shmdt() ปลดกํารเชื่อม
// 4. shmctl() คืนทรัพยํากร

    // ! Not create anymore but real client (reader)
    // int shmid = shmget(999, 1024, 0666 | IPC_CREAT);
    int shmid = shmget(key, 1024, 0666 | IPC_CREAT);
    // int shmid = shmget(key, 1024, 0666 | IPC_R);
    // ???????????????? IPC_CREAT is needed for client ???????????????????????????/
    // int shmid = shmget(999, 1024, 0666 | IPC_CREAT);
    // int shmid = shmget(1900546, 1024, 0666 | IPC_R);
    if (shmid == -1)
    {
        fprintf(stderr, "Error: shmget failed return -1 ( may be you should provide ipc_creat flag to shmget().\n");
        exit(0);
    }
    printf("shared mem id of (client) is %d\n", shmid);
    str = (char *)shmat(shmid, (void *)(0), 0);

    if (!str)
    {
        printf("Error getting NULL from shared mem (from client q3)");
        exit(-3);
    }

    // * ------------- different from q2 ------------
    // printf("%s\n", str);
    // printf("%c\n", str[0]);
    int serverPid = atoi(str);
    // ? alter data in shared mem (send this back to server)
    sprintf(str, "%d", getpid());
    printf("successfuly obtain pid of server\n");

    // kill(serverPid, SIGUSR1); // to server

    // while (isLoop); // waiting for signal from # line of # raise(SIGUSR1)
    // printf("waiting for SIG before writing to server\n");

    // sprintf(str, "%s", "os kmitl\n");
    // printf("Client (q3) wrote to mem & notify server : %s\n", str);
    // kill(serverPid, SIGUSR1);

    // * ------------- end different from q2 ------------
    shmdt(str);
    // shmctl(shmid, IPC_RMID, NULL);
    return (0);
}