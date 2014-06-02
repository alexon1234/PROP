/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author alejandro.del.amo.gonzalez
 */
public class hungariano {
    
    
    public int[][] calcularHungariano(int [][] matrix) {
        int [][] aux = copiaMatriz(matrix);
        reducirCoste(aux);
        int [][] compruebo = copiaMatriz(aux);
        while(!todoCubierto(compruebo)) {
            int min = minimoNumero(compruebo);
            for(int i=0; i < compruebo.length;++i) {
                for(int j=0; j < compruebo[0].length;++j) {
                    matrix[i][j] -= min;
                }
            }
        } 
        return matrix;
    }
    public int[][] copiaMatriz(int [][] matrix) {
        int [][] aux = new int[matrix.length][matrix[0].length];
        for(int i=0; i < matrix.length; ++i){
            for(int j = 0; j < matrix.length; ++j) {
                aux[i][j] = matrix[i][j];
            }
        }
        return aux;
    }
    
    public void reducirCoste(int [][] matrix ) {
        for (int i = 0; i < matrix.length; i++) {
            int  minimoFila = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (minimoFila > matrix[i][j]) {
                    minimoFila = matrix[i][j];
                }
            }
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= minimoFila;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int minimoCol = Integer.MAX_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (minimoCol > matrix[j][i]) {
                    minimoCol = matrix[j][i];
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] -= minimoCol;
            }

        }

    }
    public int minimoNumero(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length;++i) {
            for(int j =0; j < matrix[0].length;++j) {
                if(min > matrix[i][j]) min = matrix[i][j];
            } 
        }
        return min;
    }
    
    
    
    
    public boolean todoCubierto(int [][] matrix) {
        int NLineas = 0;
        boolean fin = false;
        int min = minimoNumero(matrix);
        int [][] aux = copiaMatriz(matrix);
        while(!fin) {
            for(int i=0; i < aux.length; ++i) {
                for(int j = 0; j < aux[0].length;++j) {
                    if(aux[i][j] == 0) {
                        //Miro si hay mas zeros en la fila
                        int contFila = 0;
                        for(int k = 0; k < aux.length;++k) {
                            if(aux[i][k] == 0 && k != j) ++contFila;
                        }
                        //Miro si hay mas zeros en la columna
                        int contCol = 0;
                        for(int k = 0; k < aux[0].length; ++k) {
                            if(aux[k][j] == 0 && k != i) ++contCol;
                        }
                        if(contFila == 0 && contCol == 0) {
                            ++NLineas;
                            for(int k =0; k < aux.length;++k) aux[i][k] += min;
                        }
                        else if(contFila > contCol) {
                            ++NLineas;
                            for(int k = 0; k < aux.length;++k) aux[i][k] += min;
                        }
                        else if(contFila < contCol) {
                            ++NLineas;
                            for(int k = 0; k < aux[0].length;++k) aux[k][j] += min;
                        }

                    }
                }
            }
            fin = true;
            for(int i=0; i < aux.length;++i) {
                for(int j = 0; j < aux[0].length;++j) {
                    if(aux[i][j] == 0) fin = false;
                }
            }
        }
        if(NLineas == matrix[0].length) return true;
        else {
            matrix = aux;
            return false;
        }
        
    }
 
    
}
