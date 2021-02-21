class TreeNode {
    private TreeNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TreeNode() {
        links = new TreeNode[R];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TreeNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch,TreeNode node) {
        links[ch - 'a'] = node;
    }
}

public class Trie {
    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String workd) {
        TreeNode node = root;
        for(char ch : workd.toCharArray()) {
            //不存在则插入
            if (!node.containKey(ch)) {
                node.put(ch, new TreeNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TreeNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String word) {
        return searchPrefix(word) != null;
    }

    private TreeNode searchPrefix(String word) {
        TreeNode node = root;
        for(char ch : word.toCharArray()) {
            if (node.containKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }
}
