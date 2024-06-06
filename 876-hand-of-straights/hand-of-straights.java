class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
               if(hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        for(int index = 0; index < hand.length; index++) {
            if(hand[index] >= 0) {
                int currentIndex = index;
                int cardCount = 1;
                int successor = hand[index] + 1;
                hand[index] = -1;
                while(currentIndex < hand.length && cardCount < groupSize) {
                    if(hand[currentIndex] == successor) {
                        hand[currentIndex] = -1;
                        successor = successor + 1;
                        cardCount++;
                    } else if (hand[currentIndex] > successor) {
                        return false;
                    }
                    currentIndex++;
                }
                if(cardCount != groupSize)
                    return false;
            }
        }
        return true;
    }
}