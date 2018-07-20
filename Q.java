//Queue implementation using LinkedList;

//Our Node of queue
class Node{

    int data ;
    Node next ;
    public Node(int data){
        this.data = data ;
    }
}
//Creating Queue
class Qe{
    Node head ; //point to front
    Node back ; //point to tail

 //Enqueue: from tail
 public void enq(int data){

    Node newnode = new Node(data);//creating node to insert

    if(head==null){
        head = newnode ;
        back  = head ;
    }
    else{
        back.next = newnode ;
        back = newnode ;
    }
 }

//Dequeue: removing from front
  public void dq(){
    if(head==null)
        return;
     head = head.next ;
 }
//Getting front
 public int head(){
   return head.data ;
 }
 //Getting tail
 public int back(){
    return back.data  ;
 }
//Checking queue is empty or not.
 public boolean isEmpty(){
    return (head==null) ;

 }
}

public class Q{

  public static void main(String[] args){

    Qe q = new Qe();//creating an empty queue
    q.enq(1);  //adding elements to queue
    q.enq(2);
    q.enq(3);
    System.out.println(q.head()); //printing head
    System.out.println(q.back()); //printing tail
    System.out.println(q.isEmpty()); //checking queue is empty or not


  }
}
