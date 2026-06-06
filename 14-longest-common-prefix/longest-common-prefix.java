class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        int childCount = 0;
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                    curr.childCount++;
                }

                curr = curr.children[idx];
            }

            curr.isEnd = true;
        }

        String longestCommonPrefix() {
            StringBuilder prefix = new StringBuilder();
            TrieNode curr = root;

            while (curr.childCount == 1 && !curr.isEnd) {
                for (int i = 0; i < 26; i++) {
                    if (curr.children[i] != null) {
                        prefix.append((char) ('a' + i));
                        curr = curr.children[i];
                        break;
                    }
                }
            }

            return prefix.toString();
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Trie trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        return trie.longestCommonPrefix();
    }
}