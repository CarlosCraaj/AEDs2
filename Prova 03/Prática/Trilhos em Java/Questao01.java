class Questao01{
    public static void main(String[] args) throws Exception
    {
        int vagoes = 0;
        int test = -1;
        String printar = " ";
        String auxiliar = "";
        do
        {
            vagoes = MyIO.readInt();
            if(vagoes != 0 )
            {
                while(printar.charAt(0) != (char)48)
                {
                    printar = MyIO.readLine();
                    int j = printar.length()-1;
                    for(int i = 0; i < printar.length(); i++, j--)
                    {
                        auxiliar += printar.charAt(j);
                    }

                    j = printar.length()-1;

                    for(int i = 0; i < printar.length(); i++, j--)
                    {
                        if(printar.charAt(i) != auxiliar.charAt(j))
                        {
                            MyIO.println("No");
                        }
                    }
                    MyIO.println(auxiliar);
                    auxiliar = "";
                }
                printar = " ";

            }
            
        }while(vagoes != 0);
    
    }
}