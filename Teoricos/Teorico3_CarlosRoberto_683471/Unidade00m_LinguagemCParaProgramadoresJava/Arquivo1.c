/*
* Faça um programa que leia n números inteiros, armazene-os em um
a* rquivo, leia-os do arquivo e mostre-os na tela
*/
#include <stdio.h>
#include <stdlib.h>

void funcao(int* a, int b){
    *a = *a + 1;
    b = b + 1;
    printf("\n(%p) (%i) (%i)", a, *a, b);
}
int main(int argc, char *argv[]) {
    int a = 0, b = 0;
    funcao(&a, b);
    printf("\n(%i) (%i)", a, b);
    return 0;
}