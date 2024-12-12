class Solution {
    public long pickGifts(int[] gifts, int k) {
       PriorityQueue<Integer> giftBag = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < gifts.length; i++) {
            giftBag.add(gifts[i]);
        }

        for(int i = 0; i < k; i++) {
            int giftNo = giftBag.poll();
            giftBag.add((int) Math.sqrt(giftNo));
        }

        long ans = 0;
        while(!giftBag.isEmpty()) {
            ans += giftBag.poll();
        }
        return ans;  
    }
}