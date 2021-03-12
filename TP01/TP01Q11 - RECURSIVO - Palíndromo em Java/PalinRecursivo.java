/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class PalinRecursivo
{
    //Método auxiliar
    public static boolean Fim(String word)
    {
        return (word.length() >= 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M');
    }

    //Método principal
    public static String PalindromoRecursivo(String word, int i, int len)
    {
        String resp = "";
        if(i == (len/2))
        {
            resp = "SIM";
        }else if(word.charAt(i) != word.charAt(len - 1 - i))
        {
            resp = "NAO";
        }else
        {
            resp = PalindromoRecursivo(word, i+1, len);
        }

        return resp;
    }

    public static void main(String[] args)
    {
        String[] words = new String[1000];
        String resp = "";
        int nWords = 0;
        int len = 0;

        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        }while(Fim(words[nWords-1]) == false);
        nWords--;//Desconsiderar a String FIM

        for(int i = 0; i < nWords; i++)
        {
            len = words[i].length();
            resp = PalindromoRecursivo(words[i], 0, len);
            MyIO.println(resp);
        }
    }
}