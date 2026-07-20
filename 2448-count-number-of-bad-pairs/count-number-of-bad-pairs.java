class Solution {
    public long countBadPairs(int[] nums){
        int n = nums.length;
        long badpairs=0;
        HashMap<Integer,Integer>map= new HashMap<>();
        for(int i =0;i<n;i++){
            nums[i]=nums[i]-i;
            if(map.containsKey(nums[i])){
                badpairs+=i-map.get(nums[i]);
            }
           else{
            badpairs+=i;
           }
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return badpairs;
    }
}