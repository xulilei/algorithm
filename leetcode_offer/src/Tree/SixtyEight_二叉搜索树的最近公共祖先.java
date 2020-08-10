package Tree;

public class SixtyEight_二叉搜索树的最近公共祖先 {
    //三种情况
    //1、pq分布在root的两侧
    //2、pq分布在root的做左子树root.val>p.val   >q.val
    //3、pq分布在root的做右子树root.val<p.val   <q.val

    //迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            //说明在左子树中
            if(root.val>p.val&& root.val>q.val){
                root=root.left;
            }else if(root.val<p.val&& root.val<q.val){
                root=root.right;
            }
            //找到最近的了,root的值等于其中一个，或者分散在左右两侧
            else break;
        }
        return root;
    }
    //递归
    public TreeNode lowestCommonAncestorDG(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val>p.val&& root.val>q.val){
               return  lowestCommonAncestorDG(root.left,p,q);
            }else if(root.val<p.val&& root.val<q.val){
               return  lowestCommonAncestorDG(root.right,p,q);
            }
            return root;
    }
}
