package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThirtyTwo_1_从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root==null)return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer>list=new ArrayList<>();
        while (!queue.isEmpty()){
            //一层一层打印就需要for
            for(int i=queue.size();i>0;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
