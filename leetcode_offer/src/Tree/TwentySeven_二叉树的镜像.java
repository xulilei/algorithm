package Tree;

import ListNode.ListNode;
import sun.java2d.loops.GraphicsPrimitiveProxy;

import java.util.LinkedList;
import java.util.Queue;

public class TwentySeven_二叉树的镜像 {
    //递归
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return null;
        //交换
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return  root;
    }
    //迭代
    public TreeNode mirrorTreeB(TreeNode root) {
        if(root==null)return null;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //取出本轮要交换父节点
            TreeNode temp=queue.poll();
            //交换该父节点的左右子节点
            TreeNode left=temp.left;
            temp.left=temp.right;
            temp.right=left;
            //将交换完的子节点添加到队列
            //(temp.right,temp.left.left,temp,left.right)
            if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
        }
        return root;


    }
}
