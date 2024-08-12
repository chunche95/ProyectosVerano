package ejercicio_recursividad;


/**
 * Ejercicio para calcular la multiplicación y media con Divide y Vencerás.
 * 
 * @author Pauchino09.
 * @version 0.0
 */
public class Ejercicio_recursividad
{
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        /* Mostramos el contenido del array */
                for(int i = 0 ; i < array.length; i++ ){
            System.out.println("La posición " + i + " del array es: " + array[i]);
        }
        /* Control de cantidad de números en el array */
        if ( array.length % 2 == 0){
            System.out.println("Media: " + mediaArrayDyV(0, array.length -1, array));
        } else {       
            System.out.println("El número de elementos debe ser par");
        }
        /* Cálculo de la multiplicación del Array */
        System.out.println("Multiplicación: " + multiplicarArrayDyV(0, array.length -1, array));
    }
    
    public static int multiplicarArrayDyV(int inicio, int fin, int[] array){
    
        if(inicio == fin){
            return array[inicio];
        }else{
            int mitad = (inicio + fin) / 2;
            int x = multiplicarArrayDyV(inicio, mitad, array);
            int y = multiplicarArrayDyV(mitad+1, fin, array);
            
            return x * y;
        }
    
    }
    
    public static float mediaArrayDyV(int inicio, int fin, int[] array){
        if(inicio == fin){
            return array[inicio];
        }else{
            int mitad = (inicio + fin) / 2;
            float x = mediaArrayDyV(inicio, mitad, array);
            float y = mediaArrayDyV(mitad+1, fin, array);
            
            return (x + y) / 2;
        }
    } 
}
