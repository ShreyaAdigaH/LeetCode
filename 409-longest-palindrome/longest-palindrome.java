class Solution {
    public int longestPalindrome(String s) {
                int count = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        boolean oddNumberFound = false;

        for (int idx = 0; idx < s.length(); idx++) {
            if (freqMap.containsKey(s.charAt(idx))) {
                freqMap.put(s.charAt(idx), freqMap.get(s.charAt(idx)) + 1);
            } else {
                freqMap.put(s.charAt(idx), 1);
            }
        }


        for (Character c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (freqMap.keySet().size() > 1) {
                if (freq % 2 == 0) {
                    count += freq;
                } else {
                    oddNumberFound = true;
                    count = count + freq - 1;
                }
            } else {
                return freqMap.get(c);
            }
        }
        return oddNumberFound ? count + 1: count;
    }
}