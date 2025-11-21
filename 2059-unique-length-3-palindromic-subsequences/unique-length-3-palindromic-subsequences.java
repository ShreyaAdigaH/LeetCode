class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] leftMap = new int[26];
        int[] rightMap = new int[26];
        HashSet<String> res = new HashSet<>();

        for(int i = 1; i < s.length(); i++) {
            leftMap[s.charAt(i) - 'a']++;
        }

        for(int i = 1; i < s.length() - 1; i++) {
            rightMap[s.charAt(i - 1) - 'a']++;
            leftMap[s.charAt(i) - 'a']--;

            for(int c = 0; c < 26; c++) {
                if(rightMap[c] > 0 && leftMap[c] > 0) {
                   res.add("" + (char) (c + 'a') + s.charAt(i) + (char) (c + 'a'));
                }
            }
        }
        return res.size();
    }
}