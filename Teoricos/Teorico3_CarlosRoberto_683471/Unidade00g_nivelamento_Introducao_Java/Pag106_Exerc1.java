/*
* Leia 3 números inteiros, selecione o menor e o maior e imprima os seus
* respectivos valores na tela.
*/
class Pag106_Exerc1 
{
    public static void main(String[] args) 
    {
        int n1, n2, n3;
        
        n1 = MyIO.readInt();
        n2 = MyIO.readInt();
        n3 = MyIO.readInt();

        if (n1 > n2 && n2 > n3) 
        {
            MyIO.println("O maior numero " + n1 + " e o menor " + n3);
        }else if (n1 > n3 && n3 > n2) 
        {
            MyIO.println("O maior numero " + n1 + " e o menor " + n2);
        }else if (n2 > n1 && n1 > n3) 
        {
            MyIO.println("O maior numero " + n2 + " e o menor " + n3);
        }else if (n2 > n3 && n3 > n1) 
        {
            MyIO.println("O maior numero " + n2 + " e o menor " + n1);    
        }else if (n3 > n1 && n1 > n2) 
        {
            MyIO.println("O maior numero " + n3 + " e o menor " + n2);
        }else if (n3 > n2 && n2 > n1) 
        {
            MyIO.println("O maior numero " + n3 + " e o menor " + n1);
        }
    }
}
