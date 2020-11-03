//
// Created by Yoon on 2020-11-02.
//

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Person {
    char name[20];
    int age;
    float height;
} Person;

#define element Person
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
        printf("[%s, %d, %.1f] ",p->data.name,p->data.age,p->data.height);
        if(p->link!=NULL)
            printf("->");
        p=p->link;
    }
}

int main(){

    linkedList *L = (linkedList *)malloc(sizeof(linkedList));
    L->head=NULL;
    L->tail=NULL;

    Person p;

    strcpy(p.name, "Kim");
    p.age = 34;
    p.height = 1.7;
    insert(L, p);

    strcpy(p.name, "Park");
    p.age = 27;
    p.height = 1.2;
    insert(L, p);

    strcpy(p.name, "Lee");
    p.age = 48;
    p.height = 1.4;
    insert(L, p);

    strcpy(p.name, "Choi");
    p.age = 30;
    p.height = 1.3;
    insert(L, p);

    printList(L);

    return 0;
}