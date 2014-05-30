



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.Random;

/**
 *
 * @author alejandro.del.amo.gonzalez
 */
public class branchBound {
    
    private PriorityQueue<Node> nodes; //Cua de prioritat ordenada de forma ascendent
    private int mida;                 // mida de la solucio
    private int[][] estadistica;      // matriu de flux
    private int[][] distancia;        // matriu de distancia
    public  Node mejorSolucion;       // Node amb la millor solucio 
    double  mejorCost;                // Millor cost fins al moment
    gilmore g;
    /**
     * Constructora per defecte
     * @param mida mida de la solucio
     */
    public branchBound(int mida) {
        mejorCost = Integer.MAX_VALUE;
        double coste = 0;
        int asignados[] = new int [mida];
        Vector<Integer> pendientes  = new Vector<Integer> ();
        mejorSolucion = new Node(pendientes,asignados,coste);
        nodes = new PriorityQueue<Node> (1,new NodeComparador());
        nodes.add(mejorSolucion);
        g = new gilmore();
    }
    
    /**
     * Constructora de la clase BranchBound
     * @param estadistica Matriu de fluxe o de similitud 
     * @param distancia Matriu de distancia 
     */
    public branchBound(int[][] estadistica, int[][] distancia) {
        this.mida = estadistica.length;
        this.distancia = distancia;
        this.estadistica = estadistica;
        mejorCost = Integer.MAX_VALUE;  // Millor cost = infinit
        double coste = 0;
        int asignados[] = new int [mida];
        for(int i=0; i < asignados.length;++i) asignados[i] = -1;
        Vector<Integer> pendientes = new Vector<Integer> (estadistica[0].length);
        mejorSolucion = new Node (pendientes,asignados,0);
        anadirPendientes();            
        
        nodes = new PriorityQueue<Node> (1,new NodeComparador()); 
        nodes.add(mejorSolucion);          
        greedy3();
        g = new gilmore(estadistica,distancia);
        solve();

        
    }
    
    /**
     * Omple el vector de assignacions pendents
     */
    public void anadirPendientes(){
        for(int i=0; i < estadistica.length; ++i) {
            mejorSolucion.teclasPendientes.add(i);  
        }
    }

    /**
     * Calcula el cost de el vector de assignacion de un possible solució
     * @param b Vector de assignacion de un node
     * @param n Posició de la assignacio realitzada
     * @param cost Cost de haber fet una assignacio
     * @return Retorna el cost total del node 
     */
    public double calcularCost(int [] b, int n,double cost) {
        for(int i=0; i < n;++i) {
            cost += estadistica[b[i]][b[n]]*distancia[i][n];
            cost += estadistica[b[n]][b[i]]*distancia[n][i];
        }
        return cost;
    }

    /**
     * Metode que calcula la primera branca del Branch & Bound
     */
    public void greedy2() {
       mejorCost = 0;
       Vector<Integer> p = new Vector<Integer> ();
       int s[] = new int [mida];
       for(int i=0; i < mida; ++i) {
           s[i] = i;
           System.out.println("Valor de la i :"+ s[i]+" posicion  "+i);
       }
       for(int i=0; i < mida; ++i) {
           for(int j=0; j < mida; ++j) {
               mejorCost += estadistica[i][j]* distancia[s[i]][s[j]];
           }
       }
       mejorSolucion = new Node(p,s,mejorCost);
       System.out.println("El mejor coste es :"+ mejorCost);
    }

