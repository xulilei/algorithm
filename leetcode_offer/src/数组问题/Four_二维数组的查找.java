package 数组问题;

public class Four_二维数组的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix==null)return false;
        int row=matrix.length;
        int column=matrix[0].length;
        int i=0,j=column-1;
        boolean flag=false;
        while (i<row&&j>=0){
            if(matrix[i][j]>target)j--;
            else if(matrix[i][j]<target)i++;
            else return true;
            }
        return  false;
        }

}


