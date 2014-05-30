


import java.util.Arrays;
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
    
    public gilmore(){};
    public gilmore(int [][] estadistica, int [][] distancia){
        this.estadisticas = estadistica;
        this.distancia = distancia;

    }
    
    public float g(int[] asignado) {
        float cost = 0;
        for(int i=0; i < asignado.length; ++i) {
            for(int j=0; j < asignado.length; ++j) {
                if(asignado[i] != -1 && asignado[j]!= -1) cost += estadisticas[i][j]*distancia[asignado[j]][asignado[i]];
            }
            
        }
        return cost;
    }
    
    public float[][] termino2(Vector<Integer> pendiente, int[] asignado, int pos, float costeFijo) {
        float [][] matriz2 = new float [pendiente.size()][pendiente.size()];
        int l = 0;
        for(int i =0; i < pendiente.size();++i) {
            for(int j = 0; j < asignado.length; ++j) {
                if(asignado[j] == -1 ) {
                    asignado[j] = pendiente.get(i);
                    float cost = g(asignado);
                    matriz2[i][l] = cost - costeFijo;
                    ++l;
                    asignado[j] = -1;
                }
                
            }
            l = 0;
            
            
            
           /* for(int j = 0; j < pendiente.size();++j){
                   for(int k = 0; k <= pos; ++k) {
                       matriz2[i][j] += estadisticas[k][pendiente.get(i)] * distancia[asignado[k]][j+pos+1];
                   } 
            }*/
        }
        return matriz2;
    }
    
    public float [][] termino3 (Vector<Integer> pendiente, int[] asignado, int pos) {
        int mida = asignado.length-pendiente.size();
        float [][] matriz3 = new float[pendiente.size()][pendiente.size()];
        float [][] flujo = new float [pendiente.size()][pendiente.size()];
        float [][] distancias = new float [pendiente.size()] [pendiente.size()];
        float [] flux = new float [pendiente.size()];
        float [] dist = new float [pendiente.size()];
       
        int k = 0; int m = 0;
        for (int i = 0; i < asignado.length; ++i) {
            if (asignado[i] == -1) {
                for (int j = 0; j < asignado.length; ++j) {
                    if (asignado[j] == -1) {
                        dist[k] = distancia[i][j];
                        ++k;
                    }
                }

                Arrays.sort(dist);
                for (int f = 0; f < pendiente.size(); ++f) distancias[m][f] = dist[f];
                ++m;
            }
            k = 0;
        }

        k = 0; m = 0;
        for (int i = mida; i < asignado.length; ++i) {
            for (int j = mida; j < asignado.length; ++j) {
                flux[k] = estadisticas[i][j];
                ++k;
            }
            Arrays.sort(flux);
            for (int f = 0; f < pendiente.size(); ++f) flujo[m][f] = flux[f];
            k =0;
            ++m;
        }
        int suma;
        for(int i = 0; i < pendiente.size(); ++i){
            for(int j = 0; j < pendiente.size(); ++j){
                suma = 0;
                m = pendiente.size()-1;
                for( k=0; k < pendiente.size(); ++k){
                   suma += distancias[i][k]*flujo[j][m];
                   --m;
                }
                matriz3[i][j] = suma;
            }
        }
        return matriz3;
    
        /*for(int i=0;i<pendiente.size();i++) {
            for(int j=0;j<i;j++) flujo[i][j] = estadisticas[i][j];
            for(int j=i+1;j<pendiente.size();j++) flujo[i][j-1] = estadisticas[i][j];
            
        }
        for(int i=0;i<pendiente.size();i++) {
            for(int j=0;j<i;j++) distancias[i][j] = distancia[pos+i+1][pos+1+j];
            for(int j=i+1;j<pendiente.size();j++) distancias[i][j-1] = distancia[pos+1+i][pos+1+j];
            
        }
        
        
        
        
        /*for(int i=0; i < pendiente.size();++i) {
            for(int j = 0; j < pendiente.size();++j) {
                flujo[i][j] = estadisticas[i][j];
                distancias[i][j] = distancia [i+pos+1][j+pos+1];
              //  flujo[i][j] = estadisticas[pendiente.get(i)][pendiente.get(j)];
              //  distancias[i][j] = distancia [asignado[i+pos+1]][asignado[j+pos+1]];
            }
        }*/
        /*System.out.println("Mida matriz flujo "+ flujo.length + " " + flujo[0].length);

        
        Comparator<Integer> comparator = Collections.reverseOrder();
        for(int k=0; k < pendiente.size();++k) {
            System.out.println("k ");
            for(int i=0; i < pendiente.size();++i) {
                System.out.println("i");
                Vector<Integer> flux = new Vector<Integer> ();
                Vector<Integer> distancia = new Vector<Integer> ();
                for( int j = 0; j < pendiente.size()-1;++j) {
                    System.out.println("j ");
                    if(i != j){
                        flux.add(flujo[i][j]);
                        distancia.add(distancias[j][i]);
                    }
                    
                }
                System.out.println("mida flux " +flux.size());
                System.out.println("mida distancia " +distancia.size());
                Collections.sort(flux);
                Collections.sort(distancia,comparator);
                for(int j=0; j < distancia.size();++j) {
                    System.out.println("matriz" + j);
                     matriz3[i][k] += flux.get(j) * distancia.get(j);
                     
                }
                System.out.println("sale");
               
            }          
        }*/
        
    }
    
    
    
    
    public float h(Vector<Integer> pendiente, int[] asignado, int pos,float costeFijo) {
        float [][] matriz2 = termino2 (pendiente,asignado,pos,costeFijo);
        float [][] matriz3 = termino3 (pendiente,asignado,pos);
        float [][] matriz = new float[matriz2[0].length][matriz2[0].length];
        for(int i = 0; i < matriz2[0].length; ++i) {
            for(int j = 0; j < matriz2[0].length;++j) {
                matriz[i][j] = matriz2[i][j]+ matriz3[i][j];
            }
        }
        hungar hungaro = new hungar();
        float cost = hungaro.eje(matriz);
        return cost;
    }
    
    
    public double calcularCoste(Vector<Integer> pendiente, int[] asignado, int pos) {;
        float costeReal = g(asignado); 
        float costeAprox=0;
        if(!pendiente.isEmpty()) costeAprox = h(pendiente,asignado,pos,costeReal);   
        return costeReal+costeAprox;
    }
}

