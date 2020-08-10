package Tree;

import ListNode.ListNode;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;

public class TwentySix_树的子结构 {
    //递归
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)return false;
        //可能是A节点，也可能是是A节点的左节点或者右节点为B的根节点
        return recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);

    }
    public boolean recur(TreeNode A, TreeNode B){
        //B树遍历完，则代表满足
        if(B==null)return true;
        if(A==null||A.val!=B.val)return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }



}
