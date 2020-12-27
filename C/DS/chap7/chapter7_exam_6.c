//
// Created by Yoon on 2020-11-07.
//
#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct DListNode {
    element data;
    struct DListNode* llink;
    struct DListNode* rlink;
}DListNode;

void dinsert(DListNode* before, DListNode* new_node) {
    new_node->llink = before;
    new_node->rlink = before->rlink;
    before->rlink->llink = new_node;
    before->rlink = new_node;
}

void init(DListNode* phead) {
    phead->llink = phead;
    phead->rlink = phead;
}

void print_list(DListNode* phead) {
    DListNode* p;
    for (p = phead->rlink; p != phead; p = p->rlink) {
        printf("%d ", p->data);
    }
    printf("\n");
    return;
}

int main(void) {
    DListNode list = {};
    DListNode* p;
    init(&list);

    int num=0;
    element data;
    printf("데이터 개수를 입력하세요 :");
    scanf("%d", &num);

    printf("\n");
    for (int i = 0; i < num; i++) {
        printf("노드 #%d의 데이터를 입력하시요 :",i+1);
        scanf("%d", &data);
        p = (DListNode*)malloc(sizeof(DListNode));
        p->data = data;
        dinsert(&list, p);
    }
    printf("\n");
    printf("데이터를 역순으로 출력 : ");

    print_list(&list);
}