public class ListaEnlazada<T> implements Lista<T> {

    private Nodo<T> cabeza;
    private int tamaño;

    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
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

        tamaño++;
    }

    @Override
    public void addFirst(T dato) {

        Nodo<T> nuevo = new Nodo<>(dato);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        tamaño++;
    }

    @Override
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;

        tamaño--;

        return dato;
    }

    @Override
    public boolean remove(T dato) {

        if (isEmpty()) {
            return false;
        }

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }

        Nodo<T> actual = cabeza;

        while (actual.siguiente != null &&
               !actual.siguiente.dato.equals(dato)) {

            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {

            actual.siguiente = actual.siguiente.siguiente;
            tamaño--;

            return true;
        }

        return false;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= tamaño) {
            return null;
        }

        Nodo<T> actual = cabeza;

        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
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
        return tamaño;
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
}

public interface Lista<T> {

    void add(T dato);

    void addFirst(T dato);

    T removeFirst();

    boolean remove(T dato);

    T get(int index);

    boolean contains(T dato);

    int size();

    boolean isEmpty();

    void print();
}

TAD Lista
   ↓
Interfaz
   ↓
Implementación concreta
   ↓
Nodos

class Nodo<T> {

    T dato;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class Main {

    public static void main(String[] args) {

        Lista<Integer> lista = new ListaEnlazada<>();

        lista.add(10);
        lista.add(20);
        lista.addFirst(5);

        lista.print();

        System.out.println(lista.get(1));

        lista.remove(10);

        lista.print();
    }
}