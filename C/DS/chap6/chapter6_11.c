//
// Created by Yoon on 2020-11-02.
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

int sumList(linkedList *L){
    ListNode* p = L->head;
    int sum = 0;
    while (p->link!=NULL){
        sum+=p->data;
        p=p->link;
    }
    sum+=p->data;

    return sum;
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

    int sum = sumList(L);
    printf("\n연결 리스트의 데이터 합: %d\n", sum);
    return 0;
}