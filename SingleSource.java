import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
//Single pair shortest path : Shortest distance from a source(let s )  to all other vertex.
//On unweighted graph, using BFS
//Vertex starts from 0 to n-1

public class SingleSource{

    static HashMap<Integer,List<Integer>> adj  ;
   static int[] distance ;
    public static void graph(int n){
        adj = new HashMap<>();
        distance = new int[n];
        Arrays.fill(distance,-1);
        for(int i=0;i<n;i++){
            List<Integer> l = new ArrayList<Integer>() ;
            adj.put(i,l);
        }
    }

    public static void addEdge(int u, int v){
            (adj.get(u)).add(v);
            (adj.get(v)).add(u);
    }

    public static List<Integer> nei(int u){
           return (adj.get(u));

    }

    public static void bfs(int s ){
        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        hs.add(s);
        distance[s]=0;
        while(!q.isEmpty()){
            int curr = q.remove();
            List<Integer> l = nei(curr);
            for(Integer nn : l){
                if(!hs.contains(nn)){
                    hs.add(nn);
                    q.add(nn);
                    distance[nn]= distance[curr]+1;
                }
            }
        }


    }
   public static void distCal(int s ){

    int n  = distance.length ;
    bfs(s);
    System.out.println("Distance From vertex: "+s);
    for(int i=0;i<n;i++)
    System.out.println("Vertex: "+i+" Distance: "+distance[i]);



   }
    public static void main(String[] args){
          graph(5);
          addEdge(0,1);
          addEdge(1,2);
          addEdge(0,2);
          addEdge(3,4);
          distCal(0);
    }
}
