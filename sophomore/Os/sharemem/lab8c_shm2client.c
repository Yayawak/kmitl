#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

char *str;
int isLoop = 0;

void sigmanager(int sig)
{
    signal(sig, SIG_IGN);
    printf("from handler\n");
    printf("%s\n", str);

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

    int shmid = shmget(key, 1024, 0666 | IPC_CREAT);
    // int shmid = shmget(999, 1024, 0666 | IPC_CREAT);
    printf("shared mem id of (server) is %d\n", shmid);
    str = (char *)shmat(shmid, (void *)(0), 0);
    


    while (isLoop);
    printf("Data in memory : %s\n", str);
    
    // pid_t ppid = atoi(str);

    // kill(SIGUSR1, ppid);
    raise(SIGUSR1);
    
    // sprintf(str, "%s", "os kmitl\n");
    // sprintf(str, "%s", "1234\n");
    sprintf(str, "%d", getpid());
    printf("Writting to mem: %s\n", str);

    shmdt(str);
    shmctl(shmid, IPC_RMID, NULL);
    return (0);
}