/*
    
    
   /* public float ejecutarGilmore(int[][] similitud, double[][] distancia, Integer[] asignaciones, Vector<Integer> pendientes) {
        
        //calculo del primer termino del Gilmore
        int n = asignaciones.length;
        int m = asignaciones.length - pendientes.size();
        float primer_termino = primerTermino(similitud, distancia, asignaciones, n);
        if (pendientes.size() > 0) { // si la solución es total, pendientes = 0
            float[][] matrizDeCoste = new float[n-m][n-m];
            float[][] matrizAux = new float[n-m][n-m];
      
            //calculo del segundo termino del Gilmore
            float[][] C1 = new float[n-m][n-m];
            float segundo_termino;
            int l = 0;
            for (int i = 0; i < pendientes.size(); ++i) {
                int cont = 0;
                for (int j = 0; j < n; ++j) {
                    if (asignaciones[j] == -1) {
                        ++cont;
                        asignaciones[j] = pendientes.get(i);                        
                        segundo_termino = primerTermino(similitud, distancia, asignaciones, n);
                        C1[i][l] = segundo_termino-primer_termino;
                        ++l;
                        asignaciones[j] = -1;
                    }
                }
                l = 0;
            }
            
            //calculo del tercer termino del Gilmore
            float[][] c2 = C2(similitud, distancia, n-m, asignaciones, m);
            float[][] C2 = new float[n-m][n-m];
            for(int i =0; i <l; ++i){
                for(int j= 0; j <l; ++j){
                    C2[i][j] = c2[i][j];
                }
            }            
            matrizDeCoste = sumaMatrices(C1, C2);
            matrizAux = sumaMatrices(C1, C2);
            int[][] hungar = h.calcularAsignaciones(matrizDeCoste);
            int X = 0; int Y = 0;
            float total = 0;
            for (int i = 0; i < hungar.length; ++i) {
                for (int j = 0; j < hungar[0].length; ++j) {
                    if (j == 0) X = hungar[i][j];
                    else Y = hungar[i][j];
                }
                total += matrizAux[X][Y];
            }
            return primer_termino+total;
        }
        else {
            return primer_termino; 
        }
    }
    
    /**
     * pre: n = asignaciones.length
     * post: devuelve el coste de las posiciones ya asignadas (primer termino)
     */
  /*  private float primerTermino(int[][] similitud, double[][] distancia, Integer[] asignaciones, int n) {
        float primer_termino = 0;
            for (int i = 0; i < n; ++i) {
                if (asignaciones[i] != -1) {
                    for (int j = i+1; j < n; ++j) {
                        if (asignaciones[j] != -1) primer_termino+= 2*similitud[i][j]*distancia[asignaciones[i]][asignaciones[j]];
                    }
                }
            }
        return primer_termino;
    }
    
    /**
     * pre: -
     * post: matriz con los costes aproximados únicamente de las posibles relacioens entre los libros no asignados
     */
  /*  private float[][] C2(int[][] similitud, double[][] distancia, int l, Integer[] asignaciones, int a) {
        double[][] aux1 = new double[l][l];
        int[][] aux2 = new int[l][l];
        double[] dist = new double[l];
        int[] flux = new int[l];
        int k = 0; int m = 0;
        for (int i = 0; i < asignaciones.length; ++i) {
            if (asignaciones[i] == -1) {
                for (int j = 0; j < asignaciones.length; ++j) {
                    if (asignaciones[j] == -1) {
                        dist[k] = distancia[i][j];
                        ++k;
                    }
                }
                Arrays.sort(dist);
                for (int f = 0; f < l; ++f) aux1[m][f] = dist[f];
                ++m;
            }
            k = 0;
        }
        k = 0; m = 0;
        for (int i = a; i < asignaciones.length; ++i) {
            for (int j = a; j < asignaciones.length; ++j) {
                flux[k] = similitud[i][j];
                ++k;
            }
            Arrays.sort(flux);
            for (int f = 0; f < l; ++f) aux2[m][f] = flux[f];
            k =0;
            ++m;
        }
        int suma;
        float[][] c2 = new float[l][l];
        for(int i = 0; i < l; ++i){
            for(int j = 0; j < l; ++j){
                suma = 0;
                m = l-1;
                for( k=0; k < l; ++k){
                   suma += aux1[i][k]*aux2[j][m];
                   --m;
                }
                c2[i][j] = suma;
            }
        }
        return c2;
    }
        
    /**
     * pre: -
     * post: matriz C1+C2
     */
 /*   private float[][] sumaMatrices(float[][] C1, float[][] C2) {
        float[][] result = new float[C1.length][C1[0].length];
        for (int i = 0; i < C1.length; ++i) {
            for (int j = 0; j < C1[0].length; ++j) {
                result[i][j] = C1[i][j]+C2[i][j];
            }
        }
        return result;
    }
}*/
