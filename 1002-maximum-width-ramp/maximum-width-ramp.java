class Solution {
    public int maxWidthRamp(int[] nums) {
        int n =  nums.length;
       int [] s = new int[n];
       s[n-1]=nums[n-1];
       for(int i=n-2;i>=0;i--){
        s[i]=Math.max(nums[i],s[i+1]);
       }
       int result=0 ;
       for(int  i= 0 ;i<n;i++){
           int max= bs(s,nums[i]);
           result=Math.max(result,max-i);
       }
       return result;
    }
    private int bs(int[]arr , int val){
        int l= 0;
        int r= arr.length-1;
        int ans= 0;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(arr[mid]>=val){
                l=mid+1;
                ans=mid;
            }
            else{
                r=mid-1;
            }
        }
        return ans; 
    }
}