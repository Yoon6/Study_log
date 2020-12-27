//
// Created by Yoon on 2020-12-03.
//

#include <stdlib.h>
#include <stdio.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 10
#define INF 1000000

typedef struct GraphNode{
    int vertex;
    struct GraphNode* link;
} GraphNode;

typedef struct GraphType {
    int n;
    int weight[MAX_VERTICES][MAX_VERTICES];
    struct GraphNode* adj_list[MAX_VERTICES];
} GraphType;

void insert_vertex(GraphType* g, int v){
    if (((g->n) + 1) > MAX_VERTICES) {
        fprintf(stderr, "�׷���: ������ ���� �ʰ�");
        return;
    }
    g->n++;
}

void insert_edge(GraphType* g, int u, int v,int weight){
    GraphNode* node;
    if (u >= g->n || v >= g->n)
    {
        fprintf(stderr, "�׷���: ���� ��ȣ ����");
        return;
    }
    g->weight[u][v] = weight;
    node = (GraphNode*)malloc(sizeof(GraphNode));
    node->vertex = v;
    node->link = g->adj_list[u];
    g->adj_list[u] = node;
}

void init(GraphType* g)
{
    int v;
    g->n = 0;
    for (v = 0; v < MAX_VERTICES; v++)
    {
        g->adj_list[v] = NULL;
        for (int a = 0; a < MAX_VERTICES; a++)
            g->weight[v][a] = INF;
    }
}
int choose(int distance[], int n, int found[]){
    int i, min, minpos;

    min = INT_MAX;
    minpos = -1;

    for(i=0; i<n; i++){
        if(distance[i]<min && !found[i]){
            min=distance[i];
            minpos=i;
        }
    }
    return minpos;
}

int distance[MAX_VERTICES]; // �ִ� ��� ǥ��
int found[MAX_VERTICES]; // �湮 ǥ��

void print_status(GraphType *g){
    static int step=1;
    printf("STEP %d: ", step++);

    printf("distance: ");
    for(int i=0; i<g->n; i++){
        if(distance[i]==INF)
            printf(" * ");
        else
            printf("%3d ",distance[i]);
    }
    printf("\n");
    printf(" \tfound: \t   ");
    for(int i=0; i<g->n; i++)
        printf("%2d ", found[i]);
    printf("\n\n");
}

void shortest_path(GraphType *g, int start){
    int i, u, w;
    for(i=0; i<g->n; i++){
        // �ʱ�ȭ
        distance[i] = g->weight[start][i];
        found[i]=FALSE;
    }
    found[start]=TRUE;
    distance[start]=0;

    for(i=0;i<g->n-1; i++){
        print_status(g);

        u=choose(distance, g->n, found);
        found[u]=TRUE;

        for(w=0; w<g->n; w++)
            if(!found[w])
                if(distance[u]+g->weight[u][w] < distance[w])
                    distance[w] = distance[u]+g->weight[u][w];
    }
}

int main(void)
{
    GraphType* g;
    g = (GraphType*)malloc(sizeof(GraphType));
    init(g);
    for (int i = 0; i < 4; i++)
        insert_vertex(g, i);
    insert_edge(g, 0, 1, 3);
    insert_edge(g, 1, 0, 3);
    insert_edge(g, 1, 2, 2);
    insert_edge(g, 2, 1, 2);
    insert_edge(g, 2, 3, 7);
    insert_edge(g, 3, 2, 7);
    insert_edge(g, 1, 3, 4);
    insert_edge(g, 3, 1, 4);
    printf("\n");
    shortest_path(g, 0);
    return(0);
}