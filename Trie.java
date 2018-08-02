import java.util.*;
class TrieNode{
    boolean endOfWord ;
    Map<Character,TrieNode> children ;
    public TrieNode(){
        endOfWord = false ;
        children = new HashMap<>();
    }
}
class TrieObj{
    TrieNode root=new  TrieNode();
    //Time complexity O(m) and space complexity O(m) where m is key length
    char[] letters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public void insert(String word){
        TrieNode  current = root ;
        for(int i =0 ;i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node ;
        }
        current.endOfWord = true ;
    }

    public boolean search(String word){

        TrieNode current = root ;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null)
                return false;
            current = node ;

        }

        return true ;


    }
    public int prefixCount(String word){
        int count =0;
        TrieNode current = root ;
        for(int i=0;i<word.length();i++){
            char ch =  word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node ==null)
                return -1;
            current = node ;
        }
        count = wordCount(current);
        return count ;
    }
    public int wordCount(TrieNode current){
        int count=0;
        if(current.endOfWord==true||current==null)
            count++;
        for(int j=0; j<letters.length;j++){
            TrieNode temp = current.children.get(letters[j]);
            if(temp!=null){
                count += wordCount(current.children.get(letters[j]));
            }
        }
          return count ;
    }


}

public class Trie{

    public static void main(String[] args){
        TrieObj obj = new TrieObj();
        obj.insert("cat");
        obj.insert("car");
        obj.insert("cats");
        obj.insert("come");

        //obj.getc("ca");
        System.out.println(obj.prefixCount("ca"));


}

}
