package 树;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("apple");
        System.out.println(trie.search("apple"));    // 返回 true
        System.out.println(trie.search("app")  );    // 返回 false
        System.out.println(trie.isPrefix("app"));           // 返回 true
        trie.add("app");
        System.out.println(trie.search("app"));      // 返回 true
        System.out.println(trie.delete("app"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
    }
}
