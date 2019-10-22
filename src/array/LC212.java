package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/14
 */
public class LC212 {

    public static void main(String[] args) {
        LC212 demo = new LC212();
        List<String> words = demo.findWords(
                new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}
                , new String[]{"oath", "pea", "eat", "rain"});
        System.out.println(words);
    }

    private int[] row = new int[]{-1, 1, 0, 0};
    private int[] col = new int[]{0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<Node>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                List<Node> mapList = map.get(ch);
                if (mapList == null) {
                    mapList = new ArrayList<>();
                }
                mapList.add(new Node(i, j));
                map.put(ch, mapList);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                if (!map.containsKey(word.charAt(i))){
                    flag = true;
                    break;
                }
            }
            if (flag)  continue;
            char ch = word.charAt(0);
            List<Node> nodes = map.get(ch);
            for (Node node : nodes) {
                if (dfs(board, node.x, node.y, word, 0,map)){
                    ans.add(word);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index,Map<Character,List<Node>> map) {
        // 检查越界的情况
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length) return false;
        if (word.charAt(index) != board[x][y]) return false;
        if (index == word.length() - 1) return true;
        // 不能重复使用
        board[x][y] = '*';
        for (int i = 0; i < 4; i++) {

            char ch = board[x+row[i]][y+col[i]];

            if (dfs(board, x + row[i], y + col[i], word, index + 1,map)) {
                board[x + row[i]][y + col[i]] = word.charAt(index+1);
                board[x][y] = word.charAt(index);
                return true;
            }
        }
        board[x][y] = word.charAt(index);
        return false;
    }
}
