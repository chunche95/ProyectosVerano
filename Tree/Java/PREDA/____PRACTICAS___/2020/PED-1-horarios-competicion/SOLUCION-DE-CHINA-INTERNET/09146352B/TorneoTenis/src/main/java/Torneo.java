
import java.util.InputMismatchException;

/**
 * Clase Torneo
 * 
 * Necesitamos organizar un torneo de tenis con N jugadores en donde cada jugador ha de jugar exactamente una vez contra cada uno de sus posibles n-1 competidores, 
 * y además ha de jugar un partido cada día, teniendo a lo sumo UN D�?A DE DESCANSO en todo el torneo. Se supone que hay campos de tenis suficientes para jugar cada 
 * día todos los partidos necesarios.
 * 
 * Se pide diseñar para resolverlo un algoritmo basado en el esquema de Divide y Vencerás.
 * 
 */

/**
 * 
 * @Fecha 04/01/2021
 * @Version 1.0
 * @Autor Paulino Esteban Bermúdez Rodríguez
 * 
 */

public class Torneo {
    
    /**
     * Atributos.
     * 
     * @param matrix
     * @param n 
     * @param i
     * @param j
     * @param traza
     */
    int matrix[][];
    int n, i, j;
    public String traza = "";
    
    public void Torneo(){  // Matriz de los NxN jugadores // Inicializa sus 'n' jugadores 
        traza += "*Entro el método Torneo de la clase Torneo";
        traza += "Creo un nuevo elemento de la clase Torneo llamado partidos";
        Torneo partidos = new Torneo();
        // Comprueba si el string que se pasa es correcto.
        try{
            partidos.DyV();
        } catch(NegativeArraySizeException negativo){
            System.out.println("El programa no funcina con números negativos.\n Ejecute la ayuda con el argumento '-h'o vuelva a ejecutarlo con otros datos, gracias.");
        } catch(InputMismatchException letra){
            System.out.println("El programa no funcina con caracteres.\n Ejecute la ayuda del programa con el argumento '-h' o vuelva a ejecutarlo con otros datos, gracias.");
        } // Try-catch 
    } // void Torneo
    
   
    /**
     * Método de resolución de Divide y Vencerás
     */
    public void DyV(){
        if ( n > 2){
            traza += "Aplicamos el algoritmo de divide y vencerás.";
            traza += "*Comprobación de nº de jugadores. ¿Es par?";
            if ( n % 2 == 0 ) {
                traza += "*> Sí";
                // Rellenamos la esquina superior derecha
                traza += "*Rellenamos la esquina superior derecha";
                for ( i=0; i<n/2; i++){
                    for ( j=n/2; j<n; j++){
                        matrix[i][j] = matrix[i][j-n/2] + n/2;
                    }
                }
                // Rellenamos la esquinainferior izquierda
                traza += "*Rellenamos la esquinainferior izquierda";
                for ( i = n/2; i<n; i++){
                    for ( j = 0; j < n/2; j++) {
                        matrix[i][j] = matrix[i-n/2][j+n/2];
                    }
                }
                // Rellenamos la esquina inferior derecha
                traza += "*Rellenamos la esquina inferior derecha";
                for (i = n/2; i < n; i++) {
                    for (j = n/2; j < n; j++) {
                        matrix[i][j] = matrix[i-n/2][j-n/2];
                    }
                }
            // Jugadores impares en el torneo
            } else {
                traza += "*> No";
                // Rellenamos la esquina superior derecha
                traza += "*Rellenamos la esquina superior derecha";
                for ( i=0; i<n/2; i++){
                    for ( j=n/2; j<n; j++){
                        matrix[i][j] = matrix[i][j-n/2] + n/2;
                    }
                }
                // Rellenamos la esquinainferior izquierda
                traza += "*Rellenamos la esquinainferior izquierda";
                for ( i = n/2; i<n; i++){
                    for ( j = 0; j < n/2; j++) {
                        matrix[i][j] = matrix[i-n/2][j+n/2];
                    }
                }
                // Rellenamos la esquina inferior derecha
                traza += "*Rellenamos la esquina inferior derecha";
                for (i = n/2; i < n; i++) {
                    for (j = n/2; j < n; j++) {
                        matrix[i][j] = matrix[i-n/2][j-n/2];
                    }
                }
            }
        } else if( n == 2) {
            matrix[0][0] = 1;
            matrix[0][1] = 2;
            matrix[1][0] = 2;
            matrix[1][1] = 1;
        }else {
            System.out.println("Los datos introducidos son incorrectos, vuelva a intentarlo de nuevo con otros datos");
        }
    }
}
