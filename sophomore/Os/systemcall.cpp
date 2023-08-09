#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>

static int lab01()
{
    pid_t pid;
    int i = 0;

    pid = fork();
    if (pid > 0) // parent
    {
        i = 1;
        printf("pid of parent(%d) = %d\n", i, pid);
        // printf("my copy of i is %d parenty\n", i);
    }
    else // parent pid = 0 processes
    {
        i = 2;
        // printf("my copy of i is child(%d)\n", i);
        
        printf("pid of child(%d) = %d\n", i, pid);
        // printf("making while loop in child\n");
        //NOTE use kill command in terminal to kill child with pid
        while (1)
        {
            printf("making while loop in child\n");
            sleep(2);
        }
    }
    return (0);
}

static int lab02()
{
    printf("I m real parent : %d\n", (int)getpid());

    pid_t pid = fork(); // split program hydraly
    fork();
    // printf("Let see how many time you will see me.\n" );
    printf("I'm %d whoami ?\n", (int)getpid());
    if (pid < 0)
    {
        perror("fork unsuccessfully created new process");
    }
    else if (pid == 0)
    {
        printf("I'm a new child process | pid = %d\n", getpid());
        sleep(5);
        printf("Child existing.....\n");
        exit(0);
    }
    else if (pid > 0)
    {
        printf("I'm mom | pid = %d | Waiting for all children is ended.\n", getpid());
        wait(NULL);
        printf("Parent ending.\n");
    }
    return (0);
}

static void lab03()
{
    // waitid();
    pid_t pid;
    int i;
    int sum = 3;

    pid = fork();
    if (pid > 0)
    {
        i = 1;
        sum += i;
        std::cout << "parent | copy(" << sum << ")\n";
    }
    else
    {
        i = 2;
        sum += i;
        std::cout << "child | copy(" << sum << ")\n";
    }
    std::cout << "my sum = " << sum << std::endl;
    wait(NULL);
    /*NOTE predicted result
        split into 2 procs
        parent -> sum =  4
        child -> sum =  5

        sum = 4
        sum = 5 interchangably above line
    */
    exit(0);
}

static void lab04()
{
    pid_t pid;
    int i;
    int sum = 3;

    for (i = 0; i < 3; i++)
    {
        pid = fork();
        if (pid == 0)
        {
            std::cout << "child : " << i << std::endl;
            exit(0);
            std::cout << "should not exicuted.\n"; 
        }
        else 
        {
            std::cout << "parent : " << i << "\n";
        }
    }
    while (wait(NULL) != -1) // empty loop
    std::cout << "bye from lab04 : sum = " << sum 
        << " from i = " << i<< "\n"; // executed once

    /*NOTE predicted results
        child : 0 (main)
        child : 0 (splited)

        child : 1
        child : 1
        child : 1
        child : 1

        child : 2
        child : 2
        child : 2
        child : 2
        child : 2
        child : 2
        child : 2
        child : 2

        bye from lab04 : sum = 3
    */

    /*REVIEW - real answer
        child : 0
        child : 1
        byte form lab04 : sum = 3 from i = 3
        byte form lab04 : sum = 3 from i = 3
        child : 2
        byte form lab04 : sum = 3 from i = 3

                โปรแกรมด้นบนไม่ได้เป็นตามรูปนี้นะ ถ้าจะเป็นตามรูปปต้อง
                ใช้แบบนี้ 
                fork();
                fork();
                fork();
                
                    0
                /      \
               1        1
              / \      / \
             2   2    2  2
            / \ / \  / \ / \  
           3  33   33  33   3 --> 8 copy
    */
}

#define clear_buffer() while (getchar() != '\n')
static void lab05()
{
    pid_t pid[3], w;
    int num, sum = 0, i, status;
    // std::cout << "Enter positive number";
    // num = getchar() - 48;
    // num = getchar() - '0';
    // clear_buffer();
    // std::cout << "num entered is " << num << '\n';

    for (i = 0; i < 3; i++)
    {
        if ((pid[i] = fork()) == 0)
        {
            printf("I'm child(%d) \tpid(%d)\n", i, getpid());
            if (i == 1)
            {
                while (true)
                {
                    std::cout << "child " << i << 
                    " |" << getpid() <<"|" << " is running\n";
                    sleep(3);
                }
            }
            // std::cout << "I'm child : " << i << " : num " << num << '\n';
            exit(i);
        }
    }
    // waitpid return "pid of the child whose state has changed ()"
    for (i = 0; (w = waitpid(pid[i], &status, 0)) && w != -1; ++i)
    {
        printf("Wait on Pid : %d return value of : %d\n\n", 
            w, WEXITSTATUS(status)
        );
    }
}

// zombie deamon orphan
static void lab06()
{
    pid_t pid ;
    int i;
    pid = fork();
    if (pid > 0)
    {
        i = 1;
        printf("I'm parent my pid = %d, i = %d\n", getpid(), i);
        while (++i < 30)
        {
            printf("runing parent process\n");
            sleep(1);
        }
        printf("process %d terminated\n", getpid());
    }
    else
    {
        i = 2;
        printf("I'm child my pid = %d, i = %d\n", getpid(), i);
    }
}

int main()
{
    // lab02();
    // lab03();
    // lab04();
    // lab05();
    lab06();
    return (0);
}