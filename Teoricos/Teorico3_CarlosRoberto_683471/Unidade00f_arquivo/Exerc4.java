/*
* Leia o nome de dois arquivos e copie o conteúdo do primeiro para o último
*/
class Exerc4
{
    public static void main(String[] args)
    {
        String nomeArq;
        String nomeArq1;
        String conteudo;

        nomeArq = MyIO.readLine();
        nomeArq1 = MyIO.readLine();

        Arq.openRead(nomeArq);

        conteudo = Arq.readAll();

        Arq.close();

        Arq.openWrite(nomeArq1);

        Arq.print(conteudo);
        
        Arq.close();
    }
}