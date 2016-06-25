import java.util.HashMap;
import java.util.Map;

/**
 * Created by Prashant on 6/25/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode current = root;
        for(int i = 0;i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        // mark end of word.
        current.endOfWord = true;
    }

    public boolean searchWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }

        // return true only if current.endOfWord is true.
        return current.endOfWord;
    }

    public void deleteWord(String word) {
        delete(word, root, 0);
    }

    private boolean delete(String word, TrieNode current, int index) {
        if(index == word.length()) {

            // current.endOfWord == false means word doesn't exist.
            if(current.endOfWord == false) {
                return false;
            }

            // otherwise make current.endOfWord as false.
            current.endOfWord = false;

            // delete node if there are no more mappings.
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if(node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(word, node,index + 1);

        // if true is returned then delete the mapping of the character and trienode reference from map.
        if(shouldDeleteCurrentNode == true) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(" ");
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}