    /** 
     *  Metode que calcula de forma aleatoria una possible solució i el seu cost
     */
    public void greedy() {
        double costeParcial = 0;
        for(int j =0; j < 200; ++j) {
            costeParcial=0;
            Vector<Integer> p = new Vector<Integer> ();
            for(int i=0; i< mida;++i) {
                p.add(i);
            }
            int s[] = new int [mida];
            int i=0;
            while(!p.isEmpty()) {
                Random randomGenerator = new Random();
                int n = randomGenerator.nextInt(p.size());
                s[i] = p.get(n);
                p.remove(n);
                ++i;
            }
            for(int n=0; n < mida; ++n){
                for(int m=0; m < mida;++m) {
                    costeParcial += estadistica[n][m]* distancia[s[n]][s[m]];
                }
            }
            if(costeParcial < mejorCost) {
                mejorCost = costeParcial;
                mejorSolucion = new Node(p,s,mejorCost);
            }
        }
        System.out.println("Mejor coste "+ mejorCost);  
    }
    public double costeFinal(Vector<Integer> asignados) {
        double costeParcial = 0;
        for(int n=0; n < mida; ++n){
            for(int m=0; m < mida;++m) {
               costeParcial += estadistica[n][m]* distancia[asignados.get(n)][asignados.get(m)];
            }
        }
        return costeParcial;
    }
    public void greedy3 () {
        double costeParcial = 0;
        Vector<Integer> p = new Vector<Integer> ();
        for(int i=0; i < mida;++i) p.add(i);
        Vector<Integer> asig = new Vector<Integer> ();
        while(!p.isEmpty()){
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt(p.size());
            asig.add(p.get(n));
            p.remove(n);
        }
        costeParcial = costeFinal(asig);
        mejorCost = costeParcial;
        int x = 0;
        int y = 0;
        for(int i=0; i < mida*mida; ++i) {
            for(int m = 0; m < mida; ++m) {
                for( int n = 0; n < mida; ++n) { ; 
                    Collections.swap(asig, m, n);
                    double costSwap = costeFinal(asig);
                    if(costSwap < costeParcial) {
                        x = m;
                        y = n;
                        costeParcial = costSwap;
                    }
                    else Collections.swap(asig, m, n);
                    
                    
                }
                
            }
            if(costeParcial < mejorCost) {
                mejorCost = costeParcial;
            }
            
            
        }
        mejorCost = costeParcial;
        System.out.println("Mejor coste "+ mejorCost);
        
        
        
    }
    
    
    
    
    
    
    /**
     * Metode per comprobar si una possible solucio 
     * @param a Cost de una solucio
     * @return true, si es una possible solucio i false, si no ho es
     */
    public boolean esMejor(double a) {
        if(a <= mejorCost) return true;
	return false; 
	   
    }
        
    /**
     * Metode principal de BranchBound
     */
    public void solve()  {
        Node a = nodes.peek();
        while(!nodes.isEmpty()){
            Node b = nodes.poll();                          // Saca un node 
            Vector<Integer> pendientesPadre = b.getTeclasPendientes(); 
            if(esMejor(b.cost)) {
                if(pendientesPadre.isEmpty()) {
                    mejorSolucion = b;
                    mejorCost = b.cost;
                }          
                else {
                    for(int i=0; i < pendientesPadre.size(); ++i) {
                            int asignadosHijo [] = b.getTeclasAssginadas();  // Copia las assignaciones realizadas del padre
                            Vector<Integer> pendientesHijo = new Vector<Integer>();
                            for(int m = 0; m < pendientesPadre.size();++m) pendientesHijo.add(pendientesPadre.get(m));  //Copia las assignaciones pendientes del padre
                            pendientesHijo.remove(i);
                            int pos = mida-pendientesPadre.size();
		            asignadosHijo[pos] = pendientesPadre.get(i);
                            //double x = calcularCost(asignadosHijo,pos,b.cost); // Calcula el coste del nodo     
                            double x = g.calcularCoste(pendientesHijo,asignadosHijo,pos); //Llama al gilmore
                            Node c = new Node(pendientesHijo,asignadosHijo,x);                          
                            if(esMejor(c.cost)) {
                                if(pendientesPadre.isEmpty()) {
                                   
                                    mejorSolucion = b;
                                    mejorCost = b.cost;
                                }          
                                else nodes.add(c);
                                
                                    
                            }                               
                    }
                }

            }
        }
  
    }
    
    /**
     *
     * @param a
     * @return
     */
    public boolean esSolucion(ArrayList<Integer> a) {
        System.out.println ("Sale");
        return (a.size() == (estadistica.length-1));
        
    }

    


    
}
    
    
    
    
    
    
    

