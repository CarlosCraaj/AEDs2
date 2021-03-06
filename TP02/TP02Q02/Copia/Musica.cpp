#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>

//Inicio Funcoes auxiliares
bool isFIM(char words[][1000], int nWords)
{
    return (strlen(words[nWords]) >= 3 && words[nWords][0] == 'F' && words[nWords][1] == 'I' && words[nWords][2] == 'M');
}

static int myOwnIndexOf(char *substr, char* str) 
{
    int lenStr = strlen(str);
    int lenSubstr = strlen(substr)-1;
    int count = 0;
    if (lenSubstr > lenStr) 
    {
        return -1;
    }
    for (int i = 0; i < lenStr - lenSubstr + 1; i++) 
    {
        for (int j = 0; j < lenSubstr; j++) 
        {
            if (str[j+i] == substr[j] && substr[j] != '\n') 
            {
                count++;
                if (count == lenSubstr-1) 
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


void pegarArquivo(char id[][1000])
{
    FILE* file = fopen("data.csv", "r");
    char Linha[1000];
    char* aux;
    int i = 0; int j = 0; int x = 0;
    while (fgets(Linha, 1000, file) != NULL && j < 170626)
    {
        aux = Linha;
        if(j > 160000)
        {
            while(x < 300)
            {
                if(myOwnIndexOf(id[i], aux) > 0)
                {
                    strcpy(id[i], aux);
                    //id[i] = line;
                    i++;
                    x = 300;
                }
                i++;
                x++;
            }
        }
        j++;
        i = 0;
        x = 0;;
    }

    fclose(file);
}

/*void pegarDadosComID(char **arquivo, char id[][1000], int i)
{
    int j = 170625;
    while(myOwnIndexOf(id[i], arquivo[j]) == -1 && j >= 0)
    {
        j--;
        if(myOwnIndexOf(id[i], arquivo[j]) > 0)
        {
            //id[i] = arquivo[j];
            strcpy(id[i], arquivo[j]);
        }
    }

}*/

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
            //printf("%s", music);
            j++;
        }
    }

    reduzindoString(j+1, music);
}

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

void pegarArtists(char *music, Musica *M);

//Inicio metodos get's
char *getId(Musica *M)
{
    return M->id;
}

char *getNome(Musica *M)
{
    return M->nome;
}

char *getKey(Musica *M) {
    return M->key;
}
//get list
//get data

double getAcousticness(Musica *M)
{
    return M->acousticness;
}

double getDanceability(Musica *M)
{
    return M->danceability;
}

double getEnergy(Musica *M)
{
    return M->energy;
}

int getDuration(Musica *M)
{
    return M->duration_ms;  
}

double getInstrumentalness(Musica *M)
{
    return M->instrumentalness;
}

double getValence(Musica *M)
{
    return M->valence;
}

int getPopularity(Musica *M)
{
    return M->popularity;
}

float getTempo(Musica *M)
{
    return M->tempo;
}

double getLiveness(Musica *M)
{
    return M->liveness;
}

double getLoudness(Musica *M)
{
    return M->loudness;
}

double getSpeechiness(Musica *M)
{
    return M->speechiness;
}

int getYear(Musica *M)
{
    return M->year;
}
//fim metodos get's

//Inicio metodos set's
void setID(Musica *M, char *id)
{
    strcpy(M->id, id);
}

void setNome(Musica *M, char *nome)
{
    strcpy(M->nome, nome);
}

void setKey(Musica *M, char *key) {
    strcpy(M->key, key);
}

void setList(Musica *M, char **list, int k)
{
    for(int i = 0; i < k; i++)
    {
        //M->list[i] = list[i];
        for(int j = 0; j < strlen(list[i]); i++)
        {
            M->list[i][j] = list[i][j];
        }
    }
}

//set data
void setData(Musica *M, char* aux)
{
    int len = strlen(aux);
    int i = 0;
    if(len <= 4)
    {
        for(int j = 0; j < 10; j++)
        {
            if(j == 2)
            {
                M->data[0] = '0';
                M->data[1] = '1';
                M->data[2] = '/';
            }else if(j > 2 && j == 5)
            {
                M->data[3] = '0';
                M->data[4] = '1';
                M->data[5] = '/';
            }else if(j > 5)
            {
                M->data[j] = aux[i];
                i++;
            }
        }
    }else
    {
        for (int j = 0; j < len; j++)
        {
            if(j == 0)
                M->data[j] = aux[8];
            if(j == 1)
                M->data[j] = aux[9];
            if(j == 2)
                M->data[j] = '/';
            if(j == 3)
                M->data[j] = aux[5];
            if(j == 4)
                M->data[j] = aux[6];
            if(j == 5)
                M->data[j] = '/';
            if(j == 6)
                M->data[j] = aux[0];
            if(j == 7)
                M->data[j] = aux[1];
            if(j == 8)
                M->data[j] = aux[2];
            if(j == 9)
                M->data[j] = aux[3];
        }   
    }
}

void setAcousticness(Musica *M, double acousticness)
{
    M->acousticness = acousticness;
}

void setDanceability(Musica *M, double danceability)
{
    M->danceability = danceability;
}

void setEnergy(Musica *M, double energy)
{
    M->energy = energy;
}

void setDuration(Musica *M, int duration)
{
    M->duration_ms = duration;  
}

void setInstrumentalness(Musica *M, double instrumentalness)
{
    M->instrumentalness = instrumentalness;
}

void setValence(Musica *M, double valence)
{
    M->valence = valence;
}

void setPopularity(Musica *M, int popularity)
{
    M->popularity = popularity;
}

void setTempo(Musica *M, float tempo)
{
    M->tempo = tempo;
}

void setLiveness(Musica *M, double liveness)
{
    M->liveness = liveness;
}

void setLoudness(Musica *M, double loudness)
{
    M->loudness = loudness;
}

void setSpeechiness(Musica *M, double speechiness)
{
    M->speechiness = speechiness;
}

void setYear(Musica *M, int year)
{
    M->year = year;
}
//fim set's

//Metodo Ler
void ler(Musica *M, char *music)
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
            toDouble = atof(aux);
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
            //toDouble = atof(aux);
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
            //toDouble = atof(aux);
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
            //toDouble = atof(aux);
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
            //toDouble = atof(aux);
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
            //toDouble = atof(aux);
            sscanf(aux, "%lg", &toDouble);
            setLiveness(M, toDouble);
            j = strlen(aux)+1;
            reduzindoString(j, music);
        }else if(i == 12)
        {
            lerAteVirgula(music, aux);
            //toDouble = atof(aux);
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
            //toDouble = atof(aux);
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

void imprimir(Musica *M)
{
    char *tmp;
    tmp = (char*)calloc(sizeof(char), 500);
    tmp[0] = '[';
    int j = 0;
    for(int i = 0; i < M->k; i++)
    {
        if(i == M->k-1)
        {
            strcat(tmp, M->list[i]);
        }else
        {
            strcat(tmp, M->list[i]);
            strcat(tmp, ",");
        }
    }
    strcat(tmp, "]");

    printf("%s ## %s ## %s ## %s ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %lg ## %d\n", getId(M), tmp, getNome(M), M->data, getAcousticness(M), getDanceability(M), getInstrumentalness(M), getLiveness(M), getLoudness(M), getSpeechiness(M), getEnergy(M), getDuration(M));
    free(tmp);
}

void freeMusica(Musica *M)
{
    free(M->id); free(M->nome); free(M->key);
    for(int i = 0; i < 20; i++)
        free(M->list[i]);
    free(M->list);
    //free(data);
    free(M);
}

int main()
{
    //Inicializar os Arrays que v??o receber ID e os dados do Arquivo
    char entradas[310][1000];
    /*char **entradas;
    entradas = (char**)calloc(sizeof(char*), 310);
    for(int i = 0; i < 310; i++)
        entradas[i] = (char*)calloc(sizeof(char), 25);*/

    /*char **arquivo;
    arquivo = (char**)calloc(sizeof(char*), 170626);
    for(int i = 0; i < 170626; i++)
        arquivo[i] = (char*)calloc(sizeof(char), 1000);*/
    
    int len = 0;
    int x = 0;

    //Ler os IDs
    do
    {
        fgets(entradas[len], 1000, stdin);
        //x = strlen(entradas[len]);
        //entradas[len][x-1] = '\0';
        len++;
    } while (isFIM(entradas, len-1) == false);
    len--;
    

    //Metodo para armazenar o arquivo em um Array de Strings
    //printf("Chegou\n");
    pegarArquivo(entradas);
    //printf("leu\n");
    /*for(int i = 0; i < len; i++)
    {
        pegarDadosComID(arquivo, entradas, i);
    }*/
    //Musica *musics;
    Musica **musics;
    musics = (Musica**)calloc(sizeof(Musica*), len);
    for(int i = 0; i < len; i++)
        musics[i] = (Musica*)calloc(sizeof(Musica), 1);
    
    //printf("\n%s", arquivo[1]);
    for(int i = 0; i < len; i++)
    {
        musics[i] = Construtor();
        x = strlen(entradas[i]);
        entradas[i][x-1] = '0';
        ler(musics[i], entradas[i]);
        imprimir(musics[i]);
    }

    //Tudo abaixo esta fazendo a limpeza da memoria, dos dados alocados
    /*for(int i = 0; i < 310; i++)
        free(entradas[i]);
    free(entradas);*/

    /*for(int i = 0; i < 170626; i++)
        free(arquivo[i]);
    free(arquivo);*/

    for(int i = 0; i < len; i++)
    {
        //freeMusica(musics[i]);
        free(musics[i]);
    }
    free(musics);

    return 0;
}

void pegarArtists(char *music, Musica *M)
{
    int j = 0; int k = 0;
    int x = 0;
    
    /*char **tmp;
    tmp = (char**)calloc(sizeof(char*), 20);
    for(int i = 0; i < 20; i++)
        tmp[i] = (char*)calloc(sizeof(char), 50);*/

    while(music[j] != ']')
    {
        if(music[j] == ',' || music[j+1] == ']')
        {
            //M->list[k] = tmp[k];
            j++;
            k++;
            x = 0;
        }else if(music[j] != (char)39 && music[j] != '"' && music[j] != '[')
        {
            //tmp[k][x] = music[j];
            M->list[k][x] = music[j];
            j++; x++;
        }else
        {
            j++;
        }
    }
    M->k = k;
    //setList(M, tmp, k);

    /*for(int i = 0; i < 20; i++)
        free(tmp[i]);
    free(tmp);*/
    k > 1 ? reduzindoString(j+3, music) : reduzindoString(j+2, music);
}