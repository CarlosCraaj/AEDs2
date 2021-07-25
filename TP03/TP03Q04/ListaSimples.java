import java.util.*;
// Essa Classe é para a Lista de Artistas
class ListaAux 
{
    private String[] array;
    private int n;

    public ListaAux() 
    {
        this(20);
    }

    public ListaAux(int tamanho)
    {
        array = new String[tamanho];
        n = 0;
    }

    public void inserirFim(String x) throws Exception {
        //Evitar erro
        if(n >= array.length){
            throw new Exception("Erro ao inserir!");
        }

        array[n] = x;
        n++;
    }

    public String mostrar()
    {
        String tmp = "";
        tmp += "[";
        for(int i = 0; i < n; i++){
            if(i == n-1)
            {
                tmp += array[i];
            }else
            {
                tmp += array[i] + ",";
            }
        }
        tmp += "]";
        return tmp;
    }

    public String[] getLista()
    {
        return array;
    }

    public void setLista(String[] arrayAux)
    {
        int i = 0;
        while(i < arrayAux.length)
        {
            array[i] = arrayAux[i];
            n++;
        }
    }
}

class DataAux
{
    private int dia; private int mes;
    private int ano;

    public DataAux()
    {
        this(0, 0, 0);
    }

    public DataAux(int day, int month, int year)
    {
        dia = day;
        mes = month;
        ano = year;
    }

    /*public String getData()
    {
        String tmp;

        tmp += dia;
        tmp += mes;
        tmp += ano;
        
        return tmp;
    }*/

    public int[] dataForCmp()
    {
        int[] tmp = new int[3];

        tmp[0] = ano;
        tmp[1] = mes;
        tmp[2] = dia;

        return tmp;
    }

    public void setData(String aux)
    {
        String tmp = "";
        int i = 0;
        if(aux.length() == 4)
        {
            ano = Integer.parseInt(aux);
            dia = 1;
            mes = 1;
        }else
        {
            for(i = 0; i < aux.length(); i++)
            {
                if(i <= 4)
                {
                    if(i == 4)
                    {
                        ano = Integer.parseInt(tmp);
                        tmp = "";
                    }else
                        tmp += aux.charAt(i);
                }else if(i > 4 && i <= 7)
                {
                    
                    if(i == 7)
                    {
                        mes = Integer.parseInt(tmp);
                        tmp = "";
                    }else
                        tmp += aux.charAt(i);
                }else if(i > 7)
                {
                    tmp += aux.charAt(i);
                    if(i == 9)
                    {
                        dia = Integer.parseInt(tmp);
                    }
                }
            }
        }
    }

    public String mostrar()
    {
        String tmp = "";
        if(dia < 10)
        {
            tmp += "0"+dia;
        }else
        {
            tmp += dia;
        }
        tmp += "/";
        if(mes < 10)
        {
            tmp += "0"+mes;
        }else
        {
            tmp += mes;
        }
        tmp += "/";
        tmp += ano;
        return tmp;
    }
}

class Musica
{
    //Declaracao de variaveis
    private String id; private String nome; private String key;
    ListaAux list = new ListaAux();
    DataAux date = new DataAux();
    private double acousticness; private double danceability;
    private double energy; private int duration_ms;
    private double instrumentalness; private double valence;
    private int popularity; private float tempo;
    private double liveness; private double loudness;
    private double speechiness; private int year;

    //Construtor vazio
    public Musica()
    {
        this.id = ""; this.nome = ""; this.key = "";
        //this de lista
        //this de release_date
        this.acousticness = 0; this.danceability = 0; this.energy = 0;
        this.duration_ms = 0; this.instrumentalness = 0;
        this.valence = 0; this.popularity = 0; this.tempo = 0;
        this.liveness = 0; this.loudness = 0; this.speechiness = 0;
        this.year = 0;
    }

    //Construtor com parametros
    public Musica(String id, String nm, String key, double acous, double dance, double ene, int durat, double inst, double val, int pop, float tem, double live, double loud, double spee, int year)
    {
        this.id = id; this.nome = nm; this.key = key;
        //this de lista
        //this de release_date
        this.acousticness = acous; this.danceability = dance; this.energy = ene;
        this.duration_ms = durat; this.instrumentalness = inst;
        this.valence = val; this.popularity = pop; this.tempo = tem;
        this.liveness = live; this.loudness = loud; this.speechiness = spee;
        this.year = year;
    }

