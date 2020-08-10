package DP;

public class SixtySix_构建成绩数组 {
    public int[] constructArr(int[] a) {
        if(a.length==0)return new int[0];
        int[]res=new int[a.length];
        int[]left=new int[a.length];
        int leftInit=1;
        int[]right=new int[a.length];
        int rightInit=1;
        for(int i=0;i<a.length;i++){
            left[i]=leftInit;
            leftInit*=a[i];
        }
        for(int i=a.length-1;i>=0;i--){
            right[i]=rightInit;
            rightInit*=a[i];
        }
        for(int i=0;i<a.length;i++){
            res[i]=left[i]*right[i];
        }
        return  res;
    }
}
