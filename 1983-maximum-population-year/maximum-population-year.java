class Solution {
    public int maximumPopulation(int[][] logs) {
        TreeMap <Integer,Integer> map = new TreeMap <>();
        for(int arr [] : logs){
            int l =arr[0];
            int r = arr[1];
            map.put(l,map.getOrDefault(l,0)+1);
            map.put(r,map.getOrDefault(r,0)-1);
        }
        int max=0;
        int result=0;
        int curr= 0;
        for(int key : map.keySet()){
          curr+=map.get(key);
          if(curr>max){
            max=curr;
            result=key;
          }
        }
        return result;
    }
}