class Solution {
    public boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }

    public String convertToUnder(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('_');
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        
        Map<String, String> vowelMap = new HashMap<>();
        
        Map<String, String> lowerMap = new HashMap<>();
        
        Set<String> exactSet = new HashSet<>();

        for (String word : wordlist) {
            exactSet.add(word);

            String lower = word.toLowerCase();
            lowerMap.putIfAbsent(lower, word);

            String converted = convertToUnder(word);
            vowelMap.putIfAbsent(converted, word);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactSet.contains(q)) {
                res[i] = q;  
            } else if (lowerMap.containsKey(q.toLowerCase())) {
                res[i] = lowerMap.get(q.toLowerCase()); 
            } else if (vowelMap.containsKey(convertToUnder(q))) {
                res[i] = vowelMap.get(convertToUnder(q));
            } else {
                res[i] = "";
            }
        }
        return res;
    }
}
