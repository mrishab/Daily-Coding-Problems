import java.util.LinkedList;
import java.util.List;

public class Problem11 {

    public static void main(String[] args) {
        TrieNode trie = new TrieNode();

        String[] words = {"dog", "deer", "deal"};
        String prefix = "de";

        // Pre-processing the data
        for (String word: words)
            trie.add(word);

        // Performing Retrieval
        List<String> wordMatchingPrefix = trie.getWords(prefix);
        System.out.println(wordMatchingPrefix);
    }
}


class TrieNode {
    private static final int MAX_CHILDREN = 26;

    private boolean endOfWord;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[MAX_CHILDREN];
        endOfWord = false;
    }

    public void add(String s){
        add(s, 0);
    }

    public void remove(String s) {
        remove(s, 0);
    }

    public List<String> getWords(String prefix) {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        return getWords(list, sb, prefix, 0);
    }

    public boolean hasChild(){
        boolean hasChild = false;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null){
                hasChild = true;
                break;
            }
        }
        return hasChild;
    }

    private List<String> getWords(List<String> list, StringBuilder sb, String prefix, int sIndex){
        if (sIndex >= prefix.length()) return list;
        char currentChar = prefix.charAt(sIndex);
        int index = index(currentChar);
        TrieNode child = children[index];
        if (child == null) return list;
        sb.append(currentChar);
        child.getWords(list, sb, prefix, sIndex + 1);
        if (prefix.length()-1 == sIndex) {
            child.concatChildren(list, sb);
        }
        return list;
    }

    private void concatChildren(List<String> list, StringBuilder sb){
        if (endOfWord){
            String word = sb.toString();
            list.add(word);
            sb = new StringBuilder();
            sb.append(word);
        }
        for (char c = 'a'; c < 'z'; c++){
            int index = index(c);
            TrieNode child = children[index];
            if (child == null) continue;
            sb.append(c);
            child.concatChildren(list, sb);
        }
    }

    private void add(String s, int sIndex) {
        if (sIndex == s.length()) endOfWord = true;
        if (sIndex >= s.length()) return;
        char currentChar = s.charAt(sIndex);
        int index = index(currentChar);
        TrieNode child = children[index];
        if (child == null) {
            children[index] = new TrieNode();
            child = children[index];
        }
        child.add(s, sIndex+1);
    }

    private void remove(String s, int sIndex){
        if (sIndex == s.length()) endOfWord = false;
        if (sIndex >= s.length()) return;
        int index = index(s.charAt(sIndex));
        TrieNode child = children[index];
        if (child == null) return;
        child.remove(s, sIndex + 1);
        boolean childHasChildren = child.hasChild();
        if (childHasChildren) {
            if (sIndex == s.length() - 1)
                child.endOfWord = false;
        } else {
            if (!child.endOfWord)
                children[index] = null;
        }
    }

    private int index(char c){
        return Character.toLowerCase(c) - 'a';
    }

}