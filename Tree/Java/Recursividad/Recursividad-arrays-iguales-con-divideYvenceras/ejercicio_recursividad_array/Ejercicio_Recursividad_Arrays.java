package ejercicio_recursividad_array;
/**
 * Teniendo dos array, comprobamos con divide y venceras si los dos arrays son iguales.
 * 
 * @author pauchino09 
 * @version 0.0
 */
public class Ejercicio_Recursividad_Arrays
{
    public static void main (String[] args) {
        int[] arr1 = { 1,2,3,4,5,6};
        int[] arr2 = { 1,2,3,4,5,6,7,8,9};
        
        if(arr1.length == arr2.length){
            if(arraysIguales(0, arr1.length -1, arr1, arr2) == -1){
                System.out.println("Los arrays son iguales");
            }else{
                System.out.println("Los arrays no son iguales");
            }
        }else{
            System.out.println("Los array no tienen la misma longitud");
        }        
        System.out.println("Diferencia en la posición: " + arraysIguales(0, arr1.length -1, arr1, arr2));
    }
    /* Ver en que posicion 'falla' o si todo está OK */
    public static int arraysIguales(int inicio, int fin, int[] arr1, int[] arr2){
        if(inicio == fin){
            if(arr1[inicio] == arr2[inicio]){
                /* No hay ninguna posición donde falla - Todo OK */
                return -1;
            } else {
                return inicio;
            }
        }else{
            int mitad =  (inicio + fin)/2;
            int x = arraysIguales(inicio, mitad, arr1, arr2);
            int y = arraysIguales(mitad +1 , fin , arr1, arr2);            
            if( x != -1){
                /* Devuelve el 'fallo' donde no coincide el array */
                return x;
            }
            if( y != -1 ){
                return y;
            }            
            return -1;
        }
    }
}
