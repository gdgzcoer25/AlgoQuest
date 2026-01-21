// Problem link: https://leetcode.com/problems/number-of-islands/

// You can send pull request of your solution (only 1st correct pr will get merged)

// Java code

class Solution {

    // check if (x, y) is inside grid
    private boolean isSafe(int x, int y, int n, int m) {
        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }

    private void dfs(int i, int j, int n, int m, char[][] grid, boolean[][] vis, int[][] dir) {
        vis[i][j] = true;

        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if(isSafe(x, y, n, m) && grid[x][y] == '1' && !vis[x][y]) {
                dfs(x, y, n, m, grid, vis, dir);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // 4 directions (horizontal, vertical)
        int[][] dir = {
                      {-1, 0},
            { 0, -1},          { 0, 1},
                      { 1, 0}
        };

        int ans = 0;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, n, m, grid, vis, dir);
                    ans++; // one complete island is found
                }
            }
        }

        return ans;
    }
}
