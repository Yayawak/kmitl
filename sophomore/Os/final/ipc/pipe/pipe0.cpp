#include "/Users/rio/Desktop/kmitl/sophomore/Os/oslib.hpp"

#define bf_size 3

int main()
{
    int processFds[2];
    // 0 is right tip, 1 is left tip

    int nreaded = 0;
    pid_t pid;
    char buf[bf_size];

    pipe(processFds);

    if ((pid = fork())  == 0)
    {
        close(processFds[1]);
        while ((nreaded = read(processFds[0], buf, bf_size)) != 0)
        {
            printf("child readed from buffer %s\n", buf);
        }
        close(processFds[0]);
        
    }
    else
    {
        // parent writer
        close(processFds[0]);
        char  const*tmp = "ABCDEFG";
        int i = 0;
        while (i <  strlen(tmp))
            buf[i++] = tmp[i];

        write(processFds[1], buf, strlen(buf) + 1);

        close(processFds[1]);
        wait(NULL);
    }


    return (0);
}