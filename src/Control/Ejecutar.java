package Control;

import Modelo.ListaEnlazadas;
import Vista.InOut;
import java.util.Vector;

/**
 *
 * @author Sandra
 *
 */
public class Ejecutar {

    public static void main(String[] args) {

        InOut ob = new InOut();
        
        int filas = ob.solicitarEnteroPositivo("¿Cuántas filas tiene su matriz?");
        int columnas = ob.solicitarEnteroPositivo("¿Cuántas columnas tiene su matriz?");
        
        ob.mostrarInfo("A continuación ingresaremos la matriz.");
        
        ListaEnlazadas fin = new ListaEnlazadas();
        
        for (int i = 0; i < filas; i++) {
            ListaEnlazadas nueva = new ListaEnlazadas();
            
            for (int j = 0; j < columnas; j++) {
                int n = ob.solicitarEntero("Ingrese el dato ["+i+"]["+j+"] de la matriz:");
                nueva.add(n);
                
            }
            
           fin.add(nueva);
       
        }
        
        ob.mostrarInfo("La matriz es: \n"+fin);
    }

}

