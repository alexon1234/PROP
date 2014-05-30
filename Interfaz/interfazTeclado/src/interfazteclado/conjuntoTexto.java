package interfazteclado;
import java.io.IOException;
import java.util.LinkedList ;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex + josep
 */
public class conjuntoTexto {
    private ArrayList<texto> conjunto;
    private int numero_textos;
    
    /**
     * Creadoras.
     */
    
    /**
     * Creadora por defecto. Crea un conjunto de textos vacío.
     */
    
    public conjuntoTexto() {
        this.conjunto = new ArrayList<texto>();
        this.numero_textos = 0;   
    }
    
    /**
     * Consultoras.
     */
    
    /**
     * Consultar número de textos.
     */
    public int getSizeConjunto() {
        return numero_textos;
    }
    
    /**
     * Consultar un texto. Se consulta un texto a partir de un índice.
     * @param i
     * @throws IllegalArgumentException.
     */
    public texto getTextoI(int i) {
        return this.conjunto.get(i);
    }
    
    /**
     * Leer textos. Se leen todos los textos del conjunto.
     * @throws java.io.IOException
     */
    public void leerTextos() throws IOException{
        controladorTexto Ct = new controladorTexto();
        for(int i=0; i < conjunto.size();++i){
            Ct.abrirTexto(conjunto.get(i).titulo + ".txt");
            Ct.leerTexto();    
        }
    }
    
    /**
     * Modificadoras.
     */
    
    /**
     * Insertar un texto. Se inserta un nuevo texto en el conjunto.
     * @param text 
     */
    public void insertarTexto(texto text) {
        this.conjunto.add(text);
        ++numero_textos;
    }

    /**
     * Borrar texto.
     * @param text
     */
    public void borrarTexto(texto text) {
        int n = conjunto.size();
        ArrayList<texto> textos = new ArrayList<texto>(n-1);
        for(int i=0; i < n; ++i) {
            if(conjunto.get(i) != text) {
               textos.add(conjunto.get(i));
            }
        }
        conjunto = textos;
    }

}
