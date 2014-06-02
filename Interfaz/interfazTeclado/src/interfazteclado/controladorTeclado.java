/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package enunciadoteclado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author gabriel
 */
public class controladorTeclado {
	
//	Atributos
	
    
//	Metodos
    public teclado crearTeclado(String formaTeclado, int numeroFilas, int numeroColumnas, int numeroPosiciones, boolean teclas4Lados) {
        teclado tec = new teclado(formaTeclado, numeroFilas, numeroColumnas, numeroPosiciones, teclas4Lados);
        return tec;
    }


    public void cambiarForma(teclado tec, String tipoTeclado) {
	tec.setForma(tipoTeclado);
    }
    
    public void cambiarNumeroFilas(teclado tec, int tamano) {
        tec.setNumeroFilas(tamano);
    }
    
    public void cambiarNumeroColumnas(teclado tec, int tamano) {
        tec.setNumeroColumnas(tamano);
    }
    
    public void cambiarTeclasDe4Lados(teclado tec, boolean b) {
        tec.setTeclasDe4Lados(b);
    }
    
    public void cambiarNumeroPosiciones(teclado tec, int numeroPosiciones) {
        tec.setNumeroPosiciones(numeroPosiciones);
    }
    
    
    
}
