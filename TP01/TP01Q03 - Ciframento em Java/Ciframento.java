/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class Ciframento
{
    public static boolean isFim(String s)
    {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    /*
    * O Método, não faz comparações. O Laço for percorre toda a string, e a cada incremento concatena o caractere + 3
    * posições na tabela ASCII, para a String auxiliar (resp), que será retornada. 
    */
    public static String Ciframento(String cesar)
    {
        String resp = "";

        for(int i = 0; i < cesar.length(); i++)
        {
            resp += (char)((int)cesar.charAt(i) + 3);
        }

        return resp;
    }

    public static void main (String[] args)
    {
        String[] words = new String[1000];
        String resp = "";
        int nWords = 0;

        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        } while(isFim(words[nWords-1]) == false);
        nWords--;

        for(int i = 0; i < nWords; i++)
        {
            resp = Ciframento(words[i]);
            MyIO.println(resp);
        }
    }
}