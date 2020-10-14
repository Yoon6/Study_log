//
// Created by Yoon on 2020-10-08.
//

#include<stdio.h>
#include<stdlib.h>
#define MAX_STACK_SIZE 10

typedef struct Stacktype {
    int stack[MAX_STACK_SIZE];
    int top;
}Stacktype;

void error(char str[]) {
    printf("%s\n", str);
    exit(1);
}

void init_stack(Stacktype* s) {
    s->top = -1;
}

int is_empty(Stacktype* s) {
    return s->top == -1;
}

int is_full(Stacktype* s) {
    return s->top == (MAX_STACK_SIZE-1);
}

void push(Stacktype* s, int item) {
    if(is_full(s)){
        error("스택 포화 에러");
    }else{
        s->stack[++(s->top)] = item;
    }
}

int pop(Stacktype* s) {
    if(is_empty(s)) {
        error("스택 공백 에러");
        return 0;
    }
    else{
        int t = s->stack[s->top];
        s->stack[s->top] = 0;
        s->top--;
        return t;
    }

}

int peek(Stacktype* s){
    if(is_empty(s)) {
        error("스택 공백 에러");
        return 0;
    }
    else{
        return s->stack[s->top];
    }
}

int size(Stacktype* s){
    if(is_empty(s))
        return 0;
    else
        return s->top+1;
}

int main(void) {
    Stacktype s1, s2;
    init_stack(&s1);
    init_stack(&s2);

    int input=0;

    printf("--- 입력 ---\n");

    while (!is_full(&s1)){
        printf("정수를 입력하시오.:");
        scanf("%d",&input);
        push(&s1, input);
    }

    printf("--- 출력 ---\n");

    while (!is_empty(&s1)){
        push(&s2, pop(&s1));
    }

    while(!is_empty(&s2)){
        printf("%d\n", pop(&s2));
    }

    return 0;
}