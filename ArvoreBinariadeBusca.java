import java.lang.reflect.*;

public class ArvoreBinariaDeBusca <X extends Comparable<X>>
{
    private class No
    {
        private No esq;
        private X  info;
        private No dir;

        public No (No e, X i, No d)
        {
            this.esq  = e;
            this.info = i;
            this.dir  = d;
        }

        public No (X i)
        {
            this.esq  = null;
            this.info = i;
            this.dir  = null;
        }

        public No getEsq ()
        {
            return this.esq;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getDir ()
        {
            return this.dir;
        }

        public void setEsq (No e)
        {
            this.esq = e;
        }
        
        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setDir (No d)
        {
            this.dir = d;
        }
    } //fim da classe No

    private No raiz;
    
    private X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe         = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo           = classe.getMethod("clone",tipoDosParms);
            Object[] parms          = null;
            ret                     = (X)metodo.invoke(x,parms);
        }
        catch(NoSuchMethodException erro)
        {}
        catch(IllegalAccessException erro)
        {}
        catch(InvocationTargetException erro)
        {}

        return ret;
    }
    
    public void guardeUmItem (X i) throws Exception
    {
        if (i==null) throw new Exception ("Informacao ausente");

        if (i instanceof Cloneable) i=this.meuCloneDeX(i);
        
        if (this.raiz==null)
        {
            this.raiz = );
            return;
        }
        
        No atual=this.raiz;
        for(;;) // forever
        {
            int comparacao=i.compareTo(atual.getInfo());
            
            if (comparacao==0) throw new Exception ("Elemento repetido");
            
            if (comparacao<0)
            {
                if (atual.getEsq()==null)
                {
                    atual.setEsq (new No (i));
                    return;
                }
                else
                    atual=atual.getEsq();
            }
            else // comparacao>0
            {
                if (atual.getDir()==null)
                {
                    atual.setDir (new No (i));
                    return;
                }
                else
                    atual=atual.getDir();
            }
        }
    }


	public void excluaUmItem(X i) throws Exception
{
    if (i == null)
        throw new Exception("Informacao ausente");

    No atual = this.raiz;
    No anterior = null;

    while (atual != null)
    {
        int comparacao = i.compareTo(atual.getInfo());

        if (comparacao == 0)
            break;

        anterior = atual;

        if (comparacao < 0)
            atual = atual.getEsq();
        else
            atual = atual.getDir();
    }

	if(atual.getDir()==null|| atual.getEsq()==null){
		if(anterior.getDir()==atual){
			anterior.getDir()==null
		}
		if(anterior.getEsq()==atual){
			antetrior.getEsq()==null
		}
		
	}


	if(atual.getDir()!=null & atual.getEsq()!=null){
		No folha= null;
		while (atual.getDir()!=null){
			folha=atual.getDir() 
		}
		atual.setInfo(folha.getInfo())
		
		
		
	}

    if (atual == null)
        throw new Exception("Item inexistente");

   //falta a exclusao aqui
}
	
    
    public boolean temOItem (X i) throws Exception
    {
        // faça
	}
	
	@Override
	public boolean equals (Object obj)
	{
		if (obj==this) return true;
		if (obj==null) return false;
		if (obj.getClass()!=this.getClass()) return false;
		ArvoreBinariaDeBusca arv = (ArvoreBinariaDeBusca)obj;
		return equals(this.raiz,arv.raiz);
    }
	
	private boolean equals (No raizArv1, No raizArv2)
	{
	    if (raizArv1==null && raizArv2==null) return true;
	    if (raizArv1==null && raizArv2!=null) return false;
	    if (raizArv1!=null && raizArv2==null) return false;
	    if (!raizArv1.getInfo().equals(raizArv2.getInfo()) return false;
	    /*
	    return equals(raizArv1.getEsq(),raizArv2.getEsq()) &&
	           equals(raizArv1.getDir(),raizArv2.getDir());
	    */
	    if (!equals(raizArv1.getEsq(),raizArv2.getEsq()) return false;
	    if (!equals(raizArv1.getDir(),raizArv2.getDir()) return false;
	    return true;
	}
	



    @Override
    public int hashCode ()
    {
        return hashCode(this.raiz);
    }


    private int hashCode (No no)
    {
        if (no == null)
            return 0;

        int resultado = no.getInfo().hashCode();//hashcode do nó especifico

        resultado = 31 * resultado + hashCode(no.getEsq());
        resultado = 31 * resultado + hashCode(no.getDir());

        return resultado;

		
    }

	    @Override
    public ArvoreBinariaDeBusca<X> clone ()
    {
        return new ArvoreBinariaDeBusca<X>(this);
    }

	
} // fim da classe ArvoreBinariaDeBusca
