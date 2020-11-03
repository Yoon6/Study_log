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
void printList(linkedList *L){
    ListNode *p = L->head;
    while(p != NULL){
        printf(" %d ",p->data);
        if(p->link!=NULL)
            printf("->");
        p=p->link;
    }
}

int main(){

    linkedList *L = (linkedList *)malloc(sizeof(linkedList));
    L->head=NULL;
    L->tail=NULL;



    return 0;
}