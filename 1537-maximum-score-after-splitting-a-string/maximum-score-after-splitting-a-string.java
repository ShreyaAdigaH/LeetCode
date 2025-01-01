class Solution {
    public int maxScore(String s) {
      
           int totalOnes = 0;

        for(int i = 0; i < s.length(); i++) {
            totalOnes += (s.charAt(i) - '0');
        }

        int zeros = 0;
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
        
            if(s.charAt(i) == '0') {
                zeros++;
            } else {
                totalOnes--;
            }
            sum = Math.max(sum, zeros + totalOnes);
        }
        return sum;
    }
}