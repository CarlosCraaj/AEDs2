/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/
import java.util.Random;

class AlteracaoAleatoria
{
    public static boolean isFim(String s)
    {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String Alteracao(String word, char c1, char c2)
    {
        String resp = "";
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == c1)
            {
                resp += c2;
            }else
            {
                resp += word.charAt(i);
            }
        }    

        return resp;
    }

    public static void main (String[] args)
    {
        Random gen = new Random();
        String[] words = new String[1000];
        String resp = "";
        char c1, c2;
        int nWords = 0;

        gen.setSeed(4);
        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        } while(isFim(words[nWords-1]) == false);
        nWords--;

        for(int i = 0; i < nWords; i++)
        {
            c1 = (char)('a' + (Math.abs(gen.nextInt()) % 26));
            c2 = (char)('a' + (Math.abs(gen.nextInt()) % 26));
            resp = Alteracao(words[i], c1, c2);
            MyIO.println(resp);
        }
    }
}