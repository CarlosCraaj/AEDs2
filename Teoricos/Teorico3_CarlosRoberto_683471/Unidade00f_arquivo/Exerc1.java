/*
* Leia o nome de um arquivo e uma frase e salve essa frase
* nesse arquivo 
*/

class Exerc1
{
    public static void main(String[] args)
    {
        String nomeArq;
        String frase;

        nomeArq = MyIO.readLine();
        frase = MyIO.readLine();

        Arq.openWrite(nomeArq);
        
        Arq.println(frase);

        Arq.close();
    }
}