package trie;

import java.util.TreeMap;

/**
 * @author liangpf
 * @Date 2019/9/19
 * 211. 添加与搜索单词 - 数据结构设计
 */
public class WordDictionary {


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bab");
        boolean hello = wordDictionary.search("b..");
        System.out.println(hello);
    }


    /**
     * Trie树的节点
     */
    static class Node {
        int frequency;// 词频
        int val;// 权重
        TreeMap<Character, Node> child;

        Node(int val) {
            this.val = val;
            child = new TreeMap<>();
        }

        Node() {
            this(0);
        }
    }

    /**
     * 根节点
     */
    private Node root;

    public WordDictionary(int val) {
        this.root = new Node(val);
    }

    public WordDictionary() {
        this(0);
    }

    /**
     * 新增一个单词到字典树中
     *
     * @param word 单词
     */
    public void addWord(String word) {
        // 拿到root节点
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.child.get(ch) == null) {
                node.child.put(ch, new Node());
            }
            node = node.child.get(ch);
        }
        // 统计词频
        node.frequency++;
    }

    /**
     * 支持含有 . 字符的正则搜索
     *
     * @param word 正则
     * @return true or false
     */
    public boolean search(String word) {
        Node node = this.root;
        return search(node, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) return node.frequency != 0;
        char ch = word.charAt(index);
        if (ch != '.') {
            return node != null && search(node.child.get(ch), word, index + 1);
        } else {
            for (char c : node.child.keySet()) {
                if(search(node.child.get(c), word, index + 1))
                    return true;
            }
            return false;
        }
    }
}
