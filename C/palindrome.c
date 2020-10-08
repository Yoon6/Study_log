//
// Created by Yoon on 2020-10-08.
//

#include<stdio.h>
#include<stdlib.h>
#define MAX_STACK_SIZE 100

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
    Stacktype s;
    init_stack(&s);

    char input[MAX_STACK_SIZE] = {};

    printf("문자열을 입력하세요:");
    scanf("%s",input);

    int i=0;
    while (input[i]!=NULL){
        if(input[i]>='a'&&input[i]<='z'){
            push(&s, input[i]);
        }else if(input[i]>='A'&&input[i]<='Z'){
            push(&s, input[i]+32);
        }
        i++;
    }

    Stacktype reverse;
    init_stack(&reverse);

    char save_string[MAX_STACK_SIZE] = {};
    i=0;
    while (!is_empty(&s)){
        save_string[i]=pop(&s);
        push(&reverse, save_string[i]);
        i++;
    }

    i=0;
    while (!is_empty(&reverse)){
        if(save_string[i]!=pop(&reverse)){
            printf("회문이 아닙니다.");
            break;
        }
        i++;
        if(is_empty(&reverse))
            printf("회문입니다.");
    }


    return 0;
}