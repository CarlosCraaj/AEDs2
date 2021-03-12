/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

class AlgebraBool
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

    /*Método para semelhante ao replace()/replaceAll() da classe String. Ou seja, vai trocar um pedaço de string menor, por um valor (0,1)
    * dentro de uma String maior, até que todas as ocorrências da String menor sejam modificadas.
    */
    public static String auxReduzindo(String substituido, String substituto, String word)
    {
        String resp = ""; String resp2 = "";
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

            while(bIndexOf(substituido, resp) != -1)
            {
                indexof = bIndexOf(substituido, resp);
                for(int i = 0; i < indexof; i++)
                {
                    resp2 += resp.charAt(i);
                }

                resp2 += substituto;

                for(int i = indexof + substituido.length(); i < resp.length(); i++)
                {
                    resp2 += resp.charAt(i);
                }

                resp = resp2;
                resp2 = "";
                indexof = bIndexOf(substituido, resp);
            }
        }else
        {
            return word;
        }

        return resp;
    }

    /*
    * Método para retirar os números inicias da String. Ex: 2 0 0 and(A , B), para: and(A , B).
    * Com intuito de facilitar a manipulação do restante dos dados da mesma.
    */
    public static String preencherAux(String word, int n)
    {
        String resp = "";

        if(n == 2)
        {
            for(int i = 6; i < word.length(); i++)
            {
                resp += word.charAt(i);
            }
        }else if(n == 3)
        {
            for(int i = 8; i < word.length(); i++)
            {
                if(i == word.length() -1 && word.charAt(i) == ' ')
                {
                    resp += "";
                }else
                {
                    resp += word.charAt(i);
                }
                
            }
        }


        return resp;
    }

    /*
    * Método para substituir todas os caracteres A, B ou C, pelo seus respectivos números (0 ou 1).
    */
    public static String substituirABC(String word, char a, char b, char c)
    {
        String resp = "";

        for(int i = 0; i < word.length(); i++)
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

        return resp;
    }


    /*
    * O Método vai substituindo as expressões mais complexas em expressões mais simples, 
    * reduzindo a String até ter o tamanho 1, onde na posição [0] da String estará a resposta em 0 ou 1.
    */
    public static String reduzindo(String word)
    {
        while(word.length() > 1)
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
        }

        return word;
    }

    public static String Resultado(String word, int i)
    {
        String resp = "";
        if(i == 1)
        {
            return resp;
        }else
        {
            resp = reduzindo(word) + Resultado(word, i+1);
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
                aux = preencherAux(words[i], 2);
                aux = substituirABC(aux, a, b, c);
                aux = reduzindo(aux);
            }else if(words[i].charAt(0) == '3')
            {
                a = words[i].charAt(2);
                b = words[i].charAt(4);
                c = words[i].charAt(6);
                aux = preencherAux(words[i], 3);
                aux = substituirABC(aux, a, b, c);
                aux = reduzindo(aux);
            }
            MyIO.println(aux);
        }

    }
}