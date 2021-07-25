/*
* Aluno: Carlos Roberto Alves de Almeida Júnior
* Matrícula: 683471
*/

/*
* OBSERVACAO: Max interpretei que era para refazer o metodo de construir(),
* mas para desencargo de consciência refiz os outros. Espero que entenda.
* Desde já agradeco.
*/

class Pergunta13
{
    //Metodo que vai construir nosso heap
    public void construir(int k)
    {
        for(int i = k; i > 1 && array[i] < array[i/2]; i /= 2)
        {
            swap(i, i/2);
        }
    }

    //Metodo que vai reconstruir o nosso heap
    public void reconstruir(int k){
        int i = 1;
        while(i <= (k/2)){
            int filho = getMenorFilho(i, k);
            if(array[i] > array[filho]){
                swap(i, filho);
                i = filho;
            }else{
                i = k;
            }
        }
    }

    //Metodo que vai pegar o menor filho
    public int getMenorFilho(int i, int k){
        int filho;
        if (2*i == k || array[2*i] < array[2*i+1]){
            filho = 2*i;
        } else {
            filho = 2*i + 1;
        }
        return filho;
    }
}