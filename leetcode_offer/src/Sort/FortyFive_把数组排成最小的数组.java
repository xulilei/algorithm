package Sort;

public class FortyFive_把数组排成最小的数组 {

    public String minNumber(int[] nums){
        String[] strs=new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs,0,strs.length-1);
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();


    }


    void quickSort(String[] strs,int left,int right){
        if(left>=right)return;
        int l=left,r=right;
        String base=strs[left];
        while (l<r){
            while ((strs[r]+base).compareTo(base+strs[r])>=0&&l<r)r--;
            while ((strs[l]+base).compareTo(base+strs[l])<=0&&l<r)l++;
            String temp=strs[l];
            strs[l]=strs[r];
            strs[r]=temp;
        }
        strs[left]=strs[l];
        strs[l]=base;
        quickSort(strs, left, l-1);
        quickSort(strs, l+1, right);

    }
}
