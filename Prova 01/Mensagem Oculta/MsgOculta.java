/*
* Aluno: Carlos Roberto Alves, Matrícula: 683471
*/

class MsgOculta
{
    public static boolean isChar(char c)
    {
        return (c >= 'a' && c <= 'z');
    }
    public static void tratarLinha(String entrada)
    {
        int n = entrada.length();
        String tmp = "";
        for(int i = 0; i < n; i++)
        {
            if(i == 0 && isChar(entrada.charAt(i)) == true && isChar(entrada.charAt(i+1)) == true)
            {
                tmp += entrada.charAt(i);
            }else if(i == 0 && isChar(entrada.charAt(i)) == true && (entrada.charAt(i+1) == (char)32 || isChar(entrada.charAt(i+1)) == false))
            {
                tmp += entrada.charAt(i);
            }else
            {
                if(isChar(entrada.charAt(i)) == true && (entrada.charAt(i-1) == (char)32 || isChar(entrada.charAt(i-1)) == false))
                {
                    tmp += entrada.charAt(i);
                }
            }
            
        }

        MyIO.println(tmp);
    }

    public static void main(String[] args)
    {
        String[] entradas = new String[1000000];
        int nEntradas = MyIO.readInt();
        int n = 0;
        while(n < nEntradas)
        {
            entradas[n] = MyIO.readLine();
            n++;
            tratarLinha(entradas[n-1]);
        }

    }
}