class Solution {
    public boolean isPalindrome(int x)
    {
        int n=x,d=0,rev=0;
        if(x>=0)
        {
            while(n!=0)
            {
                d=n%10;
                n=n/10;
                rev=rev*10+d;
            }
            if(x==rev)
            return true;


        }
        return false;
        
    }
}