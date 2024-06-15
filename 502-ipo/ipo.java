class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
                // Lowest capital highest profit
        int[][] projCapitalProfit = new int[profits.length][2];
        for(int project = 0; project < profits.length; project++) {
            projCapitalProfit[project][0] = capital[project];
            projCapitalProfit[project][1] = profits[project];
        }

        Arrays.sort(projCapitalProfit, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxCapital = new PriorityQueue<>((x, y) -> y - x);
  
        int project = 0; // w is going to increase or remain same. 
        for(int projectCount = 0; projectCount < k; projectCount++) {
            while(project < projCapitalProfit.length && projCapitalProfit[project][0] <= w) {
                maxCapital.add(projCapitalProfit[project][1]);
                project++;
            }

            if(maxCapital.isEmpty()) {
                break;
            }

            w = w + maxCapital.poll();
        }

        return w;
    }
}