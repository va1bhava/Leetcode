class Solution {
    public int maxScore(String s) {
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')ones++;
        }
        int zeroes=0;
        int score=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0')zeroes++;
            else ones--;
            score=Math.max(score,zeroes+ones);
        }
        return score;
    }
}