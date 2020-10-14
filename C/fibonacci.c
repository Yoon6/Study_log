//
// Created by Yoon on 2020-10-14.
//
#include <stdio.h>

#define MAX_QUEUE_SIZE 10
#define element int

typedef struct {
    element data[MAX_QUEUE_SIZE];
    int front;
    int rear;
}QueueTypes;

void init_queue(QueueTypes* q){
    q->front = q->rear = 0;
}

int is_empty(QueueTypes* q){
    return q->front==q->rear;
}

int is_full(QueueTypes *q){
    return (q->rear+1)%MAX_QUEUE_SIZE==q->front;
}

void enqueue(QueueTypes* q, element item){
    if(is_full(q)) {
        printf("큐 포화 에러");
    }
    q->rear = (q->rear+1)%MAX_QUEUE_SIZE;
    q->data[q->rear]=item;
}

element dequeue(QueueTypes *q){
    if(is_empty(q)){
        printf("큐 공백 에러");
    }
    q->front=(q->front+1)%MAX_QUEUE_SIZE;
    return q->data[q->front];
}

int main(void){
    QueueTypes queue;
    element ele=0;
    init_queue(&queue);


    printf("----데이터 추가----\n");

    while(!is_full(&queue)){
        printf("점수를 입력하시오 :");
        scanf("%d", &ele);
        enqueue(&queue, ele);
    }

    printf("큐는 포화상태 \n");
    printf("----데이터 삭제----\n");

    while(!is_empty(&queue)){
        printf("%d\n", dequeue(&queue));
    }
    return 0;
}