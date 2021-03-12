/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//Método auxiliar
bool isFIM(char words[][1000], int nWords)
{
    return (strlen(words[nWords]) >= 3 && words[nWords][0] == 'F' && words[nWords][1] == 'I' && words[nWords][2] == 'M');
}

//Método Principal
int PalindromoRecursivo(char *word, int i, int len)
{
    int resp;
    if(i == (len/2))
    {
        resp = 1;
    }else if(word[i] != word[len - 1 - i])
    {
        resp = 0;
    }else
    {
        resp = PalindromoRecursivo(word, i+1, len);
    }

    return resp;
}

int main()
{
    char words[1000][1000];
    int nWords = 0;
    int len = 0; int resp = 0;

    do
    {
        fgets(words[nWords], 1000, stdin);
        nWords++;
    } while (isFIM(words, nWords-1) == false);
    nWords--;

    for (int i = 0; i < nWords; i++)
    {
        len = strlen(words[i])-1;
        resp = PalindromoRecursivo(words[i], 0, len);
        resp == 1 ? printf("SIM\n") : printf("NAO\n");
    }
    
    return 0;
}