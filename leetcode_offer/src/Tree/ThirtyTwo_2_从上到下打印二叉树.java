package Tree;

import java.util.*;

public class ThirtyTwo_2_从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //保存了这一排的TreeNode
        Queue<TreeNode> queue = new LinkedList<>();
        //保存结果
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //for (int i = 0; i < queue.size(); i++) 每轮都会比较 i < queue.size() ，
            //而 queue.size() 是变化的，因此会出错～按照文中的写法，i = queue.size()只用执行一次，因此可行。
            for (int i = queue.size(); i > 0; i--) {
                //从queue从左至右取出
                TreeNode node = queue.poll();
                temp.add(node.val);
                //将下一层添加进queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
