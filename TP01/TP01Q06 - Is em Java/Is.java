/*
* Aluno: Carlos Roberto ; Matrícula: 683471 
*/

class Is
{
    //Inicio Métodos auxiliares
    public static boolean isFim(String s)
    {
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isVogal(char c)
    {
        return (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o'|| c == 'U' || c == 'u');
    }

    public static boolean isInteiro (char c)
    {
        return (c >= '0' && c <= '9');
    }

    public static boolean isLetra (char c)
    {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }
    //Fim Métodos auxiliares

    /*
    * Todos os Métodos abaixo(Métodos principais): Vogal, Consoante, NumInteiro, NumReal. Fazem O(n) comparações.
    * E todos procuram a ocorrência de um caractere diferente na String, para interromper o laço e  
    * retornar NAO. Caso chegue ao final da String a resposta é SIM.
    */
    public static String Vogal (String word)
    {
        String resp = "SIM";

        for(int i = 0; i < word.length(); i++)
        {
            if(isVogal(word.charAt(i)) == false)
            {
                resp = "NAO";
                i = word.length();
            }
        }

        return resp;
    }


    public static String Consoante (String word)
    {
        String resp = "SIM";

        for(int i = 0; i < word.length(); i++)
        {
            if(isLetra(word.charAt(i)) == true)
            {
                if(isVogal(word.charAt(i)) == true)
                { 
                    resp = "NAO";
                    i = word.length();
                }
            }else 
            {
                resp = "NAO";
                i = word.length();
            }
        }

        return resp;
    }

    
    public static String NumInteiro (String word)
    {   
        String resp = "SIM";

        for(int i = 0; i < word.length(); i++)
        {
            if(isInteiro(word.charAt(i)) == false)
            {
                resp = "NAO";
                i = word.length();
            }
        }

        return resp;
    }

    public static String NumReal (String word)
    {
        String resp = "SIM";
        int pontuacao = 0;

        for(int i = 0; i < word.length(); i++)
        {
            if(isLetra(word.charAt(i)) == true)
            {
                resp = "NAO";
                i = word.length();
            }else if(word.charAt(i) == ',' || word.charAt(i) == '.')
            {
                if((word.charAt(i) == ',' || word.charAt(i) == '.') && pontuacao < 1)
                {
                    pontuacao++;
                }else
                {
                    resp = "NAO";
                    i = word.length();
                }
            }
        }

        return resp;
    }
    //Fim dos Métodos principais

    public static void main (String[] args)
    {
        String[] words = new String[1000];
        String x1 = "", x2 = "", x3 = "", x4 = "";
        int nWords = 0;

        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        } while(isFim(words[nWords-1]) == false);
        nWords--; 

        for(int i = 0; i < nWords; i++)
        {
            x1 = Vogal(words[i]);
            x2 = Consoante(words[i]);
            x3 = NumInteiro(words[i]);
            x4 = NumReal(words[i]);
            MyIO.println(x1 + " " + x2 + " " + x3 + " " + x4);
        }
    }
}