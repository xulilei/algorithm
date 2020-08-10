package 数组问题;

public class Four_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[]nums1={1,2};
        int[]nums2={3,4};
        System.out.println(findMedianSortedArraysMerge(nums1, nums2));
    }
    //第一种使用归并排序做
    public static double findMedianSortedArraysMerge(int[] nums1, int[] nums2) {
        int[] ints = mergeSort(nums1, nums2);
        double res=0;
        int size=ints.length;
        if(size%2==1){
            res=ints[size/2];
        }else {
            res=(ints[size/2]+ints[size/2-1])/2.0;
        }
        return res;

    }
    public static int[] mergeSort(int[] nums1, int[] nums2){
        int[] res=new int[nums1.length+nums2.length];
        int index=0;
        int start1=0,end1=nums1.length;
        int start2=0,end2=nums2.length;
        while (start1<end1&&start2<end2){
            if(nums1[start1]>nums2[start2]){
                res[index++]=nums2[start2++];
            }else {
                res[index++]=nums1[start1++];
            }
        }
        while (start1<end1){
            res[index++]=nums1[start1++];
        }
        while (start2<end2){
            res[index++]=nums2[start2++];
        }
        return res;
    }

    //第二种采用二分查找，即寻找两个数组总长度，（奇数+1）/2小或者（偶数/2）小+（偶数/2）+1的平均数
    public static double findMedianSortedArraysBinary(int[] nums1, int[] nums2) {
        int lengthSum=nums1.length+nums2.length;
        return lengthSum%2==1?binarySearchK(nums1,nums2,(lengthSum+1)/2)
                :(binarySearchK(nums1,nums2,lengthSum/2)+binarySearchK(nums1,nums2,lengthSum/2+1))/2.0;
    }
    public static double binarySearchK(int[]nums1,int[] nums2,int k){
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        //排除掉上一轮不可能的范围后，起始索引
        int startIndex1=0,startIndex2=0;
        int length1=nums1.length,length2=nums2.length;
        //定义边界
        while (true){
            //。由于halfK不为0，这轮起始索引如果达到最后说明这个数组不满足要求，直接输出另一个数组的第k个元素
            if(startIndex1==length1)return nums2[startIndex2+k-1];
            if(startIndex2==length2)return nums1[startIndex1+k-1];
            //找到两个数组的第1小的，直接比较两个数组开头，找到小的那个
            if(k==1)return Math.min(nums1[startIndex1],nums2[startIndex2]);


            //防止数组越界，如果起始索引+第k个元素大于最大索引，则直接以最大索引为比较对象
            // (k/2-1) + (k/2-1) <= k-2
            int halfK=k/2;
            int compareIndex1=Math.min(startIndex1+halfK,length1)-1;
            int compareIndex2=Math.min(startIndex2+halfK,length2)-1;
            int temp1=nums1[compareIndex1],temp2=nums2[compareIndex2];
            if(temp1<=temp2){
                //k减去这轮排除掉的个数
                k-=(compareIndex1-startIndex1+1);
                //下一轮的起始位置
                startIndex1=compareIndex1+1;
            }else {
                k-=(compareIndex2-startIndex2+1);
                startIndex2=compareIndex2+1;
            }

        }

    }
}
