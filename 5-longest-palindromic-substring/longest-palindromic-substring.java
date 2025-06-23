class Solution {
    public String longestPalindrome(String s) {
        int[] odd = new int[2];
        int[] even = new int[2];
        int[] currMax = new int[2];
        int[] longest = new int[2];
        for(int i = 0; i < s.length(); i++) {
            odd = computePalindromeLength(s, i - 1,  i + 1);
            even = computePalindromeLength(s, i - 1, i);

            int left = 0;
            int right = 0;
            if(odd[1] - odd[0] >= even[1] - even[0]) {
                left = odd[0];
                right = odd[1];
            } else {
                left = even[0];
                right = even[1];
            }
            currMax = new int[] {left, right};

            int left1 = 0;
            int right1 = 0;
            if(longest[1] - longest[0] >= currMax[1] - currMax[0]) {
                left1 = longest[0];
                right1 = longest[1];
            } else {
                left1 = currMax[0];
                right1 = currMax[1];
            }
            longest = new int[] {left1, right1};
          
        }
        return s.substring(longest[0], longest[1]);
    }

    public int[] computePalindromeLength(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        return new int[]{left + 1, right};
    }
}