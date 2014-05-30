
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class gilmore {
    
    private int[][] estadisticas;
    private int[][] distancia;
    
    public gilmore(int [][] estadistica, int [][] distancia){
        this.estadisticas = estadistica;
        this.distancia = distancia;
    }
    
    public double g(int[] asignado, int pos) {
        double cost = 0;
        for(int i=0; i < pos;++i) {
            for(int j=0; j < pos; ++j) {
                cost += estadisticas[asignado[i]][asignado[j]]*distancia[i][j];
                cost += estadisticas[asignado[j]][asignado[i]]*distancia[j][i];   
            }
            
        }
        return cost;
    }
    
    public double[][] termino2(Vector<Integer> pendiente, int[] asignado, int pos) {
        double [][] matriz2 = new double [pendiente.size()][pendiente.size()];
        for(int i =0; i < pendiente.size();++i) {
            for(int j = 0; j < pendiente.size();++j){
                   for(int k = 0; k < pos; ++k) {
                       matriz2[i][j] += estadisticas[asignado[k]][pendiente.get(i)] * distancia[k][j+pos+1];
                   } 
            }
        }
        return matriz2;
    }
    
    public double[][] termino3 (Vector<Integer> pendiente, int[] asignado, int pos) {
        double [][] matriz3 = new double[pendiente.size()][pendiente.size()];
        int [][] flujo = new int [pendiente.size()][pendiente.size()];
        int [][] distancias = new int [pendiente.size()] [pendiente.size()];
        for(int i=0; i < pendiente.size();++i) {
            for(int j = 0; j < pendiente.size();++j) {
                flujo[i][j] = estadisticas[pendiente.get(i)][pendiente.get(j)];
                distancias[i][j] = distancia [i+pos+1][j+pos+1];
            }
        }

        Comparator comparator = Collections.reverseOrder();
        for(int k=0; k < pendiente.size();++k) {
            Vector<Integer> flux = new Vector<Integer> ();
            Vector<Integer> distancia = new Vector<Integer> ();
            for(int i=0; i < pendiente.size();++i) {
                for( int j = 0; j < pendiente.size();++j) {
                    flux.add(flujo[i][j]);
                    distancia.add(distancias[j][i]);
                }
                Collections.sort(flux);
                Collections.sort(distancia,comparator);
                for(int j=0; j < pendiente.size();++j) {
                     matriz3[k][i] += flux.get(j) * distancia.get(j);
                }
               
            }
            
           
        }
        return matriz3;
        
    }
    
    
    
    
    public double h(Vector<Integer> pendiente, int[] asignado, int pos) {
        double [][] matriz2 = termino2 (pendiente,asignado,pos);
        double [][] matriz3 = termino3 (pendiente,asignado,pos);
        double [][] matriz = new double[matriz2[0].length][matriz2[0].length];
        for(int i = 0; i < matriz2[0].length; ++i) {
            for(int j = 0; j < matriz2[0].length;++j) {
                matriz[i][j] = matriz2[i][j]+ matriz3[i][j];
            }
        }
        hung hung = new hung();
        double cost = hung.eje(matriz);
        
        
        
        return cost;
    }
    
    
    public double calcularCoste(Vector<Integer> pendiente, int[] asignado, int pos) {
        return g(asignado,pos)+ h(pendiente,asignado,pos);   
    }
}
