/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        LinkedList lista  = new LinkedList();  
        //Tipo de inserción al INICIO de la Lista
        lista.AñadirInicio(23);
        lista.AñadirInicio(40);
        lista.AñadirInicio(84);
        lista.AñadirInicio(1);     
        System.out.println("La lista doblemente enlazada con insercion al inicio:");
        lista.showElements();
         //Tipo de inserción al FINAL
        lista.AñadirFinal(10); //nuevo nodo tiene como valor 100
        lista.AñadirFinal(6); 
        lista.AñadirFinal(89);
        lista.AñadirFinal(44);
        lista.AñadirFinal(15);        
        lista.showElements();
        System.out.println("La lista doblemente enlazada con insercion al final:");
        lista.showElements();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones básicas");
        System.out.println("1 Eliminar al final");
        System.out.println("2 Eliminar al inicio");
        System.out.println("3 Eliminar nodo según su valor");
        System.out.println("4 Insertar antes del valor de un nodo");
        System.out.println("5 Invertir lista doblemente enlazada");
        System.out.println("Ingrese numero de ejercicio:");
        int op = sc.nextInt();
        switch(op)
        {
            case 1: System.out.println("Eliminar al final.");
                lista.removeLast();
                lista.showElements();
                break;
            case 2: System.out.println("Eliminar al inicio.");
                lista.removeFirst();
                lista.showElements();
                break;
            case 3:     
                System.out.println("Ingrese valor del nodo a eliminar");                   
                n = sc.nextInt();
                lista.remove(n);                
                break;
            case 4:
                //Insertar antes de un nodo 
                System.out.println("Se ingresa el valor de un nodo existente en la lista y el nuevo valor que se insertará antes de dicho nodo");
                lista.addBefore(23, 15);
                lista.addBefore(6, 9);
                break;
            case 5:
                System.out.println("Invertir lista");
                lista.InvertirLista();
                System.out.println("Los elementos invertidos de la lista son:");
                lista.showElements();
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }        
    }
}
