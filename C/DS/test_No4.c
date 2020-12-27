//
// Created by Yoon on 2020-10-14.
//
#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 100
#define element char

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
        exit(1);
    }
    q->rear = (q->rear+1)%MAX_QUEUE_SIZE;
    q->data[q->rear]=item;
}

element dequeue(QueueTypes *q){
    if(is_empty(q)){
        printf("큐 공백 에러");
        exit(1);
    }
    q->front=(q->front+1)%MAX_QUEUE_SIZE;
    return q->data[q->front];
}

element peek(QueueTypes* q){
    if(is_empty(q)){
        printf("큐 공백 에러");
        exit(1);
    }
    return q->data[(q->front+1)%MAX_QUEUE_SIZE];
}

void see_queue(QueueTypes* q){
    printf(" { ");
    for(int i=q->front+1;i<=q->rear; i++){
        printf("%c, ",q->data[i]);
    }
    printf(" } \n");
}

int main(void){
    QueueTypes queue;
    init_queue(&queue);


    char hello[9] = "Hello";
    printf("1. enqueue(9, \"Hello\")\n");
    for(int i=0; hello[i]!=NULL; i++) {
        enqueue(&queue, hello[i]);
        see_queue(&queue);
    }
    printf("2. dequeue()\n");
    for(int i=0; hello[i]!=NULL; i++) {
        dequeue(&queue);
        see_queue(&queue);
    }

    char good[8] = "Good";
    printf("3. enqueue(8, \"Good\")\n");
    for(int i=0; good[i]!=NULL; i++) {
        enqueue(&queue, good[i]);
        see_queue(&queue);
    }

    printf("4. enqueue(7, \"Luck\")\n");
    char luck[7] = "Luck";
    for(int i=0; luck[i]!=NULL; i++) {
        enqueue(&queue, luck[i]);
        see_queue(&queue);
    }

    printf("5. dequeue()\n");
    for(int i=0; good[i]!=NULL&&luck[i]!=NULL; i++) {
        dequeue(&queue);
        see_queue(&queue);
    }
    return 0;
}