//
// Created by Yoon on 2020-12-13.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode {
    int data;
    struct TreeNode *left, *right;
}TreeNode;

TreeNode n1 = {1, NULL, NULL};
TreeNode n2 = {4, NULL, NULL};
TreeNode n3 = {'*', &n1, &n2};
TreeNode n4 = {16, NULL, NULL};
TreeNode n5 = {25, NULL, NULL};
TreeNode n6 = {'+', &n4, &n5};
TreeNode n7 = {'+', &n3, &n6};
TreeNode *exp1 = &n7;
/*
 *        +
 *       /  \
 *      *    +
 *     / \  / \
 *    1  2 16 25
 */

int evaluate(TreeNode *root){
    if (root==NULL)
        return 0;
    if (root->left==NULL&&root->right==NULL)
        return root->data;
    else{
        int op1=evaluate(root->left);
        int op2=evaluate(root->right);
        printf("%d %c %d�� ����մϴ�.\n", op1, root->data, op2);
        switch (root->data) {
            case '+':
                return op1+op2;
            case '-':
                return op1-op2;
            case '*':
                return op1*op2;
            case '/':
                return op1/op2;
        }
    }
    return 0;
}

int main(void){
    printf("������ ���� %d�Դϴ�. \n", evaluate(exp1));
    return 0;
}