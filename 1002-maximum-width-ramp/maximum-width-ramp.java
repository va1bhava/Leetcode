class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack <Integer> left= new Stack <>();
        left.push(0);
        for(int i =1 ; i <n;i++ ){
            if(!left.isEmpty()&&nums[i]<nums[left.peek()]){
                left.push (i);
            }
        }
        int max=0;
        for(int i =n-1 ;i>=0;i--){
           while(!left.isEmpty()&&nums[i]>=nums[left.peek()]){
               max=Math.max(max,i-left.pop());
            }
        }
        return max;
    }
}