package dsa;

public class SingleLinkedList {
	
    public Node first;
    public Node last;
    
    public SingleLinkedList() {
        first = last = null;
    }
    
    //insereaza un element in lista
    public void insert(int data) {
        Node elementNou = new Node(data); //se initializeaza un nod
        
        //daca nu exista elemente in lista (first este null),
        //nodul initializat este primul elem introdus in lista
        if(first == null){
        	elementNou.next = null;
            first = elementNou;
            last = elementNou;
        }
        //daca exista elemente in lista, elementul curent este adaugat dupa ultimul nod
        //si devine ultimul nod
        else {
        	elementNou.next = null;
            last.next = elementNou;
            last = elementNou;
        }
    }
    
    //sterge un element din lista
    public Node delete(int data){
        Node tmp  = first;
        Node prev = first;
        
        while(tmp != null){
            if(tmp.data == data){
                if(tmp == first){
                    if(tmp == last){
                        first = last = null;
                    }
                    else{
                        first = tmp.next;
                    }     
                 }
                else if(tmp == last)
                {
                    prev.next = tmp.next;
                    last = prev;
                }
                else{
                    prev.next = tmp.next;
                }
                return tmp;
            }
            
            prev = tmp;
            tmp = tmp.next;
        }
        return null;
    }
    
    public void printList(){
        Node temp = first;
       if(first == null){
           System.out.println("Lista nu contine elemente.");
       }
       else{
        while(temp != null){
            temp.printNode();
            temp = temp.next;
        }
       }
    }
    
    public Boolean isEmpty(){
        return first == null;
    }
    
    public static void main(String[] args) {
	    SingleLinkedList list = new SingleLinkedList();

	    list.insert(1);
	    list.insert(2);
	    list.insert(3);
	    list.insert(4);
	    list.insert(5);

	    list.printList();

	    while(!list.isEmpty()) {
		    Node deletedLink = list.delete(4);
                    if(deletedLink == null){
                        System.out.println("Elementul nu se afla in lista.");
                        break;
                    }
		    System.out.print("Sters: ");
		    deletedLink.printNode();
		    System.out.println("");
	    }
	    list.printList();
    }
}
 