import java.util.*;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;
    int[] stones;
    int n;

    public boolean canCross(int[] stones) {

        this.stones = stones;
        n = stones.length;

        // position -> index
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        dp = new Boolean[n][n + 1];

        return dfs(0, 0);
    }

    private boolean dfs(int index, int lastJump) {

        // Reached last stone
        if (index == n - 1)
            return true;

        // Already solved
        if (dp[index][lastJump] != null)
            return dp[index][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {

            if (jump <= 0)
                continue;

            int nextPosition = stones[index] + jump;

            if (map.containsKey(nextPosition)) {

                int nextIndex = map.get(nextPosition);

                if (dfs(nextIndex, jump)) {
                    return dp[index][lastJump] = true;
                }
            }
        }

        return dp[index][lastJump] = false;
    }
}