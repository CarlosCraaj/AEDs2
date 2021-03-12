/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>


bool isFIM(char words[][1000], int nWords)
{
    return (strlen(words[nWords]) >= 3 && words[nWords][0] == 'F' && words[nWords][1] == 'I' && words[nWords][2] == 'M');
}

/*
* O Método vai fazer (sizeArray / 2) comparações entre elementos do array, caso uma comparação for falsa, a resposta é NAO. 
*/
void isPalindromo(char *word, char *resp)
{
    strcpy(resp, "SIM");
    int sizeArray = strlen(word)-1;

    for (size_t i = 0; i < sizeArray/2; i++)
    {
        if (word[i] != word[sizeArray - 1 - i])
        {
            strcpy(resp, "NAO");
            i = sizeArray;
        }
    }
    
}

int main()
{
    char words[1000][1000];
    char resp[4];
    int nWords = 0;

    do
    {
        fgets(words[nWords], 1000, stdin);
        nWords++;
    } while (isFIM(words, nWords-1) == false);
    nWords--;

    for (size_t i = 0; i < nWords; i++)
    {
        isPalindromo(words[i], resp);
        printf("%s\n", resp);
    }
    
    return 0;
}