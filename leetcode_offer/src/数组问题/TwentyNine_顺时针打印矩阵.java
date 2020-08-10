package 数组问题;

public class TwentyNine_顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0)return new int[0];
        //定义边界
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int index=0;
        int[] res=new int[(right+1)*(bottom+1)];
        while (true){
            for(int i=left;i<=right;i++){
                res[index++]=matrix[top][i];
            }
            if(++top>bottom)break;

            for(int i=top;i<=bottom;i++){
                res[index++]=matrix[i][right];
            }
            if(--right<left)break;

            for(int i=right;i>=left;i--){
                res[index++]=matrix[bottom][i];
            }
            if(--bottom<top)break;

            for(int i=bottom;i>=top;i--){
                res[index++]=matrix[i][left];
            }
            if(++left>right)break;
        }
        return res;
    }
}
