#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>


//Inicio Funcoes auxiliares
bool isFIM(char words[][1000], int nWords)
{
    return (strlen(words[nWords]) >= 3 && words[nWords][0] == 'F' && words[nWords][1] == 'I' && words[nWords][2] == 'M');
}

//Metodo semelhante ao indexOf de Java.
static int myOwnIndexOf(char *substr, char* str) 
{
    int lenStr = strlen(str);
    int lenSubstr = strlen(substr);
    int count = 0;
    if (lenSubstr > lenStr) 
    {
        return -1;
    }
    for (int i = 0; i < lenStr - lenSubstr + 1; i++) 
    {
        for (int j = 0; j < lenSubstr; j++) 
        {
            if (str[j+i] == substr[j]) 
            {
                count++;
                if (count == lenSubstr) 
                {
                    return i;
                }
            } else 
            {
                count = 0;
                j = lenSubstr;
            }
        }
    }
    return -1;
}

//Metodo para trocar ',' por ';' dentro do atributo artista.
void replaceCustom(char *aux)
{
    char *tmp = (char*)calloc(sizeof(char), 1000);
    int i = 0;
    int ColcheteAberto = 0;
    while(i < strlen(aux))
    {
        if(aux[i] == '[')
            ColcheteAberto = 1;
        if(aux[i] == ']')
            ColcheteAberto = 0;
        if(ColcheteAberto == 1)
        {
            if(aux[i] == ',')
            {
                strcat(tmp, ";");
            }else
            {
                tmp[i] = aux[i];
            }
        }else
        {
            tmp[i] = aux[i];
        }
        i++;
    }
    strcpy(aux, tmp);
    free(tmp);

}

/*
* Esse metodo faz a leitura do arquivo linha por linha, e testa o ID da linha do arquivo, 
* com todos os IDs do pub.in.
* Usa de 3 variaveis do tipo char*(String), para fazer os testes necessários.
* Uma para receber a linha e substituir em id[] caso a condição for verdadeiro, 
* outra para dividir a linha a cada ',' e ate receber a String do ID da linha do arquivo.
* E uma outra somente receber a linha do fgets e passar a linha para as outras 2 Strings citadas acima.
*/
void pegarArquivo(char id[][1000])
{
    FILE* file = fopen("/tmp/data.csv", "r");
    char Linha[1000];
    char* aux;
    char* auxID; 
    char* toCompare = (char*)calloc(sizeof(char), 1000);
    int n = 0;
    int i = 0; int j = 0; int x = 0;
    while (fgets(Linha, 1000, file) != NULL && j < 170626)
    {
        aux = Linha;
        strcpy(toCompare, Linha);
        replaceCustom(aux);
        auxID = strtok(aux, ",");
        while(n < 8)
        {
            auxID = strtok(NULL, ",");
            n++;
        }
        n = 0;
        while(x < 300)
        {
            if(strcmp(id[i], auxID) == 0)
            {
                strcpy(id[i], toCompare);
                i++;
                x = 300;
            }
            i++;
            x++;
        }
        j++;
        i = 0;
        x = 0;;
    }
    free(toCompare);
    fclose(file);
}

//Metodo que reduz a String do metodo ler(), para fazer as atribuicoes da proxima ocorrencia.
void reduzindoString(int j, char *music)
{
    int len = strlen(music);
    int k = 0;
    int g = j;
    if(music[j] == ',')
    {
        j++;
    }
    while(j < len)
    {
        music[k] = music[j];
        j++;
        k++;
    }
    music[len-g] = '\0';
}

//Metodo semelhante ao lerAteVirgula(), mas trata de um caso especial de Aspas no metodo Nome da Musica. 
void AteVirgulaOrAspas(char *music, char *tmp)
{
    int i = 0;
    int j = 0;
    if(music[j] == '"')
    {
        j++;
        while(music[j] != '"' || music[j+1] != ',')
        {
            if(music[j] == '"')
            {
                if(music[j] == '"' && music[j+1] == '"')
                {
                    tmp[i] = music[j];
                    i++;
                    j += 2;
                }
            }else
            {
                tmp[i] = music[j];
                i++;
                j++;
            }
        }

        if(music[j] == '"')
        {
            j++;
        }

    }else
    {
        while(music[j] != ',')
        {
            tmp[j] = music[j];
            j++;
        }
    }

    reduzindoString(j+1, music);
}

