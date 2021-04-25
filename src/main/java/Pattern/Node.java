package Pattern;

import java.io.Serializable;

class Node<T> implements Serializable {
    public Node<T> next;
    public Node<T> previous;
    public T value;
    public int posicion;

    public Node(){
        this.value = null;
        this.next = null;
        this.previous = null;
        this.posicion = 0;
    }

    public Node(T element){
        this.value = element;
        this.next = null;
        this.previous = null;
        this.posicion = 0;
    }

    public T getElement(){
        return this.value;
    }
    public void setDato(T valor){this.value = valor;}
    public Node<T> getNext(){return this.next;}
    public void setNext(Node<T> node){this.next = node;}
    public int getPosicion(){return posicion;}
    public void setPosicion(int posicion){this.posicion = posicion;}

}

