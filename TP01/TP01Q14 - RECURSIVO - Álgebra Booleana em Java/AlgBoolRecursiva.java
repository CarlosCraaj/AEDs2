/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class AlgBoolRecursiva
{
    //Inicio Métodos auxiliares
    public static boolean isZERO(String word)
    {
        return (word.charAt(0) == '0');
    }

    //Método semelhante ao indexOf da classe String
    public static int bIndexOf(String substr, String str) 
    {
        int lenStr = str.length();
        int lenSubstr = substr.length();
        int count = 0;
        if (lenSubstr > lenStr) 
        {
            return -1;
        }
        for (int i = 0; i < lenStr - lenSubstr + 1; i++) 
        {
            for (int j = 0; j < lenSubstr; j++) 
            {
                if (str.charAt(j+i) == substr.charAt(j)) 
                {
                    count++;
                    if (count == lenSubstr) 
                    {
                        return i;
                    }
                } else 
                {
                    count = 0;
                    j = lenSubstr;
                }
            }
        }
        return -1;
    }

    //Fim Métodos auxiliares


    //Inicio Métodos Principais

    /*
    * Método para semelhante ao replace()/replaceAll() da classe String. Onde substitui uma string
    * por uma outra, até todas serem substituidas.
    */
    public static String auxReduzindo(String substituido, String substituto, String word)
    {
        String resp = "";
        int indexof = bIndexOf(substituido, word);
        if(indexof != -1)
        {
            for(int i = 0; i < indexof; i++)
            {
                resp += word.charAt(i);
            }

            resp += substituto;

            for(int i = indexof + substituido.length(); i < word.length(); i++)
            {
                resp += word.charAt(i);
            }

            if(bIndexOf(substituido, resp) != -1)
            {
                return auxReduzindo(substituido, substituto, resp);
            }
        }else
        {
            return word;
        }

        return resp;
    }

    /*
    * O Método retira o número inteiro n que representa a quantidade de números binários, e 
    * os respectivos números binários. 
    * E também substitui onde na String é a, b ou c, pro seus valores binários.
    */
    public static String preencher(String word, int n, char a, char b, char c)
    {
        String resp = "";

        if(n == 2)
        {
            for(int i = 6; i < word.length(); i++)
            {
                if(word.charAt(i) == 'A')
                {
                    resp += a;
                }else if(word.charAt(i) == 'B')
                {
                    resp += b;
                }else if(word.charAt(i) == 'C')
                {
                    resp += c;
                }else
                {
                    resp += word.charAt(i);
                }
            }
        }else if(n == 3)
        {
            for(int i = 8; i < word.length(); i++)
            {
                if(i == word.length() -1 && word.charAt(i) == ' ')
                {
                    resp += "";
                }else if(word.charAt(i) == 'A')
                {
                    resp += a;
                }else if(word.charAt(i) == 'B')
                {
                    resp += b;
                }else if(word.charAt(i) == 'C')
                {
                    resp += c;
                }else
                {
                    resp += word.charAt(i);
                }
            }
        }

        return resp;
    }



    /*
    * O Método vai substituir as expressões do exercício, por outras string/caracteres, reduzindo assim a expressão.
    */
    public static String reduzindo(String word)
    {
        word = auxReduzindo("not(0)", "1", word);
        word = auxReduzindo("not(1)", "0", word);
        word = auxReduzindo("and(0 , 0", "and(0", word);
        word = auxReduzindo("and(0 , 1", "and(0", word);
        word = auxReduzindo("and(1 , 0", "and(0", word);
        word = auxReduzindo("and(1 , 1", "and(1", word);
        word = auxReduzindo("and(0)", "0", word);
        word = auxReduzindo("and(1)", "1", word);
        word = auxReduzindo("or(0 , 0", "or(0", word);
        word = auxReduzindo("or(0 , 1", "or(1", word);
        word = auxReduzindo("or(1 , 0", "or(1", word);
        word = auxReduzindo("or(1 , 1", "or(1", word);
        word = auxReduzindo("or(1, 1", "or(1", word);
        word = auxReduzindo("or(1, 0", "or(1", word);
        word = auxReduzindo("or(0, 1", "or(1", word);
        word = auxReduzindo("or(0, 0", "or(0", word);
        word = auxReduzindo("or(0)", "0", word);
        word = auxReduzindo("or(1)", "1", word);
        

        return word;
    }


    /*
    * Método recursivo. 
    * O método recursivo chama outro método para reduzir a expressão, e é claro, também chama a si mesmo.
    * Até que a String de resposta, chegue ao tamanho 1(string.length() == 1), com o valor de resposta em (0 ou 1).
    */
    public static String Resultado(String word, int i)
    {
        String resp = "";
        i = word.length();
        if(i == 1)
        {
            return word;
        }else
        {
            word = reduzindo(word);//O Word tem seu tamanho reduzido a cada chamada.
            resp = Resultado(word, word.length()); 
        }

        return resp;
    }

    //Fim Métodos Principais    

    public static void main(String[] args)
    {
        String[] words = new String[1000];
        int nWords = 0; int n = 0;
        char a = 0; char b = 0; char c = 0;
        String aux = new String();

        do
        {
            words[nWords] = MyIO.readLine();
            nWords++;
        }while(isZERO(words[nWords-1]) == false);
        nWords--;

        for(int i = 0; i < nWords; i++)
        {
            if(words[i].charAt(0) == '2')
            {
                a = words[i].charAt(2);
                b = words[i].charAt(4);
                aux = preencher(words[i], 2, a, b, c);
                aux = Resultado(aux, 0);
            }else if(words[i].charAt(0) == '3')
            {
                a = words[i].charAt(2);
                b = words[i].charAt(4);
                c = words[i].charAt(6);
                aux = preencher(words[i], 3, a, b , c);
                aux = Resultado(aux, 0);
            }
            MyIO.println(aux);
        }

    }
}