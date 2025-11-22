class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (lastIndex.containsKey(c)) {
                start = Math.max(start, lastIndex.get(c) + 1);
            }

            maxLen = Math.max(maxLen, i - start + 1);

            lastIndex.put(c, i);
        }
        return maxLen;
    }
}
