package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ThirtySeven_序列化反序列二叉树 {
    public String serialize(TreeNode root) {
        if(root==null)return "[]";
        StringBuilder res=new StringBuilder("[");
        //层序遍历都需要，用queue保存当前节点的左右子节点
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                res.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                res.append("null,");
            }
        }
        return res.deleteCharAt(res.length()-1).append("]").toString();

    }


    public TreeNode deserialize(String data) {
         if(data=="[]")return null;
         String[] vals= data.substring(1, data.length() - 1).split(",");
         TreeNode root=new TreeNode(Integer.parseInt(vals[0]));
         Queue<TreeNode>queue=new LinkedList<>();
         queue.add(root);
         int i=1;
         while (!queue.isEmpty()){
         TreeNode node = queue.poll();
             //从第一个节点开始，首先判断是否为空，然后依次每两个为前一个的左右子树
         if(!vals[i].equals("null")){

                node.left=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
         }
         i++;
         if(!vals[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
         }
         i++;
         }
         return  root;
    }
}
