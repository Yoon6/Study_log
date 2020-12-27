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

void delete_odd(linkedList *L){
    if(L->head==NULL)
        return;
    ListNode *p=L->head;
    p=p->link;
    L->head=p;
    while(p->link->link!=NULL){
        p->link=p->link->link;
        p=p->link;
    }
    if(p->link->link==NULL){
        p->link=NULL;
    }

}

int main(){

    linkedList *L = (linkedList *)malloc(sizeof(linkedList));
    L->head=NULL;
    L->tail=NULL;

    insert(L,1);
    insert(L,2);
    insert(L,3);
    insert(L,4);
    insert(L,5);
    insert(L,6);
    insert(L,7);
    insert(L,8);
    insert(L,9);

    printList(L);
    printf("\n");

    delete_odd(L);

    printList(L);
    return 0;
}