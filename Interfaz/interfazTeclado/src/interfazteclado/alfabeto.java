package interfazteclado;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author josep
 */
public class alfabeto {
    private String nombreAlfabeto;
    private int numCaracteres;
    private ArrayList<simbolo> alf;
    
    /**
     * Creadoras.
     */
        
   /**
    * Creadora por defecto. Crea un alfabeto sin ningun simbolo asociado.
    */
    public alfabeto() {
        this.nombreAlfabeto = null;
        this.numCaracteres = 0;
        this.alf = new ArrayList<>();
    }
    
    /**
     * Creadora. Crea un alfabeto con el nombre 'idioma', de n simbolos.
     * @param idioma Nom de l'alfabet.
     * @param n Número de simbolos del alfabeto. 
     * @throws IllegalArgumentException.
     */
    public alfabeto(String idioma, int n) throws IllegalArgumentException {
        this();
        if (n < 1) throw new IllegalArgumentException("Error al crear alfabeto: n < 1");
        this.nombreAlfabeto = idioma;
        this.alf = new ArrayList<simbolo>(n);
    }
    
    /**
     * Creadora copia. Copia el alfabeto pasado por parametro explicito al parametro implícito.
     * @param original 
     */
    public alfabeto(alfabeto original) {
        this.nombreAlfabeto = original.nombreAlfabeto;
        this.numCaracteres = original.numCaracteres;
        this.alf = original.alf;
    }
    
    /**
     * Consultoras.
     */
        
    /**
     * Consultora del nombre del alfabeto del parámetro implícito.
     */
    public String getNombreAlfabeto() {
        return this.nombreAlfabeto;
    }
    
    /**
     * Consultora del numero de carácteres del alfabeto del parámetro implícito.
     */
    public int getNumCaracteres() {
        return this.numCaracteres;
    }
    
    /**
     * Consultora de un simbolo a partir de posición. Devuelve el símbolo de la posición pos.
     * @param pos.
     * @return 
     * @throws IllegalArgumentException.
     */
    public simbolo getSimbolo(int pos) {
        if (pos < 0) throw new IllegalArgumentException("Error al consultar: n < 1");
        if (pos > numCaracteres) throw new IllegalArgumentException("Error al consultar: pos > numCaracteres");
        return this.alf.get(pos);
    }
    
    /**
     * Consultora de si un simbolo existe. True si el simbolo esta en el alfabeto. False si no esta.
     * @param s.
     * @throws IllegalArgumentException.
     */
    public boolean boolSimbolo (simbolo s) {
        for (int i = 0; i < alf.size(); i++) if (s.getInfo() == alf.get(i).getInfo()) return true;
        return false;
    }
    
    /**
     * Consultora d'una posició a partir de un simbolo. Retorna la posición del símbolo s.
     * @param s.
     * @return  
     * @throws IllegalArgumentException.
     */
    public int getPosicion(simbolo s) {
        for (int i = 0; i < numCaracteres; i++) {
            if (this.alf.get(i).getInfo() == s.getInfo()) return i;
        }
        throw new IllegalArgumentException("Error: El simbolo no está en el alfabeto.");
    }
    
    /**
     * Modificadoras.
     */
    
    /**
     * Añadir simbolo. Se añade un neuevo simbolo al alfabeto.
     * @param newsimbolo.
     * @throws IllegalArgumentException.
     */
    public void addSimbolo (simbolo newsimbolo) {
        /*for (int i = 0; i < numCaracteres; i++) {
            if (newsimbolo.getInfo() == this.alf.get(i).getInfo()) {
                throw new IllegalArgumentException("Error: El simbolo ya está en el alfabeto.");
            }
        }*/
        this.alf.add(newsimbolo);
        ++numCaracteres;
    }
       
    /**
     * Escritoras.
     */
    
    /**
     * Escritura del alfabeto pasado por paramtro implícito.
     */
    public void escribirAlfabeto() {
        for (int i = 0; i < numCaracteres; i++) System.out.println (this.alf.get(i).getInfo() + " ");
    }
    
    @Override
    public String toString() {
        return nombreAlfabeto;
    }
}
