/*
* Leia o nome de dois arquivos, abra o primeiro, converta seu
* conteúdo para letra maiúscula e salve o no segundo
*/
class Exerc5
{
    //Método para converter uma string para converter as letras de uma String para Maiúscula (Usado no exercício 3)
    public static String convertToUpper(String conteudo)
    {
        String conteudo1 = "";
        char c;
        for(int i = 0; i < conteudo.length(); i++)
        {
            if(conteudo.charAt(i) >= 'a' && conteudo.charAt(i) <= 'z')
            {
                c = (char)(conteudo.charAt(i)-32);
                conteudo1 += c;
            }else
            {
                conteudo1 += conteudo.charAt(i);
            }
        }

        return conteudo1;
    }

    public static void main(String[] args)
    {
        String nomeArq, nomeArq1;
        String conteudo, conteudo1;

        nomeArq = MyIO.readLine();
        nomeArq1 = MyIO.readLine();

        Arq.openRead(nomeArq);

        conteudo = Arq.readAll();

        Arq.close();

        //Passando o conteudo do arquivo 1 para o arquivo 2, com letras maiúsculas
        conteudo1 = convertToUpper(conteudo);

        //Abrindo arquivo, para escrever o conteudo nele.
        Arq.openWrite(nomeArq1);

        Arq.print(conteudo1);

        Arq.close();
    }
}