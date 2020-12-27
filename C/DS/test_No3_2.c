//
// Created by Yoon on 2020-10-19.
//
#include<stdio.h>
#include <stdlib.h>
#define MAX_TERMS 101

struct{
    float coef;
    int expon;
}terms[MAX_TERMS] = {{8, 4},{1, 2},{3, 1}, {10, 4},{-9, 1},{7, 0}};
int avail = 6;

// 두개의 정수를 비교
char compare(int a, int b){
    if(a>b) return '>';
    else if(a==b) return '=';
    else return '<';
}

void attach(float coef, int expon){
    if(avail>MAX_TERMS){
        fprintf(stderr, "항의 개수가 너무 많음\n");
        exit(1);
    }
    terms[avail].coef=coef;
    terms[avail++].expon=expon;
}

poly_add(int As, int Ae, int Bs, int Be, int *Cs, int *Ce) {
    float tempcoef;
    *Cs = avail;
    while (As <= Ae && Bs <= Be) {
        switch (compare(terms[As].expon, terms[Bs].expon)) {
            case '>':
                attach(terms[As].coef, terms[As].expon);
                As++;
                break;
            case '=':
                tempcoef = terms[As].coef + terms[Bs].coef;
                if (tempcoef) // 계수가 0이 아니라면
                    attach(tempcoef, terms[As].expon);
                As++;
                Bs++;
                break;
            case '<':
                attach(terms[Bs].coef, terms[Bs].expon);
                Bs++;
                break;
        }
        for (; As <= Ae; As++)
            attach(terms[As].coef, terms[As].expon);
        for (; Bs <= Be; Bs++)
            attach(terms[Bs].coef, terms[Bs].expon);
        *Ce = avail - 1;
    }
}

void main(){
    int Cs, Ce;
    poly_add(0,2,3,5,&Cs,&Ce);

    for(int i=Cs; i<Ce; i++) {
        printf("%.1f x^%d +", terms[i].coef,terms[i].expon );
    }
}