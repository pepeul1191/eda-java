/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author USUARIO
 */
public class Node {
    private int value;
    private Node next; //atributo de clase - tipo Nodo
    private Node prev; 
 
    public Node(int value){ //constructor que permita darle un valor al Nodo cada vez que creamos un nodo
        this.value = value;
    }
    public int value(){
        return value;
    }
    
    public Node next(){
        return next;
    }
    
    public Node prev(){
        return prev;
    }
    
    public void setNext(Node node){
        this.next = node;
    }
    
    public void setPrev(Node node){
        this.prev = node;
    }
} 
