class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(n<k)return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int odd = 0 ; 
        int count = 0 ; 
        map.put(0,1);
        for(int num : nums){
            odd+=num%2==1?1:0;
            if(map.containsKey(odd-k)){
                count+=map.get(odd-k);
            }
            map.put(odd,map.getOrDefault(odd,0)+1);
        }
        return count;
    }
}