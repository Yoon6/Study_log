//
// Created by Yoon on 2020-10-07.
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
        //error("스택 공백 에러");
        return 0;
    }
    else{
        return s->stack[s->top];
    }
}

int main(void) {
    Stacktype sa;
    Stacktype sb;
    init_stack(&sa);
    init_stack(&sb);

    char input[MAX_STACK_SIZE] = {};

    printf("문자열을 입력하시오.:");
    scanf("%s", input);

    int i=0;
    while(input[i]!=NULL){
        if(input[i]=='a'||input[i]=='A'){
            push(&sa, 'a');
        }else if(input[i]=='b'||input[i]=='B'){
            push(&sb, 'b');
        }
        i++;
    }

    printf("압축된 문자열: %d%c%d%c", sa.top+1,peek(&sa),sb.top+1,peek(&sb));


    return 0;
}

