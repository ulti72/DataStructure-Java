//Our Node
class Node{
    int data ;
    Node nextnode;
    public Node(int data){
        this.data =data;
    }
}
class listc{

private Node head ;

//Inserting data into LinkedList
public void append(int data){


    if(head==null)
       { head = new Node(data);
    return ;}
    //We assign head to current Node, and then perform operation on it, because we should not modify head, as it will be required to do further operation.
    Node current = head ;
    while(current.nextnode!=null)
        current = current.nextnode;
    current.nextnode = new Node(data);
}
//Printing all the nodes
public void listAll(){
    Node current = head ;
    while(current!=null){
        System.out.println(current.data);
        current = current.nextnode ;
    }
}
//Deleting A node
public void delete(int data){
     if(head==null)
        return;
    if(head.data ==data){
        head= head.nextnode ;
        return ;
    }
    Node current = head ;
    while(current.nextnode!=null){
        if(current.nextnode.data==data){
            current.nextnode=current.nextnode.nextnode ;
            return ;
        }
        current = current.nextnode ;
    }
    }

}
//Main Class
public class LinkedList{

    public static void main(String[] args){
        listc obj = new listc(); //creating an empty LinkedList
        //inserting elements to linkedlist
        obj.append(1);
        obj.append(2);
        obj.append(3);
        obj.append(4);
        obj.delete(3); //deleting 3
        obj.listAll(); //prinintg all elements .OUTPUT: 1,2,4
    }
}
