/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDoblementeEnlazadaCircular;

/**
 *
 * @author USUARIO
 */
public class ListaDoblementeEnlazadaCircular {

    private Node L;//nodo cabecera para acceder a los elementos de la lista
    private Node ultimo;
          
    public ListaDoblementeEnlazadaCircular(){//constructor crea una lista vacía, en la cual L (cabecera de la lista enlazada) referencia a nulo
	this.L = null;
        this.ultimo = null;
    }
    
    public void AñadirInicio(int value)
    {//Añadir el nuevo elemento al inicio de la Lista
	//Creacion de nodo
	Node newNode = new Node(value);
	//Si la lista esta vacia
	if(L == null){
		//Unico elemento, no tiene sucesor
                L = newNode;
		newNode.setNext(L);
                newNode.setPrev(L);
                ultimo = newNode;
	}
        else//Si no esta vacia
        {	
                //El sucesor de newNode debe ser el primero de la lista original
		newNode.setNext(L);//1->2
                L = newNode;
                newNode.next().setPrev(newNode);
                newNode.setPrev(ultimo);
                ultimo.setNext(newNode);
	}
    }    
    
    public void showElements()
    {
	//Obtener referencia al primer nodo (variable ptr)
	Node ptr = L;
        if(vacia())
        {
            System.out.println("Lista enlazada circular vacía");
            return;
        }      
        System.out.println("Mostrar elementos de izquierda a derecha:");
	//Mientras existan mas nodos por procesar
	do{
		//Procesamos la informacion del nodo actual: ptr.value()
		System.out.print(ptr.value() + " --> ");
		ptr = ptr.next();//para recorrer el sgte nodo
	}while(ptr!= L);
        //El ultimo nodo no tendra null como siguiente!!!!!
	System.out.println("*"+ptr.value());
        
        System.out.println("Mostrar elementos de derecha a izquierda:");
	//Mientras existan mas nodos por procesar
        ptr = ultimo;
        System.out.print("*"+ptr.next().value()+" --> ");
	do
        {
		//Procesamos la informacion del nodo actual: ptr.value()
		System.out.print(ptr.value() + " --> ");
		ptr = ptr.prev();//para recorrer el sgte nodo
	}while(ptr != L);
	//El ultimo nodo no tendra null como siguiente!!!!!
	System.out.println(ptr.value());
    }     
    
    public void AñadirFinal(int valor)
    {
        //verificar si la lista enlazada está vacía.
        // si vacía el nodo se convierte en la cabecera de la lista
        Node newNode = new Node(valor); //creamos el nuevo nodo a insertar
        if (vacia() == true)
        { //¿la lista está vacía?
          // entonces la cabeza se convierte en el Nodo que encabeza la lista enlazada
          L = newNode; 
          newNode.setNext(L);
          ultimo = newNode;
          newNode.setPrev(L);
          return;
        }
        //insertamos el nuevo nodo al final de la lista y lo enlazamos con el primero        
        ultimo.setNext(newNode);
        newNode.setPrev(ultimo);
        ultimo = newNode;
        newNode.setNext(L);   
        L.setPrev(newNode);
    }
    
    public void addBefore(int ref, int item)
    {//Insertar antes de un nodo
        boolean band = false;
	Node newNode = new Node(item);  
	//ptr: nodo referencia - prev: nodo anterior a "ptr"
	Node ptr = L;
	do
        {//Se detiene al encontrar el elemento "ref"
            if(ptr.value() == ref)
            {
                band = true;
                break;
            } 
	    ptr = ptr.next();
	}while(ptr!= L); //ptr termina cuando es = ultimo
                   
        if(band == true)
        {//Solo si existe el elemento con valor "ref"
		if(ptr == L){//Si el elemento encontrado es el primero
			AñadirInicio(item); //Agregar elemento al inicio
		}
                else
                {
			//El nodo anterior (prev) tendra como sucesor al nodo que hemos creado
			ptr.prev().setNext(newNode);
                        newNode.setPrev(ptr.prev());
			newNode.setNext(ptr);
                        ptr.setPrev(newNode);                        
		}  
                //Mostrar los elementos de la lista
                System.out.println("Los elementos de la lista son:");
                showElements();
	}
        else
            System.out.println("No se encontró el item en la lista doblemente enlazada circular");
    }    
       
    public void removeFirst()
    {//Eliminar nodo inicial
	if(L != null)
        {//Si la lista no esta vacia
		L = L.next(); // L.next es el nuevo nodo inicial
                //se actualiza el ultimo nodo y se conecta con el nuevo L
                ultimo.setNext(L);
                L.setPrev(ultimo);
	}
    }
    
    
    private boolean vacia(){
        if(L == null) return true;
        else return false;
    }
               
    
    public void removeLast()
    {//Eliminar nodo final
	Node ptr = L;
	if(vacia())
        {
            System.out.println("Lista vacía");
            return;
        }
         //Lista no vacia
        if(ptr.next()==L)//Si la lista tiene solo un elemento
                L = null; 
        else
        {
            ultimo.prev().setNext(L);
            ultimo = ultimo.prev();
            L.setPrev(ultimo);
        }           
    }
    
    public void remove(int ref)
    {//Eliminar nodo según su valor
        boolean band = false;
	if(L != null)
        { //Lista no vacia
		if(L.value() == ref)
                { //Si es el primer nodo
			removeFirst();
                        band = true;
		}
                else
                {
                    Node ptr = L;
                    do
                    {
                        //Se detiene al encontrar el elemento "ref"
                        if(ptr.value() == ref)
                        {
                            ptr.prev().setNext(ptr.next());
                            ptr.next().setPrev(ptr.prev());
                            band = true;
                            //verificamos si ptr == ultimo para actualizar el puntero ultimo
                            if(ptr == ultimo)
                                ultimo = ultimo.prev();
                            break;
                        } 
                        ptr = ptr.next();
                    }while(ptr != L);                     
                }
                if(band == true)
                {
                    System.out.println("Los elementos después de eliminar el nodo ingresado de la lista son:");
                    showElements();
                }
                else
                    System.out.println("No se encontró el elemento a eliminar.");
        }
        else
            System.out.println("La lista doblemente circular está vacía.");
    }
    
        
   public void DividirLista(int valor)
   {
        //Creacion de nodo
        ListaDoblementeEnlazadaCircular newList = new ListaDoblementeEnlazadaCircular();
        ListaDoblementeEnlazadaCircular newList2 = new ListaDoblementeEnlazadaCircular();
        Node ptr = L;
        boolean band = false;
        do
        {
            if (band == false && ptr.value() != valor)
            {
                newList.AñadirFinal(ptr.value()); 
            }
                  
            else
            {
                newList2.AñadirFinal(ptr.value()); 
                band = true;
            }
            ptr = ptr.next();
        }while(ptr != L);  
                
        System.out.println("La lista dividida a partir del número: "+ valor);
        
        System.out.println("La lista1 es:");
        newList.showElements();
        
        System.out.println("La lista2 es:");
        newList2.showElements();
    }
    

   
}