//Le ate a primeira virgula e armazena o dado na variavel do tipo String, para ser feito a conversao de tipo no metodo ler().
void lerAteVirgula(char *music, char *tmp)
{
    int j = 0;
    while(music[j] != ',')
    {
        tmp[j] = music[j];
        //printf("%s", music);
        j++;
    }
}


//Fim Funcoes auxiliares


//Inicio "Classe" Musica
typedef struct {
    //Declaracao de variaveis
    char *id; char *nome; char *key;
    char **list; int k;
    char *data; 
    double acousticness; double danceability;
    double energy; int duration_ms;
    double instrumentalness; double valence;
    int popularity; float tempo;
    double liveness; double loudness;
    double speechiness; int year;
} Musica;

Musica **musics;

//Construtor Vazio
Musica *Construtor()
{
    Musica *M = (Musica *) calloc(1, sizeof(Musica));
    if(M == NULL) {
        printf("Memoria insuficiente!");
        exit(1);
    }

    M->id = (char *) calloc(sizeof(char), 100);
    M->nome = (char *) calloc(sizeof(char), 100);
    M->key = (char *) calloc(sizeof(char), 100);
    M->list = (char **) calloc(sizeof(char*), 40);
    for(int i = 0; i < 20; i++)
        M->list[i] = (char*)calloc(sizeof(char), 50);
    M->data = (char *) calloc(sizeof(char), 10);
    M->k = 0;
    M->acousticness = 0.0; M->danceability = 0.0;
    M->energy = 0.0; M->duration_ms = 0;
    M->instrumentalness = 0.0; M->valence = 0.0;
    M->popularity = 0; M->tempo = 0.0;
    M->liveness = 0.0; M->loudness = 0.0;
    M->speechiness = 0.0; M->year = 0;

    return M;
}

//Prototipo do Metodo
void pegarArtists(char *music, int i);

//Inicio metodos get's
char *getId(int i)
{
    return musics[i]->id;
}

char *getNome(int i)
{
    return musics[i]->nome;
}

char *getKey(int i) {
    return musics[i]->key;
}

double getAcousticness(int i)
{
    return musics[i]->acousticness;
}

double getDanceability(int i)
{
    return musics[i]->danceability;
}

double getEnergy(int i)
{
    return musics[i]->energy;
}

int getDuration(int i)
{
    return musics[i]->duration_ms;  
}

double getInstrumentalness(int i)
{
    return musics[i]->instrumentalness;
}

double getValence(int i)
{
    return musics[i]->valence;
}

int getPopularity(int i)
{
    return musics[i]->popularity;
}

float getTempo(int i)
{
    return musics[i]->tempo;
}

double getLiveness(int i)
{
    return musics[i]->liveness;
}

double getLoudness(int i)
{
    return musics[i]->loudness;
}

double getSpeechiness(int i)
{
    return musics[i]->speechiness;
}

int getYear(int i)
{
    return musics[i]->year;
}
//fim metodos get's

//Inicio metodos set's
void setID(int i, char *id)
{
    strcpy(musics[i]->id, id);
}

void setNome(int i, char *nome)
{
    strcpy(musics[i]->nome, nome);
}

void setKey(int i, char *key) {
    strcpy(musics[i]->key, key);
}

void setList(int i, char **list, int k)
{
    for(int i = 0; i < k; i++)
    {
        for(int j = 0; j < strlen(list[i]); i++)
        {
            musics[i]->list[i][j] = list[i][j];
        }
    }
}

