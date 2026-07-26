class Solution {
    public int change(int amount, int[] coins)
    {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        dp[0][0]=1;
        int i,j;
        for(i=1;i<=n;i++)
        {
            for(j=0;j<=amount;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(coins[i-1]<=j)
                dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[n][amount];
    }
}