#include <stdio.h>
#include <stdlib.h>

int main(int agrc, char** argv) {

    int number = atoi(argv[1]);
    char **names = (char**) malloc(number * sizeof(char *));

    for (int i = 0; i < number; i++) {
        names[i] = (char*) malloc(32 * sizeof(char));
        scanf("%99s", names[i]);
    }

    printf("\n ------------------------------------------------------------------------------------------------- \n");

    for (int i = number - 1; i >= 0; i--) {
        printf("%s\n", names[i]);
    } 

    for (int i = 0; i < number; i++) {
        free(names[i]);
    }
    free(names);

    return 0;
}
