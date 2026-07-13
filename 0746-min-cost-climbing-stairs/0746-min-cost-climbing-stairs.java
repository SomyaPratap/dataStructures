class Solution {
    public int minCostClimbingStairs(int[] cost)
    {
        int n=cost.length;
        if(n<2 || n>1000)
        return 0;
        int dp[]=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        int i;
        for(i=2;i<n;i++)
        {
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        dp[n]=Math.min(dp[i-1],dp[i-2]);
        return dp[n];
        
    }
}