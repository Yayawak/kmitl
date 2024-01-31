#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void)
{
    FILE *file = fopen("aaa.txt", "w");

    int fd = fileno(file);
    printf("current file descriptor is %d\n", fd);
    
    // ? q2.1
    dup2(fd, 1);

    printf("please read this line in aaa.txt\n");
    close(fd);
    return (0);
}