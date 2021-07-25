/*
* Aluno: Carlos Roberto Alves, Matrícula: 683471
*/

class Medalhas
{
    public static int comparison(String p1, String p2)
    {
        String[] split1 = new String[4];
        split1 = p1.split(" ");
        String[] split2 = new String[4];
        split2 = p2.split(" ");

        int medgold1 = Integer.parseInt(split1[1]);
        int medgold2 = Integer.parseInt(split2[1]);
        int medsilver1 = Integer.parseInt(split1[2]);
        int medsilver2 = Integer.parseInt(split2[2]);
        int medbronze1 = Integer.parseInt(split1[3]);
        int medbronze2 = Integer.parseInt(split2[3]);

        int resp = 0;

        if((int)medgold1 > (int)medgold2)
        {
            resp = 1;
        }else if((int)medgold1 == (int)medgold2)
        {
            if((int)medsilver1 > (int)medsilver2)
            {
                resp = 1;
            }else if((int)medsilver1 == (int)medsilver2)
            {
                if((int)medbronze1 > (int)medbronze2)
                {
                    resp = 1;
                }else if((int)medbronze1 == (int)medbronze2)
                {
                    if(split1[0].compareTo(split2[0]) > 0)
                    {
                        resp = -1;
                    }else if(split1[0].compareTo(split2[0]) < 0)
                    {
                        resp = 1;
                    }
                }else if((int)medbronze1 < (int)medbronze2)
                {
                    resp = -1;
                }
            }else if((int)medsilver1 < (int)medsilver2)
            {
                resp = -1;
            }
        }else if((int)medgold1 < (int)medgold2)
        {
            resp = -1;
        }

        return resp;
    }

    public static void OrdenarPaises(String[] entradas, int n)
    {
        String tmp = "";
        for(int i = 0; i < (n-1); i++)
        {
            int maior = i;
            for(int j = (i+1); j < n; j++)
            {
                if(comparison(entradas[maior], entradas[j]) == -1)
                {
                    maior = j;
                }
            }
            tmp = entradas[maior];
            entradas[maior] = entradas[i];
            entradas[i] = tmp;
        }
    }
    public static void main(String[] args)
    {
        String[] entradas = new String[500];
        int nEntradas = MyIO.readInt();
        int n = 0;
        //MyIO.print
        while(n < nEntradas)
        {
            entradas[n] = MyIO.readLine();
            n++;
        }

        OrdenarPaises(entradas, nEntradas);

        for(int i = 0; i < nEntradas; i++)
        {
            MyIO.println(entradas[i]);
        }
    }
}