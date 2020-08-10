package 滑动窗口;

import java.sql.ClientInfoStatus;
import java.util.LinkedList;
import java.util.List;

public class FiftySeven_I_和为S的两个数字 {
    public int[][] findContinuousSequence(int target) {
        List<int[]>res=new LinkedList<>();
        int l=1,r=1,sum=0;
        while (l<=target/2){
            if(sum<target){
                sum+=r;
                //r最后一次满足是超出边界的
                r++;
            }else if(sum>target){
                sum-=l;
                l++;
            }else {
                int[]arr=new int[r-l];
                for(int i=l;i<r;i++){
                    arr[i-l]=l;
                }
                res.add(arr);
                sum-=l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
