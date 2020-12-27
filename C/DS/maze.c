//
// Created by Yoon on 2020-10-08.
//

#include<stdio.h>
#define MAX_STACK_SIZE 100
#define MAZE_SIZE 6

char maze[MAZE_SIZE][MAZE_SIZE] = {
        {'1','1','1','1','1','1'},
        {'e','0','1','0','0','1'},
        {'1','0','0','0','1','1'},
        {'1','0','1','0','1','1'},
        {'1','0','1','0','0','x'},
        {'1','1','1','1','1','1'},
};

typedef struct element {
    int r, c;
}element;

typedef struct Stacktype {
    element stack[MAX_STACK_SIZE];
    int top;
}Stacktype;

void init_stack(Stacktype* s) {
    s->top = -1;
}

void push(Stacktype* s, int row, int column) {
    if (row < 0 || row >= MAZE_SIZE || column < 0 || column >= MAZE_SIZE) // maze의 범위를 넘어가면
        return;
    if (maze[row][column] == '0' || maze[row][column] == 'x'){
        s->stack[++(s->top)].r = row;
        s->stack[(s->top)].c = column;
    }
    return;
}

int is_empty(Stacktype* s) {
    return s->top == -1;
}

element pop(Stacktype* s) {
    element t = s->stack[s->top];
    s->stack[s->top].r = 0;
    s->stack[s->top].c = 0;
    s->top--;
    return t;
}



int main(void) {
    Stacktype s;
    init_stack(&s);

    element log[MAX_STACK_SIZE] = {};

    element here = { 1,0 }; // 출발 주소

    int i = 0, r, c;
    while (maze[here.r][here.c] != 'x') {
        r = here.r;
        c= here.c;
        maze[r][c] = '.';

        //경로 저장
        log[i].r = r;
        log[i++].c = c;

        // 4방향
        push(&s, r + 1, c);
        push(&s, r, c + 1);
        push(&s, r - 1, c);
        push(&s, r, c - 1);

        if (is_empty(&s)) {
            printf("실패\n");
            return 0;
        }
        else
            here = pop(&s);

    }
    for (int k = 0; k < i; k++)
        printf("(%d, %d) \n", log[k].r, log[k].c);

    return 0;
}