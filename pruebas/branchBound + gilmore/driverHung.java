
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class driverHung {
    public static void main (String[] args) {
        int [][] matrix = { {250,400,350},
                            {400,600,350},
                            {200,400,250} };
        
        /*                    {77,37,49,92},
                            {11,69,5,86},
                            {8,9,98,23} }; 

/*
                            {35,85,55,65},
                            {125,95,90,105},
                            {45,110,95,115} };*/
        hungaro h = new hungaro();
        int [][] matriz = h.assignaciones(matrix);
        for(int i=0; i < matriz.length;++i) {
            for(int j=0; j < matriz[0].length;++j) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
		 

         
        
    }
}
