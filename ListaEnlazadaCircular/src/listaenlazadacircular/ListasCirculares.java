/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazadacircular;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class ListasCirculares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        ListaEnlazadaCircular lista  = new ListaEnlazadaCircular();  
        //Tipo de inserción al INICIO de la Lista
        lista.AñadirInicio(23);
        lista.AñadirInicio(40);
        lista.AñadirInicio(84);
        lista.AñadirInicio(1);
        System.out.println("Lista con elementos añadidos al inicio");
        lista.showElements();
        
        lista.AñadirFinal(10); //nuevo nodo tiene como valor 100
        lista.AñadirFinal(6); 
        lista.AñadirFinal(89);
        lista.AñadirFinal(44);
        lista.AñadirFinal(15);
        System.out.println("Lista con elementos añadidos al final");
        lista.showElements();   
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones básicas");
        System.out.println("1 Insertar antes del valor de un nodo");
        System.out.println("2 Eliminar al final");
        System.out.println("3 Eliminar el nodo inicial de la lista");
        System.out.println("4 Eliminar un nodo a partir de un valor ingresado");
        System.out.println("5 Dividir la lista circular en dos");
        System.out.println("Ingrese numero de ejercicio:");
        int op = sc.nextInt();
        
        switch(op)
        {            
            case 1:
                    //se ingresa el valor del nodo existente en la lista y el nuevo valor a insertar antes de él
                    lista.addBefore(23, 63);
                    lista.addBefore(40, 35);
                    lista.addBefore(0, 0);                    
                    break;
            case 2:
                    lista.removeLast();
                    lista.showElements();
                    break;
            case 3:
                    lista.removeFirst();
                    System.out.println("Los elementos después de eliminar el nodo inicial de la lista son:");
                    lista.showElements();
                    break;
            case 4:
                    System.out.println("Ingrese el elemento a eliminar");
                    n = sc.nextInt();
                    lista.remove(n);                    
                    break;
            case 5:
                    System.out.println("Ingrese el elemento para dividir la lista enlazada circular");
                    n = sc.nextInt();
                    lista.DividirLista(n);
                    break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}
