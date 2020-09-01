package Tree;

import java.util.ArrayList;
import java.util.List;

public class ThirtyFour_二叉树中和为某一值得路径II {
    private  List<List<Integer>>res;
    public  List<List<Integer>> pathSum(TreeNode root, int sum) {
        res=new ArrayList<>();
        preOrder(root, sum);
        return res;
    }
    //由于可能从任意节点开始，因此采用先序遍历每一个节点，再dfs查找符合条件的
    private  void preOrder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        dfs(root, sum,new ArrayList<>());
        preOrder(root.left, sum);
        preOrder(root.right, sum);
    }

    private  void dfs(TreeNode root, int sum, List<Integer>temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        sum-=root.val;
        if (sum==0) {
            res.add(new ArrayList<>(temp));
            //在这里能return，因为要继续的
        }
        dfs(root.left, sum - root.val,temp);
        dfs(root.right, sum - root.val,temp);
        //回溯
        temp.remove(temp.size()-1);
    }
}
