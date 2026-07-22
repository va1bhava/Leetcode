class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int diff [] = new int [n];
        for(int [] arr: bookings){
            int start= arr[0]-1;
            int end= arr[1]-1;
            int value= arr[2];
            diff[start]+=value;
            if(end+1<n){
                diff[end+1]-=value;
            }
        }
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}