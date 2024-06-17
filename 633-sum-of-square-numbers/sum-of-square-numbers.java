class Solution {
    public boolean judgeSquareSum(int c) {
          if(c == 1 || c == 0 || c == 2)
            return true;

        long low = 1;
        long high = c/2;
        long squareRootC = 0;

        while(low <= high) {
            long mid = low + (high - low)/2;

            long square = mid * mid;

            if(square == c) {
               return true;
            } if (square > c) {
                high = mid - 1;
            } else {
                squareRootC = mid;
                low = mid + 1;
            }
        }

        long a = 0;
        long b = squareRootC;

        while(a <= b) {
            long tempC = (a * a) + (b * b);
            if(tempC == c)
                return true;
            if(tempC > c) {
                b--;
            } else {
                a++;
            }
        }
        
        return false;
    }
}