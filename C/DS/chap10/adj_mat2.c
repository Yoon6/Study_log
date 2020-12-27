//
// Created by Yoon on 2020-11-28.
//

#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 50

typedef struct GraphType {
    int n; // 정점의 개수
    int adj_mat[MAX_VERTICES][MAX_VERTICES]; // 점의 개수 제한 50개
} GraphType;

void init(GraphType *g){
    int r, c;
    g->n = 0;
    for(r=0; r<MAX_VERTICES; r++)
        for(c=0; c<MAX_VERTICES; c++)
            g->adj_mat[r][c]=0;
}

void insert_vertex(GraphType *g, int v){
    if(((g->n)+1)>MAX_VERTICES){
        fprintf(stderr, "그래프 : 정점의 개수 초과");
        return;
    }
    g->n++;
}

void insert_edge(GraphType *g, int start, int end){
    if(start >= g->n || end >= g->n){
        fprintf(stderr, "그래프 : 정점 번호 오류"); // 정점 번호가 차례대로 생김
        return;
    }
    g->adj_mat[start][end]=1;
    g->adj_mat[end][start]=1;
}

void print_adj_mat(GraphType *g){
    for(int i=0; i<g->n; i++){
        for(int j=0; j<g->n; j++){
            printf("%2d ", g->adj_mat[i][j]);
        }
        printf("\n");
    }
}

int out_degree(GraphType *g, int n){
    int sum=0;

    for(int i=0; i<g->n; i++){
        sum += g->adj_mat[n][i];
    }
    return sum;
}
int in_degree(GraphType *g, int n){
    int sum=0;

    for(int i=0; i<g->n; i++){
        sum += g->adj_mat[i][n];
    }
    return sum;
}
int sum_edge(GraphType *g){
    int sum=0;

    for(int i=0; i<g->n; i++)
        for(int j=0; j<g->n; j++)
        sum += g->adj_mat[i][j];

    return sum;
}
void main(){
    GraphType *g;
    g=(GraphType *)malloc(sizeof(GraphType));
    init(g);

    for(int i=0; i<4; i++)
        insert_vertex(g, i);

    insert_edge(g, 0, 1);
    insert_edge(g, 0, 2);
    insert_edge(g, 0, 3);
    insert_edge(g, 1, 2);
    insert_edge(g, 2, 3);
    print_adj_mat(g);

    int out = out_degree(g, 0);
    int in = in_degree(g, 0);
    printf("\n%d\n", out);
    printf("\n%d\n", in);

    free(g);
}