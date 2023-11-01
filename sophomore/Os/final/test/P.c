// C program to illustrate 
// pipe system call in C 
#include <stdio.h> 
#include <unistd.h> 
#include <stdlib.h>
#define MSGSIZE 16 
char* msg1 = "hello, world #1"; 
char* msg2 = "hello, world #2"; 
char* msg3 = "hello, world #3"; 

int main() 
{ 
	char inbuf[MSGSIZE]; 
	int p[2], i; 

    // ! p[1] -> write tip
    // ! p[0] -> read tip

    // p[1]       p[0]
    // ----------
    // |      hhh  |
    // ----------
	if (pipe(p) < 0) 
		exit(1); 

	/* continued */
	/* write pipe */

	write(p[1], msg1, MSGSIZE); 
	write(p[1], msg2, MSGSIZE); 
	write(p[1], msg3, MSGSIZE); 

// * make no sense here
    // char A[16];
    // // char *A;
    // read(p[1], A, MSGSIZE);
    // printf("==> %s\n", (char *)A);
    
	// for (i = 0; i < 3; i++) { 
	// 	/* read pipe */
	// 	read(p[0], inbuf, MSGSIZE); 
	// 	printf("%s\n", (char*)inbuf); 
	// } 
    // dup2(1, p[0]);
    dup2(p[0], 1);

    // char _buff[4];

    // int readed = 1;
    // do
    // {
    //     readed = read(p[0], _buff, 4);
    //     printf("-> %s\n", _buff);
    // }
    // while (readed >= 0);
    // printf("kk\n");

    
	return 0; 
} 

