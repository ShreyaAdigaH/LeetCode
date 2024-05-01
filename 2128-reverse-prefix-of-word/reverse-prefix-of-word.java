class Solution {
    public String reversePrefix(String word, char ch) {
  StringBuilder result;
        int idx = 0;
        while (idx < word.length() && word.charAt(idx) != ch) {
            idx++;
        }

        if (idx == word.length()) {
            return word;
        } else {
            result = new StringBuilder(word.substring(0, idx + 1));
            return result.reverse() + word.substring(idx + 1);
        }
    }
}