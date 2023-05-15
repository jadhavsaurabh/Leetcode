class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(int i=0;i<strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(map.containsKey(sorted) == false) {
                List<String> arr = new ArrayList<String>();
                arr.add(strs[i]);
                map.put(sorted, arr);
            } else {
                List<String> list = map.get(sorted);
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
