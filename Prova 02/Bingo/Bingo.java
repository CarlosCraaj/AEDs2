class Bingo
{
    public static void main(String[] args)
    {
        int n = 0, k = 0, u = 0, i = 0;
        n = MyIO.readInt();
        k = MyIO.readInt();
        int[][] cartela = new int[n][k];
        u = MyIO.readInt();
        int[] numerosDeU = new int[u];
        int uteste = 0;
        int[] vencedor = new int[n];

        while(i < n)
        {
            for(int x = 0; x < k; x++)
            {
                uteste = MyIO.readInt();
                if(uteste <= u)
                {
                    cartela[i][x] = uteste;
                    //MyIO.print(cartela[i][x] + " ");
                }
            }
            //MyIO.println(" ");            
            i++;
        }

        for(int x = 0; x < u; x++)
        {
            uteste = MyIO.readInt();
            if(uteste <= u)
            {
                numerosDeU[x] = uteste;
                //MyIO.print(numerosDeU[x] + " ");
            }

        }

        //MyIO.println(" ");

        for(int x = 0; x < n; x++)
        {
            int j = 0;
            while(j < k)
            {
                int perc = 0;
                while(perc < u)
                {
                    //MyIO.print(cartela[x][j] + "/" + numerosDeU[perc] + "  " + perc + "\t");
                    if(cartela[x][j] == numerosDeU[perc])
                    {
                        vencedor[x] += perc;
                        perc = u;
                    }
                    perc++;
                }
                //MyIO.println(" ");
                j++;
            }
            //MyIO.println(vencedor[x]);
        }

        int menor = vencedor[0];
        int[] cartelasWinner = new int[n];
        int win = 0;
        for(int x = 1; x < n; x++)
        {
            if(vencedor[x] < menor)
            {
                menor = vencedor[x];
                
            }
        }

        for(int x = 0; x < n; x++)
        {
            if(vencedor[x] == menor)
            {
                cartelasWinner[win] = x+1;
                win++;
            }
        }
        
        for(int x = 0; x < n; x++)
        {
            if(cartelasWinner[x] != 0)
            {
                MyIO.print(cartelasWinner[x] + " ");
            }
        }
    }
}