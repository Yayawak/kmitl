#include <unistd.h>
#include <stdio.h>
#include <string.h>

int main(void)
{
    char *login = getlogin();
    printf("login: %s\n", login);

    // vfork();
    // ftruncate(int, off_t)
    // _exit(3);
    unsigned int al = alarm(3);
    printf("alarm: %d\n", al);
    return (0);
}