class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            while (map.size() > 2) {
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
