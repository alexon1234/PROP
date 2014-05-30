package interfazteclado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

/**
 *
 * @author gabriel
 */

/*enum TipoTeclado {
    rectangular,
    hexagonal,
    dosHexagonos,
}*/

public class teclado {
    
//  Atributos
    private String formaTeclado;
    private int numFilas;
    private int numCols;
    private int numeroPosiciones;
    private boolean teclasDe4Lados;
    
//  Metodos
	public teclado() {}				     //constructor por defecto

	public teclado(String fT, int nF, int nC, int nP, boolean t4) {    //construct
		setForma(fT);
		setNumeroFilas(nF);
		setNumeroColumnas(nC);
		setNumeroPosiciones(nP);
		setTeclasDe4Lados(t4);
	}

	/**
	 * setForma.    Asigna una forma al teclado
	 * @param tt    forma del teclado
	 */
	public void setForma(String tt) {
		if (!(tt).equals("rectangular") && !(tt).equals("hexagonal") && !(tt).equals("dosHexagonos")) {
			throw new IllegalArgumentException("Error en el nombre del teclado:" + 
					" rectangular || hexagonal || dosHexagonos  -->" + tt + "<---");
		}
		formaTeclado = tt;
	}

	/**
	 * getForma.    Obtiene la forma del teclado
	 * @return      Devuelve la forma del teclado
	 */
	public String getForma() {
		return formaTeclado;
	}

	/**
	 * setNumeroFilas. Asigna el numero de filas del teclado
	 * @param nf    numero de filas del teclado
	 */
	public void setNumeroFilas(int nf) {
		if (nf < 0) {
			throw new IllegalArgumentException("Error en el numero de filas del teclado: numeroFilas < 0");
		}
		numFilas = nf;
	}

	/**
	 * getNumeroFilas. Obtiene el numero de filas del teclado
	 * @return      Devuelve el numero de filas del teclado
	 */
	public int getNumeroFilas() {
		return numFilas;
	}

	/**
	 * setNumeroCols.  Asigna el numero de columnas del teclado
	 * @param nc    numero de columnas del teclado
	 */
	public void setNumeroColumnas(int nc) {
		if (nc < 0) {
			throw new IllegalArgumentException("Error en el numero de columnas del teclado: numeroColumnas < 0");
		}
		numCols = nc;
	}

	/**
	 * getNumeroCols.  Obtiene el numero de columnas del teclado
	 * @return      numero de columnas del teclado
	 */
	public int getNumeroColumnas() {
		return numCols;
	}

	/**
	 * setTeclasDe4Lados.   Asigna el numero de lados de las teclas del teclado
	 * @param b             b = 1: 4 lados. b = 0: 6 lados
	 */
	public void setTeclasDe4Lados(boolean b) {
		teclasDe4Lados = b;
	}

	/**
	 * getTeclasDe4Lados.   Obtiene el numero de lados de las teclas del teclado
	 * @return              Devuelve el numero de lados de las teclas del teclado
	 */
	public boolean getTeclasDe4Lados() {
		return teclasDe4Lados;
	}

	/**
	 * setNumeroPosiciones. Asigna el numero de posiciones de la matriz
	 * @param nP            numero de posiciones de la matriz
	 */
	public void setNumeroPosiciones(int nP) {
		if (nP < 0 || nP > getNumeroFilas()*getNumeroColumnas()) {
			throw new IllegalArgumentException("Error al asignar las posiciones: numeroPosiciones < 0 || numeroPosiciones > numeroFilas*numeroColumnas");
		}
		numeroPosiciones = nP;
	}

	/**
	 * getNumeroPosiciones. Obtiene el numero de posiciones de la matriz 
	 * @return              Devuelve el numero de posiciones de la matriz
	 */
	public int getNumeroPosiciones() {
		return numeroPosiciones;
	}
    
}
