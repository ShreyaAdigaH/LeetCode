class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
                int[] res = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
        }
        for (int i = 0; i < prices.length; i++) {

            while(!stack.empty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                res[index] = prices[index] - prices[i];
            }

           

            stack.push(i);
        }
        return res;
    }
}