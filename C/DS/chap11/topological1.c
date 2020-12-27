//
// Created by Yoon on 2020-12-05.
//

#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50

typedef struct GraphNode {
    int vertex;
    struct GraphNode *link;
}GraphNode;

typedef struct {
    int n; // 정점의 개수
    GraphNode *adj_list[MAX_VERTICES];
}GraphType;

void graph_init(GraphType *g){
    int v;
    g->n=0;
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
    node=(GraphNode *)malloc(sizeof(GraphNode));
    node->vertex=v;
    node->link=g->adj_list[u];
    g->adj_list[u]=node;
}

// ---- stack ----
#define MAX_STACK_SIZE 100
typedef int element;
typedef struct {
    element stack[MAX_STACK_SIZE];
    int top;
}StackType;

void init(StackType *s){
    s->top=-1;
}

int is_empty(StackType *s){
    return (s->top==-1);
}

int is_full(StackType *s){
    return (s->top==(MAX_STACK_SIZE-1));
}

void push(StackType *s, element item){
    if(is_full(s)){
        fprintf(stderr, "스택 포화 에러\n");
        return;
    }
    else s->stack[++(s->top)]=item;
}

element pop(StackType *s){
    if(is_empty(s)){
        fprintf(stderr, "스택 공백 에러\n");
        exit(1);
    }
    else return s->stack[(s->top)--];
}

int topo_sort(GraphType *g){
    int i;
    StackType s;
    GraphNode *node;

    // 모든 정점의 진입 차수를 계산
    int *in_degree = (int *)malloc(g->n*sizeof(int));

    for(i=0; i<g->n; i++){
        in_degree[i]=0; // 초기화
    }

    for(i=0; i<g->n; i++){
        node = g->adj_list[i]; // 정점 i에서 나오는 간선들
        while (node!=NULL){
            in_degree[node->vertex]++;
            node=node->link;
        }
    }

    init(&s);

    for(i=0; i<g->n; i++){
        if(in_degree[i]==0) push(&s, i);
    }

    // 위상 순서를 생성
    while(!is_empty(&s)){
        int w;
        w=pop(&s);

        printf("cs%d ->", w+1);
        node=g->adj_list[w];

        while (node != NULL){
            int u = node->vertex;
            in_degree[u]--;
            if(in_degree[u]==0) push(&s, u);
            node=node->link;
        }
    }
    free(in_degree);
    printf("\n");
    return (i==g->n); // 1이면 성공 0이면 실패
}

int main(void){
    GraphType g;

    graph_init(&g);

    insert_vertex(&g, 0);
    insert_vertex(&g, 1);
    insert_vertex(&g, 2);
    insert_vertex(&g, 3);
    insert_vertex(&g, 4);
    insert_vertex(&g, 5);
    insert_vertex(&g, 6);
    insert_vertex(&g, 7);

    insert_edge(&g, 0,1);
    insert_edge(&g, 1,2);
    insert_edge(&g, 1,3);
    insert_edge(&g, 1,4);
    insert_edge(&g, 2,7);
    insert_edge(&g, 3,6);
    insert_edge(&g, 4,5);
    insert_edge(&g, 4,6);
    insert_edge(&g, 5,7);
    insert_edge(&g, 6,7);

    topo_sort(&g);

    return 0;

}
