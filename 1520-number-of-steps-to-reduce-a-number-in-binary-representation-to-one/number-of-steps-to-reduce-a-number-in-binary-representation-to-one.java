class Solution {
    public int numSteps(String s) {
        if(s.equals("10"))
            return 1;

        if(s.equals("1") || s.equals("0"))
            return 0;

        int steps = 0;
        int index = s.length() - 1;
        int carry = 0;
        while(index > 0) {
            if (s.charAt(index) - '0' + carry == 1) {
                carry = 1;
                steps += 2;
            } else {
                steps += 1;
            }
            index--;
        }
        return steps + carry;
    }
}