package Grafo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

//import grafo.Nodo;

public class Grafo {

	//para cada Integer (id de nodo) guardamos ArrayList de los Nodos con que enlaza
	private HashMap<Integer, Nodo> nodos;
	private int L;
        static int num_nodos = 30;
	
	public Grafo() {
		this.nodos = new HashMap<Integer, Nodo>();
		this.L = 0;
	}
	
	/**
	 * Genera un grafo aleatorio con un número de nodos determinado siguiendo una función de probabilidad.
	 * Para ello genera números aleatorios por cada enlace posible, si el número generado es menor que 
         * la probabilidad, se crea el enlace.
	 * @param num_nodos Número de nodos del grafo (>0)
	 * @param probabilidad Número decimal entre (0 <= p <= 1)
	 * @return
	 */
	public Grafo generarGrafoAleatorio(int num_nodos, double probabilidad)
	{
	
		this.nodos = new HashMap<Integer, Nodo>();
		this.L = 0;
		//inicaliza los id de cada nodo
		for(int i=0; i<num_nodos; i++)
		{
			nodos.put(i, new Nodo(i));
		}
		
		int generados = 0;
		int no_generados = 0;
		
		//recorre solo la diagonal de arriba a la derecha
		for(int i=0; i<num_nodos; i++)
		{
			for(int j=i+1; j<num_nodos; j++)
			{
				double aleatorio = Math.random();
				//crea enlace si el aleatorio es menor que la probabilidad
				if(aleatorio < probabilidad)
				{
					generados++;
					nodos.get(i).anadirEnlace(j);
					nodos.get(j).anadirEnlace(i);
					L = L+2;
				} 
				else 
				{
					no_generados++;
				}
			}
		}
		
		System.out.println("generados: " + generados + ", no generados: " + no_generados);
		
		return this;
	}
	
	
	
	
	
	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	/**
	 * 
	 * @param grafo
	 */
	public void imprimirGrafoAleatorio(int numNodos, double probabilidad)
	{
		
            FileWriter fichero = null;
            PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("grafo_aleatorio_" + numNodos + "nodos_" + probabilidad + "prob" + ".gdf");
            pw = new PrintWriter(fichero);
 
            
            pw.println("nodedef>name VARCHAR");            
            Iterator<Entry<Integer, Nodo>> it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	pw.println(it.next().getKey());
            }
            
            pw.println("edgedef>node1 VARCHAR, node2 VARCHAR");
            it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	Entry<Integer, Nodo> elementos = it.next();
            	Nodo nodoactual = elementos.getValue();
            	for (int enlace: nodoactual.get_enlaces((int)elementos.getKey()))
            	{
            		
            		if(enlace > (int)elementos.getKey()) {
            			pw.println(elementos.getKey() + ", " + enlace);
            		}
            			
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }	
    }
	/**
	 * Calcula la probabilidad de que un nodo ya existente sea enlazada a un nuevo nodo
	 * 
	 * @param nodo
	 * @param L
	 * @return
	 */
	public double probabilidadEnlace(Nodo nodo, int L) {
		
		int k = nodo.get_enlaces(nodo.get_id()).size(); //Obtenemos el grado del nodo en cuestion
		return k / ((double)L - k);
		
	}
	


	public HashMap<Integer, Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(HashMap<Integer, Nodo> nodos) {
		this.nodos = nodos;
	}
}
