package enunciadoteclado;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class afinidad {
    public double[][] afinidades;
    
    /**Constructora por defecto
     *
     * @param mida Mida que tendra la matriz de afinidades
     */
    public afinidad(int mida) {
        afinidades= new double[mida][mida];
    }

    /**Incrementa el valor de una posicion de la matriz de afinidades
     *
     * @param i posicion de la matriz de afinidades 
     * @param j posicion de la matriz de afinidades
     * @param afinidad valor que tomara la posicion [i][j]
     */
    public void insertar_afinidad(int i,int j,double afinidad) {
        try {
            afinidades[i][j] += afinidad;
            afinidades[j][i] += afinidad;
        }
        catch(Exception e)  {
            System.out.println("Error:Posicion erronia");
        }
    
    }
    /**Consula la afinidad de una posicion de la matriz 
     *
     * @param i posicion de la matriz de afinidades
     * @param j posicion de la matriz de afinidades
     * @return el valor que toma de la posicion [i][j] 
     * @throws IOException cuando la matriz no es simetrica
     */
    public double consultar_afinidad(int i,int j) throws IOException {
        if(afinidades[i][j] != afinidades[j][i]){
            throw new IOException("Error:Matrices no simetricas");
        }
        return afinidades[i][j];
    }
}   
    
    

