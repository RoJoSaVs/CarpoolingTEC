package Server;

/*
 * Clase encargada de crear el mapa con sus conecciones con pesos
 * aleatorios
 * ademas se encarga de mantener los datos de los usuarios
 */
public class Server {
	/*
	 * @param listaConductores: lista con todos los conductores 
	 * @param listaEstudiates: liscta con todos los estuidantes
	 * @param mapa: grafo con todas las conecciones
	 */
	
	public List<Usuario> listaConductores;
	public List<Usuario> listaEstudiates;
	public Grafo mapa;
	
	public Server() {
		ListDestinosConecciones i = new ListDestinosConecciones();
		List<NodoG> nodos = i.ListDestinos();
		List<Coneccion> conecciones = i.listConecciones(nodos);
		
		//GRAFO
		this.mapa = new Grafo(nodos,conecciones);
		
		
		
	}
}
