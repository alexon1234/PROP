/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfazteclado;

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
*/

/**
 *
 * @author alex + gabriel
 */
public class texto {
    String ruta;
    String idioma;
    String titulo;
    int numeroCaracteres;
    
    /**
     * Creadora por defecto.
     */
    public texto(){
        this.ruta = null;
	this.idioma  = null;
	this.titulo = null;
	this.numeroCaracteres = 0;
    }
    
    /**
     * Creadora.
     * @param idioma
     * @param titulo
     * @param numeroCaracteres
     */
    public texto(String idi, String tit, int nC, String rt) {
        ruta = rt;
        idioma = idi;
        titulo = tit;
        numeroCaracteres = nC;
    }

    /**
    *
    * @param i
    */
    public void setIdioma(String i) {
    	if (i.length() < 1) {
		throw new IllegalArgumentException("Error en el nombre del idioma: length() < 1");
	}
	idioma = i;
    }
		
    /**
     *
     * @return
     */
    public String getIdioma(){
        return idioma;
    }

    /**
    *
    * @param t
    */
    public void setTitulo(String t) {
	if (t.length() < 1) {
		throw new IllegalArgumentException("Error en el titulo: length() < 1");
	}
	titulo = t;
    }
    
    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
    *
    * @param n
    */
    public void setNumeroCaracteres(int n) {
	if (n < 1) {
		throw new IllegalArgumentException("Error en el numero de caracteres: numeroCaracteres < 1");
	}
        numeroCaracteres = n;
    }
		
    /**
     *
     * @return
     */
    public int getNumeroCaracteres(){
        return numeroCaracteres;
    } 

    /**
     *
     * @param ruta
     */
    public void setRuta (String ruta) {
        this.ruta = ruta;
    }

    /**
     *
     * @return
     */
    public String getRuta() {
        return ruta;
    }
     
}