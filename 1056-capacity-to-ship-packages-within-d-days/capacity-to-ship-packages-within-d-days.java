class Solution {
    public int shipWithinDays(int[] weights, int days) {
              /** to find : max weight you have to ship in one day such that other days you can ship packages having
                      weight less than that

                      so at minimum we must be able to ship - max(weights array) - at one shipping.
                      and at maximum we can ship all the packages in one shipping. Which would be sum(weights)
                      our answer lies somewhere between minimum and maximum
                      ==> Max(weights array elements) <= our required answer <= Sum(Weights)

        */

        // Step 1 -- Calculate Maximum and Sum
        int maxOfWeights = 0;
        int totalWeight = 0;
        for(int weight : weights) {
            maxOfWeights = Math.max(maxOfWeights, weight);
            totalWeight += weight;
        }

        /** Step 2 -- Find the maximum value
         - We know our solution is --  Max(weights array elements) <= our required answer <= Sum(Weights)
         - So our value lies somewhere in between those..
         - Consider we pick a weight in between those numbers and check if we can ship weight lesser than
         - that in remaining shipping. In remaining shipping if we find out that we may have to ship weight greater than
         - the chosen weight then that implies we actually have to choose weight greater than the one we chose
         - Else if we find out that we can send packages which are less in weight compared to the one we chose without utilizing
         - all other days then we can reduce the maximum weight we chose to spend in one day to utilize other days effectively
         - since above approach reduces the search space once we chose a weight we can use binary search
         */

        int minWeight = maxOfWeights;
        int maxWeight = totalWeight;

        while(minWeight <= maxWeight) { //our value lies between maximumOfWeight and totalWeight
            int middleWeight = (minWeight + maxWeight) / 2;
            if(isSplitPossible(weights, middleWeight, days)) { 
                maxWeight = middleWeight - 1; //if split is possible with a weight, try giving lesser weight
            } else {
                minWeight = middleWeight + 1;
            }
        }
        return minWeight;
    }

    private static boolean isSplitPossible(int[] weights, int trailWeight, int days) {
        int daysUsed = 0;
        for(int packageShipped = 0; packageShipped < weights.length; packageShipped++) {
            int weightShipped = 0;
            while(packageShipped < weights.length && weightShipped + weights[packageShipped] <= trailWeight) {
                weightShipped += weights[packageShipped];
                packageShipped++;

            }
            daysUsed++;
            packageShipped--;
        }
        if(daysUsed <= days)
            return true;
        return false;
    }
}