void setData(int i, char* aux)
{
    int len = strlen(aux);
    int x = 0;
    if(len <= 4)
    {
        for(int j = 0; j < 10; j++)
        {
            if(j == 2)
            {
                musics[i]->data[0] = '0';
                musics[i]->data[1] = '1';
                musics[i]->data[2] = '/';
            }else if(j > 2 && j == 5)
            {
                musics[i]->data[3] = '0';
                musics[i]->data[4] = '1';
                musics[i]->data[5] = '/';
            }else if(j > 5)
            {
                musics[i]->data[j] = aux[i];
                x++;
            }
        }
    }else
    {
        for (int j = 0; j < len; j++)
        {
            if(j == 0)
                musics[i]->data[j] = aux[8];
            if(j == 1)
                musics[i]->data[j] = aux[9];
            if(j == 2)
                musics[i]->data[j] = '/';
            if(j == 3)
                musics[i]->data[j] = aux[5];
            if(j == 4)
                musics[i]->data[j] = aux[6];
            if(j == 5)
                musics[i]->data[j] = '/';
            if(j == 6)
                musics[i]->data[j] = aux[0];
            if(j == 7)
                musics[i]->data[j] = aux[1];
            if(j == 8)
                musics[i]->data[j] = aux[2];
            if(j == 9)
                musics[i]->data[j] = aux[3];
        }   
    }
}

void setAcousticness(int i, double acousticness)
{
    musics[i]->acousticness = acousticness;
}

void setDanceability(int i, double danceability)
{
    musics[i]->danceability = danceability;
}

void setEnergy(int i, double energy)
{
    musics[i]->energy = energy;
}

void setDuration(int i, int duration)
{
    musics[i]->duration_ms = duration;  
}

void setInstrumentalness(int i, double instrumentalness)
{
    musics[i]->instrumentalness = instrumentalness;
}

void setValence(int i, double valence)
{
    musics[i]->valence = valence;
}

void setPopularity(int i, int popularity)
{
    musics[i]->popularity = popularity;
}

void setTempo(int i, float tempo)
{
    musics[i]->tempo = tempo;
}

void setLiveness(int i, double liveness)
{
    musics[i]->liveness = liveness;
}

void setLoudness(int i, double loudness)
{
    musics[i]->loudness = loudness;
}

void setSpeechiness(int i, double speechiness)
{
    musics[i]->speechiness = speechiness;
}

void setYear(int i, int year)
{
    musics[i]->year = year;
}
//fim set's

//Metodo Ler
void ler(int M, char *music)
{
    int j;
    double toDouble = 0.0;
    int toInt = 0; float toFloat = 0.0;

    for(int i = 0; i < 19; i++)
    {
        char *aux; 
        aux = (char*)calloc(sizeof(char), 200);
        j = 0; toDouble = 0.0; toInt = 0; //resetar variaveis
        if(i == 0)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setValence(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);

        }else if(i == 1)
        {
            lerAteVirgula(music, aux);
            toInt = atoi(aux);
            setYear(M, toInt);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 2)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setAcousticness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 3)
        {
            pegarArtists(music, M);
        }else if(i == 4)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setDanceability(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 5)
        {
            lerAteVirgula(music, aux);
            toInt = atoi(aux);
            setDuration(M, toInt);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 6)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setEnergy(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 7)
        {
            //Aqui seria o atributo Explicity, porem nao foi pedido, mas mesmo assim eh necessario reduzir a String music
            lerAteVirgula(music, aux);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 8)
        {
            lerAteVirgula(music, aux);
            setID(M, aux);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 9)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setInstrumentalness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 10)
        {
            lerAteVirgula(music, aux);
            setKey(M, aux);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 11)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setLiveness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 12)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setLoudness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 13)
        {
            //Mesma coisa do Explicity, aqui seria o mode.
            lerAteVirgula(music, aux);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 14)
        {
            AteVirgulaOrAspas(music, aux);
            setNome(M, aux);
        }else if(i == 15)
        {
            lerAteVirgula(music, aux);
            toInt = atoi(aux);
            setPopularity(M, toInt);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 16)
        {
            lerAteVirgula(music, aux);
            setData(M, aux);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 17)
        {
            lerAteVirgula(music, aux);
            sscanf(aux, "%lg", &toDouble);
            setSpeechiness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 18)
        {
            toFloat = strtof(music, NULL);
            setTempo(M, toFloat);
        }
        free(aux);
    }

}

