package Tree;

import ListNode.ListNode;

import java.util.*;

public class 树的前序中序后序层序遍历 {
    List<Integer> list=new ArrayList<>();

    //层序遍历使用迭代+queue
    private  void floorOrder(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            list.add(cur.val);
            if(root.left!=null)queue.add(root.left);
            if(root.right!=null)queue.add(root.right);
        }

    }
    //前序递归遍历
    private void preOrderDG(TreeNode root){
        if(root==null)return;
        list.add(root.val);
        preOrderDG(root.left);
        preOrderDG(root.right);
    }
    //前序迭代遍历使用stack
    private void preOrderDD(TreeNode root){
        if(root==null)return;
        Stack<TreeNode>stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            list.add(cur.val);
            //由于stack先进后出，因此先放右子节点
            if(cur.right!=null)stack.add(cur.right);
            if(cur.left!=null)stack.add((cur.left));
        }
    }

    //中序递归遍历
    private void inOrderDG(TreeNode root){
        if(root==null)return;
        inOrderDG(root.left);
        list.add(root.val);
        inOrderDG(root.right);
    }
    //中序迭代遍历使用stack
    private void inOrderDD(TreeNode root){
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        while (!stack.isEmpty()||cur!=null){
            //先处理root节点的所有左子节点
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //再从最后一层开始依次处理左节点的右节点
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
    }

    //后续遍历递归
    private void postOrderDG(TreeNode root){
        if(root==null)return;
        postOrderDG(root.left);
        postOrderDG(root.right);
        list.add(root.val);
    }

    //后续遍历迭代只用stack
    private void postOrderDD(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode preRight=null;
        while (cur!=null||!stack.isEmpty()){
            while (cur!=null){
                //先跑完左子节点
                stack.push(cur);
                cur=cur.left;
            }
            //验证该节点的左右子节点是否已经完成,如果右子节点未完成还需遍历右子节点
            cur=stack.peek();
            if(cur.right==null||cur.right==preRight){
                //代表左右子节点已经遍历完了
                stack.pop();
                list.add(cur.val);
                //当右子节点完成，记录一下，作为其父节点是否完成的标志
                preRight=cur;
                cur=null;
            }else {
                cur=cur.right;
            }
        }
    }
}
