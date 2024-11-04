class Solution {
    public String compressedString(String word) {
        StringBuffer comp = new StringBuffer();
        int charLength = 1;
        for(int i = 1; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(i - 1)  && charLength > 0) {
                comp.append(charLength).append(word.charAt(i - 1));
                charLength = 1;
            } else {
                 charLength++;
                 if(charLength == 9) {
                     comp.append(charLength).append(word.charAt(i));
                     if(i == word.length() - 1)
                        return comp.toString();
                     charLength = 0;
                 }
            }
        }
        return comp.append(charLength).append(word.charAt(word.length() - 1)).toString();
    }
}