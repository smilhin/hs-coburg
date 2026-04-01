#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node 
{
    char* name;
    char* surname;
    struct Node* next_node;
    struct Node* prev_node;
};

struct Node* add_node(char* name, char* surname, struct Node* prev_node) 
{
    struct Node* new_node = malloc(sizeof(struct Node));
    new_node->name = strdup(name);
    new_node->surname = strdup(surname);
    new_node->prev_node = prev_node;
    new_node->next_node = NULL;

    if (prev_node != NULL) 
    {
        prev_node->next_node = new_node;    
    }

    return new_node;
}


int main(int argc, char** argv) 
{
    if (argc != 2)
    {
        fprintf(stderr, "Usage: %s [NUMBER OF ELEMENTS]\n", argv[0]);
        return 1;
    }

    int number = atoi(argv[1]);
    struct Node* head = NULL;
    struct Node* current = NULL;

    for (int i = 0; i < number; i++) 
    {
        char buffer_name[32];
        char buffer_surname[32];

        if(scanf("%31s %31s", buffer_name, buffer_surname) == 2)
        {
            current = add_node(buffer_name, buffer_surname, current);
            if (head == current)
            {
                head = current;
            }
        }
    }

    printf("------------------------------------------------------------------------------------------------------------------ \n");

    struct Node* temp = current;

    while (temp != NULL)
    {
        printf("%s %s\n", temp->name, temp->surname);
        temp = temp->prev_node;
    }

    temp = head;

    while(temp != NULL)
    {
        struct Node* next = temp->next_node;
        free(temp->name);
        free(temp->surname);
        free(temp);
        temp = next;
    }
    
    return 0;
}
