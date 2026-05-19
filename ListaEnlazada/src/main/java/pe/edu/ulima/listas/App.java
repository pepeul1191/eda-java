package pe.edu.ulima.listas;

public class App 
{
    private static <T> boolean sonIguales(Lista<T> lista1, Lista<T> lista2){
        if(lista1.size() == lista2.size()){
            for(int i = 0; i < lista1.size(); i++){
                if(!lista1.get(i).equals(lista2.get(i))){
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private static <T> Lista<T> concatenar(Lista<T> lista1, Lista<T> lista2) {
        lista1.concatenate(lista2.getNode(0));
        return lista1;
    }

    private static <T> void split(Lista<T> lista, T valor) {

        Lista<T> listaA = new ListaEnlazada<>();
        Lista<T> listaB = new ListaEnlazada<>();

        int indice = 0;

        for (int i = 0; i < lista.size(); i++) {
            if(valor == lista.getNode(i).dato){
                indice = i;
            }
        }

        for (int i = 0; i < lista.size(); i++) {

            if (i < indice) {
                listaA.add(lista.get(i));
            } else {
                listaB.add(lista.get(i));
            }
        }

        listaA.print();
        listaB.print();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Lista<Integer> listaA = new ListaEnlazada<>();

        listaA.add(1);
        listaA.add(2);
        listaA.addFirst(3);

        //System.out.println(lista.get(1));
        listaA.remove(10);
        //lista.print();
        listaA.print();

        Lista<Integer> listaB = new ListaEnlazada<>();

        listaB.add(10);
        listaB.add(20);
        listaB.addFirst(5);

        listaB.print();
        
        System.out.println(sonIguales(listaA, listaB));

        listaA.concatenate(listaB.getNode(0));
        listaA.print();

        listaA.invert();
        listaA.print();
        listaA.bubbleSort();
        listaA.print();

        split(listaA, 5);
    }
}
