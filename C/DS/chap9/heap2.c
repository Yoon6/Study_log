//
// Created by Yoon on 2020-11-28.
//

// heap은 1차원 배열로 표현할 수 있다.
// 노드의 각 요소들을 구조체 element로 정의
// element의 1차원 배열
// heap_size는 heap안에 저장된 요소의 개수

#include <stdlib.h>
#include <stdio.h>

#define MAX_ELEMENT 200
typedef struct {
    int key
}element;

typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
}HeapType;

HeapType * create(){
    return (HeapType *)malloc(sizeof(HeapType));
}

void init(HeapType *h){
    h->heap_size=0;
}

// 요소의 개수가 heap_size인 힙에 item 삽입
void insert_max_heap(HeapType *h, element item){
    int i;
    i=++(h->heap_size);

    // 삽입 값과, 부모노드의 값 비교
    while((i!=1)&&(item.key > h->heap[i/2].key)){
        h->heap[i]=h->heap[i/2]; // 부모노드를 말단에
        i /= 2;
    }
    h->heap[i]=item;
}

element delete_max_heap(HeapType *h){
    int parent, child;
    element item, temp;

    item = h->heap[1]; // 루트 노드
    temp = h->heap[(h->heap_size)--]; // 가장 말단의 노드

    parent=1;
    child=2;

    while(child <= h->heap_size){ // 자식 인덱스가 전체보다 작을 때,
        // 자식노드 중에 더 큰 자식
        if((child < h->heap_size)&&(h->heap[child].key) < (h->heap[child+1].key))
            child++;
        if(temp.key >= h->heap[child].key) break; // 부모노드가 자식노드보다 크면

        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2; // 자식의 왼쪽 자식
    }
    h->heap[parent]=temp;
    return item;
}

void heap_sort(element a[], int n){
    int i;
    HeapType *h;

    h=create();
    init(h);
    for(i=0; i<n; i++){
        insert_max_heap(h, a[i]);
    }
    for(i=(n-1); i>=0; i--){
        a[i]=delete_max_heap(h);
    }
    free(h);
}

#define SIZE 8
int main(void){
    element list[SIZE] = {23, 56, 11, 9, 56, 99, 27, 34};
    heap_sort(list, SIZE);

    for(int i=0; i<SIZE; i++){
        printf("%d ", list[i].key);
    }
    printf("\n");
    return 0;
}