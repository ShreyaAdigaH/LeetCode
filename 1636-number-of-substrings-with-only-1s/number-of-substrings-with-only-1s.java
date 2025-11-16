class Solution {
    public int numSub(String s) {
        long res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                long count = 0;
                while(i < s.length() && s.charAt(i) == '1') {
                    count++;
                    i++;
                }

                res += (((count + 1) * count) / 2) % 1000000007;
            }
        }
        return (int) res;
    }
}