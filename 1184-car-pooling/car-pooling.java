class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int diff[] = new int[1001];
        for(int[] trip:trips){
            int l = trip[1];
            int r= trip[2];
            int seats= trip[0];
            diff[l]+=seats;
            if(r+1<1000){
                diff[r]-=seats;
            }
        }
        int curr=0;
        for(int i =0 ; i<diff.length;i++){
           curr+=diff[i];
            if(curr>capacity)return false;
        }
        return true;
    }
}