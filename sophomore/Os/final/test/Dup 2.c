#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main()
{
    char *cat_args[] = {"cat", 
    "/Users/rio/Desktop/kmitl/sophomore/Os/final/test/C2.c",
    NULL };

    int pipes[2];
    pipe(pipes);

    // dup2(pipes[1], 1);
    // execvp(*cat_args, cat_args);
    execl("/bin/sh", "sh", "-c", "/bin/cat > C2.c", (char *)0);
    printf("ABC\n");
}