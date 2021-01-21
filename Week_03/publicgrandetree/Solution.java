public class Solution {
    public TreeNode ans = null;

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q) {
        //递归结束条件
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        //eft && right:说明root 节点的左右子树必定含有p 、 q 节点，
        // 且因为p ,q 是不同的且唯一的节点，所以这个条件满足则说明root 是近公共祖先
        //((root.val == p.val || root.val == q.val) && (left || right)): 因为p 和 q 可以自己为自己的祖先，
        // 所以判断当前root 节点是否式p 节点或者 q 节点，如果满足，那么root 节点的左右子树必然有个含有p 节点和 q 节点中另一个
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            this.ans = root;
        }

        return left || right || (root.val = p.val || root.val == q.val);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
