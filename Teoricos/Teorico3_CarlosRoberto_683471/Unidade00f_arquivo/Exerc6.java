/*
* Leia o nome de dois arquivos e copie o conteúdo do primeiro
* para o segundo invertendo a ordem dos caracteres. O último
* caractere no arquivo de entrada será o primeiro do de saída, o
* penúltimo caractere será o segundo, ...
*/
class Exerc6 
{
    /*
    * O método para inverter a string, começa da posição final da string - 2,
    * devido ao fato de string-1 poder ser \n dentro do arquivo, caso tenha sido
    * gravado com MyIO.println();
    */
    public static String InvertendoString(String conteudo)
    {
        String retorno = "";

        for (int i = conteudo.length()-2; i >= 0 ; i--) 
        {
            retorno += conteudo.charAt(i);
        }

        return retorno;
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

        //Chamando função/Método que vai fazer a inversão da String do arquivo 1 e converter para outra String
        conteudo1 = InvertendoString(conteudo);

        //Abrindo arquivo, para mandar/printar a string invertida para dentro do arquivo.
        Arq.openWrite(nomeArq1);

        Arq.println(conteudo1);

        Arq.close();
    }
}
