/*
* O banco do Zé abriu uma linha de crédito para os seus clientes. O valor
* máximo da prestação não poderá ultrapassar 40% do salário bruto. Fazer
* um algoritmo que permita entrar com o salário bruto e o valor da prestação
* e informar se o empréstimo será concedido.
*/
class BancoDoZe
{
    public static void main(String[] args)
    {
        double salario = 0.0; double prestacao = 0.0;
        double emprestimo = 0.0;

        salario = MyIO.readDouble(); 
        prestacao = MyIO.readDouble();

        emprestimo = salario*0.40;

        if(prestacao > emprestimo)
        {
            MyIO.println("Empréstimo não concedido");
        }else if(prestacao <= emprestimo)
        {
            MyIO.println("Empréstimo concedido");
        }
    }
}