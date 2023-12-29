#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>

void readStrAsChars(char *s)
{
    while (*s)
    {
        // printf("%c\n", *s);
        printf("%d\n", *s);
        s++;
    }
}

int main(void)
{
    FILE * fp;
    char * line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen("./Memory.csv", "r");
    if (fp == NULL)
        exit(EXIT_FAILURE);

    while ((read = getline(&line, &len, fp)) != -1) {
        printf("Retrieved line of length %zu:\n", read);
        readStrAsChars(line);
        printf("%s", line);
    }

    fclose(fp);
    if (line)
        free(line);
    exit(EXIT_SUCCESS);
}