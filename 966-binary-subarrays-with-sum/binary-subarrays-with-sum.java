class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
       int count=0;
       int arr[]= new int[n+1];
       arr[0]++;
       int sum=0;
       for(int i=0;i<n;i++){
          sum+=nums[i];
           if(sum-goal>=0)count+=arr[sum-goal];
           arr[sum]++;
       }
       return count;
    }
}