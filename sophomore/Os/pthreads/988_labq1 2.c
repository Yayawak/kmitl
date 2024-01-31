#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int csum = 0;
// int msum = 0;

void *runner(void *param)
{
    // printf("Running sub thread.\n");
    int i = 1;
    while (i < 2 * atoi(param))
    {
        csum += i;
        i++;
    }

    pthread_exit(0);
}

void test(char **argv)
{
    csum = 0;
    int msum = 0;
    int i = 1;
    while (i < atoi(argv[1]))
    {
        msum += i;
        i++;
    }

    pthread_t tid;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_create(&tid, &attr, runner, argv[1]);
    
    // pthread_join(tid, NULL);
    printf("After all threads terminated.\n");
    printf("msum = %d\n", msum);
    printf("csum = %d\n", csum);

    // ? show abs difference of msum and csum
    printf("diff = %d\n", abs(msum - csum));

}

int main(int argc, char **argv)
{
    if (argc < 2)
    {
        fprintf(stderr, "Usage error : run this program with a argument\n");
        exit(2);
    }
    // char *programname = argv[0];
    char *param = argv[1];
    printf("arg[1] = %d\n", atoi(param));

    int i = 0;
    while (i < 100)
    {
        test(argv);
        i++;
        printf("-------\n");
    }
    
    return (0);
}