package TrieProblems;

public class WordSearchII {
}

class Solution {

    List<String> result;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        result=new ArrayList<>();
        this.board=board;
        Trie root=new Trie();

        for(String s:words){
            Trie temp=root;
            for(char c:s.toCharArray()){
                if(temp.t[c-'a']==null){
                    temp.t[c-'a']=new Trie();
                }
                temp=temp.t[c-'a'];
            }
            temp.end=true;
            temp.word=s;
        }
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(root.t[board[i][j]-'a']!=null){
                    helper(i,j,root);
                }
            }
        }

        return result;
    }

    void helper(int row,int col,Trie root){

        if(row<0 || col<0 || row>= board.length || col >= board[0].length || board[row][col]=='#' || root.t[board[row][col]-'a']==null){
            return;
        }

        if(root.t[board[row][col]-'a'].end){
            result.add(root.t[board[row][col]-'a'].word);
            root.t[board[row][col]-'a'].end=false;
        }

        root=root.t[board[row][col]-'a'];
        char c=board[row][col];

        board[row][col]='#';

        helper(row+1,col,root);
        helper(row-1,col,root);
        helper(row,col+1,root);
        helper(row,col-1,root);

        board[row][col]=c;

    }

    class Trie{
        boolean end;
        Trie[] t;
        String word;

        Trie(){
            end=false;
            t=new Trie[26];
        }
    }
}