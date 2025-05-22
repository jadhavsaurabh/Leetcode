class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        int j = citations.length - 1;
        while(j >= 0) {
            h++;
            if(h > citations[j]) {
                h--;
                break;
            }
            j--;
        }
        return h;
    }
}
