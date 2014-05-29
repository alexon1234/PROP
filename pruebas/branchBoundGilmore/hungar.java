
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alejandro.del.amo.gonzalez
 */

import java.util.*;



public class hungar {
    
   
    private boolean[] filinicub;
    private boolean[] colinicub;
    private boolean[] filcub;
    private boolean[] colcub;
    private int[] filselec;
    private int[] colselec;
    private int a;

    public hungar() {
        filinicub = null;
        colinicub = null;
        filcub = null;
        colcub = null;
        filselec = null;
        colselec = null;
    }
    
    public double eje(double[][] M) {
        double [][] matriz = new double [M.length][M[0].length];
        for(int i=0; i < M.length;++i) {
            for(int j=0; j < M[0].length;++j) {
                matriz[i][j] = M[i][j];
            }
        }
        filinicub = new boolean[M.length]; //Fila cubierta
        if (M.length > 0) a = M[0].length;
        else a = 0;
        colinicub = new boolean[a]; // Columna cubierta
        ini(M);
        filselec = new int[M.length];         //Fila seleccionada
        colselec = new int[colinicub.length]; //Columna seleccionada
        int[] filnosel = new int[M.length];   //Fila no seleccionada
        for (int i = 0; i < M.length; ++i) {
            filselec[i] = -1;                 //No hay ninguna fila selecionada
            filnosel[i] = -1;
        }
        for (int j = 0; j < a; ++j) {
            colselec[j] = -1;                 //No hay columna seleccionada
        }
        inisel(M);
        filcub = new boolean[filinicub.length];
        colcub = new boolean[colinicub.length];
        cubcolceros();
        boolean aa = false;
        while (!aa) {
            int[] cerosel = selceros(M, filnosel);
            boolean entradainv = false;

            while (cerosel == null) {              
                if (!continua(M)) {
                    entradainv = true;
                    break;
                }
                cerosel = selceros(M, filnosel);
                entradainv = false;
            }
            if (entradainv) {
                break;
            }
            int columnIndex = filselec[cerosel[0]];
            if (-1 == columnIndex) {
                marceros(cerosel, filnosel);
                for (int i = 0; i < filnosel.length; ++i) filnosel[i] = -1;
                colcub = colinicub;
                filcub = filinicub;
                cubcolceros();
            } else {
                filcub[cerosel[0]] = true;
                colcub[columnIndex] = false;
            }
            aa = true;
            for (int i = 0; i < colcub.length && aa; ++i) {
                if(!colcub[i]) {
                    aa = false;
                }
            }
        }
        boolean trobat = false;
        for(int i=0; i < colselec.length;++i) {
            if(colselec[i] == -1) trobat = true;
        }
        if(trobat) System.out.println("trobat " + trobat);
        if(trobat) colselec = buscarSolucionAlternativa(matriz);
        double cost = 0;
        int[][] retval = new int[a][];
        for (int i = 0; i < a; i++) {
            if (colselec[i] != -1) {
                cost += matriz[colselec[i]][i];
                retval[i] = new int[]{colselec[i], i};
            }
        }
        return cost;
    }
    // Resto el minimo de la fila y el minimo de la columna
    private void ini(double[][] M) {
        boolean b = false;
        for (int i = 0; i < M.length; i++) {
            double min = Integer.MAX_VALUE;
            for (int j = 0; j < M[i].length; j++) {
                if (min > M[i][j]) {
                    min = M[i][j];           //Cojo el minimo
                    b = true;
                }
            }          
            if (b) {                         //Si hay minimo
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j] < Integer.MAX_VALUE) { //
                        M[i][j] -= min;     //Resto
                    }
                }
            } else {
                filinicub[i] = true;        //Fila cubierta    
            }
        }
        b = false;
        for (int j = 0; j < a; j++) {
            double mincol = Integer.MAX_VALUE;
            for (int i = 0; i < M.length; i++) {
                if (mincol > M[i][j]) {
                    mincol = M[i][j];       //Cojo el min
                    b = true;
                }
            }

            if (b) {                        //Si hay minimo
                for (int i = 0; i < M.length; i++) {
                    if (M[i][j] < Integer.MAX_VALUE) {
                        M[i][j] -= mincol; //resto el minimo
                    }
                }
            } else {
                colinicub[j] = true;       //Columna cubierta
            }
        }
    }
    private void inisel(double M2[][]) {

        boolean[] filaconcero = new boolean[M2.length]; //Filas con zero
        boolean[] colconcero = new boolean[a];          //Columnas con zero

        for (int i = 0; i < M2.length; i++) {
            for (int j = 0; j < M2[i].length; j++) {
                if (0 == M2[i][j] && !filaconcero[i] && !colconcero[j]) {
                    filselec[i] = j;                    // Inserto donde tengo 
                    colselec[j] = i;                    // un zero
                    filaconcero[i] = true;
                    colconcero[j] = true;
                    break;
                }
            }
        }
    }
    //Cubro la columna con ceros
    private void cubcolceros() {
        for (int j = 0; j < colselec.length; j++) {
            assert !(colcub[j] && colselec[j] != -1); // Sino no esta cubierta                                            // una columna
            if (colselec[j] != -1) {                  // una columna 
                colcub[j] = true;
            }
        }
    }
    // Devuelvo un int[] donde para cada fila i hay una columna j con zero
    private int[] selceros(double M[][], int[] filnosel) {
        for (int i = 0; i < M.length; i++) {
            if (filcub[i]) {
                continue;
            }
            for (int j = 0; j < M[i].length; j++) {
                if (0 == M[i][j] && !colcub[j]) {
                    filnosel[i] = j;
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    private void marceros(int[] cerodesparej, int[] filnosel) {
        int i;
        int j = cerodesparej[1];
        ArrayList<int[]> secero = new ArrayList<int[]>();
        secero.add(cerodesparej);
        boolean apareao = false;
        do {
            i = colselec[j];
            apareao = -1 != i && secero.add(new int[]{i, j});
            if (!apareao) {
                break;
            }
            j = filnosel[i];
            apareao = -1 != j && secero.add(new int[]{i, j});
        } while (apareao);
        for (int[] zero : secero) {
            if (colselec[zero[1]] == zero[0]) {
                colselec[zero[1]] = -1;
                filselec[zero[0]] = -1;
            }

            if (filnosel[zero[0]] == zero[1]) {
                filselec[zero[0]] = zero[1];
                colselec[zero[1]] = zero[0];
            }
        }
    }
    private int[] buscarSolucionAlternativa(double [][] M) {
		double[][] matriz = new double[M.length][M.length];
		for (int i = 0; i < M.length; i++) {
			for(int j = 0; j < M.length; j++) {
				matriz[i][j] = M[i][j];
			}
		
		}
		int[] solucio = new int[M.length];
		for (int i = 0; i < solucio.length; i++) {
			solucio[i] = -1;
		}
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M.length; j++) {
				if(matriz[i][j] == 0) {
					int[] solucio1 = new int[M.length];
					matriz[i][j] = -1;
					solucio1 = buscarSolucionAlternativa(M);
                                        for(int k = 0; k < solucio1.length; k++) {
                                            if(solucio1[i] != -1) solucio[i] = solucio1[i];
                                        }
					boolean trobat = true;
					for(int k = 0; k < M.length; k++) {
						if(solucio1[k] == -1) trobat = false;
					}
					if(trobat) {
						return solucio1;
					} else {
						solucio[i] = j;
						for(int k = 0; k < M.length; k++) {
							matriz[i][k] = -1;
							matriz[k][j] = -1;
						}
						solucio1 = buscarSolucionAlternativa(M);
						for(int k = 0; k < solucio1.length; k++) {
                                                    if(solucio1[i] != -1) solucio[i] = solucio1[i];
                                                }
					}
				}
			}
		}
		return solucio;
    }
    
    private boolean continua(double[][] M) {
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < M.length; i++) {
            if (!filcub[i]) {
                for (int j = 0; j < M[i].length; j++) {
                    if (!colcub[j] && M[i][j] < min) {
                        min = M[i][j];
                    }
                }
            }
        }
        if (min >= Integer.MAX_VALUE) {
            return false;
        }
        for (int i = 0; i < filcub.length; i++) {
            if (filcub[i]) {
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j] < Integer.MAX_VALUE) {
                        M[i][j] += min;
                    }
                }
            }
        }
        for (int j = 0; j < colcub.length; j++) {
            if (!colcub[j]) {
                for (int i = 0; i < M.length; i++) {
                    if (M[i][j] < Integer.MAX_VALUE) {
                        M[i][j] -= min;
                    }
                }
            }
        }

        return true;
    }
}
