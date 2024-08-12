/**
 *  Necesitamos generar un sistema que genere boletos de loteria de la primitiva.
 * Un boleto de loteria de la primitiva está formado por una combinación de 6 elecciones de numeros de 0 a 49,
 * el programa dará de manera automática los numeros junto con un número de reintegro.
 */
package es.uclm.loteria;
import java.util.Scanner;
/**
 * @version 0.1
 * @author Paulino Esteban Bermçudez R.
 */
public class Boleto {
    public static void main(String[] args) {
        System.out.println("Sistema de Primitivas de la UCLM. \n\n");        
        solicitarNumero();        
    }    
    public static void solicitarNumero(){        
        int numLoteriasQueQuiero;
        //Scanner numLote = new Scanner(System.in);
        System.out.println("¿Cuántas loterías quieres comprar? ");
        numLoteriasQueQuiero = 4;//numLote.nextInt();        
        generadorBoleto(numLoteriasQueQuiero);
    }
    public static void generadorBoleto(int hacerNumLoterias){
        int [][] boleto = new int[hacerNumLoterias][6];
        System.out.println(">Loterias solicitadas: " + hacerNumLoterias);
        
        for (int fila = 0; fila < boleto.length; fila++) {
            System.out.printf("Su nº de loteria: %d :", fila+1);
            for (int columna = 0; columna < boleto[fila].length; columna++) {                
                if (yaExiste(fila, columna)) {
                    System.out.print("[ "+ generarNumeros(columna) + " ]");
                }
            }  
            System.out.println("");
        }
        System.out.println("Su nº de reintegro es: "+darReintegro());
        darReintegro();
        //return 1;
    }
    public static int generarNumeros(int numero){
        int candidatosMax = 6;                
        for (int i = 0; i < candidatosMax; i++) {
            numero = (int) (Math.random()*49);
        }
        return numero;
    }
    public static boolean yaExiste(int i, int numero){
        if (i == numero) {
            return false;
        }
        return true;
    }
    public static int darReintegro(){
        int reintegro = (int) (Math.random()*9);
        //System.out.printf("Su nº de reintegro es:  %d", reintegro);
        return reintegro;
    }
}
