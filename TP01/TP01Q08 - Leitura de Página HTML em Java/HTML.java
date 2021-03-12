/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

import java.io.*;
import java.net.*;

class HTML
{
    //Inicio M�todos auxiliares
    public static boolean isFim(String s)
    {
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //M�todo para contar quantidade de substrings (nesse exerc�cio, <br> e <table>)
    public static int brORtable(String substr, String str) 
    {
        int lenStr = str.length();
        int lenSubstr = substr.length();
        int count = 0;
        int brTable = 0;
        if (lenSubstr > lenStr) 
        {
            return brTable;
        }
        for (int i = 0; i < lenStr - lenSubstr + 1; i++) 
        {
            for (int j = 0; j < lenSubstr; j++) {
                if (str.charAt(j+i) == substr.charAt(j)) 
                {
                    count++;
                    if (count == lenSubstr) 
                    {
                        brTable++;
                        j = lenSubstr;
                    }
                } else 
                {
                    count = 0;
                    j = lenSubstr;
                }
            }
        }
        return brTable;
    }

    public static boolean isLetra (char c)
    {
        return (c >= 'a' && c <= 'z');
    }

    //Fim M�todos auxiliares

    //Inicio M�todos principais

    //M�todo que vai contar vogais, consoantes, <br>, <table>, e printar as quantidades.
    public static void contX(String word, String nomePage)
    {
        int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;
        int x6 = 0, x7 = 0, x8 = 0, x9 = 0, x10 = 0;
        int x11 = 0, x12 = 0, x13 = 0, x14 = 0, x15 = 0;
        int x16 = 0, x17 = 0, x18 = 0, x19 = 0, x20 = 0;
        int x21 = 0, x22 = 0, consoante = 0, br = 0, table = 0;

        int len = word.length();
        for(int i = 0; i < len; i++)
        {
            if(word.charAt(i) == 'a')
                x1++;
            else if(word.charAt(i) == 'e')
                x2++;
            else if(word.charAt(i) == 'i')
                x3++;
            else if(word.charAt(i) == 'o')
                x4++;
            else if(word.charAt(i) == 'u')
                x5++;
            else if(word.charAt(i) == '�')
                x6++;
            else if(word.charAt(i) == '�')
                x7++;
            else if(word.charAt(i) == '�')
                x8++;
            else if(word.charAt(i) == '�')
                x9++;
            else if(word.charAt(i) == '�')
                x10++;
            else if(word.charAt(i) == '�')
                x11++;
            else if(word.charAt(i) == '�')
                x12++;
            else if(word.charAt(i) == '�')
                x13++;
            else if(word.charAt(i) == '�')
                x14++;
            else if(word.charAt(i) == '�')
                x15++;
            else if(word.charAt(i) == '�')
                x16++;
            else if(word.charAt(i) == '�')
                x17++;
            else if(word.charAt(i) == '�')
                x18++;
            else if(word.charAt(i) == '�')
                x19++;
            else if(word.charAt(i) == '�')
                x20++;
            else if(word.charAt(i) == '�')
                x21++;
            else if(word.charAt(i) == '�')
                x22++;
            else if(isLetra(word.charAt(i)) == true)
            {
                consoante++;
            }
        } 
        
        br = brORtable("<br>", word);
        table = brORtable("<table>", word);

        /*
        * As 3 opera��es de subtra��o abaixo, s�o necess�rias para retirar as vogais/consoantes, que est�o em <br> e <table>.
        * Poderia tamb�m ser feito um m�todo para substituir as ocorr�ncias de <br> e <table> por um espa�o vazio.
        */
        x1 = x1 - table;
        x2 = x2 - table;
        consoante = consoante - (table*3) - (br*2);

        MyIO.println("a"+"("+x1+") "+"e"+"("+x2+") "+"i"+"("+x3+") "+"o"+"("+x4+") "+"u"+"("+x5+") "+"�"+"("+x6+") "+"�"+"("+x7+") "+"�"+"("+x8+") "+"�"+"("+x9+") "+"�"+"("+x10+") "+"�"+"("+x11+") "+"�"+"("+x12+") "+"�"+"("+x13+") "+"�"+"("+x14+") "+"�"+"("+x15+") "+"�"+"("+x16+") "+"�"+"("+x17+") "+"�"+"("+x18+") "+"�"+"("+x19+") "+"�"+"("+x20+") "+"�"+"("+x21+") "+"�"+"("+x22+") "+"consoante"+"("+consoante+") "+"<br>"+"("+br+") "+"<table>"+"("+table+") "+nomePage);
    }

    //Fim M�todos principais

    public static void main(String[] args)
    {
        String[] namePage = new String[100];
        String[] words = new String[100];
        int nWords = 0, nPage = 0;
        String html = new String();
        MyIO.setCharset("UTF-8");

        do
        {
            namePage[nPage] = MyIO.readLine();
            if(isFim(namePage[nPage]) == false)
            {
                words[nWords] = MyIO.readLine();
                nWords++;
            }
            nPage++; 
        }while(isFim(namePage[nPage-1]) == false);
        nPage--; //Desconsiderar palavra FIM

        for(int i = 0; i < nWords; i++)
        {
            html = GetHTML.gethtml(words[i]);
            contX(html, namePage[i]);
        }

    }
}

class GetHTML 
{
    //M�todo reutilizado do ExemploURL.java.
    public static String gethtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 

        try {
            is.close();
        } catch (IOException ioe) {
        // nothing to see here
        }

        return resp;
    }
}