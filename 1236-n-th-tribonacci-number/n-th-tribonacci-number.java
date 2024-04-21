class Solution {
         int[] arr = new int[38];

    public int tribonacci(int n) {
                if (arr[n] == 0) {
            if (n == 0) return 0;

            if (n == 1 || n == 2) return 1;

            int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            arr[n] = result;
            return result;
        }
        return arr[n];
    }
}