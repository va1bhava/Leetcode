class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n= nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int max=0 ;
        for(int i=0 ;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(max,nums[i]);
        }
        int [] diff= new int[max+2];
        for(int i = 0 ; i < n;i++){
            int  l = Math.max(nums[i]-k,0);
            int r= Math.min(max,nums[i]+k);
            diff[l]++;
            if(r+1<diff.length)
              diff[r+1]--;
        }
        int result=0;
        for(int i =0 ;i<diff.length;i++){
            diff[i]+=i>0?diff[i-1]:0;
            int currfreq=map.getOrDefault(i,0);
            int neededconversion= diff[i]-currfreq;
            int maxfreq=Math.min(neededconversion,numOperations);
             result=Math.max(result,maxfreq+currfreq);
        }
        return result;
    }
}