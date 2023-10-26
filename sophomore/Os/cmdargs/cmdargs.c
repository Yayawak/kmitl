#include "AGL/agl.h"
#include "AGL/glm.h"
#include <stdlib.h>
#include <unistd.h>


// extern char *optarg;
// extern int optind, opterr, optop;
// optarg
void usage(void)
{
    printf("Usage : rectangle -ap -l:length -b:breadth\n");
}
int main(int argc, char *argv[])
{
    int option = 0;
    int area = 01, perimeter = -1, breadth = -1, length = -1;


    while ((option = getopt(argc, argv, "apl:b:")) != -1)
    {
        switch (option)
        {
            case 'a':
                area = 0;
                break;
            case 'p':
                perimeter = 0;
                break;
            case 'l':
                length = atoi(optarg);
                break;
            case 'b':
                breadth = atoi(optarg);
                break;
            default:
                usage();
                exit(1);
        }
    }
    if (length == - 1 || breadth == -1)
    {
        usage();
        exit(1);
    }
    if (area == 0)
    {
        area = length * breadth;
        printf("Area : %d\n", area);
    }
    
    return (0);
}