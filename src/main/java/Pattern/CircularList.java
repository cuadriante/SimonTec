package Pattern;

import java.io.Serializable;

public class CircularList<T> implements Serializable {
    private Node<T> first;

    public CircularList(){
        first = null;
    }

    public void addFirst(T element){
        if (first == null){
            first = new Node<>(element);
            first.next = first;
            first.previous = first;
        } else {
            Node<T> ultimo = first.previous;
            Node<T> nuevo= new Node<>(element);
            nuevo.next = first;
            nuevo.previous = ultimo;
            first.previous = nuevo;
            ultimo.next = nuevo;
            first = nuevo;
        }
    }


    public void addLast(T dato) {
        if (first == null) {
            addFirst(dato);
        }else{
            Node<T> nuevo = new Node<>(dato);
            Node<T> ultimo = first.previous;
            nuevo.next = first;
            nuevo.previous = ultimo;
            first.previous = nuevo;
            ultimo.next = nuevo;
        }
    }

    public void printList(){
        if (first == null) {
            System.out.println("Empty");
        } else {
            Node<T> actual = first;
            do { // se ejecuta al menos una vez
                System.out.print(actual.getElement() + ", ");
                actual = actual.next;
            } while (actual != first);
            System.out.println();
        }
    }

    public int listSize() {
        if (first == null) {
            return 0;
        } else {
            Node<T> actual = first;
            Node<T> ultimo = first.previous;
            int tamano = 0;

            do { // se ejecuta al menos una vez
                tamano++;
                actual = actual.next;
            } while (actual != first);
            return tamano;
        }
    }

    public T getElement(int position) {
        if (position < 0 || first == null) {
            return null;
        }
        Node<T> actual = first;
        int indice = 0;
        do {
            if (indice == position) {
                return actual.getElement();
            }
            indice++;
            actual = actual.next;
        } while (actual != first);
        return null; // la position sobrepasa el indice
    }

    public void deleteFirst() {
        if (first != null) {
            if (first.next == first){
                first = null;
            } else {
                Node<T> temp = first;
                Node<T> last = temp.previous;
                first = temp.next;
                first.previous = temp.previous;
                last.next = first;
                temp.next = null;
                temp.previous = null;
            }
        }
    }

    public void deleteLast() {
        if (first != null) {
            if (first.next == first){
                first = null;
            } else {
                Node<T> temp = first.previous;
                Node<T> last = temp.previous;
                last.next = first;
                first.previous = last;
                temp.previous = null;
                temp.next = null;
            }
        }
    }

    public void deleteAll() {
        if (first != null) {
            if (first.next == first) {
                deleteFirst();
            } else {
                Node<T> actual = first;
                int index = 0;
                do {
                    deletePosition(index);
                } while (index <= listSize()-1);
            }
        }
    }

    public void deletePosition(int position){
        if (position >= 0) {
            if (position == 0) {
                deleteFirst();
            } else {
                Node<T> actual = first;
                int index = 0;

                do {
                    if (index == position) {
                        Node<T> nodePrev = actual.previous;
                        Node<T> nodeSig = actual.next;
                        nodePrev.next = nodeSig;
                        nodeSig.previous = nodePrev;
                        actual.previous = null;
                        actual.next = null;
                        break;
                    }
                    index++;
                    actual = actual.next;
                } while (actual != first);
            }
        }
    }

    public int getPosition(T element){
        if (first == null) {
            return -1;
        } else {
            int index = 0;
            Node<T> actual = first;
            do { // se ejecuta al menos una vez
                if ( (T) actual.getElement() == element){
                    return  index;
                }
                index++;
                actual = actual.next;
            } while (actual != first);
        }
        return -1;
    }
}

