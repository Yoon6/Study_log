//
// Created by Yoon on 2020-11-07.
//
#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct StackNode {
    element data;
    struct StackNode *link;
}StackNode;

typedef struct {
    StackNode  *top;
}LinkedStackType;

void init(LinkedStackType *s){
    s->top=NULL;
}

int is_empty(LinkedStackType *s){
    return(s->top==NULL);
}

int is_full(LinkedStackType *s){
    return 0;
}

void push(LinkedStackType *s, element item){
    StackNode *temp = (StackNode *)malloc(sizeof(StackNode));

    temp->data = item;
    temp->link = s->top;
    s->top = temp;
}

element pop(LinkedStackType *s){
    if(s->top==NULL){
        fprintf(stderr, "스택이 비어있음\n");
        exit(1);
    }
    else{
        StackNode *temp = s->top;
        element data = temp -> data;
        s->top = temp -> link;
        free(temp);
        return data;
    }
}

element peek(LinkedStackType *s){
    if(is_empty(s)){
        fprintf(stderr, "스택이 비어있음\n");
        exit(1);
    }
    else return s->top->data;
}

void print_stack(LinkedStackType *s){
    for(StackNode *p=s->top; p!=NULL; p=p->link){
        printf("%d->", p->data);
    }
    printf("NULL\n");
}

int main(void){
    LinkedStackType *s;

    init(&s);
    push(&s, 1);
    print_stack(&s);
    push(&s, 2);
    print_stack(&s);
    push(&s, 3);
    print_stack(&s);
    push(&s, 4);
    print_stack(&s);
    pop(&s);
    print_stack(&s);
    pop(&s);
    print_stack(&s);
    pop(&s);
    print_stack(&s);
    pop(&s);
    print_stack(&s);
    return 0;
}