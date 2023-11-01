#include "/Users/rio/Desktop/kmitl/sophomore/Os/oslib.hpp"

int main()
{
    int processFds[2];
    // 0 is right tip, 1 is left tip
    // * [fd1, fd2]

    pid_t pid;

    pipe(processFds);




    pid = fork();
    if (pid > 0)
    {
        // * write
        close(processFds[0]);
        // dup2(processFds[1], 1);
        dup2(processFds[1], 1); // ? 1 -> pfds[1] (write tip)
        close(processFds[1]);
        execlp("ls", "ls", NULL);
        exit(3);
    }
    else
    {
        // * read
        close(processFds[1]);
        
        // dup2(processFds[0], 0);
        dup2(processFds[0], 0);

        close(processFds[0]);

        execlp("wc", "wc", NULL);
        exit(4);

    }
    exit(0);


    return (0);
}