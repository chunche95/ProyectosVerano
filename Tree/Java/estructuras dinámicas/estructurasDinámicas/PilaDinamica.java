package estructurasDinámicas;

/**
 * Write a description of class PilaDinamica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilaDinamica<T>
{
    /* Elemento que esta arriba del todo 'en la torre', siguiendo el ejemplo que está en la clase Nodo<T>
     * sería el plato número 30.
     */
    private Nodo<T> top; 
    private int tamanio;
    
    public PilaDinamica(){
        /* No hay nada -> Palet vacio */
        top = null;
        this.tamanio = 0;
    }
    
    public boolean isEmpty(){
        /* Vacio */
        return top == null;
    }
    
    public int size(){
        return this.tamanio;
    }
    
    public T top(){
        /* Quiero saber quien es el elemento 'top' de la pila */
        if(isEmpty()){
            return null;
        }else{
            /* Devolvemos el elemento */
            return top.getElemento();
        }
    }
    
    public T pop(){
        /* Sacamos el contenido de la pila y lo eliminamos. --> (Siguiendo el ejemplo: Vendemos el plato */
        if(isEmpty()){
            return null;
        }else{
            T elemento = top.getElemento();
            /*
             * Nodo<T> aux = top.getSiguiente();
             * top = null;
             * top = aux;
             */
            /* Eliminamos el elemento (plato) - desreferenciando el elemento. */
            top = top.getSiguiente();
            this.tamanio--;
            return elemento;
        }
    }
    
    public void push(T elemento){
        /* Creamos un nuevo nodo - el plato 31 */
        Nodo<T> aux = new Nodo<>(elemento, top);
        top = aux;
        this.tamanio++;
    }
           
       
    public String toString(){
        if(isEmpty()){
            return "La pila está vacía";
        }else{
            String resultado="";
            Nodo<T> aux = top;
            while(aux != null){
                resultado += aux.toString();
                aux = aux.getSiguiente();
            }
        }
    }
    
    public elemento getElemento(){
         return elemento;
    }
    // public Nodo<T> getTop(){
        // return top;
    // }
    
    // public void setTop(Nodo<T> top){
        // this.top = top;    
    // }
    
    // public int getTamanio(){
        // return tamanio;
    // }
    
    // public void setTamanio(int tamanio){
        // this.tamanio = tamanio;
    // }
}
