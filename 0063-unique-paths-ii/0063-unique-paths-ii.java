class Solution {
    public int uniquePathsWithObstacles(int[][] grid)
    {
      int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                dp[i][j] = 0; // obstacle -> unreachable
                continue;
            }
            if (i == 0 && j == 0) {
                dp[i][j] = 1; // starting cell
            } else {
                int fromTop = (i > 0) ? dp[i - 1][j] : 0;
                int fromLeft = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = fromTop + fromLeft;
            }
        }
    }
    return dp[m - 1][n - 1];
}
}