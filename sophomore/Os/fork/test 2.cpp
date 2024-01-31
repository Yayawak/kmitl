// #include <cstdio>
#include <stdlib.h>
// #include <pthread.h>
// #include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <iostream>
// #include <

void t1()
{
    for (int i = 0; i < 2; i++)
    {
        pid_t pid = fork();
        if (pid == 0)
        {
            printf("child %d\n", i + 1);
        }

    }
    while (wait(NULL) != -1);
    // std::std << "GB\n";
    printf("gb\n");
}

static void t2()
{
    fork();
    fork();
    fork();
    printf("hello\n");
}

static void t3()
{
    pid_t p = fork();
    int i = 0;
    int sum = 3;


    // printf("sum sum sum\n");
}

static void t4()
{
    pid_t pids[3];
    pid_t w;
    int num, sum = 0;
    int i, status;

    std::cin >> num;
    for (i = 0; i < 3; i++)
    {
        if ((pids[i] = fork()) == 0)
        {
            printf("I'm child %d. | my copy of num %d\n", i, num);
            exit(i);
        }
    }
    for (i = 0; (w = waitpid(pids[i], &status, 0)) && w != -1; i++)
    {
        // std::cout << "waiting pid : %d returns value of : %d\n" << w << WEXITSTATUS(status);
        printf("waiting pid : %d returns value of : %d\n", w, WEXITSTATUS(status));
    }
}

void t5()
{
    pid_t p = fork();
    if (p == 0)
    {
        // while (true)
        // {
        sleep(8);
        std::cout << "child is runing " << getpid() << "\n";
        // }
    }
    else
    {
        // while (true)
        // {
        // }
        std::cout << "mom is running  " << getpid() << "\n";
        sleep(1);
    }
}

static void t6()
{
    if (fork() == 0)
    {
        std::cout << "child\n";
        execlp("ps", "ps");
    }
    else
    {
        std::cout << "mom\n";
    }
}

void t7()
{
    if (fork() == 0)
    {
        std::cout << "mom  \n";
    }
    else
    {
        std::cout << "child \n";
        // execl("/Users/rio/Desktop/kmitl/sophomore/Os/fork/kuysusjai", "kuysusjai");
        // char *vector[] = {"ls", "..", NULL};
        // char *vector[] = {"kuysusjai"};


        // execv("/bin/ls", vector);
        // execl("/bin/ls", "ls", "-l", NULL);
        // execv("kuysusjai", vector);
        // execl("kuysusjai", "kuysusjai");
        // execl("kuysusjai", "kuysusjai");
        // execlp("kuysusjai", NULL);
    }
}

int main(void)
{
    // t2();
    // t4();
    // t5();
    t7();
    return (0);
}