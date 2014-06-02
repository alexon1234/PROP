/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;


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
     * Constructora por defecto
     */
    public texto(){
		this.idioma  = null;
		this.titulo = null;
		this.numeroCaracteres = 0;
    }
    
    /**
     * Constructora completa
     * @param idioma String con el idioma del texto
     * @param titulo String con el titulo del texto0
     * @param numeroCaracteres
     */
    public texto(String idi, String tit, int nC) {
        idioma = idi;
        titulo = tit;
        numeroCaracteres = nC;
    }
    /**
     * Metodo para insertar un idioma en un texto
     * @param i Nombre del idiomaque tendra el texto
     */
    public void setIdioma(String i) {
        if (i.length() < 1) {
            throw new IllegalArgumentException("Error en el nombre del idioma: length() < 1");
	}
        idioma = i;

    }
	
	
    /**
     * Metodo que devuelve el idioma de un texto
     * @return el idioma de un texto
     */
    public String getIdioma(){
        return idioma;
    }

    /**
     * Metodo que inserta un titulo a un texto
     * @param t Titulo que quieres dar al texto
     */

    public void setTitulo(String t) {
        if (t.length() < 1) {
            throw new IllegalArgumentException("Error en el titulo: length() < 1");
	}
        titulo = t;
    }
		
    /**
     * Metodo que devuelve el titulo
     * @return el titulo de un texto
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Inserta el numero de caracteres de un texto
     * @param n Inserta el numero de caracteres de un texto
     */

    public void setNumeroCaracteres(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Error en el numero de caracteres: numeroCaracteres < 1");
	}
        numeroCaracteres = n;

    }
	
	
    /**
     * Metodo que devuelve el numero de caracteres
     * @return el numero de caracteres
     * 
     */
    public int getNumeroCaracteres(){
        return numeroCaracteres;
    } 
    
    
}