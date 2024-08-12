/**
 * Escriba un programa que calcule las combinaciones de la primitiva,teniendo en cuenta que son combinaciones
 * de 49 elementos sin repeticiones tomados de 6 en 6. Es decir, sería el número combinatorio: C(49,6).
 * 
 * Debemos crear la función factorial, teniendo en cuenta que el factorial de un número es ese número 
 * multiplicado por todos los menores que él, y que el facotiral es 0 es 1. El factorial de 'n' se representa
 * como n!.
 * 
 * Ejemplo: 5! = 5x4x3x2x1 = 120
 * 
 * La fórmula que me calcula el numero combinatorio de c(n,k) es laa siguite:
 *      c(n,k) = n!/(k! (n-k)!) con k <= n
 */
 /** 
  * Debemos diseñar una función que calcule el valor de un numero combinatorio. Y usar esa función para resolver el problema 
  * del número de combinaciones de lotería primitiva posibles.
  */
package es.uclm.sesion7_fupro;

/**
 *
 * @author Paulino Esteban Bermúdez R.
 */
public class combinacionesPrimitiva {
    public static void main(String[] args) {
        //double resultado=0;
        combinatoria();
    }   
    public static double combinatoria(){
        // Declaración de las variables.
        double c=0; // resultado de la combinatoria (49,6)
        int n=0; // n= 0,1,2,3,4, ... , 48,49        
        int k=0; // k= 6,5,4,3,2,1,0                
        /*****************************
         * Aplicación de la fórmula. *
         ***************************** 
         * c(49,6) = n!/(k!*(n-k)!) => c(49,6)=49!/(48!*(49!-48))!
         */
        factorial49(n); // 6.0828x10^62
        factorial6(k); // 720
        // Redefinimos las variables iniciales para la resta de la fórmula.
        n = 49;
        k = 6;
        factorial49Menos6( n, k); // 6.04152x10^52        
        // Aplicamos la fórmula.
        System.out.println("N:"+factorial49(n));
        System.out.println("K:"+factorial6(k));
        System.out.println("Resta:"+factorial49Menos6( n, k));
        
        c = factorial49(n)/(factorial6(k)*factorial49Menos6(n,k)); // POSIBILIDADES DE ADIVINAR LA PRIMITIVA 13.953.816
        System.out.println("C vale "+c);
        return c;
    }
    public static double factorial49(int n){
        double nResultado = 0;
        for (n = 0; n <= 49; n++) { // Factorial hasta 49
            if (n==0) { // Factorial 0!=1
                nResultado = 1;
            } else {
                nResultado *= n;
            }
            //System.out.printf("Resultado de %d! es: %3.5e \n",n,nResultado);
        }
        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        return nResultado;
    }
    public static double factorial6(int k){
        double kResultado=0;
        for (k = 0; k <= 6; k++) {
            if (k==0) { // Factorial 0!=1
                kResultado = 1;
            } else {
                kResultado *= k;
            }
            //System.out.printf("Resultado de %d! es: %3.5e \n",k,kResultado);
        }
        //System.out.println("-------------------------------------------------");
        return kResultado;
    }
    public static double factorial49Menos6(int n, int k){
        int resta = n-k;
        double iResultado=0;
        for (int i = 0; i <= resta; i++) {
            if (i==0) { // Factorial 0!=1
                iResultado = 1;
            } else {
                iResultado *= i;
            }
            //System.out.printf("Resultado de %d! es: %3.5e \n",i,iResultado);
        }
        //System.out.println("*************************************************");
        return iResultado;
    }
}