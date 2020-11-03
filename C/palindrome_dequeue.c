//
// Created by Yoon on 2020-10-15.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX_DEQUE_SIZE 100
typedef char element;

typedef struct {
    element data[MAX_DEQUE_SIZE];
    int front, rear;
}DequeType;

void init_deque(DequeType* dq){
    dq->front=dq->rear=0;
}

int is_empty(DequeType* dq){
    return dq->front==dq->rear;
}
int is_full(DequeType* dq){
    return ((dq->rear+1)%MAX_DEQUE_SIZE == dq->front);
}

void add_rear(DequeType* dq, element value){
    if(is_full(dq)) {
        printf("큐 포화\n");
        exit(1);
    }
    else {
        dq->rear = (dq->rear + 1) % MAX_DEQUE_SIZE;
        dq->data[dq->rear] = value;
    }
}

void add_front(DequeType* dq, element value){
    if(is_full(dq)) {
        printf("큐 포화\n");
        exit(1);
    }
    else {
        dq->data[dq->front] = value;
        dq->front = (dq->front - 1 + MAX_DEQUE_SIZE) % MAX_DEQUE_SIZE;
    }
}

element delete_rear(DequeType* dq){
    if(is_empty(dq)) {
        printf("큐 공백\n");
        exit(1);
    }
    else{
        element temp = dq->data[dq->rear];
        dq->rear = (dq->rear - 1) % MAX_DEQUE_SIZE;
        return temp;
    }
}

element delete_front(DequeType* dq){
    if(is_empty(dq)) {
        printf("큐 공백\n");
        exit(1);
    }
    else{
        dq->front = (dq->front+1) % MAX_DEQUE_SIZE;
        return dq->data[dq->front];
    }
}

int main(void) {
    DequeType dq_front, dq_rear;
    init_deque(&dq_front);
    init_deque(&dq_rear);

    char input[MAX_DEQUE_SIZE]={};

    printf("문자열을 입력하세요 :");
    scanf("%s", input);

    int i = 0;

    while (input[i] != NULL) {
        if (input[i] >= 'a' && input[i] <= 'z') {
            add_front(&dq_front, input[i]);
            add_rear(&dq_rear, input[i]);
        } else if (input[i] >= 'A' && input[i] <= 'Z') {
            add_front(&dq_front, input[i] + 32);
            add_rear(&dq_rear, input[i] + 32);
        }
        i++;
    }

    while (!is_empty(&dq_rear)) {
        if(delete_front(&dq_front)!=delete_front(&dq_rear)){
            printf("회문이 아닙니다.");
            break;
        }
        if(is_empty(&dq_front)) {
            printf("회문입니다.");
        }

    }

}





