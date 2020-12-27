//
// Created by Yoon on 2020-11-15.
//
#include <stdio.h>

typedef struct TreeNode {
    int data;
    struct TreeNode *left, *right;
} TreeNode;

TreeNode n1 = { 1,NULL,NULL };
TreeNode n2 = { 4,&n1,NULL };
TreeNode n3 = { 16,NULL,NULL };
TreeNode n4 = { 25,NULL,NULL };
TreeNode n5 = { 20,&n3,&n4 };
TreeNode n6 = { 15,&n2,&n5 };
TreeNode* root = &n6;

int max(int a, int b){

    if(a>=b) return a;
    else return b;
}

int get_height(TreeNode* root)
{
    int height = 0;
    if (root != NULL)
        height = 1 + max(get_height(root->left), get_height(root->right));
    return height;
}
int isBalanced(TreeNode *root)
{
    if (root == NULL) return 0;
    int temp = get_height(root->left) - get_height(root->right);
    if (temp <= 1 && temp >= -1)
        return 1;
    else
        return 0;
}
void inorder(TreeNode* root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}
main()
{
    printf("입력된 트리값(중위순회) :");
    inorder(root);
    if (isBalanced(root) == 1)
        printf("\n균형 트리입니다\n");
    else
        printf("\n균형 트리가 아닙니다\n");
}