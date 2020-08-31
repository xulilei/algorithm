package DFS;

import javax.swing.*;
import java.util.List;

public class 一二九_求根到叶子节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int num ){
        if(root==null)return 0;
        int temp=num*10+root.val;
        if(root.left==null&&root.right==null)return temp;
        return dfs(root.left,temp)+dfs(root.right,temp);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
