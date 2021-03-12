/*
* Aluno: Carlos Roberto ; Matrícula: 683471
*/

import java.io.*;

class ArquivoBin
{
    public static void main(String[] args) throws Exception
    {
        int n = MyIO.readInt();
        double num = 0;
        int number = 0;

        //Abrir arquivo para gravar os dados
        RandomAccessFile raf = new RandomAccessFile("ArquivoBin.txt", "rw");

        for(int i = 0; i < n; i++)
        {
            num = MyIO.readDouble();
            raf.writeDouble(num);
        }

        raf.close();

        //Abrir arquivo para ler os dados do mesmo começando pela última posição
        raf = new RandomAccessFile("ArquivoBin.txt", "rw");

        for(int i = n-1; i >= 0; i--)
        {
            raf.seek(i*8);
            num = raf.readDouble();
            if(num % 1 == 0)//Testando se o arquivo é um double sem casas decimais, para converter para inteiro
            {
                number = (int)num;
                MyIO.println(number);
            }else
            {
                MyIO.println(num);
            }
        }

        raf.close();
    }
}