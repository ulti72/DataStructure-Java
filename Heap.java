//Max heap: parent is always greater than childrens .
import java.util.*;
//Implementing Heap using ArrayList::
class heapy{
//Our Heap :)
ArrayList<Integer> heap = new ArrayList<>();

//inserting data
public void insert(int data){
  heap.add(data); //adding at the end
  siftUp();  // then putting it , at right positon
  }

//deleting max elemnt, that is our top.
public int deletemax() throws NoSuchElementException{
   if(heap.size()==0)
     throw new NoSuchElementException();
   else if(heap.size()==1)
      return heap.remove(0);

  int deleted= heap.get(0);
  heap.set(0,heap.remove(heap.size()-1)); //removing last element and setting it to front
  shiftDown(); // after removing rignt elemtn , we put last element at top, now putting that top at right place
  return deleted ; //return the element we deleted

  }

  //size of our heap
public int size(){
    return heap.size();
  }
//maximum element in our heap: i.e top element
public int maxElement(){
    return heap.get(0);
  }
//checking heap is empty or not
public boolean isEmpty(){
    return heap.isEmpty();
  }

//Used when element is inserted at end, and need to go at correct position
public void siftUp(){

   int current = heap.size()-1;
   while(current>0){
   int p = (int)Math.floor((current-1)/2);
   if(heap.get(current)>heap.get(p)){
     //do swap
     int temp = heap.get(current);
     heap.set(current,heap.get(p));
     heap.set(p,temp);
     current = p ;

   }
   else
     break ;
  }
}

//Used when element deleted form top, then last element come at top, and we need to place that element at correct position:
public void shiftDown(){

    int parent = 0;
        int left = 2*parent+1;
        while (left < heap.size()) { //checking it has left child or not
            int select=left, right=left+1;
            if (right < heap.size()) { // there is a right child
                if (heap.get(right)>heap.get(left) ){  //selecting left or child, (which is greater)
                    select++;
                }
            }
            if (heap.get(parent)<heap.get(select)) { //after selecting child, compare it to parent, and swap
                    // switch
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(select));
                    heap.set(select, temp);
                    parent = select;
                    left = 2*parent+1;
            } else {
                break;
            }
        }
  }
}



public class Heap{

public static void main(String[] args){
//Operations:  insert(data) , isEmpty() , deletemax(), size(), maxElement
heapy obj = new heapy();
obj.insert(15);
obj.insert(9);
obj.insert(11);
obj.insert(7);
obj.insert(6);
obj.insert(8);
obj.insert(16);

System.out.println(obj.maxElement());
System.out.println(obj.deletemax());
System.out.println(obj.maxElement());
}

}
