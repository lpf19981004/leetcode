package array;

/**
 * @author liangpf
 * @Date 2019/10/9
 */
public class LC1160 {

    public static void main(String[] args) {
        String[] strings = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(strings, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] temp = new int[26];
        for(int i = 0; i < chars.length(); i++){
            temp[chars.charAt(i) - 'a'] ++;
        }
        int count = 0;
        for(int k = 0; k < words.length; k ++){
            if(isSpell(words[k], temp)){
                count += words[k].length();
            }
        }
        return count;

    }

    public static boolean isSpell(String s, int[] temp){
        int[] tem = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // 当两者相等时，意味这ch在chars中不存在（每个字符只能使用1次）
            if(tem[ch - 'a'] == temp[ch - 'a']){
                return false;
            }
            tem[ch - 'a'] ++;
        }
        return true;
    }
}
