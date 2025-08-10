class Solution {
    public String getSorted(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public boolean reorderedPowerOf2(int n) {

        String sortedN = getSorted(n);

        for(int i=0;i<30;i++) {
            String sortedTwoPow = getSorted(1 << i);

            if(sortedTwoPow.equals(sortedN)) {
                return true;
            }
        }

        return false;
    }
}
