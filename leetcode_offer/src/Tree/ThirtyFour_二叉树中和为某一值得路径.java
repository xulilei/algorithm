package Tree;

import java.util.LinkedList;
import java.util.List;

public class ThirtyFour_二叉树中和为某一值得路径 {
    LinkedList<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        recur(root,sum);
        return  res;

    }
    public void recur(TreeNode root,int target){
        //遍历到子树后开启回溯
        if(root==null)return;
        //先从根节点开始记录所有值到链表中
        path.add(root.val);

        target-=root.val;
        //满足这样的条件的路径即为所求
        if(target==0&& root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
        }
        //先从左子树找
        recur(root.left,target);
        //再从右子树找
        recur(root.right,target);
        //我要回去，我就要把他给减了
        path.removeLast();
    }
}
