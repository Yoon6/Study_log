#include <stdio.h>


typedef struct TreeNode{
    int data;
    struct TreeNode *left;
    struct TreeNode *right;
}TreeNode;

int calc_dir_size(TreeNode *root){
    if(root==NULL) return 0;
    return (root->data+calc_dir_size(root->left)+calc_dir_size(root->right));
}

void main(){
    TreeNode n1, n2, n3, n4, n5;
    n5.data=200;
    n5.left=NULL;
    n5.right=NULL;

    n4.data=500;
    n4.left=NULL;
    n4.right=NULL;

    n3.data=100;
    n3.left=&n4;
    n3.right=&n5;

    n2.data=50;
    n2.left=NULL;
    n2.right=NULL;

    n1.data=0;
    n1.left=&n2;
    n1.right=&n3;

    printf("디렉토리 크기=%d\n", calc_dir_size(&n1));
}