//
// Created by Yoon on 2020-12-12.
//

/*
 * 배열을 이용한 이진트리 구현
 * 주로 포화 이진 트리나 완전 이진 트리
 * 트리의 높이가 k면 2^k-1 크기의 배열을 만들어서 순번대로 저장
 */

/*
 * 링크 표현법(포인터를 이용한 구현)
 * 각 노드를 구조체조 표현
 * 왼쪽, 오른쪽 노드 가리키는 포인터를 가진다.
 */

//=== 링크 표현법 ===
#include <stdio.h>
#include <stdlib.h>
#include <minmax.h>

typedef struct TreeNode {
    int data;
    struct TreeNode *left, *right;
}TreeNode;

// 노드의 개수
int get_node_count(TreeNode *node){
    int count=0;

    if(node!=NULL){
        count=1+get_node_count(node->right)+get_node_count(node->left);
    }
    return count;
}

//단말 노드 개수
int get_leaf_count(TreeNode *node){
    int count=0;

    if (node!=NULL){
        if(node->left==NULL&&node->right==NULL)
            return 1;
        else
            count=get_leaf_count(node->left)+get_leaf_count(node->right);
    }
    return count;
}

//높이 구하기
int get_height(TreeNode *node){
    int height=0;

    if(node!=NULL)
        height=1+max(get_height(node->left),get_height(node->right));

    return height;
}

int main(void){
    TreeNode *n1, *n2, *n3;
    n1=(TreeNode *)malloc(sizeof(TreeNode));
    n2=(TreeNode *)malloc(sizeof(TreeNode));
    n3=(TreeNode *)malloc(sizeof(TreeNode));

    n1->data=10;
    n1->left=n2;
    n1->right=n3;

    //   n1
    //  / |
    // n2 n3

    n2->data=20;
    n2->left=NULL;
    n2->right=NULL;

    n3->data=30;
    n3->left=NULL;
    n3->right=NULL;

    //   10
    //  / |
    // 20 30
    printf("%d\n",get_node_count(n1));
    printf("%d\n",get_leaf_count(n1));
    printf("%d\n",get_height(n1));

    free(n1);
    free(n2);
    free(n3);

    return 0;

}