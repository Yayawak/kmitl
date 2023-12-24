#ifndef BstH
#define BstH

#include <iostream>
#include <string>
#include <math.h>

typedef struct Node
{
    int val;   
    struct Node* l;
    struct Node* r;
} Node;

typedef struct Tree
{
    Node *root;

} Tree;

Node* newNode(int data)
{
    Node* node = (Node *)malloc(sizeof(Node));
    node->val = data;
    node->l = NULL;
    node->r = NULL;
    return (node);
}

void addDataToSubNode(Node *n, int val)
{
    // add right
    if (val >= n->val)
    {
        if (n->r)
        {
            addDataToSubNode(n->r, val);
        }
        else
        {
            n->r = newNode(val);
        }
    }
    // add left
    else
    {
        if (n->l)
        {
            addDataToSubNode(n->l, val);
        }
        else
        {
            n->l = newNode(val);
        }
    }

    // printf("val = %d\n", val);
}

void addDataToBst(Tree *t, int val)
// void addDataToBst(Node *n, int val)
{
    if (t->root == 0)

    // if (n->l == NULL)
    {
        t->root = newNode(val);
        return;
    }
    addDataToSubNode(t->root, val);

    // if (val )
}

void printT(Node *root)
{
    if (root->l)
        printT(root->l);
    printf("%d\n", root->val);
    if (root->r)
        printT(root->r);
}

#endif