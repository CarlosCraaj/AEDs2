/*
* Leia o nome de um arquivo e mostre seu conteúdo convertido
* para letras maiúsculas
*/
class Exerc3
{
    public static void main(String[] args)
    {
        String nomeArq;
        String conteudo;
        String conteudo1 = "";
        char c;

        nomeArq = MyIO.readLine();
        Arq.openRead(nomeArq);

        conteudo = Arq.readAll();
        //MyIO.println(conteudo.toUpperCase());//Uso de função para converter para Maiúscula

        /*
        * Método próprio, concatenando string. Pegando os dados da String que leu o arquivo, e passando para a String secundária.
        */
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
        MyIO.println(conteudo1);

        Arq.close();
    }
}