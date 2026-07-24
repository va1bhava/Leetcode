class Solution {
    public int maximumPopulation(int[][] logs) {
       int freq [] = new int[101];
        for(int arr [] : logs){
            int l =arr[0];
            int r = arr[1];
             freq[l-1950]++;
             freq[r-1950]--;
        }
        int max=0;
        int result=0;
        int curr= 0;
        for(int i =0 ;i < freq.length;i++){
          curr+=freq[i];
          if(curr>max){
            max=curr;
            result=i+1950;
          }
        }
        return result;
    }
}