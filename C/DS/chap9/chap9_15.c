//
// Created by Yoon on 2020-11-22.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct LinkedNode {
    int data;
    struct LinkedNode *next;
} LinkedNode;

int is_empty(LinkedNode *node) {
    if (node == NULL) return 1;
    else return 0;
}


LinkedNode *new_node(int a) {
    LinkedNode *tmp = (LinkedNode *) malloc(sizeof(LinkedNode));
    tmp->data = a;
    tmp->next = NULL;
    return tmp;
}


LinkedNode * insert(LinkedNode *node, int val) {
    LinkedNode *tmp = new_node(val);
    LinkedNode *first = node;
    if (node->data > val) {
        tmp->next = node;
        node = tmp;
    } else {
        while (first->next != NULL && first->next->data < val) {
            first = first->next;
        }
        tmp->next = first->next;
        first->next = tmp;
    }
    return
            node;
}

int peek(LinkedNode *node) {
    return node->data;
}

LinkedNode *pop(LinkedNode *node) {
    LinkedNode *tmp = node;
    node = node->next;
    free(tmp);
    return node;
}


void result(HeapType *h, int size, int scan) {
    element save1, save2;
    int count = 0;
    int *mem;
    mem = (int *) malloc(sizeof(int) * size);
    for (int a = 0; a < size; a++) {
        save1 = delete_min_heap(h);
        if (save1.key == scan)
            continue;
        mem[count] = save1.key;
        count++;
    }
    free(h);
    h = create();
    init(h);
    for (int a = 0; a < count; a++) {
        save2.key = mem[a];
        insert_min_heap(h, save2);
    }
}
