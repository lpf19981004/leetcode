package trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liangpf
 * @Date 2019/9/19
 * 字典树
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strings = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] strings2 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(trie.topKFrequent(strings2, 4));
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
    private TreeMap<String, Integer> frequencyMap;


    public Trie(int val) {
        this.root = new Node(val);
        this.frequencyMap = new TreeMap<>();
    }

    public Trie() {
        this(0);
    }

    /**
     * 新增一个单词到字典树中
     *
     * @param word 单词
     */
    public void add(String word) {
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
        frequencyMap.put(word, node.frequency);
    }

    /**
     * 判断是否包含该单词
     *
     * @param word 单词
     * @return 是否包含 true或false
     */
    public boolean search(String word) {
        Node node = this.root;
        return search(node, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length() && node.frequency != 0) {
            return true;
        } else if (index == word.length()) {
            return false;
        }
        Node cur = node.child.get(word.charAt(index));
        return cur != null && search(cur, word, index + 1);
    }


    /**
     * 判断一个字符串是否按照该prefix开头
     *
     * @param prefix prefix
     * @return true or false
     */
    public boolean startsWith(String prefix) {
        return startsWith(this.root, prefix, 0);
    }

    private boolean startsWith(Node node, String prefix, int index) {
        if (index == prefix.length()) return true;
        Node cur = node.child.get(prefix.charAt(index));
        return cur != null && startsWith(cur, prefix, index + 1);
    }


    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            this.add(word);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(this.frequencyMap.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o1.getValue() < o2.getValue() ? 1 : -1;
            }
        });
        System.out.println(list);
        List<String> collect = list.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        return k>list.size()?null:collect.subList(0, k);
    }


}
