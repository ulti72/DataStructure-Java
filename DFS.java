import java.util.*;
import java.util.Stack;

public class DFS{
   static int flag=0;
   static int[][] ar ;
    public static List<Integer> nei(int u){
      List<Integer> n = new ArrayList<Integer>();
      for(int i=0;i<ar.length;i++){
           if(ar[u][i]==1) n.add(i);
      }
     return n ;
    }

    public static void addEdge(int u, int v){
        ar[u][v]=1;
        ar[v][u]=1;
    }

    public static HashMap<Integer,Integer> Dfs(int s , int g ){

      //for back tracking
      Stack<Integer> st = new Stack<Integer>();
      HashSet<Integer> hs = new HashSet<>();//for tracking visited vertex;
      HashMap<Integer,Integer> hm = new HashMap<>();//for tracking path
      st.push(s);
      hs.add(s);
      while(!st.isEmpty()){
        int curr = st.pop();
        if(curr==g){flag=1; return hm;}
        List<Integer> ne= nei(curr);
        for(Integer k:ne){
            if(!hs.contains(k)){
                  hs.add(k);
                  st.push(k);
                  hm.put(k,curr);
            }
        }
      }   return hm ;

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

     int start = 3 ;
     int goal = 10 ;
     HashMap<Integer,Integer> ans = Dfs(start,goal);

     int temp = goal;
     if(flag==1)
     while(ans.get(temp)!=3){

        System.out.println(ans.get(temp));
        temp = ans.get(temp);

     }
     else System.out.println("No path exist");


    }
}
