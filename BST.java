//Node of Our Tree
class Node{

    int key;

    Node leftChild ;
    Node rightChild ;

    Node(int key){
        this.key = key;
    }

}

//Creating BinaryTree
 class BinaryTree{
//Our root ;
     Node root ;
     //Adding Node:
     public void addNode(int key){
 //creating new node,to add in our tree
        Node newNode = new Node(key);

//if our tree is not yet created, making newnode root
        if(root==null){
            root = newNode ;
        }
        //if tree is already created, jump into this
        else{
            //creating focusNode to traverse and find parent for our Node
            Node focusNode= root ;
            //running till we find parent for our tree
            while(true){
                 //if data need to  insert less than root
                if(key<=focusNode.key){
                    //while traversing checking if node leftchild was null
                    if(focusNode.leftChild==null){
                        focusNode.leftChild = newNode ; //left child was null, so we insert our data
                        return ;
                    }else // if child was not null, we move to our next node, to check it will parent of our newnode or node
                    focusNode= focusNode.leftChild ;
                }
                //else if data need to insert greater than our root
                else{
//while traversing checking if node right was null
                    if(focusNode.rightChild==null){
                        focusNode.rightChild= newNode ; //right child was null, so we insert our data
                        return ;
                    }else
                    focusNode= focusNode.rightChild ;//if child was not null, we move to our next node, to check it will parent of our newnode or node


            }
                }

        }
     } //END of addNode

   //Inorder traversing Node: Left->Root->Right  print in increasing order.
     public void inOrderTraverseTree(Node focusNode){
        if(focusNode!=null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.key);
            inOrderTraverseTree(focusNode.rightChild);
        }
     }

}

public class BST{
    public static void main(String[] args){
       BinaryTree t = new BinaryTree(); // creating Binary search tree.
       t.addNode(50);    // adding elements
       t.addNode(25);
       t.addNode(60);
       t.addNode(60);
       t.addNode(75);

       t.inOrderTraverseTree(t.root); //printing tree inorder

    }

}

