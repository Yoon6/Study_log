//
// Created by Yoon on 2020-11-28.
//

#include <stdio.h>
#include <stdlib.h>

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

void print_adj_list(GraphType *g){
    for(int i=0; i<g->n; i++){
        GraphNode *p=g->adj_list[i];
        printf("정점 %d의 인접 리스트 ",i);
        while(p!=NULL){
            printf("-> %d", p->vertex);
            p=p->link;
        }
        printf("\n");
    }
}

int out_degree(GraphType *g, int n){
    GraphNode *p=g->adj_list[n];
    int sum=0;
    while(p!=NULL){
        sum+=1;
        p=p->link;
    }
    return sum;
}

int in_degree(GraphType *g, int n){
    int sum = 0;
    for(int i=0; i<g->n; i++){
        GraphNode *p=g->adj_list[i];
        while(p!=NULL){
            if(p->vertex==n) sum+=1;
            p=p->link;
        }
    }
    return sum;
}

int all_degree(GraphType *g){
    int sum = 0;
    for(int i=0; i<g->n; i++){
        GraphNode *p=g->adj_list[i];
        while(p!=NULL){
            sum+=1;
            p=p->link;
        }
    }
    return sum;
}

int main(){
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
    print_adj_list(g);

    int out = out_degree(g, 1);
    printf("%d\n", out);

    int in = in_degree(g, 2);
    printf("%d\n", in);

    int all = all_degree(g);
    printf("%d\n", all);
    free(g);
    return 0;
}