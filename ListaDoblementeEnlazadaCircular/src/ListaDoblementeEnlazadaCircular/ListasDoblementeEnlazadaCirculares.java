/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDoblementeEnlazadaCircular;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ListasDoblementeEnlazadaCirculares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        ListaDoblementeEnlazadaCircular lista  = new ListaDoblementeEnlazadaCircular();  
        //Tipo de inserción al INICIO de la Lista
        lista.AñadirInicio(23);  
        lista.AñadirInicio(40);
        lista.AñadirInicio(84);
        lista.AñadirInicio(1);
        System.out.println("Lista añadir inicio");
        lista.showElements();
         //Tipo de inserción al FINAL
        lista.AñadirFinal(10); //nuevo nodo tiene como valor 100
        lista.AñadirFinal(6); 
        lista.AñadirFinal(89);
        lista.AñadirFinal(44);
        lista.AñadirFinal(15);
        System.out.println("\nLista añadir final");
        lista.showElements();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones básicas");
        System.out.println("1 Insertar antes del valor de un nodo");
        System.out.println("2 Eliminar al nodo inicial de la lista");
        System.out.println("3 Eliminar el nodo final");
        System.out.println("4 Eliminar un nodo a partir de un valor ingresado");
        System.out.println("5 Dividir la lista circular en dos");
        System.out.println("Ingrese numero de ejercicio:");
        int op = sc.nextInt();
        
        switch(op)
        {            
            case 1:
                    //se ingresa el valor del nodo existente en la lista y el valor del nuevo nodo a insertar antes de él
                    lista.addBefore(15, 63);    
                    lista.addBefore(100, 6); //el valor de 100 no se encuentra en la lista
                    break;
            case 2:
                    //Eliminar el nodo inicial de la lista
                    lista.removeFirst();
                    System.out.println("Los elementos después de eliminar el nodo inicial de la lista son:");
                    lista.showElements();
                    break;
            case 3:
                    //Eliminar nodo final de la lista
                    lista.removeLast();
                    System.out.println("Los elementos después de eliminar el nodo final de la lista son:");
                    lista.showElements();
                    break;
            case 4:
                    //Eliminar nodo a partir del valor ingresado
                    System.out.println("Ingrese numero a eliminar");
                    n = sc.nextInt();
                    lista.remove(n);                    
                    break;
            case 5:
                    System.out.println("Ingrese valor para dividir la lista");
                    n = sc.nextInt();
                    lista.DividirLista(n);
                    break;
            default:
                    System.out.println("Opcion inválida");
                    break;
        }        
    }
}
