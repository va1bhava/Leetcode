class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n= s.length();
        StringBuilder sb = new StringBuilder();
        int diff[]= new int[n];
        for(int[] arr : shifts){
            int start= arr[0];
            int end= arr[1];
            int value= arr[2];
            if(value==0){
                value=-1;
            }
            diff[start]+=value;
            if(end+1<n){
                diff[end+1]-=value;
            }
        }
        int curr=0;
        for(int i=0 ;i<diff.length;i++){
            curr+=diff[i];
            int shift=((curr%26)+26)%26;
            char ch =(char)('a'+(s.charAt(i)-'a'+shift)%26);
            sb.append(ch);
        }
        return sb.toString();
    }
   
}