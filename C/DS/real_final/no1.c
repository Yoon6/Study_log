//
// Created by Yoon on 2020-12-14.
//

#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode {
    element data;
    struct ListNode *link;
}ListNode;

// insert_first()
// 새로운 노드를 만들고, 새로운 노드의 link에 head값(원래의 첫 번째 노드)을 저장하고,
// head가 새로운 노드를 가리키게 한다.
// 변경된 헤드 포인터를 반환한다.
ListNode *insert_first(ListNode *head, element value){
    ListNode *newNode;
    newNode=(ListNode *)malloc(sizeof(ListNode));

    newNode->data=value;
    newNode->link=head;
    head=newNode;

    return head;
}

// print_list()
void print_list(ListNode *head){
    for(ListNode *p=head; p!=NULL; p=p->link){
        printf("%d -> ",p->data);
    }
    printf("NULL\n");
}

void split(ListNode *A, ListNode *B, ListNode *C){
    int i=1;
    for(ListNode *p=C; p!=NULL; p=p->link, i++){
        if(i%2==0){ // 짝수
            B=insert_first(B, p->data);
            if (p->link==NULL){
                printf("B : ");
                print_list(B);
            }
        }else{ // 홀수
            A=insert_first(A, p->data);
            if (p->link->link==NULL){
                printf("A : ");
                print_list(A);
            }
        }
    }
}

int main(void){
    ListNode *A = NULL;
    ListNode *B = NULL;
    ListNode *C = NULL;

    for(int i=0; i<10; i++){
        C=insert_first(C, i+1);
    }
    printf("C : ");
    print_list(C);

    split(A, B, C);


    return 0;
}