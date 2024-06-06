class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
               if(hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        HashMap<Integer, Integer> cardFreq = new HashMap<>();
        for (int card : hand) {
            cardFreq.put(card, cardFreq.getOrDefault(card, 0) + 1);
        }

        int[] sortedKeys = new int[cardFreq.size()];
        int index = 0;
        for (int key : cardFreq.keySet()) {
            sortedKeys[index++] = key;
        }
        Arrays.sort(sortedKeys);
        
        for(int card : sortedKeys) {
            while(cardFreq.get(card) > 0) {
                int nextCard = card + 1;
                int cardCount = 1;
                cardFreq.put(card, cardFreq.get(card) - 1);

                while (cardCount < groupSize) {
                    if (cardFreq.containsKey(nextCard) && cardFreq.get(nextCard) > 0) {
                        cardFreq.put(nextCard, cardFreq.get(nextCard) - 1);
                    } else {
                        return false;
                    }
                    cardCount++;
                    nextCard++;
                }
            }
        }
        return true;
    }
}