/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enunciadoteclado;

import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class controladorAlfabeto {
    private alfabeto alfabetoControlador;
    
    /**
     * Creadoras.
     */
    
    /**
     * Creadora por defecto. Crea un alfabeto cuando el usuario quiere añadir un alfabeto.
     */
    public controladorAlfabeto() {
        alfabetoControlador = new alfabeto();        
    }
    
    /**
     * Creadora. Crea un alfabeto con el nombre y el numero de caracteres pasados por parametro.
     * @param idioma
     * @param n 
     * @throws IllegalArgumentException.
     */
    public controladorAlfabeto (String idioma, int n) {
        if (n < 1) throw new IllegalArgumentException("Error al crear alfabeto: n < 1"); 
        alfabetoControlador = new alfabeto(idioma, n);
    }
    
    /**
     * Creadora copia. Crea una copia del alfabeto pasado por parametro explícito.
     * @param original 
     */
    public controladorAlfabeto (alfabeto original) {
        alfabetoControlador = new alfabeto(original);
    }
    
    /**
     * Modificadoras.
     */
    
    /**
     * Añadir simbolo. Añadir un nuevo simbolo al alfabeto.
     * @param newsimbolo
     */
    public void addSimbolo (simbolo newsimbolo) {
        alfabetoControlador.addSimbolo(newsimbolo);
    }
    
    /**
     * Escritoras.
     */
    
    /**
     * Escribir Alfabeto. Escribe todos los caracteres del alfabeto por pantalla.
     */
    public void escribirAlfabeto() {
        alfabetoControlador.escribirAlfabeto();
    }
}
