import java.util.List;
import java.util.ArrayList;

 class Solution { // inorder : 132
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return traverse(root, list);
       
    }
    public List<Integer> traverse(TreeNode node,  List<Integer> list){
         if(node == null){
            return list;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
        return list;
    }
}
 