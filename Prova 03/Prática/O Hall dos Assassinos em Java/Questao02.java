/*
* Aluno: Carlos Roberto Alves de Almeida Júnior.
* Matrícula: 683471
* Questão: O Hall dos Assassinos
*/
class Questao02{
    public static void main(String[] args) throws Exception
    {
        String[] assassinos = new String[1000000];
        String[] assassinados = new String[1000000];
        String[] resp = new String[1000000];
        int i = 0;
        do
        {
            assassinos[i] = MyIO.readString();
            resp[i] = assassinos[i];
            if(assassinos[i].compareTo("FIM") != 0)
            {
               assassinados[i] = MyIO.readString();
            }
            i++;
        }while(assassinos[i-1].compareTo("FIM") != 0);
        i--;

        
        int[] respN = new int[i];

        for(int x = 0; x < i; x++)
        {
            respN[x] = 1;
            for(int j = x+1; j < i; j++)
            {
                if(resp[x].compareTo(assassinos[j]) == 0)
                {
                    respN[x] += 1;
                    resp[j] = "nada";
                }
            }
            
            //MyIO.println(assassinos[x] + "\t" + assassinados[x]);
        }
    
        for(int x = 0; x < i; x++)
        {
            for(int j = 0; j < i; j++)
            {
                if(resp[x].compareTo(assassinados[j]) == 0)
                {
                    resp[x] = "nada";
                }
            }
        }

        String[] organizado = new String[i];
        int[] orgInt = new int[i];

        int aux = 0;

        MyIO.println("HALL OF MURDERERS");
        for(int x = 0; x < i; x++)
        {
            
            if(resp[x].compareTo("nada") != 0)
            {
                organizado[aux] = resp[x];
                orgInt[aux] = respN[x];
                aux++;
                //MyIO.println(resp[x] + " " + respN[x]);
            }
        }
        

        for(int x = 0; x < aux; x++)
        {
            int menor = x;
            String tmp = "";
            int tmpInt = 0;
            for(int j = x+1; j < aux; j++)
            {
                if(organizado[menor].compareTo(organizado[j]) > 0)
                {
                    menor = j;
                }
            }
            tmp = organizado[menor];
            organizado[menor] = organizado[x];
            organizado[x] = tmp;

            tmpInt = orgInt[menor];
            orgInt[menor] = orgInt[x];
            orgInt[x] = tmpInt;
            MyIO.println(organizado[x] + " " + orgInt[x]);
        }
        
    }
}