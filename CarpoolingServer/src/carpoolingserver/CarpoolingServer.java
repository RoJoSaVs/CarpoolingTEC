package carpoolingserver;

import DatosDriver.DriverData;
import Grafo.Grafo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarpoolingServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Grafo grafo = new Grafo();
        grafo.generarGrafoAleatorio(30, 0.3);
        //DriverData drivers = new DriverData();
        //drivers.Intento();
        
    }
    
}
