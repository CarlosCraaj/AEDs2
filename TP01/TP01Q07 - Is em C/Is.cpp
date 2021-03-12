/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

//Inicio Métodos Auxiliares
bool isFIM(char words[][1000], int nWords)
{
    return (strlen(words[nWords]) >= 3 && words[nWords][0] == 'F' && words[nWords][1] == 'I' && words[nWords][2] == 'M');
}

bool isVogal(char c)
{
    return (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o'|| c == 'U' || c == 'u');
}

bool isInteiro(char c)
{
    return (c >= '0' && c <= '9');
}

bool isLetra(char c)
{
    return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
}

//Fim Métodos Auxiliares

//Inicio Métodos Principais
void Vogal(char *word, char *resp)
{
    strcpy(resp, "SIM");
    int sizeWord = strlen(word)-1;

    for (int i = 0; i < sizeWord; i++)
    {
        if(isVogal(word[i]) == false)
        {
            strcpy(resp, "NAO");
            i = sizeWord;
        }
    }
}

void Consoante(char *word, char *resp)
{
    strcpy(resp, "SIM");
    int sizeWord = strlen(word)-1;

    for (int i = 0; i < sizeWord; i++)
    {
        if(isLetra(word[i]) == true)
        {
            if(isVogal(word[i]) == true)
            {
                strcpy(resp, "NAO");
                i = sizeWord;
            }
        }else
        {
            strcpy(resp, "NAO");
            i = sizeWord;
        }
    }
}

void Inteiros(char *word, char *resp)
{
    strcpy(resp, "SIM");
    int sizeWord = strlen(word)-1;

    for (int i = 0; i < sizeWord; i++)
    {
        if(isInteiro(word[i]) == false)
        {
            strcpy(resp, "NAO");
            i = sizeWord;
        }
    }
    
}

void Real(char *word, char *resp)
{
    strcpy(resp, "SIM");
    int sizeWord = strlen(word)-1;
    int acentuacao = 0;

    for (int i = 0; i < sizeWord; i++)
    {
        if(isLetra(word[i]) == true)
        {
            strcpy(resp, "NAO");
            i = sizeWord;
        }else if(word[i] == ',' || word[i] == '.')
        {
            if((word[i] == ',' || word[i] == '.') && acentuacao < 1)
            {
                acentuacao++;
            }else
            {
                strcpy(resp, "NAO");
                i = sizeWord;
            }
        }
    }
    
}

//Fim Métodos Principais

int main()
{
    char words[1000][1000];
    char x1[4], x2[4], x3[4], x4[4];
    int nWords = 0;
    int num = 0;

    do
    {
        fgets(words[nWords], 1000, stdin);
        nWords++;
    } while (isFIM(words, nWords-1) == false);
    nWords--;

    for (size_t i = 0; i < nWords; i++)
    {
        Vogal(words[i], x1);
        Consoante(words[i], x2);
        Inteiros(words[i], x3);
        Real(words[i], x4);
        printf("%s %s %s %s\n", x1, x2, x3, x4);
    }
    
}