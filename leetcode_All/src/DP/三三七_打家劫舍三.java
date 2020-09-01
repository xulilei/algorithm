package DP;

public class 三三七_打家劫舍三 {
    public int rob(TreeNode root) {
        int[]res=robSelect(root);
        return Math.max(res[0],res[1]);


    }
    /*
    * 增加一维，表示该节点偷不偷，0表示不偷，1表示偷
    * 两种情况，当前节点偷，那么左右子节点不能偷，此时最大值为res[1]=left[0]+left[0]+当前节点.val;
    * 当前节点不偷，那么左右节点根据情况选择偷不偷,res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1])
    * 通过后序遍历，自下而上
    * */
    private int[]robSelect(TreeNode root){
        if(root==null)return new int[]{0,0};
        int[]res=new int[2];
        //后续遍历
        int[]left=robSelect(root.left);
        int[]right=robSelect(root.right);

        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+root.val;
        return res;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
