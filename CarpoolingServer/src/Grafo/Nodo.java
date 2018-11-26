package Grafo;

import java.util.ArrayList;

public class Nodo {

	private int id;
	private ArrayList<Integer> enlaces = new ArrayList<Integer>(); //guarda los enlaces de cada nodo
	
	public Nodo(int id)
	{
		this.id = id;
	}
	
	public void anadirEnlace(int j)
	{
                int peso = (int)((Math.random()*10)+1);
                System.out.println(peso);
                enlaces.add(peso);
		//enlaces.add(j);
	}	
	
	/////////GETTERS Y SETTERS
	
	public int get_id()
	{
		return id;
	}
	
	public void set_id(int id)
	{
		this.id = id;
	}
	
	public ArrayList<Integer> get_enlaces(int id)
	{
		return enlaces;
	}
}
