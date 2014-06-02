

import java.util.*;



public class hung {
    
   
    private boolean[] filinicub;
    private boolean[] colinicub;
    private boolean[] filcub;
    private boolean[] colcub;
    private int[] filselec;
    private int[] colselec;
    private int a;

    public hung() {
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
        
        
        
        filinicub = new boolean[M.length];
        if (M.length > 0) a = M[0].length;
        else a = 0;
        colinicub = new boolean[a];
        ini(M);
        filselec = new int[M.length];
        colselec = new int[colinicub.length];
        int[] filnosel = new int[M.length];
        for (int i = 0; i < M.length; ++i) {
            filselec[i] = -1;
            filnosel[i] = -1;
        }
        for (int j = 0; j < a; ++j) {
            colselec[j] = -1;
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

    private void ini(double[][] M) {
        boolean b = false;
        for (int i = 0; i < M.length; i++) {
            double min = Integer.MAX_VALUE;
            for (int j = 0; j < M[i].length; j++) {
                if (min > M[i][j]) {
                    min = M[i][j];
                    b = true;
                }
            }          
            if (b) {
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j] < Integer.MAX_VALUE) {
                        M[i][j] -= min;
                    }
                }
            } else {
                filinicub[i] = true;
            }
        }
        b = false;
        for (int j = 0; j < a; j++) {
            double mincol = Integer.MAX_VALUE;
            for (int i = 0; i < M.length; i++) {
                if (mincol > M[i][j]) {
                    mincol = M[i][j];
                    b = true;
                }
            }

            if (b) {
                for (int i = 0; i < M.length; i++) {
                    if (M[i][j] < Integer.MAX_VALUE) {
                        M[i][j] -= mincol;
                    }
                }
            } else {
                colinicub[j] = true;
            }
        }
    }
    private void inisel(double M2[][]) {

        boolean[] filaconcero = new boolean[M2.length];
        boolean[] colconcero = new boolean[a];

        for (int i = 0; i < M2.length; i++) {
            for (int j = 0; j < M2[i].length; j++) {
                if (0 == M2[i][j] && !filaconcero[i] && !colconcero[j]) {
                    filselec[i] = j;
                    colselec[j] = i;
                    filaconcero[i] = true;
                    colconcero[j] = true;
                    break;
                }
            }
        }
    }
    private void cubcolceros() {
        for (int j = 0; j < colselec.length; j++) {
            assert !(colcub[j] && colselec[j] != -1);
            if (colselec[j] != -1) {
                colcub[j] = true;
            }
        }
    }
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
    private void marceros(
            int[] cerodesparej,
            int[] filnosel) {
        int i, j = cerodesparej[1];
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
