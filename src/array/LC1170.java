package array;

import java.util.*;

/**
 * @author liangpf
 * @date 2019/10/10
 */
public class LC1170 {
    public static void main(String[] args) {
        LC1170 demo = new LC1170();
        int[] res = demo.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"});
        System.out.println(Arrays.toString(res));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] accCount = new int[12];
        for(int i=0;i<words.length;i++) accCount[f(words[i])]++;
        for(int i=9;i>=0;i--) {
            accCount[i] += accCount[i+1];
        }

        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++) {
            res[i] = accCount[f(queries[i])+1];
        }
        return res;
    }

    private int f(String word) {
        int[] counts = new int[26];
        for(char ch:word.toCharArray()) {
            counts[ch-'a']++;
        }

        for(int i=0;i<26;i++)
            if(counts[i]>0) return counts[i];

        return 0;
    }
}
