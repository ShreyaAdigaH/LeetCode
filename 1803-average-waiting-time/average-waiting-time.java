class Solution {
    public double averageWaitingTime(int[][] customers) {
          long totalWaitTime = 0;
        long finishTime = customers[0][0];

        for(int customer = 0; customer < customers.length; customer++) {
            if(finishTime <= customers[customer][0]) {
                finishTime = customers[customer][0] + customers[customer][1];
            } else {
                finishTime = finishTime + customers[customer][1];
            }

            totalWaitTime += (finishTime - customers[customer][0]);

        }
        return (double)totalWaitTime / customers.length;
    }
}