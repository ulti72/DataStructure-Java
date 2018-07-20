//Node class
class Node{

int data ;
Node next ;

public Node(int data){
    this.data = data ;
  }
}

//Stack class
class S{
    Node top ;

//Push: inserting data at top
    public void push(int data){

     Node newnode = new Node(data);
     if(top==null)
        top = newnode ;

    newnode.next = top;
    top = newnode ;
   }
//Pop: removeing top value from stack
    public void pop(){
        top=top.next ;
    }
//checking stack is empty or not
    public boolean isEmpty(){
        return (top==null);
    }
//getting top of stack
    public int top(){
         return top.data;
    }

}
//main class ;
public class Stack{

public static void main(String[] args){

  S stk  = new S();  //creating a empty stack;

  System.out.println("Adding 2 to stack");
  stk.push(2);
  System.out.println("Adding 3 to stack");
  stk.push(3);
  System.out.println("Stack Empty: "+stk.isEmpty());
  System.out.println("Stack Top: "+stk.top());
  stk.pop();
  System.out.println("Stack Top after pop: "+stk.top());
}

}
