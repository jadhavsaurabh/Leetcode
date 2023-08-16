class Solution {
  public int closetTarget(String[] words, String target, int startIndex) {
    final int n = words.length;
    int result = 200;
    for (int i = 0; i < n; i++) {
      if (words[i].equals(target)) {
        int distance = Math.abs(startIndex - i);
        result = Math.min(result, Math.min(distance, n - distance));
      }
    }

    return result == 200 ? -1 : result;
  }
}
