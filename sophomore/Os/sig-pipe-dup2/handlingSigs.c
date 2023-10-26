#include <stdio.h>
#include <unistd.h> // pause()
#include <signal.h>
#include <stdlib.h> // exit

void inthandler(int sig)
{
    // NOTE : override default behaviour of 'sig interpute' of os
    signal(sig, SIG_IGN); // diable ctrl - c
    printf("Did you hit Ctrl-C?\nwant to quit? [y/n]\n");

    char c;
    // c = getchar();
    scanf("%c", &c);

    if (c == 'y' || c == 'Y')
    {
        exit(0);
    }
    else
    {
        // continute to register our handler 
        // * this is example of event-driven programing
        // ? using design pattern name "Observer Pattern"
        signal(SIGINT, inthandler);
    }
}

int main(void)
{
    signal(SIGINT, inthandler);

    while (1)
        // cpu can be allocated to others
        pause();
    
    return (0);
}