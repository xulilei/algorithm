package Tree;

public class ThirtyThree_二叉树搜索的后序遍历 {
    public static void main(String[] args) {
        int[] a={1,3,2,7,9,8,5};
        System.out.println(verifyPostorder(a));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    static boolean  recur(int[] postorder, int i, int j) {
        //递归结束条件
        if(i >= j) return true;
        //索引记录以根节点的左右子树分界
        int p = i;
        //遇到的第一个数比根节点大的时候其左边都是左子树，右边都是右子树
        while(postorder[p] < postorder[j]) p++;
        //记录分界点
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        //以各自左右子树递归
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
