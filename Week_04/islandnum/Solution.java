public class Solution {
    public int numIslands(char[][] grid) {
        //深度遍历解法
        //将二维数组中 位置为 1 的竖直和水平方向的所有的 1 看做是一个无向图
        //遍历数组，遇到值为 1 的位置开始遍历这个 1 位置的 无向图，同时把 1 的值改为0，防止重复遍历
        //数组遍历结束之后，遍历 1 的次数即为岛屿的个数
        if(grid == null || grid[0].length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int islandNum = 0;
        for (int r = 0; r < nr; r++) {
            for(int c = 0;c < nc; c++) {
                if(grid[r][c] == '1') {
                    islandNum ++;
                    dfs(grid, r, c, nr, nc);
                }
            }
        }
        return islandNum;
    }
    private void dfs(char[][] grid,int r,int c,int nr,int nc) {
        //越界或者遍历到 0 的 时候停止遍历
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        //将 1 值 改为 0
        grid[r][c] = '0';

        //遍历竖直方向和水平方向的 1
        dfs(grid, r + 1, c, nr, nc);
        dfs(grid, r - 1, c, nr, nc);
        dfs(grid, r, c + 1, nr, nc);
        dfs(grid, r, c - 1, nr, nc);
    }

}
