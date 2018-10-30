//Weighted graph, with vertex starting from 0 to n-1
//
import java.util.*;

//Object  end vertex and weight of an edge this object also used for putting updated distance and to
    class Edge implements Comparable<Edge>{

        int to ;
        int weight;
        public  Edge(int to , int weight){
            this.to = to ;
            this.weight= weight ;
        }
        public int getto(){
            return to ;
        }
        public int getweight(){
            return weight ;
        }
        public String toString(){
            return (to+" W("+weight+")");
        }
        public int compareTo(Edge e){
            return this.weight - e.weight ;
        }
    }
//End of Edge class
//Weighed Graph Class
public class Dijkstra{

//Adjency list for graph
   public static HashMap<Integer,List<Edge>> adj ;
  static int[] distance ;

//Initializing graph with 0 to n-1 nodes
    public static void graph(int n){
        distance = new int[n];
        for(int i=0;i<n;i++)
            distance[i]= Integer.MAX_VALUE ;

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
//Dijkstra: finding minimum weight to reach g from s
    public static int Dij(int s , int g){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();
        distance[s]=0;
        pq.add(new Edge(s,0));
        while (!pq.isEmpty()){
            Edge curr = pq.remove();
            if(curr.getto()==g)return distance[g];
            if(!hs.contains(curr.getto())){
                hs.add(curr.getto());
                List<Edge> ll = getNei(curr.getto()) ;
                for(Edge e :ll ){
                    if(!hs.contains(e.getto())){

                        if(distance[e.getto()]>(distance[curr.getto()] +e.getweight())){

                        distance[e.getto()] = distance[curr.getto()] +e.getweight() ;
                        pq.add(new Edge(e.getto(),distance[e.getto()]));

                       }
                    }
                }
            }

        }
            return distance[g] ;
    }
//main method
public static void main(String[] args){

        graph(4);
        addEdge(0,1,10);
        addEdge(0,3,5);
        addEdge(1,2,10);
        addEdge(2,3,5);
        addEdge(0,3,30);

            System.out.println(Dij(0,3));
    }
}
