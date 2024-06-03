class Solution {
    public int appendCharacters(String s, String t) {
 int tLength = t.length();
        int sLength = s.length();
        int tIndex = 0;
        for(int sIndex = 0; tIndex < tLength && sIndex < sLength; sIndex++) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
        }
        return tLength - tIndex;
    }
}