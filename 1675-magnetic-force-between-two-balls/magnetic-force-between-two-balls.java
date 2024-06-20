class Solution {
    public int maxDistance(int[] position, int m) {
                Arrays.sort(position);
        int minDistance = 1;
        int maxDistance = position[position.length - 1] - position[0] / (m - 1);
        int maxDistancePossible = 0;

        while(minDistance <= maxDistance) {
            int distance = minDistance + (maxDistance - minDistance) / 2;

            if(distancePossible(position, distance, m)) {
                maxDistancePossible = distance;
                minDistance = distance + 1;
            } else {
                maxDistance = distance - 1;
            }
        }
        return maxDistancePossible;
    }

    private static boolean distancePossible(int[] positions, int distance, int balls) {
        int lastPlaced = positions[0];
        int ballsPlaced = 1;
        for(int pos = 1; pos < positions.length; pos++) {
            if(positions[pos] - lastPlaced >= distance) {
                lastPlaced = positions[pos];
                ballsPlaced++;
                if(ballsPlaced == balls){
                    return true;
                }
            }
        }
        return false;
    }
}