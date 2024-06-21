class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int nonGrumpyTimingCustomers = 0;

        for (int time = 0; time < customers.length; time++) {
            nonGrumpyTimingCustomers += (1 - grumpy[time]) * customers[time]; // (1 - grumpy[time] ---> To multiply
                                                                              // customers count indexed at value = time
                                                                              // if grumpy[time] = 0
                                                                              // If grumpy[time] = 0, then 1 -
                                                                              // grumpy[time] = 1. And hence consider
                                                                              // that value
        }

        // Sliding window to find max number of customers
        // For Example if window size (minutes) = 3
        int customerCount = 0;
        int maxSatisfiedCustomers = 0;
        int excludeTime = 0;
        for (int time = 0; time < customers.length; time++) {
            customerCount += customers[time] * grumpy[time]; // now take into consideration only those times when owner
                                                             // is grumpy. i.e grumpy[time] = 1
            maxSatisfiedCustomers = Math.max(customerCount, maxSatisfiedCustomers);

            if (time >= minutes - 1) { // sliding window slides over times when owner is grumpy and also not grumpy.
                                       // After sliding only take those values when owner is not grumpy..
                // Since index represents minutes, and it's a continues value, you can only take
                // grumpy times customers which are adjacent.
                customerCount -= customers[excludeTime] * grumpy[excludeTime++];
            }
        }
        return maxSatisfiedCustomers + nonGrumpyTimingCustomers;
    }
}