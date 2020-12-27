//
// Created by Yoon on 2020-10-29.
//
#include <stdio.h>
#include <stdlib.h>

#define element int
typedef struct ListNode{
    element data;
    struct ListNode* link;
} ListNode;

typedef struct list {
    ListNode *head;
    ListNode *tail;
} linkedList;

void insert(linkedList *L, element value){
    ListNode *node = (ListNode *)malloc(sizeof(ListNode));
    node->data=value;
    node->link=NULL;
    if(L->head==NULL&&L->tail==NULL){
        L->head=L->tail=node;
    }else{
        L->tail->link=node;
        L->tail=node;
    }
}

void printList(linkedList *L){
    ListNode *p = L->head;
    while(p != NULL){
        printf(" %d ",p->data);
        if(p->link!=NULL)
            printf("->");
        p=p->link;
    }
}

int sizeList(linkedList *L){
    ListNode* p = L->head;
    int count = 0;
    while (p->link!=NULL){
        count++;
        p=p->link;
    }
    return count+1;
}

int main(){

    linkedList *L = (linkedList *)malloc(sizeof(linkedList));
    L->head=NULL;
    L->tail=NULL;

    int n;
    element input;

    printf("노드의 개수 :");
    scanf("%d",&n);

    for(int i=0; i<n; i++){
        printf("노드 #%d 데이터 :", i+1);
        scanf("%d",&input);

        insert(L, input);
    }

    int size = sizeList(L);
    printf("\n연결 리스트 노드의 개수 = %d\n", size);
    return 0;
}