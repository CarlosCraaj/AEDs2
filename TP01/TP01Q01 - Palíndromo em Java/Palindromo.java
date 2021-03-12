/*
* Aluno: Carlos Roberto ; Matrícula: 683471
* Reutilizei o Método "isFim", apresentado no "LAB01Q01Aquecimento.java"
*/

class Palindromo
{
    public static boolean isFim(String s)
    {
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    /*
    * O Método vai fazer (sizeArray / 2) comparações entre elementos do array, caso uma comparação for falsa, a resposta é NAO. 
    */
    public static String isPalindromo(String palin)
    {
        String resp = "SIM";
        int aux = 0;
        int sizeArray = palin.length();

        for(int i = 0; i < sizeArray/2; i++)
        {
            if(palin.charAt(i) != palin.charAt(sizeArray - 1 - i))
            {
                resp = "NAO";
                i = sizeArray;
                aux += 1;
            }
        }

        return resp;
    }

    public static void main(String[] args)
    {
        String[] words = new String[1000];
        String resp = "";
        int nWords = 0;

        //Leitura das Strings, até a palavra FIM ser encontrada.
        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        } while(isFim(words[nWords-1]) == false);
        nWords--; //Desconsiderar a última String (FIM).

        for(int i = 0; i < nWords; i++)
        {
            resp = isPalindromo(words[i]);
            MyIO.println(resp);
        }
    }
}