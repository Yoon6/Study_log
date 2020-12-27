//
// Created by Yoon on 2020-11-22.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ELEMENT 100
typedef struct {
    int key; //우선순위
    char content[25]; //할일 내용
} element;
typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;
HeapType* create()
{
    return (HeapType*)malloc(sizeof(HeapType));
}
void init(HeapType* h)
{
    h->heap_size = 0;
}
void insert_max_heap(HeapType* h, element item)
{
    int i;
    i = ++(h->heap_size);
    while ((i != 1) && (item.key > h->heap[i / 2].key)) {
        //트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item; //새로운 노드를 삽입
}
element delete_max_heap(HeapType* h)
{
    int parent, child;
    element item, temp;
    item = h->heap[1];
    temp = h->heap[(h->heap_size)--];
    parent = 1;
    child = 2;
    while (child <= h->heap_size) {
        //현재 노드의 자식노드 중 더 큰 자식노드를 찾는다
        if ((child < h->heap_size) && (h->heap[child].key) < h->heap[child + 1].key)
            child++;
        if (temp.key >= h->heap[child].key) break;
        //한단계 아래로 이동
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}
main()
{
    HeapType* heap;
    heap = create(); //히프 생성
    init(heap); //초기화
    while (1)
    {
        element scan, print;
        printf("삽입(i), 삭제(d) : ");
        char command;
        scanf("%c", &command);
        switch (command) {
            case'i':
                printf("할 일 : ");
                char scancont[25];
                scanf(" %[^\n]", &scancont);
                strcpy(scan.content, scancont);
                printf("우선순위 : ");
                int scankey;
                scanf("%d", &scankey);
                getchar();
                //엔터가 남아 다음 입력에 영향을 준다.
                //아무것도 없는 공간에 엔터를 입력받아서 버퍼에서 제거한다
                scan.key = scankey;
                insert_max_heap(heap, scan);
                break;
            case'd':
                print = delete_max_heap(heap);
                printf("제일 우선 순위가 높은 일은 \"%s\"\n", print.content);
                getchar();
                break;
            default:
                printf("잘못된 명령어 입력\n");
                break;
        }
    }
}
