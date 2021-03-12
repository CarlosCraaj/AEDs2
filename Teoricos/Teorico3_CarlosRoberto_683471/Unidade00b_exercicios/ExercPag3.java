/*
Faça um método que receba um array de inteiros e mostre na
tela o maior e o menor elementos do array.
*/
public class ExercPag3 
{
    /*
    * Função para descobrir maior e menor números de um Array
    */
    public static void MaiorMenor(int[] nums, int[] Maior, int[] Menor)
    {
        int n = nums.length;
        Maior[0] = nums[0];
        Menor[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            if(Maior[0] < nums[i])
            {
                Maior[0] = nums[i];
            }

            if(Menor[0] > nums[i]) 
            {
                Menor[0] = nums[i];
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[100];
        int[] maior = new int[1]; 
        int[] menor = new int[1];

        for (int i = 0; i < 100; i++) 
        {
            nums[i] = i*2;
        }

        MaiorMenor(nums, maior, menor);
        MyIO.println("O Maior número é " + maior[0] + " e o menor é "+ menor[0]);
    }
}
