class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
                int count = duration;

        if(timeSeries.length == 1)
            return duration;

        for(int time = timeSeries.length - 2; time >= 0; time--) {
            int intersection = (timeSeries[time  + 1] + duration) - (timeSeries[time] + duration);
            if(intersection >= duration) {
                count = count + duration;
            } else {
                count = count + intersection;
            }
        }
        return count;
    }
}