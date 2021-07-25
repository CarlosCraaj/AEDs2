class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.

	public Celula() {
		this(0);
	}

	public Celula(int elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

class CelulaMat {
   public int elemento;
   public CelulaMat inf, sup, esq, dir;
   public Celula primeiro, ultimo;

   public CelulaMat(){
      this(0);
   }

   public CelulaMat(int elemento){
      this(elemento, null, null, null, null);
   }

   public CelulaMat(int elemento, CelulaMat inf, CelulaMat sup, CelulaMat esq, CelulaMat dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
      this.primeiro = this.ultimo = new Celula();
   }
}

class MatrizDeLista {
    private CelulaMat inicio;
    private int linha, coluna;

    public MatrizDeLista(){
        this(3, 3);
    }

    public MatrizDeLista(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }


    boolean pesquisar(int elemento){
        boolean resp = false;

        for(CelulaMat i = inicio; !resp && i != null; i = i.dir){
            for(CelulaMat j = i; !resp && j != null; j = j.inf){
                if(j.elemento == elemento){
                resp = true;
                } else {
                    for(Celula k = j.primeiro.prox; k != null; k = k.prox){
                        if(k.elemento == elemento){
                            resp = true;
                            k = j.ultimo;
                        } 
                    }
                }
            }
        }

        return resp;
    }

    /*boolean pesquisar(int i, int j, int elemento){
        boolean resp = false;
        CelulaMat pi, pj;

        for(int ii = 0, pi = inicio; ii < i; ii++, pi = pi.dir){
            for(int jj = 0, pj = pi; jj < j; jj++, pj = pj.inf);
        }

        for(Celula k = pj.primeiro.prox; k != null; k = k.prox){
            if(k.elemento == elemento){
                resp = true;
                k = j.ultimo;
            }
        }

    }*/

}


class PaoDeQueijo
{
    public static boolean isFim(String s)
    {
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }


    public static void main(String[] args)
    {
        int linha = 0, coluna = 0;
        String linhaS = "";
        String colunaS = "";
        String fimteste = "";

        do
        {
            fimteste = MyIO.readLine();
            if(!fimteste.equals("FIM"))
            {
                linhaS += fimteste.charAt(0); linha = Integer.parseInt(linhaS);
                colunaS += fimteste.charAt(2); coluna = Integer.parseInt(colunaS);
                MyIO.println(linha + " " + coluna);

            }
            /*fimteste = MyIO.readString();
            if(!fimteste.equals("FIM"))
            {
                linha = Integer.parseInt(fimteste);
                fimteste = MyIO.readString();
                coluna = Integer.parseInt(fimteste);

            }*/
        } while(isFim(fimteste) == false);
    }
}