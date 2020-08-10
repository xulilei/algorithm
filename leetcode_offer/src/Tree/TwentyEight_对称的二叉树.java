package Tree;

import ListNode.ListNode;
import org.omg.PortableInterceptor.ClientRequestInfo;

import java.util.Deque;
import java.util.LinkedList;

public class TwentyEight_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return root==null?true:recur(root.left,root.right);

    }
    //分析对称条件即
    //root.left=root.right
    //root.left.left=root.right.right
    public boolean recur(TreeNode A,TreeNode B){
        if(A==null&&B==null)return true;
        if(A==null||B==null||A.val!=B.val)return false;
        return recur(A.left,B.right)&&recur(A.right,B.left);
    }
    //迭代
    public boolean isSymmetricB(TreeNode root) {
        if(root==null)return true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()){
            TreeNode left=deque.pollFirst();
            TreeNode right=deque.pollLast();
            //说明当前路径满足
            if(left==null&&right==null)continue;
            //当前路径不满足
            if(left==null||right==null)return false;
            if(left.val!=right.val)return false;
            //先纵向比，再横向比
            deque.addFirst(left.right);
            deque.addFirst(left.left);
            deque.addLast(right.left);
            deque.addLast(right.right);
        }
        return true;
    }

}
