/*
* Aluno: Carlos Roberto Alves de Almeida Júnior
* Matrícula: 683471
*/

/*
* Fiquei sem tempo para fazer o resto da questão, devido a isso não consegui desenvolver.
* Acredito que a complexidade seria Theta (lg(n))
*/
class Pergunta32{
    int soma()
    {
        int[] t1 = new int[TAMT1];
        int[] t3 = new int[TAMT3];
        int resp = 0;

        for(int i = 0; i < TAMT1; i++){
            if(t1[i] != NULO){
                resp += t1[i];
            }
        }

        for(int i = 0; i < TAMT3; i++){
            if(t1[i] != NULO){
                resp += t3[i];
            }
        }
    }
}