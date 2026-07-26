class Solution {
    public int findTargetSumWays(int[] nums, int target)
    {
        int n=nums.length;
        int i,j,sum=0,sumP;
        for(i=0;i<n;i++)
        sum+=nums[i];
        sumP=(target+sum)/2;
        if((target+sum) % 2!=0 || target+sum<0)
        return 0;
        int dp[][]=new int[n+1][sumP+1];
        dp[0][0]=1;
        for(i=1;i<=n;i++)
        {
            for(j=0;j<=sumP;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j)
                dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sumP];

        

    }
}