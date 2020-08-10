package Tree;

public class FiftyFive_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        //left  right都平衡，且当前节点的左右子树高度差小于1
        if(isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1)return true;
        else return false;
    }
    //求子树高度
    private int depth(TreeNode root){
        if(root==null)return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
