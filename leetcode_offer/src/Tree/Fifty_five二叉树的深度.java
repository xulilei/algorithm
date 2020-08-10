package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Fifty_five二叉树的深度 {
    //递归
    private int maxDepthDG(TreeNode root) {
        if(root==null)return 0;
        return Math.max(maxDepthDG(root.left),maxDepthDG(root.right))+1;
    }
    //迭代
    private int maxDepthDD(TreeNode root){
        int res=0;
        if(root==null)return 0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }
            res++;
        }
        return res;
    }

}
