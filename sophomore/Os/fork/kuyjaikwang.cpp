#include <iostream>
#include <unistd.h>
#include <signal.h>

int main(void)
{
    int i = 0;
    while (i < 10)
    {
        std::cout << "kuy i sus jk\n";
        sleep(3);
        i++;
    }
    return (9);
}