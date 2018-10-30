//Weighted graph, with vertex starting from 0 to n-1
//
import java.util.*;

//Object  end vertex and weight of an edge

//End of Edge class
//Weighed Graph Class
public class GraphWei{

     class Edge{

        int to ;
        int weight;
        public  Edge(int to , int weight){
            super();
            this.to = to ;
            this.weight= weight ;
        }

        public String toString(){
            return (to+" W("+weight+")");
        }
    }

//Adjency list for graph
   public static HashMap<Integer,List<Edge>> adj ;

//Initializing graph with 0 to n-1 nodes
    public static void graph(int n){

        adj = new HashMap<>();
        for(int i=0;i<n;i++){
            List<Edge> obj = new ArrayList<>();
            adj.put(i,obj);
        }
    }

//adding edge u to v with weight w
    public static void addEdge(int u, int v, int w){
         Edge obj1 = new Edge(v,w);
         Edge obj2 = new Edge(u,w);
            (adj.get(u)).add(obj1);
            (adj.get(v)).add(obj2);
    }

//Getting neighbours of u
    public static List<Edge> getNei(int u){
         return adj.get(u);
    }
//main method
public static void main(String[] args){

        graph(4);
        addEdge(0,1,9);
        addEdge(0,3,10);
        addEdge(1,2,40);
        addEdge(2,3,80);
        List<Edge> l = getNei(0);
        for(Edge edge : l)
            System.out.println("0-->"+edge);
    }
}
