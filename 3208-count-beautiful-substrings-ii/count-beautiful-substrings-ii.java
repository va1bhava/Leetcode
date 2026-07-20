class Solution {
    public long beautifulSubstrings(String s, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
         long count= 0 ;
         int L= getL(k);
         map.put(0,new HashMap<>());
         map.get(0).put((L-1)%L,1);
         int sum=0;
         for(int i =0 ;i < s.length();i++){
            sum+=isVowel(s.charAt(i))?1:-1;
            map.putIfAbsent(sum,new HashMap<>());
            int rem= i%L;
            HashMap<Integer,Integer> inner= map.get(sum);
            count+=inner.getOrDefault(rem,0);
            inner.put(rem,inner.getOrDefault(rem,0)+1);
         }
         return count;
    }
    private boolean isVowel(char ch ){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    private int getL(int k){
        int L=2; // why 2 ?? vowels==consonants !! 
        while(true){
            int half=L/2;
            if((1L*half*half)%k==0)return L;
            L+=2; 
        }
    }
}