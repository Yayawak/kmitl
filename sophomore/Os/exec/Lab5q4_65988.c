#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <sys/types.h>
int main(){
	char userChoice = 'z';
	while (userChoice != 'q'){
		printf("a: ls ");
		printf("b: ps ");
		printf("c: who ");
		printf("q for quit ");
		scanf(" %c", &userChoice);
		pid_t pid;
		pid = fork();
		if (pid ==0){
			if (userChoice =='a') {//perform ls
				execlp("/bin/ls", "ls", NULL);
				// printf("performed ls\n");
			}
			if (userChoice =='b'){//perform ps
				// printf("performed ps\n");
				execlp("/bin/ps","ps",NULL);
			}
			if (userChoice =='c'){//perform who
				execlp("/usr/bin/whoami", "whoami", NULL);
                // printf("")
				// printf("performed who\n");
			}
			// if (userChoice == 'q'){// quit
			// 	// printf("bye bye\n");
			// }
			exit(0);
		}
		//your code 2
		wait(NULL);

	}
	printf("parent terminated\n");
}