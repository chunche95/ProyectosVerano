package ejercicio_recursividad;


/**
 * Calculo mínimo y máximo con divide y vencerás..
 * 
 * @author Pauchino09
 * @version 0.0
 */
public class ejercicio_recursividad_min_y_max
{
    public static void main(String[] args){
        int [] arr = {1,2,3,4,5,6,7,8,9,4,3,-1,0,7,-6,-10};
        int min = minimo(0, arr.length -1, arr);
        int max = maximo(0, arr.length -1, arr);
        int[] min_max = min_max(0, arr.length -1, arr);
        System.out.println("Mínimo(Función 1): "+ min);
        System.out.println("Máximo(Función 2): "+ max);
        System.out.println("\n");
        System.out.println("Mínimo(Función 3): "+ min_max[0]);
        System.out.println("Máximo(Función 3): "+ min_max[1]);
    }
    public static int minimo(int inicio, int fin, int[] arr){
        if(inicio == fin){
            return arr[inicio];
        }else{
            int mitad = (inicio+fin)/2;
            int x = minimo(inicio, mitad, arr);            
            int y = minimo(mitad +1, fin, arr);
            if ( x < y){
                return x;
            }else{
                return y;
            }
        }
    }
    
    public static int maximo(int inicio, int fin, int[] arr){
        if(inicio == fin){
            return arr[inicio];
        }else{
            int mitad = (inicio+fin)/2;
            int x = maximo(inicio, mitad, arr);            
            int y = maximo(mitad +1, fin, arr);
            if ( x > y){
                return x;
            }else{
                return y;
            }
        }
    }
    
    public static int[] min_max(int inicio, int fin, int[] arr){
        int[] min_max = new int[2];
        /* Comparamos dos valores contiguos del array */
        if(fin-inicio <= 1){
            min_max[0]=arr[inicio];
            min_max[0]=arr[fin];
            
            if(min_max[0] > min_max[1]){
                int aux = min_max[0];
                min_max[0] = min_max[1];
                min_max[1] = aux;
            }
            return min_max;
        }else{
            int mitad = (inicio+fin)/2;
            int[] minmax1 = min_max(inicio, mitad, arr);            
            int[] minmax2 = min_max(mitad +1, fin, arr);
            
            if(minmax1[0] < minmax2[0]){
                min_max[0] = minmax1[0];
            }else{
                min_max[0] = minmax2[0];
            }
            if(minmax1[1] > minmax2[1]){
                min_max[1] = minmax1[1];
            }else{
                min_max[1] = minmax2[1];
            }

        }
        return min_max;
    }    
}
