class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean end;

    TrieNode() {
        children = new HashMap<>();
        end = false;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++) {
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode());
            }
            curr = curr.children.get(word.charAt(i));
        }

        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            if (!curr.children.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.children.get(word.charAt(i));
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            if (!curr.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.children.get(prefix.charAt(i));
        }

        return true;
    }
}
