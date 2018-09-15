import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class BFS{

 static int[][] ar ;

 public static void addEdge(int u, int v){
      ar[u][v]=1;
      ar[v][u]=1 ;
 }

 public static List<Integer> nei(int u){
    int l = ar.length;
    List<Integer> n = new ArrayList<>();
    for(int i =0;i<l;i++){
        if(ar[u][i]==1)n.add(i);
    }
    return n ;
 }

 public static HashMap<Integer,Integer> Bfs(int s, int g){

      HashMap<Integer,Integer> hm = new HashMap<>();
      Queue<Integer> q = new LinkedList<Integer>();
      HashSet<Integer> hs = new HashSet<>();

      q.add(s);
      hs.add(s);
      while(!q.isEmpty()){
        int curr = q.remove();
        if(curr==g)return hm ;
        List<Integer> l = nei(curr);
        for(Integer node : l ){
            if(!hs.contains(node)){
               q.add(node);
               hs.add(node);
               hm.put(node,curr);

           }

        }

      }
return hm ;
 }



    public static void main(String[] args){

    Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     ar = new int[n][n];
     addEdge(10,0);
      addEdge(0,1);
       addEdge(1,2);
        addEdge(2,3);
         addEdge(3,4);
         addEdge(4,5);
          addEdge(5,6);
           addEdge(6,7);
            addEdge(7,8);
             addEdge(7,9);
              addEdge(10,8);

     int start = 3 ;
     int goal = 10 ;

    HashMap<Integer,Integer> hm = Bfs(start,goal);
    int temp = goal;
    while(hm.get(temp)!=start){
             System.out.println(hm.get(temp));
             temp = hm.get(temp);
    }

    }
}
