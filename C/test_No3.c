//
// Created by Yoon on 2020-10-19.
//
#include<stdio.h>
#define MAX(a,b) ((a>b)?a:b)
#define MAX_DEGREE 101

typedef struct{
    int degree;
    float coef[MAX_DEGREE];
}polynomial;

polynomial poly_add1(polynomial A, polynomial B) {
    polynomial C;
    int Apos = 0, Bpos = 0, Cpos = 0;
    int degree_a = A.degree; //4
    int degree_b = B.degree; //4
    C.degree = MAX(A.degree, B.degree); //4
    while (Apos <= A.degree && Bpos <= B.degree) {
        if (degree_a > degree_b) {
            C.coef[Cpos++] = A.coef[Apos++];
            degree_a--;
        } else if (degree_a == degree_b) {
            C.coef[Cpos++] = A.coef[Apos++] + B.coef[Bpos++];
            degree_a--;
            degree_b--;
        } else {
            C.coef[Cpos++] = B.coef[Bpos++];
            degree_b--;
        }
    }
    return C;

}

int main(void){
    polynomial a = {4, {10, 0, 0, (-9), 7}};
    polynomial b = {4, {8, 0, 1, 3, 0}};
    polynomial c;
    c = poly_add1(a,b);

    for(int i=0; i<=c.degree; i++){
        if(i==c.degree){
            printf("%.1f",c.coef[i], c.degree-i);
        }
        else {
            printf("%.1fx^%d + ", c.coef[i], c.degree - i);
        }
    }
}