//Metodo imprimir como pedido no enunciado, mas com tratamento do atributo list Artists.
void imprimir(int i)
{
    char *tmp;
    tmp = (char*)calloc(sizeof(char), 500);
    tmp[0] = '[';
    for(int j = 0; j < musics[i]->k; j++)
    {
        if(j == musics[i]->k-1)
        {
            strcat(tmp, musics[i]->list[j]);
        }else
        {
            strcat(tmp, musics[i]->list[j]);
            strcat(tmp, ",");
        }
    }
    strcat(tmp, "]");

    printf("%s ## %s ## %s ## %s ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %d\n", getId(i), tmp, getNome(i), musics[i]->data, getAcousticness(i), getDanceability(i), getInstrumentalness(i), getLiveness(i), getLoudness(i), getSpeechiness(i), getEnergy(i), getDuration(i));
    free(tmp);
}


void SelecaoRecursiva(int i, int len, int comp[], int mov[])
{
    Musica *tmp;
    int menor = 0;
    if(i < (len - 1))
    {
        menor = i;
        for(int j = (i + 1); j < len; j++)
        {
            comp[0] += 1;
            if(strcmp(musics[menor]->nome, musics[j]->nome) > 0)
            {
                menor = j;
            }
        }
        tmp = musics[menor];
        musics[menor] = musics[i];
        musics[i] = tmp;
        mov[0] += 3;
        SelecaoRecursiva(i+1, len, comp, mov);
    }
    
}

int main()
{
    char entradas[310][1000];
    int len = 0;
    int x = 0;
    //Ler os IDs
    do
    {
        scanf("%s", entradas[len]);
        len++;
    } while (isFIM(entradas, len-1) == false);
    len--;

    pegarArquivo(entradas);
    musics = (Musica**)calloc(sizeof(Musica*), len);
    for(int i = 0; i < len; i++)
        musics[i] = (Musica*)calloc(sizeof(Musica), 1);
    
    for(int i = 0; i < len; i++)
    {
        musics[i] = Construtor();
        x = strlen(entradas[i]);
        entradas[i][x-1] = '0';
        ler(i, entradas[i]);
    }
    
    int comp[1]; int mov[1];
    comp[0] = 0; mov[0] = 0;
    clock_t inicio, fim;
    double total;
    FILE* file = fopen("683471_selecaoRecursiva.txt", "w");
    inicio = clock();
    SelecaoRecursiva(0, len, comp, mov);
    fim = clock();
    total = ((fim - inicio) / (double)CLOCKS_PER_SEC);
    
    fprintf(file, "%s\t%d\t%d\t%lf", "683471", comp[0], mov[0], total);
    
    fclose(file);
    for (int i = 0; i < len; i++)
    {
        imprimir(i);
    }
    

    //Tudo abaixo esta fazendo a limpeza da memoria, dos dados alocados
    for(int i = 0; i < len; i++)
    {
        free(musics[i]);
    }
    free(musics);

    return 0;
}

//Metodo que vai pegar uma lista de artista e mandar para cada posicao no Array de Strings de Artistas
void pegarArtists(char *music, int i)
{
    int j = 0; int k = 0;
    int x = 0;
    
    while(music[j] != ']')
    {
        if(music[j] == ',' || music[j+1] == ']')
        {
            j++;
            k++;
            x = 0;
        }else if(music[j] != (char)39 && music[j] != '"' && music[j] != '[')
        {
            musics[i]->list[k][x] = music[j];
            j++; x++;
        }else
        {
            j++;
        }
    }
    musics[i]->k = k;
    k > 1 ? reduzindoString(j+3, music) : reduzindoString(j+2, music);
}