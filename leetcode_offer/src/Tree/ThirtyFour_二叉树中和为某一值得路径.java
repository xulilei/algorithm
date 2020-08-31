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
        if(root==null)return;
        path.add(root.val);
        target-=root.val;

        if(target==0&& root.left==null&&root.right==null){
            res.add(new LinkedList<>(path));
            return;
        }
        recur(root.left,target);
        recur(root.right,target);
        //我要回去，我就要把他给减了
        path.removeLast();
    }
}
