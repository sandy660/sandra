package Modelo;

public class Node {

    private int valor;
    private Node siguiente;
    private ListaEnlazadas l;
    int band = 0;

    //Métodos constructores
    public Node(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public Node(ListaEnlazadas l) {
        this.l = l;
        this.siguiente = null;
        band++;
    }

    public Node(int cargo, Node siguiente) {
        this.valor = cargo;
        this.siguiente = siguiente;
    }

    public Node(ListaEnlazadas l, Node siguiente) {
        this.l = l;
        this.siguiente = siguiente;
    }

    //Métodos Set
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }

    public void setL(ListaEnlazadas l) {
        this.l = l;
    }

    //Métodos get
    public int getValor() {
        return valor;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public ListaEnlazadas getL() {
        return l;
    }

    //Método toString
    public String toString() {

        if (band == 0) {
            return valor + "";
        } else {
            return "{ "+l + " }";
        }

    }

}