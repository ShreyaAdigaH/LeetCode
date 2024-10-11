class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] arrivalTime = new int[times.length][3];

        for(int i = 0; i < times.length; i++) {
            arrivalTime[i][0] = times[i][0];
            arrivalTime[i][1] = times[i][1];
            arrivalTime[i][2] = i;
        }

        Arrays.sort(arrivalTime, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> availableChair = new PriorityQueue<>();
        for(int i = 0; i < arrivalTime.length; i++) {
            availableChair.add(i);
        }

        PriorityQueue<int[]> usedChair = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < arrivalTime.length; i++) {
            while (!usedChair.isEmpty() && (usedChair.peek())[0] <= arrivalTime[i][0]) {
                int[] emptiedChair = usedChair.poll();
                availableChair.add(emptiedChair[1]);
            }

            int chairAssigned = availableChair.poll();
            usedChair.add(new int[] {arrivalTime[i][1], chairAssigned});

            if(arrivalTime[i][2] == targetFriend) {
                return chairAssigned;
            }
        }
        return -1;
    }
}