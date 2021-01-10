public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode root,List<Integer> res) {
        if (root == null) {
            return;
        }
        //先根，再左子树，最后右子树
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }
}
