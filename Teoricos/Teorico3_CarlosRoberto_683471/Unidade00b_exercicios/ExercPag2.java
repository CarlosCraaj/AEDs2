/*
* Exercício da Página 2 da unidade00b_exercicios
* Faça um método que receba um array de inteiros e um
* número inteiro x e retorne um valor booleano informando se o
* elemento x está contido no array
*/
class ExercPag2
{
    //Função que procura o elemento x no array
    public static boolean NumInArray(int[] num, int x)
    {
        boolean resp = false;
        int n = num.length;

        for (int i = 0; i < n; i++) 
        {
            if (x == num[i]) 
            {
                resp = true;
                i = n;
            }
        }

        return resp;
    }

    public static void main(String[] args) 
    {
        int[] num = new int[100];//declaração do array com tamanho 100
        int x = 0;
        boolean resp = false;
        //for para preencher o array com numeros pares
        for (int i = 0; i < 100; i++) 
        {
            num[i] = i*2;
        } 

        x = MyIO.readInt(); //recebe um valor x, para saber se ele está contido no array
        resp = NumInArray(num, x);//chamada da função
        if (resp == true) 
        {
            MyIO.println("O número " + x + " está contido no array.");    
        }else
        {
            MyIO.println("O número " + x + " não está contido no array.");
        }
    }
}