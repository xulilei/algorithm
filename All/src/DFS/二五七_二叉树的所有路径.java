package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class 二五七_二叉树的所有路径 {
    ArrayList<String> paths;
    public List<String> binaryTreePaths(TreeNode root) {
        paths=new ArrayList<>();
        dfs(root,"");
        return paths;
    }
    //string是不可变的，因此不用回溯
    public void dfs(TreeNode root,String path){
        //先写递归结束条件
        if(root!=null){
            path+=root.val;
            if(root.left==null&&root.right==null){
                paths.add(path);
            }else {
                path+="->";
                dfs(root.left,path);
                dfs(root.right,path);
            }
        }
    }
    //使用stringBuilder,stringBuilder由于是可变的，值引用改变了StringBuilder值内存所对应的变量的值，因此需要回溯
    public void dfs2(TreeNode root,StringBuilder sb){
        if(root.left==null&&root.right==null){
            paths.add(sb.toString()+root.val);
        }else {
            String temp=root.val+"->";
            sb.append(temp);
            if(root.left!=null){
                dfs2(root.left,sb);
            }
            if(root.right!=null){
                dfs2(root.right,sb);
            }
            //回溯，sb才能够回去
            sb.delete(sb.length()-temp.length(),sb.length());
        }
    }
}
