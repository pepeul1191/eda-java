package pe.edu.ulima.listas;

public class ListaEnlazada<T> implements Lista<T> {

    private Nodo<T> cabeza;
    private int tamanio;

    public ListaEnlazada() {
        cabeza = null;
        tamanio = 0;
    }

    @Override
    public void add(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {

            Nodo<T> actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        tamanio++;
    }

    @Override
    public void concatenate(Nodo<T> nodo) {

        if (tamanio == 0) {
            cabeza = nodo;
            return;
        }

        Nodo<T> actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
            tamanio = tamanio + 1;
        }

        actual.siguiente = nodo;
        tamanio = tamanio + 1;
    }
    

    @Override
    public void addFirst(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        tamanio++;
    }

    @Override
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;

        tamanio--;

        return dato;
    }

    @Override
    public boolean remove(T dato) {

        if (isEmpty()) {
            return false;
        }

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }

        Nodo<T> actual = cabeza;

        while (actual.siguiente != null &&
               !actual.siguiente.dato.equals(dato)) {

            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {

            actual.siguiente = actual.siguiente.siguiente;
            tamanio--;

            return true;
        }

        return false;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= tamanio) {
            return null;
        }

        Nodo<T> actual = cabeza;

        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    @Override
    public Nodo<T> getNode(int index) {

        if (index < 0 || index >= tamanio) {
            return null;
        }

        Nodo<T> actual = cabeza;

        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }

        return actual;
    }

    @Override
    public boolean contains(T dato) {

        Nodo<T> actual = cabeza;

        while (actual != null) {

            if (actual.dato.equals(dato)) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public int size() {
        return tamanio;
    }

    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }

    @Override
    public void print() {

        Nodo<T> actual = cabeza;

        while (actual != null) {

            System.out.print(actual.dato + " -> ");

            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    @Override
    public void invert(){
      if (tamanio > 0){
        Nodo<T> nuevaCabeza = new Nodo<>(this.getNode(tamanio-1).dato);
        Nodo<T> actual = nuevaCabeza;
        for(int i = tamanio - 2; i >= 0; i--){
          
          Nodo<T> nodo = new Nodo<>(this.getNode(i).dato);
          //System.out.println(this.getNode(i).dato);
          actual.siguiente = nodo;
          actual = nodo;
        }
        cabeza = nuevaCabeza;
      }
    }

    @Override
    public void bubbleSort() {  

    if (tamanio <= 1) return;

    boolean swapped;

    do {
        swapped = false;
        Nodo<T> actual = cabeza;

        while (actual != null && actual.siguiente != null) {

            Nodo<T> siguiente = actual.siguiente;

            // Comparamos y swap si hace falta
            if (((Comparable<T>) actual.dato).compareTo(siguiente.dato) > 0) {
                T temp = actual.dato;
                actual.dato = siguiente.dato;
                siguiente.dato = temp;

                swapped = true;
            }

            actual = actual.siguiente;
        }

    } while (swapped);
}
}