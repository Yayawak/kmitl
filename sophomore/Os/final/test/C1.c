#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/shm.h>

#define BFSIZE 3

int main(void)
{
    key_t k = ftok("/Users/rio/Desktop/kmitl/sophomore/Os/final/test/C1.c", 7);
    int id = shmget(k, BFSIZE * sizeof(int), 0600 | IPC_CREAT);
    int *A = (int *)shmat(id, 0, 0);



    printf("MOM process is runnin\n");
    for (int i = 0; i < BFSIZE; i++)
    {
        A[i] = i;
        printf("writing = %d\n", A[i]);
    }

    // int A[] = {0, 1, 2, 3};
    // const int *B_ptr = {0, 3, 3};

    // for (int i = 0; i < sizeof(A) / sizeof(int); i++)
    // {
    //     printf("%d\n\n", A[i]);
    // }
    // while (B_ptr != NULL)
    // {
    //     printf("%d\n", *B_ptr);
    //     B_ptr++;
    // }
}