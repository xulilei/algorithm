package Tree;

import java.util.ArrayList;
import java.util.List;

public class FiftyFour_二叉搜索树的第K大节点 {
    //二叉搜索树的中序遍历为一个递增序列，该递增序列的逆序的第k个即为所求
    static int count;
    static int res;

    //在递归体中判断次数
    public static int kthLargestA(TreeNode root, int k) {
        count=k;
        dfsA(root);
        return k;
    }
    static void dfsA(TreeNode root){
        if(root==null)return;
        dfsA(root.right);
        //即在本轮递归结束后res=0时，其父节点即为所求
        if(count==0)return;
        if(--count==0)res=root.val;
        dfsA(root.left);
    }

    //先中序逆序遍历放入list集合，再取
    public int kthLargest(TreeNode root, int k) {
        List<Integer>list=new ArrayList<>();
        dfs(root,list);
        return list.get(k-1);
    }
    void dfs(TreeNode root, List<Integer>list){
        if(root==null)return;
        dfs(root.right,list);
        list.add(root.val);
        dfs(root.left,list);
    }
}
