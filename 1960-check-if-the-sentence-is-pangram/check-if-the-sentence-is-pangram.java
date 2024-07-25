class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphabets = new boolean[27];
        int totalAlpha = 0;
        for (int index = 0; index < sentence.length(); index++) {
            char c = sentence.charAt(index);
            if (!alphabets[c - 'a']) {
                totalAlpha++;
                alphabets[c - 'a'] = true;
            }
        }
        return totalAlpha == 26;
    }
}