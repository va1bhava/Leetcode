class Solution {
    public int minZeroArray(int[] nums, int[][] mat) {
        boolean allTrue=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                allTrue=false;
                break;
            }
        }
        if(allTrue)return 0;
        int low=0;
        int high= mat.length-1;
        int ans=-1;
        while(low<=high){
            int mid =low+(high-low)/2;
            if(solve(nums,mat,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans==-1?-1:ans+1;
    }
    private boolean solve(int [] nums,int [][]queries,int k){
        int n=nums.length;
        int diff[]= new int[n];
        for(int i=0;i<=k;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int value=queries[i][2];
            diff[start]+=value;
            if(end+1<n){
                diff[end+1]-=value;
            }
        }
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=diff[i];
            if(curr<nums[i])return false;
        }
        return true;
    }
}