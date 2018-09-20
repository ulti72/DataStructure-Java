import java.util.*;
import java.util.Stack;
//vertices starts from 0to n-1
//graph is bidirectional
public class GraphComponents{

static HashMap<Integer,List<Integer>> adj ;
static int component ;

public static void graph(int n ){
   adj = new HashMap<>();
   for(int i=0;i<n;i++){
       List l = new ArrayList<Integer>();
       adj.put(i,l);
   }
}

public static void addEdge(int u, int v){
      (adj.get(u)).add(v);
      (adj.get(v)).add(u);
}

public static List<Integer> neigh(int u){
     return (adj.get(u));
}

public static HashSet<Integer> dfs(int u,HashSet<Integer> hs){
   Stack<Integer> st = new Stack<>();
   st.push(u);
   hs.add(u);
   component++;
   while(!st.isEmpty()){
         int cur = st.pop();
         System.out.print(cur+" ");
         List<Integer> nei = neigh(cur);
         for(Integer s : nei){
            if(!hs.contains(s)){
                st.push(s);
                hs.add(s);
            }
         }
   }
   System.out.println();
   return hs ;

}

public static void components(int n ){
    HashSet<Integer> hs=new HashSet<Integer>() ;
    for(int i=0;i<n;i++){
        if(!hs.contains(i)){
           hs =  dfs(i,hs);
        }
    }
    System.out.println("Total Number of Components: "+component);
}

public static void main(String[] args){
    int n = 7 ;
        graph(n);
        addEdge(0,1);
         addEdge(0,2);
          addEdge(1,3);
           addEdge(2,3);
            addEdge(4,5);
            components(n);

}

}
