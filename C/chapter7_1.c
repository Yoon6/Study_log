//
// Created by Yoon on 2020-11-07.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int element;
typedef struct DListNode{
    element data;
    struct DListNode *llink;
    struct DListNode *rlink;
}DListNode;

void init(DListNode *head){
    head->llink=NULL;
    head->rlink=NULL;
    head->data=NULL;
}

void print_list(DListNode *phead){
    DListNode *p;

    for(p=phead->rlink; p!=phead; p=p->rlink){
        printf("<-||%d||->",p->data);
    }

    printf("\n");
}

void dinsert(DListNode *before, element data){
    DListNode *newnode = (DListNode *)malloc(sizeof(DListNode));

    strcpy(newnode->data, data);
    newnode->llink=before;
    newnode->rlink=before->rlink;
    before->rlink->llink=newnode;
    before->rlink=newnode;
}

void ddelete(DListNode *head, DListNode *removed){
    if(removed==head) return;
    removed->llink->rlink=removed->rlink;
    removed->rlink->llink=removed->llink;
    free(removed);
}

int main(void){
    DListNode *head = (DListNode *)malloc(sizeof(DListNode));
    init(head);
    printf("삽입 단계\n");
    for(int i=0; i<5; i++){
        printf("%d insert\n", i);
        dinsert(head, i);
    }
    printf("\n삭제 단계\n");
    for(int i=0; i<5; i++){
        print_list(head);
        ddelete(head, head->rlink);
    }
    free(head);
    return 0;

}