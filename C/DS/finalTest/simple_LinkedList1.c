//
// Created by Yoon on 2020-12-11.
//
/*
 * ADT
 * `insert_first()`
 * `insert()`
 * `delete_first()`
 * `delete()`
 * `print_list()`
 */

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

// insert()
// 연결 리스트의 중간에 새로운 노드 추가
// 선행 노드를 가리키는 pre
ListNode *insert(ListNode *head, ListNode *pre, element value){
    ListNode *newNode;
    newNode=(ListNode *)malloc(sizeof(ListNode));

    newNode->data=value;
    newNode->link=pre->link;
    pre->link=newNode;

    return head;
}

// delete_first()
// head가 첫번째 노드의 링크를 가리키게한다.
ListNode *delete_first(ListNode *head){
    ListNode *removed;

    if (head==NULL) return NULL;

    removed=head;
    head=removed->link;
    free(removed);
    return head;
}

// delete()
// 삭제할 노드의 이전노드가 삭제할 노드의 link를 가리키게 한다.
ListNode *delete(ListNode *head, ListNode *pre){
    ListNode *removed;

    if (head==NULL) return NULL;

    removed=pre->link;
    pre->link=removed->link;
    free(removed);
    return head;
}

// print_list()
void print_list(ListNode *head){
    for(ListNode *p=head; p!=NULL; p=p->link){
        printf("%d -> ",p->data);
    }
    printf("NULL\n");
}

// concat_list
// 두 개의 리스트를 이어 붙임
// 첫 번째 리스트의 마지막으로 가서,
// 두 번 째 리스트의 첫 번째 노드를 가리키게 한다.
// NULL check
ListNode *concat_list(ListNode *head1, ListNode *head2){
    if (head1==NULL) return NULL;
    if (head2==NULL) return NULL;

    ListNode *p=head1;
    for(;p->link!=NULL; p=p->link);
    p->link=head2;
    return head1;
}

// reverse()
// 리스트를 역순으로 만들기
// p, q, r 포인터를 사용. 리스트를 순회하면서, 방향을 바꾼다.
ListNode *reverse(ListNode *head){
    ListNode *p, *q, *r; // 순회포인터

    p=head; // p는 역순으로 만들 리스트
    q=NULL; // q는 역순으로 만들 노드
    while (p!=NULL){
        r=q; // r은 역순으로 된 리스트.
        // r은 q, q는 p를 차례로 따라간다.

        q=p;
        p=p->link;
        q->link=r; // q의 링크 방향을 바꾼다.
    }
    return q;
}

int main(void){
    ListNode *head = NULL;
    ListNode *head2 = NULL;

    for(int i=0; i<5; i++){
        head=insert_first(head, i);
    }
    print_list(head);

    for(int i=9; i>5; i--){
        head2=insert_first(head2, i);
    }
    print_list(head2);

    head = concat_list(head,head2);
    print_list(head);

    head = reverse(head);
    print_list(head);

    return 0;
}