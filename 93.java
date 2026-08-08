/*
"हर level पर 1–3 digit का valid part चुनो → combination tree में push करो → आगे explore करो → वापस आकर pop करो."
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        backTrack(s, res, 0, new ArrayList<>());
        return res;
    }

    public boolean isInvalid(String s) {
        return s.isEmpty() || Integer.parseInt(s) > 255 || (s.length() > 1 && s.charAt(0) == '0');
    }

    public void backTrack(String s, List<String> res, int idx, List<String> parts) {
        // return if can't go ahead
        if((s.length() - idx) < 4 - parts.size()) return;

        // reached target
        if(parts.size() == 4) {
            if(idx < s.length()) {
                return;
            }
            res.add(parts.getFirst() + "." + parts.get(1) + "." + parts.get(2) + "." + parts.getLast());
        }

        // Try subs & remove
        for(int i=idx + 1;i<=idx+4 && i<=s.length();i++) {

            String subIp = s.substring(idx, i);

            if(!isInvalid(subIp)) {
                parts.add(subIp);
                backTrack(s, res, i, parts);
                parts.removeLast();
            }
        }
    }
}
