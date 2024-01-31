#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum;

// void *runner(void *param);
void *runner(void *param)
{
    int upper = atoi(param);
    sum += upper;
    printf("I am child thread, sum value here is %d\n", sum);
    pthread_exit(0);

    // return 0;
}

int main(int argc, char *argv[])
{
    pthread_t tid;
    pthread_attr_t attr;


    // ! Main concept is to work concurrently
    // * Init thread
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, argv[1]);
    // pthread_create(&tid, &attr, main, argv[1]);

    printf("I am mother thread, I will waiting for my child thread\n");
    pthread_join(tid, NULL);
    printf("from my child sum = %d\n", sum);
}
