/*
* Faça um programa que leia a nota de um aluno e escreva na tela:
* "Parabéns, muito bom" (se a nota >= 80); "Parabéns, aprovado" (se a
* nota >= 70 && nota < 80); e, caso contrário, "Infelizmente, reprovado"
*/
class ExemploIf
{
   public static void main(String[] args)
   {
        int nota = 0;

        nota = MyIO.readInt();

        if(nota >= 80)
        {
            MyIO.println("Parabéns, muito bom.");
        }else if(nota >= 70 && nota <= 80)
        {
            MyIO.println("Parabéns, aprovado.");
        }else
        {
            MyIO.println("Infelizmente, reprovado.");
        }
   }
}