//
// Created by Yoon on 2020-11-15.
//
#include <stdio.h>
typedef struct TreeNode {
    int data;
    struct TreeNode* left, * right;
} TreeNode;

TreeNode n1 = { 1,NULL,NULL };
TreeNode n2 = { 4,&n1,NULL };
TreeNode n3 = { 16,NULL,NULL };
TreeNode n4 = { 25,NULL,NULL };
TreeNode n5 = { 20,&n3,&n4 };
TreeNode n6 = { 15,&n2,&n5 };
TreeNode* root = &n6;

void search(TreeNode* root, int scan){
    if (root != NULL) {
        if (root->data < scan)
            printf("%d보다 작은 노드 : %d\n", scan, root->data);
        search(root->left, scan);
        search(root->right, scan);
    }
}

main(){
    printf("\n값을 입력하시오 :");
    int scan;
    scanf("%d", &scan);
    search(root, scan);
}
