package 广联达;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 数组元素提取到第一个有序最少次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                map.put(a[i], i);
            }
            Arrays.sort(a);
            int sum = 0;
            int newIndex=-1;
            for (int j = n-1; j >0; j--) {
                if (map.get(a[j]) < map.get(a[j-1])) {
                    map.put(a[j-1],newIndex--);
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }
}


