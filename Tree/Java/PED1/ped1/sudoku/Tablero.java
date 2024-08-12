package sudoku;


/**
 * Write a description of class Tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero
{
    /**
     * Propiedades
     */
    private Casilla[][] casillas;
    
    /*
     * Constructor.
     * Genera un tablero de sudoku básico de 9x9.
     */
    public Tablero()
    {
        // initialise instance variables
        this.casillas = new Casilla[9][9];
    }
    /*
     * Métodos.
     * Devuelve las carillas del tablero
     * @return
     */
    public Casilla[][] getCasilla(){
    return this.casillas;
    }    
    /*
     * Inicializamos el tablero establecido por defecto los valores:
     * valor = 0
     * posX = i
     * posY = j
     * editable = True
     * Sector = Según posición
     */
    public void inicializarTablero(){
        for (int i = 0; i < this.casillas.length; i++){
            for (int j = 0; j < this.casillas[i].length; j++){
                Casilla casilla = new Casilla();
                casilla.setValor(0);
                casilla.setPosX(i);
                casilla.setPosY(j);
                casilla.setEditable(true);
                casilla.SectorSeugunPosicion();
                
                this.casillas[i][j] = casilla;
            }
        }
    }
    /*
     * Establece una nueva casilla en la posición que tenga configurada la misa
     * @param casilla
     */
    public void editarCasilla(Casilla casilla){
        this.casilla[casilla.getPosX()][casilla.getPosY()] = casilla;
    }
    /*
     * Reestablecer el valor de la casilla según su posición
     * @param x: posición horizontal.
     * @param y: posición vertical.
     */
    public void reestablecerCasillaPorPosicion(int x, int y){
        this.casilla[x][y].setValor(0);
    }
    /*
     * Inserta los valores de la matriz en la misma casilla respecto a su posición. Ha tenido que inicializarse la matriz previamente.
     * Matriz de enteros entre 0 y 9.
     * @param matriz Matriz 
     */
    public void insertarValores(int[][] matriz){
        for (int i=0; i<matriz.length; i++){
            for (int j=0; j< matriz[i].length; i++){
                this.casillas[i][j].setEditable(false);
            }
            this.casillas[i][j].setValor(matriz[i][j]);
        }
    }
}
