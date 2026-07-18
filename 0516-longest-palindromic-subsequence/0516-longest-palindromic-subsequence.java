class Solution {
    public int longestPalindromeSubseq(String s)
    {
        String rev="";
        int n=s.length();
        int i,j;
        for(i=n-1;i>=0;i--)
        {
            rev+=s.charAt(i);
        }
        int dp[][]=new int[n+1][n+1];
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
        
    }
}