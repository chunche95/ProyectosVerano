package estructurasDinámicas;


/**
 * Estructuras dinámicas en Java.
 * 
 * @author Pauchino09.
 * @version 1.0
 */
public class Nodo<T>
{
   /* Un nodo genérico nos permite poner cualquier tipo de valor:
    * - int
    * - float
    * - double
    * - objetos char
    * - ...
    * 
    * Estructura LIFO => Último en entrar, primero en salir.
    * 
    * Ejemplo: tengo que sacar una pila de platos y llenar un palet para luego venderlos.
    * El palet está al inicio vacio, por ello tendré 0 platos pero a medida que lo voy llenando 
    * tengo más acumulados, total 30 platos (0 --> 10 --> 20 --> 30).
    * Una vez puestos a vender, los primeros en venderse serán los que se pusieron los últimos en
    * el palet, por ello para llegar a los primeros que se pusieron en el palet, tengo que vender los 
    * 30, luego 20 y 10 para quedarme con el palet vacío.
    * 
    *   Tengo 30 platos
    *      [---30---]  ... 29 28 27 26 25 24 23 22 21 
    *   Tengo 20 platos
    *      [---20---]  ... 19 18 17 16 15 14 13 12 11
    *   Tengo 10 platos
    *      [---10---]  ... 9 8 7 6 5 4 3 2 1
    *   Tengo 0 platos  
    *      [---00---]
    */
   private T elemento;
   private Nodo<T> siguiente;
   
   public Nodo(T elemento, Nodo<T> siguiente){
       this.elemento = elemento;
       this.siguiente = siguiente;
   }
   
   public T getElmento(){
       return elemento;
   }
   
   public void setElemento(T elemento){
       this.elemento = elemento;
   }
   
   public Nodo<T> getSiguiente(){
       return siguiente;
   }
   
   public void setSiguiente(Nodo<T> siguiente){
       this.siguiente = siguiente;
   }
   
   @Override
   public String toString(){
       return elemento+"\n";
   }
}
