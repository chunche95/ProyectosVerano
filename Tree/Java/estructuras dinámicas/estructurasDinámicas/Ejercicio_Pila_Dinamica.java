package estructurasDinámicas;


/**
 * Write a description of class Ejercicio_Pila_Dinamica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio_Pila_Dinamica
{
    public static void main(String[] args) {
        PilaDinamica<Integer> pilaNumeros = new PilaDinamica<>();
        pilaNumeros.push(5);
        pilaNumeros.push(10);
        pilaNumeros.push(15);
        pilaNumeros.push(20);
        pilaNumeros.push(25);
        pilaNumeros.push(30);
        
        System.out.println("El tamaño ahora es de " + pilaNumeros.size());
        
        System.out.println("El top es " + pilaNumeros.top());
        
    }
}
