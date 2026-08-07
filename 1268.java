class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        int l = 0;
        int r = products.length - 1;
        int idx = 0;
        List<List<String>> res = new ArrayList<>();
        int length = searchWord.length();

        while(idx < length) {
            char ch = searchWord.charAt(idx);

            while (l <= r && (products[l].length() <= idx || products[l].charAt(idx) != ch)) {
                l++;
            }

            while (l <= r && (products[r].length() <= idx || products[r].charAt(idx) != ch)) {
                r--;
            }

            List<String> matches = new ArrayList<>();
            for(int i=l;i<=r && i<l+3;i++) {
                matches.add(products[i]);
            }

            res.add(matches);
            idx++;
        }

        return res;
    }
}
