//
// Created by Yoon on 2020-11-11.
//

#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <stdlib.h>

struct MNT_ELE{
    int MNTC;
    char Name[10];
    int Index;
    struct MNT_ELE *next;
};

struct MDT_ELE{
    int MDTC;
    char Def[50];
    struct MDT_ELE *next;
};

struct ALA_ELE{
    char i[32];
    char Arg[32];
    struct ALA_ELE *next;
};

typedef struct MNT{
    struct MNT_ELE *head, *tail;
}MNT;

typedef struct MDT{
    struct MDT_ELE *head, *tail;
}MDT;

typedef struct ALA{
    struct ALA_ELE *head, *tail;
}ALA;

MNT mnt;
MDT mdt;
ALA mc, md;
FILE *in, *out, *tm;
FILE *fMnt, *fMdt, *fMc, *fMd;

// 패스 1에서 매크로 이름표를 만드는 함수
void Construct_MNT(char *name);

// 패스 1에서 매크로 이름표를 만드는 함수
void Construct_MDT();

// 패스 1과 패스 2에서 인수표를 만드는 함수
void Construct_ALA(ALA *x, char arg[], int i, int flag);

// 패스 1
void PASS1(char buff[]);

// 패스 2
void PASS2(char buff[]);

// 매크로 이름표에서 OP코드를 검색하는 함수
int Search_MNT(char *id);

// 매크로 호출 시, 매크로 정의표의 정의대로 확장하는 함수
void Expand(int i);

// Replace (문자열에 인수표의 Arg와 같은 부분이 있다면 인수표의 i부분과 대치하는 함수)
char *Replace(char buf[], struct ALA_ELE *p);

int main(int argc, char *argv[]){

    return 0;
}

// MNT를 만드는 함수
void Construct_MNT(char *name){
    struct MNT_ELE *ele;
    ele=(struct MNT_ELE*)malloc(sizeof(struct MNT_ELE));
    if(mnt.head==NULL){
        mnt.head=ele;
        mnt.head->MNTC=1;
    }

    if(mnt.tail!=NULL){
        mnt.tail->next=ele;
        ele->MNTC=mnt.tail->MNTC+1;
    }

    mnt.tail=ele;

    strcpy_s(ele->Name, strlen(name)+1, name);

    if(mdt.tail==NULL) ele->Index=1;
    else ele->Index=mdt.tail->MDTC+1;
    ele->next=NULL;
    fprintf(fMnt, "%d   %s   %d\n", ele->Index, ele->Name, ele->MNTC);
}

// MDT 테이블을 만드는 함수
// 링크드 리스트 기법을 사용해 메모리 낭비 최소화
void Construct_MDT(){
    char buf[40];
    struct MDT_ELE *ele;

    do{
        ele=(struct MDT_ELE *)malloc(sizeof(struct MDT_ELE));
        if(mdt.head==NULL){
            mdt.head=ele;
            mdt.head->MDTC=1;
        }
        if(mdt.tail!=NULL){
            mdt.tail->next=ele;
            ele->MDTC=mdt.tail->MDTC+1;
        }
        mdt.tail=ele;
        fgets(buf, 40, in);
        strcpy_s(ele->Def, strlen(Replace(buf, mc.head))+1, Replace(buf, mc.head));
        ele->next=NULL;
    }while (!strstr(buf, "ENDM"));
}

// ALA함수는 형식 인수표와 실 인수표을 동시에 만든다.
// flag값이 0이면 형식 인수표를 만들고, 1이면 실인수표를 만든다.
void Construct_ALA(ALA *x, char arg[], int i, int flag){
    struct ALA_ELE *ele;

    ele=(struct ALA_ELE *)malloc(sizeof(struct ALA_ELE));
    if(x->head==NULL) x->head=ele;
    if(x->tail!=NULL) x->tail->next=ele;
    x->tail=ele;
    if(flag==0){
        sprintf(ele->i, "#%d", i);
        strcpy_s(ele->Arg, strlen(arg)+1, arg);

        fprintf(fMc, "#%d\n%s\n", i, ele->Arg);
    }
    ele->next=NULL;
}

