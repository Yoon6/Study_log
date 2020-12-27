//
// Created by Yoon on 2020-11-29.
//

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 2
#define MAX_QUEUE_SIZE 10

typedef int element;

// 큐 타입
typedef struct {
    element queue[MAX_QUEUE_SIZE];
    int front, rear;
}QueueType;

void error(char *message){
    fprintf(stderr, "%s\n", message);
    exit(1);
}

void queue_init(QueueType *q){
    q->front=q->rear=0;
}

int is_empty(QueueType *q){
    return (q->front==q->rear);
}

int is_full(QueueType *q){
    return ((q->rear+1)%MAX_QUEUE_SIZE==q->front);
}

void enqueue(QueueType *q, element item){
    if(is_full(q))
        error("큐가 포화상태입니다.");
    q->rear = (q->rear+1)%MAX_QUEUE_SIZE;
    q->queue[q->rear]=item;
}

element  dequeue(QueueType *q){
    if(is_empty(q))
        error("큐가 공백 상태 입니다");
    q->front=(q->front+1)%MAX_QUEUE_SIZE;
    return q->queue[q->front];
}

#define MAX_VERTICES 50


typedef struct GraphNode {
    int vertex;
    struct GraphNode *link;
} GraphNode;

typedef struct GraphType {
    int n; // 정점의 개수
    GraphNode *adj_list[MAX_VERTICES];
}GraphType;

void init(GraphType *g){
    int v;
    g->n = 0;
    for(v=0; v<MAX_VERTICES; v++){
        g->adj_list[v]=NULL;
    }
}

void insert_vertex(GraphType *g, int v){
    if(((g->n)+1)>MAX_VERTICES){
        fprintf(stderr, "그래프 : 정점의 개수 초과");
        return;
    }
    g->n++;
}

void insert_edge(GraphType *g, int u, int v){
    GraphNode *node;
    if(u >= g->n || v >= g->n){
        fprintf(stderr, "그래프 : 정점 번호 오류");
        return;
    }
    node=(GraphNode *)malloc(sizeof(GraphNode)); // 노드를 새로 할당
    node->vertex=v; // 값에 v
    node->link = g->adj_list[u]; // 링크는 원래 출발리스트가 가르키고 있던 곳
    g->adj_list[u] = node; // 출발 리스트는 새로운 노드를 가리킨다.
}

int visited[MAX_VERTICES];

void bfs_list(GraphType *g, int v){
    GraphNode *w;
    QueueType q;

    queue_init(&q);
    visited[v]=TRUE;
    printf("%d 방문 -> ", v);
    enqueue(&q, v);
    while(!is_empty(&q)){
        v = dequeue(&q);
        for(w=g->adj_list[v]; w; w=w->link)
            if(!visited[w->vertex]){
                visited[w->vertex]=TRUE;
                printf("%d 방문 -> ", w->vertex);
                enqueue(&q, w->vertex);
            }
    }
}

int main(void){
    GraphType *g;
    g=(GraphType *)malloc(sizeof(GraphType));
    init(g);
    for(int i=0; i<4; i++)
        insert_vertex(g, i);
    insert_edge(g, 0, 1);
    insert_edge(g, 1, 0);
    insert_edge(g, 0, 2);
    insert_edge(g, 2, 0);
    insert_edge(g, 0, 3);
    insert_edge(g, 3, 0);
    insert_edge(g, 1, 2);
    insert_edge(g, 2, 1);
    insert_edge(g, 2, 3);
    insert_edge(g, 3, 2);
    bfs_list(g, 1);
    free(g);
    return 0;
}