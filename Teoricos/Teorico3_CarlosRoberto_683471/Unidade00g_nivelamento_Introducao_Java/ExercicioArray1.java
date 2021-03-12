/* 
* Faça um programa que leia n números e mostre quais deles são maiores que a média
*/
class ExercicioArray1
{
    public static void main(String[] args) 
    {
        int n = MyIO.readInt();
        int media = 0;

        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) 
        {
            vetor[i] = MyIO.readInt();
            media = media + vetor[i];//soma dos valores para depois dividir por n e encontrar a média
        }

        media = media / n;

        for (int i = 0; i < n; i++) 
        {
            if(vetor[i] > media)
            {
                MyIO.println("O vetor[" + i + "]: " + vetor[i] + "é maior que a média");
            }
        }
    }
}