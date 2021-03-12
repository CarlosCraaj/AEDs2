/*
* Leia dois números. Se um deles for maior que 45, realize a soma dos
* mesmos. Caso contrário, se os dois forem maior que 20, realize a subtração
* do maior pelo menor, senão, se um deles for menor do que 10 e o outro
* diferente de 0 realize a divisão do primeiro pelo segundo. Finalmente, se
* nenhum dos casos solicitados for válido, mostre seu nome na tela.
*/
class Pag106_Exerc2 
{
    public static void main(String[] args) 
    {
        int n1, n2, n3;
        n1 = MyIO.readInt();
        n2 = MyIO.readInt();
        
        if (n1 > 45 || n2 > 45) 
        {
            n3 = n1 + n2;
            MyIO.println("A soma dos 2 numeros: " + n3);
        }else if (n1 > 20 && n2 > 20) 
        {
            if (n1 > n2) 
            {
                n3 = n1 - n2;
                MyIO.println("A subtracao: " + n3);
            }else
            {
                n3 = n2 - n1;
                MyIO.println("A subtracao: " + n3);
            }
        }else if ((n1 < 10 && n2 != 0) || (n2 < 10 && n1 != 0)) 
        {
            n3 = n1/n2;
            MyIO.println("A divisao: " + n3);
        }else
        {
            MyIO.println("Carlos Roberto Alves.");
        }
    }
}
