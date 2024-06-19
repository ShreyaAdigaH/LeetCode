class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // if you can make m bouquets by day d then you can make m bouquets by any day x > d
        // once you find number of days that you could use to make m bouquets try with a number that lesser than that number
        // => binary search
        

        int minDays = 1;
        int maxDays = 1000000000;
        int minDaysToMakeBouquet = -1;

        while(minDays <= maxDays) {
            int flowerCount = 0;
            int bouquetCount = 0;
            int days = minDays + (maxDays - minDays) / 2;
            for(int flowerBloomDay = 0; flowerBloomDay < bloomDay.length; flowerBloomDay++) {
                if(bloomDay[flowerBloomDay] <= days) { // For each dayTh in bloomDay array a flower blooms. But we have to consider days count that is less than considered day
                    flowerCount++;
                    if(flowerCount >= k) {
                        flowerCount = 0;
                        bouquetCount++;
                    }
                } else { // But we have to consider only those days where flowers grow adjacent to each other. So if two consecutive bloom days doesnt fall under considered day we cant use the flowers
                    flowerCount = 0;
                }
            }

            if(bouquetCount >= m) {
                minDaysToMakeBouquet = days;
                maxDays = days - 1;
            } else {
                minDays = days + 1;
            }
        }
        return minDaysToMakeBouquet; 
    }
}