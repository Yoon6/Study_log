//
// Created by Yoon on 2020-11-22.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX_ELEMENT 50
typedef struct {
    int key;
} element;
typedef struct {
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

HeapType *create() {
    return (HeapType *) malloc(sizeof(HeapType));
}//힙 생성
void init(HeapType *h) {
    h->heap_size = 0;
}//힙 초기화
void insert_min_heap(HeapType *h, element item) {
    int i;
    i = ++(h->heap_size);
    while ((i != 1) && (item.key < h->heap[i / 2].key)) {
        h->heap[i] = h->heap[i / 2];
        i /= 2;
    }
    h->heap[i] = item;
}//힙 삽입
element delete_min_heap(HeapType *h) {
    int parent, child;
    element item, temp;
    item = h->heap[1];
    temp = h->heap[(h->heap_size)--];
    parent = 1;
    child = 2;
    while (child <= h->heap_size) {
        if ((child < h->heap_size) && (h->heap[child].key) > h->heap[child + 1].key)
            child++;
        if (temp.key < h->heap[child].key) break;
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2;
    }
    h->heap[parent] = temp;
    return item;
}//힙 삭제
void result(HeapType *h, int size, int scan) {
    element save1, save2; //임시로 저장할 element 변수 생성
    int count = 0; //배열에서 사용할 카운터 생성
    int *mem; //동적으로 배열 생성 준비
    mem = (int *) malloc(sizeof(int) * size); //동적으로 배열생성
    for (int a = 0; a < size; a++) {
        save1 = delete_min_heap(h); //h에서 값을 가져와 save1에 저장
        if (save1.key == scan) //만약 삭제해야 하는 값이라면 넘어간다
            continue;
        mem[count] = save1.key; //삭제할 값이 아니면 배열에 저장
        count++; //카운터 증가
    }
    free(h); //h 비우기
    h = create();
    init(h); //h 재생성 과정
    for (int a = 0; a < count; a++) {
        save2.key = mem[a]; //배열에 있는 값을 save2에 저장
        insert_min_heap(h, save2); //순서대로 h에 다시 저장
    }
}//힙 삭제를 응용한 것이다

main() {
    element data[] = {5, 64, 2, 45, 15, 43, 22, 17}; //값 미리 입력
    element save;
    HeapType *h;
    h = create();
    init(h);
    printf("트리에 들어갈 요소 : ");
    for (int a = 0; a < 8; a++) {
        int temp = data[a].key;
        printf("%d ", temp);
    }
    for (int a = 0; a < 8; a++)
        insert_min_heap(h, data[a]);
    printf("\n");
    printf("삭제할 요소 : ");
    int scan;
    scanf("%d", &scan);
    printf("삭제 후 결과 : ");
    result(h, 8, scan);
    int size = h->heap_size;
    for (int a = 0; a < size; a++) {
        save = delete_min_heap(h);
        printf("%d ", save.key);
    }
}
