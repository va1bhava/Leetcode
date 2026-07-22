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
        for(int i=1;i<diff.length;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0;i<diff.length;i++){
            if(diff[i]>0){
                sb.append(forward(s.charAt(i),diff[i]));
            }
            else{
                sb.append(backward(s.charAt(i),diff[i]));
            }
        }
        return sb.toString();
    }
    private char forward(char ch , int shift){
        return (char)('a'+(ch-'a'+shift)%26);
    }
    private char backward(char ch, int shift) {
          return (char)('a'+(ch-'a'+(shift%26)+26)%26);
    }
}