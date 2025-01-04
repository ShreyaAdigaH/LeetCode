class Solution {
    public int countPalindromicSubsequence(String s) {
          int[] charFreq = new int[26];
        for(int i = 2; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }
        boolean[] charSet = new boolean[26];
        charSet[s.charAt(0) - 'a'] = true;
        HashSet<String> res = new HashSet<>();

        for(int i = 1; i < s.length() - 1; i++) {
            for(int c = 0; c < 26; c++) {
                if(charSet[c] && charFreq[c] > 0) {
                     res.add("" + (char) (c + 'a') + s.charAt(i) + (char) (c + 'a'));
                }
            }
            charSet[s.charAt(i) - 'a'] = true;
            charFreq[s.charAt(i + 1) - 'a']--;
        }
        return res.size();
    }
}