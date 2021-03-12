/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class CifraRecursiva
{
    public static boolean Fim(String word)
    {
        return (word.length() >= 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M');
    }


    public static String CiframentoRecursivo(String word, int i)
    {
        String resp = "";

        if(i == (word.length()-1))
        {
            resp += (char)((int)word.charAt(i) + 3);
        }else
        {
            resp = (char)((int)word.charAt(i) + 3) + CiframentoRecursivo(word, i+1);
        }

        return resp;
    }

    public static void main(String[] args)
    {
        String[] words = new String[1000];
        String resp = "";
        int nWords = 0;

        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        }while(Fim(words[nWords-1]) == false);
        nWords--; 

        for(int i = 0; i < nWords; i++)
        {
            resp = CiframentoRecursivo(words[i], 0);
            MyIO.println(resp);
        }
    }
}