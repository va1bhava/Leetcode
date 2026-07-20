class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int m, int k) {
        HashMap<Long,Integer> map= new HashMap<>();
        long sum=0;
        long result=0; 
        map.put(0L,1);
         for(int i =0;i<nums.size();i++){
            sum+=nums.get(i)%m==k?1:0;
            long currmod=sum%m;
            long rem =(currmod-k+m)%m;
            if(map.containsKey(rem)){
                result+=(long)map.get(rem);
            }
            map.put(currmod,map.getOrDefault(currmod,0)+1);
         }
         return result;
    }
}