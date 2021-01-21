public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //回溯思想实现
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        //标记每个位置的数字是否使用过
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfs(nums,n,0,used,path,res);
        return res;
    }

    private void dfs(int[] nums,int n,int depth,boolean[] used,List<Integer> path,List<List<Integer>> res) {
        //终止条件:到达最后一层完毕，添加结果
        if (depth == n) {
            //path 不是局部变量，如果不声明一个新变量，最后结果会都为空
            res.add(new ArrayList(path));
            return;
        }
        
        //遍历nums,一层层的往下找数字组合
        for (int i = 0;i<n;i++) {
            //判断元素是否被使用过
            if(!used[i]) {
                //当前层操作
                path.add(nums[i]);
                used[i] = true;

                //递归 往下一层
                dfs(nums,n,depth + 1,used,path,res);

                //reverse 重置非局部变量
                path.remove(path.size() -1);
                used[i] = false;
            }
        }
    }

}