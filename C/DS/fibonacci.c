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

element peek(QueueTypes* q){
    if(is_empty(q)){
        printf("큐 공백 에러");
    }
    return q->data[(q->front+1)%MAX_QUEUE_SIZE];
}

element fibonacci(QueueTypes* q, element n){
    if(n==0){
        return 0;
    }else if(n==1){
        return 1;
    }
    else{
        for(int i=2; i<=n; i++){
            element tmp = dequeue(q)+peek(q);
            enqueue(q, tmp);
        }
        dequeue(q);
        return dequeue(q);
    }
}

int main(void){
    QueueTypes queue;
    init_queue(&queue);

    int n=9;
    enqueue(&queue, 0);
    enqueue(&queue, 1);

    printf("fibonacci(%d) = %d", n, fibonacci(&queue, n));


    return 0;
}