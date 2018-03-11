package Modelo;

import java.util.Vector;

public class ListaEnlazadas {

    private Node cabeza;

    public ListaEnlazadas() {
        this.cabeza = null;
    }

    //Método para agregar un nodo al final.
    public void add(int valor) {

        //Creación del objeto Nodo
        Node nodo = new Node(valor);

        //Si la cabeza está vacia, entonces el nodo ingresado becomes la cabeza.
        if (this.cabeza == null) {
            this.cabeza = nodo;
        } else {
            //El nodo auxiliar inicialmente queda valiendo la cabeza.
            Node auxiliar = this.cabeza;
            //Mientras que el siguiente no sea vácio.
            while (auxiliar.getSiguiente() != null) {
                //El auxiliar pasa a tener el valor del siguiente.
                auxiliar = auxiliar.getSiguiente();
            }
            //Cuando se acaba el ciclo, el siguiente, es decir el último, queda valiendo lo del nodo.
            auxiliar.setSiguiente(nodo);
        }

    }
    
    public void add(ListaEnlazadas l) {

        //Creación del objeto Nodo
        Node nodo = new Node(l);

        //Si la cabeza está vacia, entonces el nodo ingresado becomes la cabeza.
        if (this.cabeza == null) {
            this.cabeza = nodo;
        } else {
            //El nodo auxiliar inicialmente queda valiendo la cabeza.
            Node auxiliar = this.cabeza;
            //Mientras que el siguiente no sea vácio.
            while (auxiliar.getSiguiente() != null) {
                //El auxiliar pasa a tener el valor del siguiente.
                auxiliar = auxiliar.getSiguiente();
            }
            //Cuando se acaba el ciclo, el siguiente, es decir el último, queda valiendo lo del nodo.
            auxiliar.setSiguiente(nodo);
        }

    }

    public Node getCabeza() {
        return cabeza;
    }
    
    

    //Método toString
    public String toString() {

        String s = "";
        //s=s+"Lista: ";

        Node p = this.cabeza;
        while (p != null) {
            s = s + "[" + p.toString() + "]";
            p = p.getSiguiente();
        }

        return s;
    }

    public Vector<Integer> buscarNumero(int b) {
        
        Vector<Integer> vec = new Vector<Integer>();

        Node n = this.cabeza;
      
        int aux=0;

        while (n != null) {
            aux++;
            if(n.getValor()==b){
            vec.add(aux);
            }
            n = n.getSiguiente();
        }
        return vec;
    }

}