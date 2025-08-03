class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean end;

    TrieNode() {
        children = new HashMap<>();
        end = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode node, int index) {
        if (index == word.length()) return node.end;

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (search(word, child, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) return false;
            return search(word, child, index + 1);
        }
    }
}
