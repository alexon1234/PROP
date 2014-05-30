/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

/**
 *
 * @author gabriel
 */
public class distancia extends distanciaCluster {
    
//  Atributos 
    private String formaTeclado;
    private int primerasPosicionesForma[];
	
	
//  Metodos    

    /** 
     * Creadora por defecto de distancia.
     */
        public distancia() {}
    
    /**
     * distancia.   Creadora de la matriz de distancias con nF filas, nC columnas, nP posiciones y forma fT
     * @param nF:   numero de filas de la matriz
     * @param fT:   forma del teclado
     * @param nC:   numero de columnas de la matriz
     * @param nP:   numero de posiciones de la matriz
     */
    public distancia(String fT, int nF, int nC, int nP){
		super(nF, nC, nP);
		primerasPosicionesForma = new int[nF];
		setFormaTeclado(fT);
    }
    
    
    /**
     * setFormaTeclado.	Asigna una forma al teclado
     * @param fT:	forma del teclado
     */
    public void setFormaTeclado(String fT) {
		if (!(fT).equals("rectangular") && !(fT).equals("hexagonal") && !(fT).equals("dosHexagonos")) {
			throw new IllegalArgumentException("Error en el nombre del teclado:" + 
					" rectangular || hexagonal || dosHexagonos");
		}
		formaTeclado = fT;
    }
    
    
    /**
     * getFormaTeclado.	Obtiene la forma del teclado
     * @return		Devuelve la forma del teclado
     */
    public String getFormaTeclado() {
            return formaTeclado;
    }

	
    /**
     * setPrimeraPosicionForma.	Asigna la posicion inicial de una fila al vector de primerasPosiciones
     * @param numeroFila:	numero de fila al que se quiere asignar la posicion
     * @param posicion		posicion que se quiere asignar al numero de fila
     */
    public void setPrimeraPosicionForma(int numeroFila, int posicion) {
		if (numeroFila < 0 || numeroFila > getNumeroFilas() - 1) {
				throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: nF < 0 || nF > numeroFilas -> " + (getNumeroFilas() - 1));
			}
		if (posicion < 0 || posicion > getNumeroPosiciones() - 1) {
				throw new IllegalArgumentException("Error al asignar la primera posicion de una fila: pos < 0 || pos > numeroPosiciones -> " + (getNumeroPosiciones() - 1));
			}
		primerasPosicionesForma[numeroFila] = posicion;
	}
    
    /**
     * getPrimeraPosicionForma. Obtiene la primera posicion de una fila
     * @param numeroFila:	fila de la que se quiere obtener la primera posicion
     * @return			Devuelve la primera posicion de la fila numeroFila
     */
    public int getPrimeraPosicionForma(int numeroFila) {
		return primerasPosicionesForma[numeroFila];
    }

}