    //Funcoes principais da Classe Musica:Ler, Imprimir e PegarArtists 
    /*
    * O Metodo Ler, funciona por reducao de String a cada chamada.
    * Entao ele usa de metodos auxiliares para reduzir a String principal (linha do ID da musica)
    * Sendo os metodos auxiliares para armazenar os dados: lerAteVirgula(), AteVirgulaOrAspas(), PegarArtists().
    */
    public void Ler(String music) throws Exception
    {
        String aux;
        int j = 0; int k = 0;
        double toDouble = 0; int toInt = 0;
        float toFloat = 0;
        for(int i = 0; i < 19; i++)
        {
            aux = ""; j = 0; toDouble = 0; toInt = 0; //resetar as variaveis
            if(i == 0)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setValence(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 1)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toInt = Integer.parseInt(aux);
                setYear(toInt);
                music = reduzindoString(j, music);
            }else if(i == 2)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setAcousticness(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 3)
            {
                music = pegarArtists(music); //Alem de guardar artistas em suas posicoes, reduz a String music
            }else if(i == 4)
            {
                
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setDanceability(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 5)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toInt = Integer.parseInt(aux);
                setDuration_ms(toInt);
                music = reduzindoString(j, music);   
            }else if(i == 6)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setEnergy(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 7)
            {
                //Aqui seria o atributo Explicity, porem nao foi pedido, mas mesmo assim eh necessario reduzir a String music
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                music = reduzindoString(j, music);
            }else if(i == 8)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                setID(aux);
                music = reduzindoString(j, music);
            }else if(i == 9)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setInstrumentalness(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 10)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                setKey(aux);
                music = reduzindoString(j, music);
            }else if(i == 11)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setLiveness(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 12)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setLoudness(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 13)
            {
                //Mesma coisa do Explicity, aqui seria o mode.
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                music = reduzindoString(j, music);
            }else if(i == 14)
            {
                int[] x = new int[1];
                aux = AteVirgulaOrAspas(music, x);
                setNome(aux);
                music = reduzindoString(x[0], music);
            }else if(i == 15)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toInt = Integer.parseInt(aux);
                setPopularity(toInt);
                music = reduzindoString(j, music);  
            }else if(i == 16)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                date.setData(aux);
                music = reduzindoString(j, music);
            }else if(i == 17)
            {
                aux = lerAteVirgula(music);
                j = aux.length()+1;
                toDouble = Double.parseDouble(aux);
                setSpeechiness(toDouble);
                music = reduzindoString(j, music);
            }else if(i == 18)
            {
                //aux = lerAteVirgula(music);
                j = aux.length()+1;
                toFloat = Float.parseFloat(music);
                setTempo(toFloat);
            }
        }
    }    

    public String pegarArtists(String music) throws Exception
    {
        int j = 0; int k = 0;
        String tmp = "";
        while(music.charAt(j) != ']')
        {
            if(music.charAt(j) == ',' || music.charAt(j+1) == ']')
            {
                list.inserirFim(tmp);
                tmp = "";
                j++;
                k++;
            }else if(music.charAt(j) != (char)39 && music.charAt(j) != '"' && music.charAt(j) != '[')
            {
                tmp += music.charAt(j);
                j++;
            }else
            {
                j++;
            }
        }
        tmp = k > 1 ? reduzindoString(j+3, music) : reduzindoString(j+2, music);

        return tmp;
    }
    
    public void imprimir()
    {
        //String teste = "";
        //teste = date.mostrar();
        //MyIO.println(teste);
        MyIO.println(getID() + " ## " + list.mostrar() + " ## " + getNome() + " ## " + date.mostrar() + " ## " + getAcousticness() + " ## " + getDanceability() + " ## " + getInstrumentalness() + " ## " + getLiveness() + " ## " + getLoudness() + " ## " + getSpeechiness() + " ## " + getEnergy() + " ## " + getDuration_ms());
    }

    public Musica clone()
    {
        Musica copy = new Musica();
        copy.id = this.id;
        copy.nome = this.nome; copy.key = this.key;
        copy.list = this.list; copy.date = this.date;
        copy.acousticness = this.acousticness;
        copy.danceability = this.danceability;
        copy.energy = this.energy;  copy.duration_ms = this.duration_ms;
        copy.instrumentalness = this.instrumentalness;
        copy.valence = this.valence; copy.popularity = this.popularity;
        copy.tempo = this.tempo; copy.liveness = this.liveness;
        copy.loudness = this.loudness; copy.speechiness = this.speechiness;
        copy.year = this.year;

        return copy;
    }


    

    //Inicio get's e set's
    public String getID()
    {
        return this.id;
    }

    public void setID(String ID)
    {
        this.id = ID;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String name)
    {
        this.nome = name;
    }
    
    public String getKey()
    {
        return this.key;
    }

    public void setKey(String chave)
    {
        this.key = chave;
    }

    //Usei para testar tempo do algoritmo
    public long now()
    {
      return new Date().getTime();
    }

    /*
    * O get e set de List, estao na Classe ListaAux e do date, na Classe DataAux
    */


    public double getAcousticness()
    {
        return this.acousticness;
    }

    public void setAcousticness(double acous)
    {
        this.acousticness = acous;
    }

    public double getDanceability()
    {
        return this.danceability;
    }

    public void setDanceability(double dance)
    {
        this.danceability = dance;
    }

    public double getEnergy()
    {
        return this.energy;
    }

    public void setEnergy(double ene)
    {
        this.energy = ene;
    }

    public int getDuration_ms()
    {
        return this.duration_ms;
    }

    public void setDuration_ms(int duration)
    {
        this.duration_ms = duration;
    }

    public double getInstrumentalness()
    {
        return this.instrumentalness;
    }

    public void setInstrumentalness(double instru)
    {
        this.instrumentalness = instru;
    }

    public double getValence()
    {
        return this.valence;
    }

    public void setValence(double val)
    {
        this.valence = val;
    }

    public int getPopularity()
    {
        return this.popularity;
    }

    public void setPopularity(int pop)
    {
        this.popularity = pop;
    }

    public float getTempo()
    {
        return this.tempo;
    }

    public void setTempo(float ritmo)
    {
        this.tempo = ritmo;
    }

    public double getLiveness()
    {
        return this.liveness;
    }

    public void setLiveness( double live)
    {
        this.liveness = live;
    }

    public double getLoudness()
    {
        return this.loudness;
    }

    public void setLoudness(double loud)
    {
        this.loudness = loud;
    }

    public double getSpeechiness()
    {
        return this.speechiness;
    }

    public void setSpeechiness(double spee)
    {
        this.speechiness = spee;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setYear(int ano)
    {
        this.year = ano;
    }
    //Fim get's e set's

    //Inicio Metodos auxiliares (Nao exclusivos da Classe)
    public static boolean isFim(String s)
    {
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static int myOwnIndexOf(String substr, String str) 
    {
        int lenStr = str.length();
        int lenSubstr = substr.length();
        int count = 0;
        if (lenSubstr > lenStr) 
        {
            return -1;
        }
        for (int i = 0; i < lenStr - lenSubstr + 1; i++) 
        {
            for (int j = 0; j < lenSubstr; j++) 
            {
                if (str.charAt(j+i) == substr.charAt(j)) 
                {
                    count++;
                    if (count == lenSubstr) 
                    {
                        return i;
                    }
                } else 
                {
                    count = 0;
                    j = lenSubstr;
                }
            }
        }
        return -1;
    }


    //Metodo que vai ler ate a primeira virgula, e retornar essa String.
    public static String lerAteVirgula(String music)
    {
        String tmp = "";
        int j = 0;
        
        while(music.charAt(j) != ',')
        {
            tmp += music.charAt(j);
            j++;
        }

        return tmp;
    }

    //Metodo semelhante ao "lerAteVirgula", mas trata de um caso especial quando o atributo nome tem varias aspas dentro dele.
    public static String AteVirgulaOrAspas(String music, int[] j)
    {
        String tmp = "";
        if(music.charAt(j[0]) == '"')
        {
            j[0]++;
            while(music.charAt(j[0]) != '"' || music.charAt(j[0]+1) != ',')
            {
                if(music.charAt(j[0]) == '"')
                {
                    if(music.charAt(j[0]) == '"' && music.charAt(j[0]+1) == '"')
                    {
                        tmp += music.charAt(j[0]);
                        j[0] += 2;
                    }
                }else
                {
                    tmp += music.charAt(j[0]);
                    j[0]++;
                }
            }

            if(music.charAt(j[0]) == '"')
            {
                j[0]++;
            }

        }else
        {
            while(music.charAt(j[0]) != ',')
            {
                tmp += music.charAt(j[0]);
                j[0]++;
            }
        }

        return tmp;
    }

    //Metodo para trocar ','(virgula), por ';'(ponto e virgula). Para facilitar no split do Metodo PegarAquivo()
    public static String tratarString(String tmp)
    {
        String aux = "";
        int i = 0;
        int Colchete = 0;
        while(i < tmp.length())
        {
            if(tmp.charAt(i) == '[')
                Colchete = 1;
            if(tmp.charAt(i) == ']')
                Colchete = 0;

            if(tmp.charAt(i) == ',' && Colchete == 1)
                aux += ';';
            else
                aux += tmp.charAt(i);
            i++;
        }
        return aux;
    }

    /*
    * Esse Metodo pega cada linha, faz o split para pegar o ID, e compara com os IDs do pub.in. 
    * Caso existir vai preencher o array de String id, com a linha completo, ou seja, substituir ID dela pela sua linha.
    */
    public static void PegarArquivo(String[] id, int n)
    {
        String tmp = "";
        String auxiliar = "";
        String[] pegarId;
        Arq.openRead("/tmp/data.csv", "UTF-8");
        int j = 0; 
        int x = 0;
        while(Arq.hasNext())
        {
            tmp = Arq.readLine();
            auxiliar = tmp;
            tmp = tratarString(tmp);
            pegarId = tmp.split(",");
            x = 0;
            while(x < n)
            {
                if(pegarId[8].compareTo(id[x]) == 0)
                {
                    id[x] = auxiliar;
                    x = n;
                }
                x++;
            }
            j++;
        }
        Arq.close();
    }

    //Esse metodo, como diz no nome reduz a String, pois eu nao utilizo Split no metodo Ler.
    public static String reduzindoString(int j, String music)
    {
        String tmp = "";
        int len = music.length();
        if(music.charAt(j) == ',')
        {
            j++;
        }
        while(j < len)
        {
            tmp += music.charAt(j);
            j++;
        }
        return tmp;
    }
    //Fim Metodos auxiliares

}

class Celula {
    public Musica elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


	public Celula() 
    {
		this(null);
	}

	public Celula(Musica music) 
    {
        this.elemento = music;
        this.prox = null;
	}
}

class ListaSimples
{
    private Celula primeiro;
	private Celula ultimo;

	
	public ListaSimples() 
    {
		primeiro = new Celula();
		ultimo = primeiro;
	}

    public void inserirInicio(Musica music) 
    {
	    Celula tmp = new Celula(music);
        tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) 
        {                 
			ultimo = tmp;
		}
        tmp = null;
	}

    public void inserirFim(Musica music) 
    {
		ultimo.prox = new Celula(music);
		ultimo = ultimo.prox;
	}


    public Musica removerInicio() throws Exception 
    {
		if (primeiro == ultimo) 
        {
			throw new Exception("Erro ao remover (vazia)!");
		}

        Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Musica resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
		return resp;
	}

    public Musica removerFim() throws Exception 
    {
		if (primeiro == ultimo) 
        {
			throw new Exception("Erro ao remover (vazia)!");
		} 

        Celula i;
        for(i = primeiro; i.prox != ultimo; i = i.prox);

        Musica resp = ultimo.elemento; 
        ultimo = i; 
        i = ultimo.prox = null;
      
		return resp;
	}

    public void inserir(Musica music, int pos) throws Exception 
    {

        int tamanho = tamanho();

        if(pos < 0 || pos > tamanho)
        {
	    	throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0)
        {
            inserirInicio(music);
        } else if (pos == tamanho)
        {
            inserirFim(music);
        } else 
        {
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            Celula tmp = new Celula(music);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }

    public Musica remover(int pos) throws Exception 
    {
        Musica resp;
        int tamanho = tamanho();

		if (primeiro == ultimo)
        {
			throw new Exception("Erro ao remover (vazia)!");

        } else if(pos < 0 || pos >= tamanho)
        {
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0)
        {
            resp = removerInicio();
        } else if (pos == tamanho - 1)
        {
            resp = removerFim();
        } else 
        {
		   // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for(int j = 0; j < pos; j++, i = i.prox);
		
            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

		return resp;
	}

	public void mostrar() {
        int j = 0;
		for (Celula i = primeiro.prox; i != null; i = i.prox, j++) {
            MyIO.print("[" + j + "] ");
            i.elemento.imprimir();
		}
	}

	public int tamanho() 
    {
        int tamanho = 0; 
        for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
        return tamanho;
    }   


    public static void main(String[] args) throws Exception
    {
        String[] pubin = new String[310];
        int x = 0;
        int j = 0;
        ListaSimples lista = new ListaSimples();
        MyIO.setCharset("UTF-8");

        do
        {
            pubin[x] = MyIO.readLine();
            x++;
        }while(Musica.isFim(pubin[x-1]) == false);
        x--; //Desconsiderar FIM

        Musica.PegarArquivo(pubin, x);
        
        for(int i = 0; i < x; i++)
        {
            Musica auxiliar = new Musica();
            auxiliar.Ler(pubin[i]);
            lista.inserirFim(auxiliar);
        }
    

        j = MyIO.readInt();
        String[] ids = new String[j];
        String[] insercts = new String[j];
        int nIDs = 0;


        for(int i = 0; i < j; i++)
        {
            String[] split1 = new String[3];
            Musica auxiliar = new Musica();
            String ins = "";
            ins = MyIO.readLine();

            if(ins.contains("II"))
            {
                split1 = ins.split(" ");
                ids[nIDs] = split1[1];
                insercts[i] = split1[0];
                nIDs++;
            }else if(ins.contains("IF"))
            {
                split1 = ins.split(" ");
                ids[nIDs] = split1[1];
                insercts[i] = split1[0];
                nIDs++;
            }else if(ins.contains("I*"))
            {
                split1 = ins.split(" ");
                ids[nIDs] = split1[2];
                insercts[i] = split1[0] + " " + split1[1];
                nIDs++;
            }else if(ins.contains("RI"))
            {
                insercts[i] = ins;
            }else if(ins.contains("R*")){
                insercts[i] = ins;
            }else if(ins.contains("RF"))
            {
                insercts[i] = ins;
            }

        }

        int nINS = 0;
        Musica.PegarArquivo(ids, nIDs);


        for(int i = 0; i < j; i++)
        {
            String[] split1 = new String[3];
            Musica auxiliar = new Musica();
            String ins = insercts[i];
            int num = 0;

            if(ins.contains("II"))
            {
                auxiliar.Ler(ids[nINS]);
                lista.inserirInicio(auxiliar);
                nINS++;
            }else if(ins.contains("IF"))
            {
                auxiliar.Ler(ids[nINS]);
                lista.inserirFim(auxiliar);
                nINS++;
            }else if(ins.contains("I*"))
            {
                split1 = ins.split(" ");
                num = Integer.parseInt(split1[1]);
                auxiliar.Ler(ids[nINS]);
                lista.inserir(auxiliar, num);
                nINS++;
            }else if(ins.contains("RI"))
            {
                auxiliar = lista.removerInicio();
                MyIO.println("(R) " + auxiliar.getNome());
            }else if(ins.contains("RF"))
            {
                auxiliar = lista.removerFim();
                MyIO.println("(R) " + auxiliar.getNome());
            }else if(ins.contains("R*"))
            {
                split1 = ins.split(" ");
                num = Integer.parseInt(split1[1]);
                auxiliar = lista.remover(num);
                MyIO.println("(R) " + auxiliar.getNome());
            }

        }

        //int size = lista.tamanho();

        lista.mostrar();


    }
}