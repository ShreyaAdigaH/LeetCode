class Solution {
    public long maxKelements(int[] nums, int k) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            maxHeap.add(num);
        }

        int count = 1;
        long sum = 0;
        while(!maxHeap.isEmpty() && count <= k) {
            int max = maxHeap.poll();
            sum += max;
            maxHeap.add((int) Math.ceil((double) max / 3));
            count++;
        }
        return sum;
    }
}