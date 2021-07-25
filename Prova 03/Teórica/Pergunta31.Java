/*
* Aluno: Carlos Roberto Alves de Almeida Júnior
* Matrícula: 683471
*/

/*
* Explicacao: A ideia é, quando chegar na ultima posicao da string, comparar se o elemento daquele nó (letra) é igual a ultima.
* Tem a mesma complexidade da pesquisa da árvore trie.
*/
class Pergunta31{
    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if(no.prox[s.charAt(i)] == null){
            resp = false;
        } else if(i == s.length() - 1){
            resp = (no.prox[s.charAt(i)].elemento == s.charAt(i));
        } else if(i < s.length() - 1 ){
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }
}