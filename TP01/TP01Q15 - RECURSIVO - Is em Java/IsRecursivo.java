/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class IsRecursivo
{
    //Inicio Métodos Auxiliares
    public static boolean Fim(String word)
    {
        return (word.length() >= 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M');
    }

    //Testa se o caractere é uma vogal
    public static boolean isVogal(char c)
    {
        return (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o'|| c == 'U' || c == 'u');
    }

    //Testa se o caracetere é uma letra (Maiuscula ou minuscula)
    public static boolean isLetra (char c)
    {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }

    //Testa de o caractere é um número inteiro
    public static boolean isInteiro (char c)
    {
        return (c >= '0' && c <= '9');
    }

    //Fim Métodos auxiliares

    //Inicio Métodos Recursivos
    //Os métodos abaixos, vão testar se uma determinada String é Vogal, Consoante, Inteiro, ou Real.
    public static String VogalRecursivo(String word, int i)
    {
        String resp = "";
        if(i  == word.length())
        {
            resp = "SIM";
        }else if(isVogal(word.charAt(i)) == false)
        {
            resp = "NAO";
        }else
        {
            resp = VogalRecursivo(word, i+1);
        }

        return resp;
    }

    public static String ConsoanteRecursivo(String word, int i)
    {
        String resp = "";
        if(i == word.length())
        {
            resp = "SIM";
        }else if(isLetra(word.charAt(i)) == false || isVogal(word.charAt(i)) == true)
        {
            resp = "NAO";
        }else if(isLetra(word.charAt(i)) == true)
        {
            resp = ConsoanteRecursivo(word, i+1);
        }
        return resp;
    }

    public static String InteiroRecursivo(String word, int i)
    {
        String resp = "";
        if(i == word.length())
        {
            resp = "SIM";
        }else if(isInteiro(word.charAt(i)) == true)
        {
            resp = InteiroRecursivo(word, i+1);
        }else
        {
            resp = "NAO";
        }

        return resp;
    }


    public static String RealRecursivo(String word, int i, int pontuacao)
    {
        String resp = "";
        /int pontuacao = 0;
        if(i == word.length())
        {
            resp = "SIM";
        }else if(pontuacao > 1)
        {
            resp = "NAO";
        }else if(isInteiro(word.charAt(i)) == true)
        {
            resp = RealRecursivo(word, i+1, pontuacao);
        }else if(word.charAt(i) == ',' || word.charAt(i) == '.')
        {
            resp = RealRecursivo(word, i+1, pontuacao+1);
        }else
        {
            resp = "NAO";
        }

        return resp;
    }

    //Fim Métodos Recursivos

    public static void main(String[] args)
    {
        //Declaração de variaveis.
        String[] words = new String[1000];
        int nWords = 0;

        //Leitura dos dados
        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        }while(Fim(words[nWords-1]) == false);
        nWords--;

        //Escrever as saidas a cada String.
        for(int i = 0; i < nWords; i++)
        {
            MyIO.println(VogalRecursivo(words[i], 0) + " " + ConsoanteRecursivo(words[i], 0) + " " + InteiroRecursivo(words[i], 0) + " " + RealRecursivo(words[i], 0, 0));
        }
    }
}