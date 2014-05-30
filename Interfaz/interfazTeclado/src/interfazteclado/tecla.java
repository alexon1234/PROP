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
public class tecla {
    
//  Atributos
    private char nombre;
    private int fila;
    private int columna;
    
//  Metodos
    public tecla() {}			    //constructor por defecto
    
    /**
     * Creadora por defecto de tecla
     * @param n:    nombre tecla
     * @param x:    numero de fila
     * @param y:    numero de columna
     */
    public tecla(char n, int x, int y) {    //constructor
	setNombre(n);
	setFila(x);
	setColumna(y);
    }
        
    /**
     * setNombre.   Asigna un nombre a la tecla
     * @param n:    caracter/nombre de la tecla
     */
    public void setNombre(char n) {
	nombre = n;
    }
    
    /**
     * getNombre.   Obtiene el nombre de la tecla
     * @return:     Devuelve el nombre de la tecla
     */
    public char getNombre() {
	return nombre;
    }
    
    /**
     * setFila.     Asigna la fila a la tecla
     * @param x:    Numero de la fila de la tecla
     */
    public void setFila(int x) {
	if (x < 0) {
	    System.out.println("Error: fila negativa");
	    return;
	}
	fila = x;
    }
    
    /**
     * getFila.     Obtiene la fila de la tecla
     * @return:     Devuelve la fila de la tecla
     */
    public int getFila() {
	return fila;
    }
    
    /**
     * setColumna.  Asigna una columna a la tecla
     * @param y:    Numero de la columna de la tecla
     */
    public void setColumna(int y) {
	if (y < 0) {
	    System.out.println("Error: columna negativa");
	    return;
	}
	columna = y;
    }

    /**
     * getColumna.  Obtiene la fila de la tecla
     * @return:     Devuelve la fila de la tecla
     */
    public int getColumna() {
	return columna;
    }
}
