#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>

int main(void)
{
    // key_t key = ftok("shmfile", 65);
    // key_t key = ftok("shmfile", 65);
    key_t key = ftok(".", 65);

// 1. shmget() จองพ้ืนที่ได้ id ของ memory 
// 2. shmat() เชื่อมตวั แปรไปที่ id พ้ืนที่ที่จอง 
// 3. shmdt() ปลดกํารเชื่อม
// 4. shmctl() คืนทรัพยํากร

    int shmid = shmget(key, 1024, 0666 | IPC_CREAT);
    char *str = (char *)shmat(shmid, (void *)(0), 0);
    printf("Read from mem : %s\n", str);
    
    sprintf(str, "%s", "os kmitl\n");
    printf("Data written to mem: %s\n", str);

    shmdt(str);

    shmctl(shmid, IPC_RMID, NULL);


    return (0);
}