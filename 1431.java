class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;

        for(int i=0;i<candies.length;i++) {
            if(max < candies[i]) {
                max = candies[i];
            }
        }
        List<Boolean> ls = new ArrayList();
        for(int i=0;i<candies.length;i++) {
            if(max <= candies[i] + extraCandies) {
                ls.add(true);
            } else {
                ls.add(false);
            }
        }

        return ls;
    }
}
