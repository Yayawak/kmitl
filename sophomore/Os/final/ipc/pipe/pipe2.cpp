#include "/Users/rio/Desktop/kmitl/sophomore/Os/oslib.hpp"
#include <iostream>


int main()
{
    int fd = open("/Users/rio/Desktop/kmitl/sophomore/Os/final/ipc/pipe/dummy.txt"
        , O_WRONLY | O_APPEND);
    std::cout << fd << "\n"; 
    dup2(fd, 1); // ? dup 1 -> fd
    printf("\nI will be printed in file dummy.txt\n"); // -> stdout 1
    return (0);
}
//!This will lead all the printf() statements to be written 
//in the file referred by the old file descriptor.