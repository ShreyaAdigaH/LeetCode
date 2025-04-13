class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            return (1 / calculatePower(x,-N));
        }
        return calculatePower(x, n);
     
  
    }

    public double calculatePower(double x, long n) {
           double res = 1;
      while (n > 0) {
            if(n % 2 == 1) {
                res = res * x;
            }
            n = n / 2;
            x = x * x;
        }
        return res;
    }
}