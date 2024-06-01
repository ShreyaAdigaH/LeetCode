class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if(num == 0) {
            return true;
        }
     for(int num1 = num / 2; num1 < num; num1++) {
            int quotient = num1;
            int num2 = 0;
            while(quotient > 0) {
                int remainder = quotient % 10;
                num2 = num2 * 10 + remainder;
                quotient = quotient / 10;
            }

            if(num1 + num2 == num) {
                return true;
            }
        }
        return false;
    }
}