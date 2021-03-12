/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

#include <stdio.h>

int main()
{
    int n = 0;
    double num = 0;
    int num1 = 0;
    scanf("%d", &n);

    //Abrir arquivo para gravar os dados
    FILE *arq = fopen("ArquivoBin.txt", "wb");

    for(int i = 0; i < n; i++)
    {
        scanf("%lf", &num);
        fwrite(&num, sizeof(double), 1, arq);
    }

    fclose(arq);

    //Abrir arquivo para ler os dados do mesmo começando pela última posição
    arq = fopen("ArquivoBin.txt", "rb");

    for (int i = n-1; i >= 0; i--)
    {
        fseek(arq, i*8, SEEK_SET);
        fread(&num, sizeof(double), 1, arq);

        printf("%g\n", num);
    }
    

    fclose(arq);
    return 0;
}