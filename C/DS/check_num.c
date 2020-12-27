//
// Created by Yoon on 2020-10-07.
//
#include<stdio.h>
#include<stdlib.h>

#define MAX_STACK_SIZE 100
typedef int element;

element stack[MAX_STACK_SIZE];
int top = -1;

void error(char str[]) {
    printf("%s\n", str);
    exit(1);
}

int is_empty() { return (top == -1); }

int is_full() { return (top == (MAX_STACK_SIZE - 1)); }

int size() { return top + 1; }

void push(element item) {
    if (is_full())
        error("스택 포화 에러");
    else stack[++top]=item;
}

element pop() {
    if (is_empty()){
        error("스택 공백 에러");
        return 0;
    }
    else return stack[top--];
}

element peek() {
    if (is_empty()){
        error("스택 공백 에러");
        return 0;
    }
    else return stack[top];
}
int main() {

    char input[MAX_STACK_SIZE]={};
    printf("수식:");
    scanf("%s", input);

    int i=0, count=1;
    while(input[i] != NULL){
        if(input[i]=='('){
            push(count);
            printf("%d ",count);
            count++;
        }else{
            printf("%d ",pop());
        }
        i++;
    }

    return 0;
}
