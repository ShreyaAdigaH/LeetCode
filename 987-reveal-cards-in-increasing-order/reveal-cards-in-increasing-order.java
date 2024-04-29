class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
                Arrays.sort(deck);
        int[] result = new int[deck.length];
        Deque<Integer> order = new LinkedList<>();
        for(int index = 0; index < deck.length; index++){
            order.add(index);
        }

        for(int card : deck) {
            result[order.poll()] = card;
            order.add(order.poll());
        }

        return result;
    }
}