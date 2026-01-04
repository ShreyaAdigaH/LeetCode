class Solution {
    public int sumFourDivisors(int[] nums) {
        // if x is a square root of num ==> x * x = num
        int res = 0;
        for (int num : nums) {
            int sum = 0;
            int count = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    if (i * i != num) {
                        count = count + 2;
                        sum += (num / i);
                    } else {
                        count++;
                    }
                    sum += i;

                }
            }
            if (count == 4) {
                res += sum;
            }
        }
        return res;
    }
}