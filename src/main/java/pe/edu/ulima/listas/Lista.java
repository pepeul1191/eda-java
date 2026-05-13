package pe.edu.ulima.listas;

public interface Lista<T> {

  void add(T dato);

  void addFirst(T dato);

  T removeFirst();

  boolean remove(T dato);

  T get(int index);

  boolean contains(T dato);

  int size();

  boolean isEmpty();

  Nodo<T> getNode(int index);

  void print();

  public void concatenate(Nodo<T> nodo);

  void invert();

  void bubbleSort();
}