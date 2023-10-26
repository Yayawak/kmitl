#include <stdlib.h>
#include <unistd.h>
// #include <wait.h>
#include <string.h>
#include <stdio.h>

#define buffer_size 10 // pipe buffer size

int main(void)
{
    // store (pipe) files descriptors returned from pipe()
    int pipe_fds[2];   
    int nread;
    int pid;
    char buff[buffer_size];
    char inbuff[buffer_size * 2];
    // recieve int[2]
    // ? q1.1
    pipe(pipe_fds);
    if (pipe(pipe_fds) == -1)
    {
        perror("pipe failed\n");
        exit(-1);
    }
    printf("write pipe id = %d\n", pipe_fds[0]);
    printf(" read pipe id = %d\n", pipe_fds[1]);

    pid = fork();
    // NOTE : child is reader
    if (pid == 0)
    {
        // tidy unused end
        close(pipe_fds[1]);
        // read while end of stream
        // ? q1.2
        while ((nread = read(pipe_fds[0], buff, buffer_size)) != 0)
        {
            if (nread > 11)
            {
                printf("avoid overflow -> no conversion %s to int\n", buff);
            }
            else
            {
                printf("child reciebed %s. After + 5 = %d\n",
                    buff, atoi(buff) + 5
                );
            }
        }
        close(pipe_fds[0]);
    }
    else
    {
        close(pipe_fds[0]);

        strcpy(inbuff, "432999999");
        // sprintf(inbuff, "%ld", 123456789012);

        // ? q1.3
        // send exceed the limit of buffer
        write(pipe_fds[1], inbuff, buffer_size);
        // ? q1.4
        close(pipe_fds[1]);

        // ? q.15
        wait(NULL);
    }

    return (0);
}