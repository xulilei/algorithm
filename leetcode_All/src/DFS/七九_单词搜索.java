package DFS;

public class 七九_单词搜索 {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0))return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int i,int j,int index){
        if(i>board.length||i<0||j>board[0].length||j<0||board[i][j]!=word.charAt(index))return false;
        if(index==word.length()-1)return true;
        char temp=board[i][j];
        board[i][j]='@';
        boolean res=dfs(board, word, i+1, j, index+1)||dfs(board, word, i, j+1, index+1)
                               ||dfs(board, word, i-1, j, index+1)||dfs(board, word, i, j-1, index+1);
        board[i][j]=temp;
        return res;
    }
}
