


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
public class estadisticas extends afinidad {
    
    int mida;
    
    /**
     *
     */
    public estadisticas() {
        super(0);
        this.mida = 0;
    }
    
    
    /**
     *
     * @param mida
     */
    public estadisticas(int mida) {
        super(mida);
        this.mida = mida;
    }
  
    /**
     *
     * @param letra1
     * @param letra2
     * @param similitud
     */
    public void insertarEstadistica (int i,int j,double similitud) {
      System.out.println("Se a insertado en la posicion "+ similitud );
      insertarAfinidad(i,j,similitud);
      
    }

    /**
     *
     * @param letra1
     * @param letra2
     * @return
     */
    public double consultarEstadistica (int i,int j) throws IOException{
      return consultarAfinidad(i,j);
    
    }

    /**
     *
     * @throws IOException
     */
    public void leerMatriz() throws IOException {
        for(int i=0; i < mida; ++i) {
            for (int j=0; j < mida; ++j) {
                System.out.print (consultarEstadistica(i,j) + " ");
            }
            System.out.println("");
        }
    }
    
}
