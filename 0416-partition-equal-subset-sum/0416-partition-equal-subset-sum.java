class Solution {
    public boolean canPartition(int[] nums) 
    {
        int n=nums.length;
        int i,target=0,j;
        for(i=0;i<n;i++)
        {
            target+=nums[i];
        }
        if(target%2!=0)
        return false;
        target/=2;
        boolean dp[][]=new boolean[n+1][target+1];
        for(i=0;i<=n;i++)
        dp[i][0]=true;
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=target;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j)
                dp[i][j]=dp[i][j] || dp[i-1][j-nums[i-1]];
            }
        }
    return dp[n][target];
    }
}