// buf에 들어온 문자열과 인수표의 문자열과 비교해 치환해 주는 함수
// construct_mdt와 expand에서 호출된다.
// construct_mdt에서 호출 될 떄 반환되는 buf의 내용은 변수에 인덱스 값만 치환된 내용이 들어간다.
// expand에선 replace는 인덱스값과 실인수값이 치환된 내용이 들어간다.
char *Replace(char buf[], struct ALA_ELE *p){
    int bp, t_bp;
    char temp[40];
    struct ALA_ELE *t;

    bp=0;
    t=p;
    while(buf[bp]!='\n'){
        while(buf[bp]==' '||buf[bp]==','||buf[bp]=='\t')bp++;
        while(p!=NULL){
            if(!strncmp(buf+bp, p->Arg, strlen(p->Arg))){
                t_bp=bp;
                while(buf[bp]!=' '&&buf[bp]!=','&&buf[bp]!='\t'&&buf[bp]!='\n')bp++;
                strcpy_s(temp, strlen(buf+bp)+1,buf+bp);
                strcpy(buf+t_bp,p->i);
                bp=t_bp+strlen(p->i);
                strcat(buf, temp);
                break;
            }
            p=p->next;
        }
        p=t;
        while(buf[bp]!=' '&&buf[bp]!=','&&buf[bp]!='\t'&&buf[bp]!='\n')bp++;
    }
    return(buf);
}

// 패스 1은 MNT, MDT, 형식 인수표를 만들고 다음 과정인 패스 2를 위해 tm(임시파일)을 만드는 것이 목적
void PASS1(char buff[]){
    int i, j, bp;
    char word[5][10];

    for(i=0; i<5; i++)word[i][0]='\0';
    bp=0;i=0;j=0;

    while(buff[bp]!='\n'){
        while (buff[bp]==' '||buff[bp]==','||buff[bp]=='\t') bp++;
        while(buff[bp+i]!=' '&&buff[bp+i]!=','&&buff[bp+i]!='\t'&&buff[bp+i]!='\n') {
            *(word[j]+i)=buff[bp+i];
            i++;
        }
        bp+=i;
        *(word[j]+i)='\0';
        i=0;
        j++;
    }
    if(!strcmp(word[1],"MACRO")){
        Construct_MNT(word[0]);
        for(i=2; i<j; i++)Construct_ALA(&mc, word[i], i-1, 0);
        Construct_MDT();
    }
    else
        fprintf(tm, "%s", buff);
}

void PASS2(char buff[]){
    int jp, i, j, k, bp;
    char word[5][10];

    for(i=0; i<5; i++) word[i][0]='\0';
    bp=0; i=0; j=0;

    while(buff[bp]!='\n'){
        while (buff[bp]==' '||buff[bp]==','||buff[bp]=='\t') bp++;
        while(buff[bp+i]!=' '&&buff[bp+i]!=','&&buff[bp+i]!='\t'&&buff[bp+i]!='\n') {
            *(word[j]+i)=buff[bp+i];
            i++;
        }
        bp=bp+i;
        *(word[j]+i)='\0';
        i=0;
        j++;
    }
    jp=Search_MNT(word[0]);
    if(jp){
        for(k=1; k<j; k++) Construct_ALA(&md, word[k], k, 1);
        Expand(jp);
    }
    else{
        fprintf(out, "%s", buff);
    }
}

// 매크로 이름을 받아 매크로 이름표에서 그 id와 같은 이름의 매크로를 찾아 발견되면 그 매크로의 인덱스를 return하고 찾지 못하면 0을 리턴
int Search_MNT(char *id){
    struct MNT_ELE *p=mnt.head;
    while(p!=NULL)
        if(!strcmp(p->Name, id)) return p->Index;
        else p=p->next;
    return 0;
}

// temp변수를 선언한 이유는 mdt의 내용 변화를 막기 위함.
// 매크로를 발견했을 경우 그 매크로에 맞는 인수를 치환하여 temp에 넣고, temp를 out.txt에 출력
void Expand(int i){
    struct MDT_ELE *p=mdt.head;

    while(i!=p->MDTC) p=p->next;
    while(!strstr(p->Def, "ENDM")){
        strcpy_s(p->Def, strlen(Replace(p->Def, md.head))+1, Replace(p->Def, md.head));
        fprintf(out, "%s", p->Def);
        p=p->next;
    }
}

