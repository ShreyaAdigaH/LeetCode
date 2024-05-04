class Solution {
    public int numRescueBoats(int[] people, int limit) {
                Arrays.sort(people);
        int boatCount = 0;
        int i = 0;
        int j = people.length - 1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boatCount = boatCount + 1;
        }
        return boatCount;
    }
}