//
// Created by Yoon on 2020-11-15.
//
#include <stdio.h>
#include <stdlib.h>

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

int Min(TreeNode* root)
{
    if (root == NULL)
        return 9999;
    else
    {
        int temp = root->data;
        if (temp > Min(root->left))
            temp = Min(root->left);
        if (temp > Min(root->right))
            temp = Min(root->right);
        return temp;
    }
}

int Max(TreeNode* root)
{
    if (root == NULL)
        return -9999;
    else
    {
        int temp = root->data;
        if (temp < Max(root->left))
            temp = Max(root->left);
        if (temp < Max(root->right))
            temp = Max(root->right);
        return temp;
    }
}

main()
{
    printf("최소값 : %d\n", Min(root));
    printf("최대값 : %d\n", Max(root));
}