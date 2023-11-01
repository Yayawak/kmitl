#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <sys/shm.h>


#define BFSIZE 30

int main(void)
{
    // printf("%lu Bytes\n", sizeof(9));
    unsigned int long ll = 999999999999999999;
    // printf("%lu Bytes\n", sizeof(429496729999999999));
    // printf("%lu Bytes\n", sizeof(ll));
    // printf("%lu Bytes\n", sizeof(int));
    // printf("%lu Bytes\n", sizeof(long));
    // printf("%lu Bytes\n", sizeof(long long));
    // printf("%lu Bytes\n", sizeof(long int));
    // printf("%lu Bytes\n", sizeof(float));

    int id = shmget(IPC_PRIVATE, BFSIZE * sizeof(int), 0600 | IPC_CREAT);
    int *A = (int *)shmat(id, 0, 0);



    int pid = fork();
    if (pid > 0)
    {
        printf("MOM process is running.");
        // ! writer = mommy
        for (int i = 0; i < BFSIZE; i++)
        {
            A[i] = i;
            printf("writing = %d\n", A[i]);
        }
    }
    else
    {
        printf("Child process is running.");
        for (int i = 0; i < BFSIZE; i++)
        {
            printf("reading = %d\n", A[i]);
        }
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


    // [_,_,_,_,_]

}