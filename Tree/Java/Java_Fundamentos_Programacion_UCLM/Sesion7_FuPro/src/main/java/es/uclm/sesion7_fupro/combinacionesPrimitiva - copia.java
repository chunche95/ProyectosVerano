public class combinacionesPrimitiva {
    public static void main(String[] args) {
        //double resultado=0;
        System.out.println(combinatoria());
    }   
    public static double combinatoria(){
        // Declaración de las variables.
        double c=0; // resultado de la combinatoria (49,6)
        int n=0; // n= 0,1,2,3,4, ... , 48,49        
        int k=0; // k= 6,5,4,3,2,1,0                
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
            System.out.printf("Resultado de %d! es: %3.5e \n",n,nResultado);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
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
            System.out.printf("Resultado de %d! es: %3.5e \n",k,kResultado);
        }
        System.out.println("-------------------------------------------------");
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
            System.out.printf("Resultado de %d! es: %3.5e \n",i,iResultado);
        }
        System.out.println("*************************************************");
        return iResultado;
    }
}
