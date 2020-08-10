package DFS;

public class twelve_矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (dfs(board,words,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }
    //i,j为行和列，k为word索引
    boolean dfs(char[][]board,char[]word,int i,int j,int k){
        //定义递归终止失败条件
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word[k])return false;
        //定义递归终止正确条件，当k与word的长度相等说明找到了;
        if (k==word.length-1) return true;
        //防止回头
        char temp=board[i][j];
        board[i][j]='&';
        boolean res=dfs(board, word, i+1, j, k+1)||dfs(board, word, i, j+1, k+1)
                           ||dfs(board, word, i-1, j, k+1)||dfs(board, word, i, j-1, k+1);
        board[i][j]=temp;
        return res;
    }
}
