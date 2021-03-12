/*
* Leia o nome de um arquivo e mostre seu conteúdo na tela 
*/
class Exerc2 
{
    public static void main(String[] args)
    {
        String nomeArq;
        String conteudo;

        nomeArq = MyIO.readLine();
        Arq.openRead(nomeArq);

        conteudo = Arq.readAll();
        MyIO.println(conteudo);

        Arq.close();
    }
}
