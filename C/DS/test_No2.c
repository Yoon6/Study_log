#include <stdio.h>

double recursive(int n){
    if(n==0)
        return 0;
    if(n==1)
        return 1;

    return recursive(n-1)+(recursive(n-1)-recursive(n-2)+(float) 1/n);
}

int main(void){
    int n=2;
    printf("recursive(%d) = %lf", n, recursive(n));

    return 0;
}