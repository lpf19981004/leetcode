package esay;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangpf
 * @Date 2019/11/5
 */
public class LC804 {


    public int uniqueMorseRepresentations(String[] words) {
        String[] temp = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i)-97;
                builder.append(temp[index]);
            }
            set.add(builder.toString());
            builder.setLength(0);
        }
        return set.size();
    }
}
