package 数组问题;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwentyNine_有条件的顺时针打印矩阵 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] mn = sc.nextLine().split(" ");
        int m=Integer.parseInt(mn[0]);
        int n=Integer.parseInt(mn[1]);
        if(m>=10&&m<=1000&&n>=10&&n<=1000){
            int[][] matrix=new int[m][n];
            List<String> list = spiralOrder(matrix);
            if(list==null) System.out.println("[]");
            System.out.println(list.toString());
        }
    }

    public static List<String> spiralOrder(int[][] matrix) {
        List<String>resList=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return null;
        }
        //定义边界
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int index=1;
        while (true){
            for(int i=left;i<=right;i++){
                if(isOk(index)){
                    String temp="["+top+","+i+"]";
                    resList.add(temp);
                }
                index++;
            }
            if(++top>bottom)break;

            for(int i=top;i<=bottom;i++){
                if(isOk(index)){
                    String temp="["+i+","+right+"]";
                    resList.add(temp);
                }
                index++;
            }
            if(--right<left)break;

            for(int i=right;i>=left;i--){
                if(isOk(index)){
                    String temp="["+bottom+","+i+"]";
                    resList.add(temp);
                }
                index++;
            }
            if(--bottom<top)break;

            for(int i=bottom;i>=top;i--){
                if(isOk(index)){
                    String temp="["+i+","+left+"]";
                    resList.add(temp);
                }
                index++;
            }
            if(++left>right)break;
        }
        return resList;
    }

    public static boolean isOk(int s) {
        String s1 = String.valueOf(s);
        StringBuffer sb=new StringBuffer(s1);
        sb.reverse();
        if(sb.length()>1){
            return Integer.parseInt(String.valueOf(sb.charAt(0)))==7&&Integer.parseInt(String.valueOf(sb.charAt(1)))%2==1;
        }else return false;
    }
}
