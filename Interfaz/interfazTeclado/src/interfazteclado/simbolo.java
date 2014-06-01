/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

/**
 *
 * @author josep
 */
public class simbolo {
    private char caracter; 
    
    /**
     * Constructoras.
     */
    
    /**
     * Constructora por defecto. Inicializamos a 0 porque no se puede poner
     * un char a null.
     */
    public simbolo() {
        this.caracter = 0;
    }
    
    /**
     * Constructora
     * @param c que contendrá el simbolo creado.
     */
    public simbolo(char c) {
        this.caracter = c;
    }
    
    /**
     *Constructora copia
     * @param original simbolo que se va a copiar.
     */
    public simbolo(simbolo original) {
        if (original.caracter == 0) this.caracter = 0;
        else this.caracter = original.caracter;
    }
    
    /**
     * Consultoras.
     */
    
    /**
     * Devuelve la informacion del simbolo.
     * @return 
     */
    public char getInfo() throws IllegalArgumentException {
        if (this.caracter == 0) throw new IllegalArgumentException("Error al consultar la informacion del simbolo: referencia nula");
        return this.caracter;
    }
    
    /**
     * Modificadoras.
     */
    
    /**
     * Modifica el caracter del simbolo.
     * @param newchar El nuevo caracter asociado al simbolo.
     */
    public void setInfo(char newchar) {
        this.caracter = newchar;
    }   
}
