//
// Created by Yoon on 2020-11-22.
//

#include <stdio.h>

#define MAX 50
int p_queue[MAX];
int front, rear;

void create()
{
    front = rear = -1;
}
void check(int val)
{
    int x, y;
    for (x = 0; x <= rear; x++)
    {
        if (val >= p_queue[x])
        {
            for (y = rear + 1; y > x; y--)
            {
                p_queue[y] = p_queue[y - 1];
            }
            p_queue[x] = val;
            return;
        }
    }
    p_queue[x] = val;
}


void insert(int val)
{
    if (rear >= MAX - 1)
    {
        printf("ERROR\n");
        return;
    }
    if ((front == -1) && (rear == -1))
    {
        front = front + 1;
        rear = rear + 1;
        p_queue[rear] = val;
        return;
    }
    else
        check(val);
    rear = rear + 1;
}

void show()
{
    if ((rear == -1) && (front == -1))
    {
        printf("큐에 데이터 없음\n");
        return;
    }
    for (; front <= rear; front++)
    {
        printf(" %d ", p_queue[front]);
    }
    printf("\n");
    front = 0;
}


void delete(int val)
{
    if ((front == -1) && (rear == -1))
    {
        printf("ERROR \n");
        return;
    }
    for (int x = 0; x <= rear; x++)
    {
        if (val == p_queue[x])
        {
            for (; x < rear; x++)
            {
                p_queue[x] = p_queue[x + 1];
            }
            p_queue[x] = -49;
            rear = rear - 1;
            if (rear == -1)
                front = -1;
            return;
        }
    }
    printf("값이 존재하지 않음\n");
}
