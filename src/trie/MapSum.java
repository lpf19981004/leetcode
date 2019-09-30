package trie;

import java.util.TreeMap;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class MapSum {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        int sum = mapSum.sum("a");
        System.out.println(sum);
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

    public MapSum(int val) {
        this.root = new Node(val);
    }

    public MapSum() {
        this(0);
    }


    public void insert(String key, int val) {
        Node node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            Node temp = node.child.get(ch);
            if (temp == null) {
                node.child.put(ch, new Node());
            }
            node = node.child.get(ch);
        }
        node.val = val;
    }


    public int sum(String prefix) {
        Node node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.child.get(ch) == null)
                return 0;
            node = node.child.get(ch);
        }

        return sum(node);
    }

    private int sum(Node node) {
        if (node.child.size() == 0) return node.val;
        int sum = node.val;
        for (Character ch : node.child.keySet()) {
            sum += sum(node.child.get(ch));
        }
        return sum;
    }


}
