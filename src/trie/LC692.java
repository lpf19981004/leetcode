package trie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liangpf
 * @Date 2019/9/20
 */
public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        List<String> collect = list.stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue() < o2.getValue() ? 1 : -1;
        }).map(Map.Entry::getKey).collect(Collectors.toList());
        return k > collect.size() ? null : collect.subList(0, k);
    }
}
