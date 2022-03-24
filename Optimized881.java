class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        int i = 0;
        int j = len-1;
        while(i<=j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return len - 1 - j;
    }
}
