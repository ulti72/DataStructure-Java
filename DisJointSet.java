//Disjoint SET: Weighted Quick Union Find using path compression
//worst-case time: N+Mlog*N
//Where M union-find operations on a seet of N objects
import java.util.*;

class Set{
    //array for storing representative of each element
    private int[] id;
    //storing size of each set for performing union by rank/height
    private int[] sz;

//initializing set with n elements
    public Set(int n){
     id = new int[n];
     sz = new int[n];
     for(int i=0;i<n;i++){
        id[i]=i; // set id of each object to itself
        sz[i]=1; //setting size of each set 1 intitally
     }
    }

    //getting root/ representative of set
    public int root(int i){

        while(i!=id[i]){
           id[i]= id[id[i]];//path compression::::
           i = id[i];
        }
        return i;
    }

//Boolean returning they belongs to same set or not
    public boolean connected(int p, int q){
        return root(p)==root(q) ;
    }
//Performing union:
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i==j)return ;
        if(sz[i]<=sz[j]){id[i]=j; sz[j]+=sz[i];}
        else{id[j]=i;sz[i]+=sz[j];}
    }

//Returning size of set: In which element P belongs
    public int size(int p){
        int root = root(p);
        return sz[root];
    }



}

public class DisJointSet{

public static void main(String[] args){

    Set obj = new Set(5);
    obj.union(0,1);
    obj.union(2,3);
    obj.union(0,4);
    System.out.println(obj.connected(1,4));
    System.out.println(obj.size(4));
    System.out.println(obj.size(2));

}


}
