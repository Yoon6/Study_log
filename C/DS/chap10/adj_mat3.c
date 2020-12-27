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
            printf("%2d", g->adj_mat[i][j]);
        }
        printf("\n");
    }
}

void read_graph_mat(GraphType *g, char *name){

    FILE *fp = fopen(name, "r");

    if(fp == NULL){
        printf("파일열기 실패\n");
        return;
    } else {
        printf("파일열기 성공\n");
    }

    fscanf(fp, "%d", &g->n);

    for(int i=0; i<g->n; i++)
        for(int j=0; j<g->n; j++)
            fscanf(fp, "%d",&(g->adj_mat[i][j]));

    fclose(fp);

}

void write_graph_mat(GraphType *g, char *name){
    FILE *fp = fopen(name, "w");

    if(fp == NULL){
        printf("파일열기 실패\n");
        return;
    } else {
        printf("파일열기 성공\n");
    }

    for(int i=0; i<g->n; i++){
        for(int j=0; j<g->n; j++){
            fprintf(fp, "%d ", g->adj_mat[i][j]);
        }
        fprintf(fp, "\n");
    }

    fclose(fp);

}

void main(){
    GraphType *g;
    g=(GraphType *)malloc(sizeof(GraphType));
    init(g);

    read_graph_mat(g, "C:\\Users\\Yoon\\Study_log\\C\\DS\\chap10\\input.txt");
    write_graph_mat(g, "C:\\Users\\Yoon\\Study_log\\C\\DS\\chap10\\output.txt");

    print_adj_mat(g);

    free(g);
}