/*
* Faça um programa que leia três números reais representando os lados
* de um triângulo e informe se seu triângulo é Equilátero, Isósceles ou Escaleno
*/

class Pag105_LadosTriangulo
{
    public static void main(String[] args)
    {
        int ladoa, ladob, ladoc;

        ladoa = MyIO.readInt();
        ladob = MyIO.readInt();
        ladoc = MyIO.readInt();

        if(ladoa == ladob && ladob == ladoc)
        {
            MyIO.println("O Triângulo é Equilátero.");
        }else if(ladoa == ladob || ladob == ladoc || ladoa == ladoc)
        {
            MyIO.println("O Triângulo é Isósceles");
        }else
        {
            MyIO.println("O Triângulo é Escaleno");
        }
    }
}