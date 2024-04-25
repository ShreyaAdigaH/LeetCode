class Solution {
  public String convertToBase7(int num) {
        StringBuilder base7 = new StringBuilder();

        if(num == 0) {
            return "0";
        }
        int remainder = 0;
        int num1 = num;
        num = Math.abs(num);

        while (Math.abs(num) >= 7) {
            remainder = num % 7;
            base7.append(remainder);
            num = num / 7;
        }

        base7.append(num);

        return num1 > 0 ? base7.reverse().toString() : base7.append('-').reverse().toString();
    }
}