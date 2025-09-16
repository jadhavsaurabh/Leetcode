import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean end = false;
}

class Solution {
    public void dfs(Map<Character, TrieNode> trie, int i, int j, StringBuilder path,
                    List<String> res, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (visited[i][j]) return;

        char c = board[i][j];
        if (!trie.containsKey(c)) return;

        visited[i][j] = true;
        path.append(c);

        TrieNode node = trie.get(c);
        if (node.end) {
            res.add(path.toString());
            node.end = false; // avoid duplicate word & prune search
        }

        dfs(node.children, i + 1, j, path, res, board, visited);
        dfs(node.children, i - 1, j, path, res, board, visited);
        dfs(node.children, i, j + 1, path, res, board, visited);
        dfs(node.children, i, j - 1, path, res, board, visited);

        path.deleteCharAt(path.length() - 1); // backtrack
        visited[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        HashMap<Character, TrieNode> trie = new HashMap<>();
        for (String word : words) {
            HashMap<Character, TrieNode> next = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!next.containsKey(c)) {
                    next.put(c, new TrieNode());
                }
                if (i == word.length() - 1) {
                    next.get(c).end = true;
                }
                next = next.get(c).children;
            }
        }

        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(trie, i, j, new StringBuilder(), res, board, visited);
            }
        }

        return res;
    }
}
