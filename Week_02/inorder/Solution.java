public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        inOrder(root,list);
        return list;
    }

    public void inOrder(TreeNode root,List<Integer> res) {
        //递归退出条件
        if(root == null) {
            return;
        }
        //中序遍历：先左子树，然后根，最后右子树
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
}
