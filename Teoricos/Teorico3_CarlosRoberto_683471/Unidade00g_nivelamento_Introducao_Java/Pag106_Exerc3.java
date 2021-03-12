/*
* Seja uma partida de futebol, leia os números de gols do mandante e do
* visitante e imprima quem foi o vencedor ou se foi empate.
*/
class Pag106_Exerc3 
{
    public static void main(String[] args) 
    {
        int time1, time2;
        time1 = MyIO.readInt();
        time2 = MyIO.readInt();    
        if (time1 > time2) 
        {
            MyIO.println("Time 1 ganhou.");
        }else if (time2 > time1) 
        {
            MyIO.println("Time 2 ganhou.");  
        }else if (time1 == time2) 
        {
            MyIO.println("Empatou.");    
        }
    }
}
