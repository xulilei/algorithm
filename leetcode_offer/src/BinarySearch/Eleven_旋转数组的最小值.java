package BinarySearch;

public class Eleven_旋转数组的最小值 {
    public int minArray(int[] numbers) {
        //二分法
        int i=0,j=numbers.length-1;
        while (i<j){
            int m=(i+j)/2;
            if(numbers[m]>numbers[j]){
                i=m+1;
            }else if(numbers[m]<numbers[j]){
                j=m;
            }else j--;
        }
        return numbers[j];

    }
}
