class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder result = new StringBuilder();
        int idx = 0;
        while (idx < word.length() && word.charAt(idx) != ch) {
            result.append(word.charAt(idx));
            idx++;
        }

        if (idx == word.length()) {
            return word;
        } else {
            return result.append(word.charAt(idx)).reverse() + word.substring(idx + 1);
        }
    }
}