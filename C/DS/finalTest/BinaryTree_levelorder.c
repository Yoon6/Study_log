//
// Created by Yoon on 2020-12-13.
//

// 레벨 순회 구현
// 같은 층(레벨) 순서로 탐색
// 왼쪽에서 오른쪽으로
// 큐를 사용한다.

#include <stdlib.h>
#include <stdio.h>
#include <memory.h>

typedef struct TreeNode {
    int data;
    struct TreeNode *left, *right;
}TreeNode;

// ====== 원형 큐 =======
#define MAX_QUEUE_SIZE 100
typedef TreeNode *element;
typedef struct {
    element data[MAX_QUEUE_SIZE];
    int front, rear;
}QueueType;

void init_queue(QueueType *q){
    q->front=q->rear=0;
}

int is_empty(QueueType *q){
    return (q->rear==q->front);
}

int is_full(QueueType *q){
    return ((q->rear+1)%MAX_QUEUE_SIZE==q->front);
}

void enqueue(QueueType *q, element item){
    if(is_full(q)){
        fprintf(stderr, "큐 표화상태\n");
        exit(1);
    }
    q->rear=(q->rear+1)%MAX_QUEUE_SIZE;
    q->data[q->rear]=item;
}

element dequeue(QueueType *q){
    if(is_empty(q)){
        fprintf(stderr, "큐 공백상태\n");
        exit(1);
    }
    q->front=(q->front+1)%MAX_QUEUE_SIZE;
    return q->data[q->front];
}

void level_order(TreeNode *ptr){
    QueueType q;

    init_queue(&q);

    if(ptr==NULL) return;
    enqueue(&q, ptr);

    while (!is_empty(&q)){
        ptr=dequeue(&q);
        printf(" [%d] ", ptr->data);
        if(ptr->left)
            enqueue(&q, ptr->left);
        if(ptr->right)
            enqueue(&q, ptr->right);
    }
}

TreeNode n1 = {1, NULL, NULL};
TreeNode n2 = {4, &n1, NULL};
TreeNode n3 = {16, NULL, NULL};
TreeNode n4 = {25, NULL, NULL};
TreeNode n5 = {20, &n3, &n4};
TreeNode n6 = {15, &n2, &n5};
TreeNode *root = &n6;

/*
 *       n6
 *     /   \
 *    n2   n5
 *   /    /  \
 *  n1   n3  n4
 *
 *       15
 *      /  \
 *     4   20
 *    /   /  \
 *   1   16  25
 */

int main(void){
    printf("레벨 순회=");
    level_order(root);
    printf("\n");

    return 0;
}