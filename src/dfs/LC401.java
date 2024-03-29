package dfs;

import java.util.*;

/**
 * @author liangpf
 * @Date 2019/10/24
 */
public class LC401 {

    public static void main(String[] args) {

        List<String> a = Arrays.asList("0:15", "0:23", "0:27", "0:29", "0:30", "0:39", "0:43", "0:45", "0:46", "0:51", "0:53", "0:54", "0:57", "0:58",
                "1:07", "1:11", "1:13", "1:14", "1:19", "1:21", "1:22", "1:25", "1:26", "1:28", "1:35", "1:37", "1:38", "1:41",
                "1:42", "1:44", "1:49", "1:50", "1:52", "1:56", "2:07", "2:11", "2:13", "2:14", "2:19", "2:21", "2:22", "2:25",
                "2:26", "2:28", "2:35", "2:37", "2:38", "2:41", "2:42", "2:44", "2:49", "2:50", "2:52", "2:56", "3:03", "3:05",
                "3:06", "3:09", "3:10", "3:12", "3:17", "3:18", "3:20", "3:24", "3:33", "3:34", "3:36", "3:40", "3:48", "4:07",
                "4:11", "4:13", "4:14", "4:19", "4:21", "4:22", "4:25", "4:26", "4:28", "4:35", "4:37", "4:38", "4:41", "4:42",
                "4:44", "4:49", "4:50", "4:52", "4:56", "5:03", "5:05", "5:06", "5:09", "5:10", "5:12", "5:17", "5:18", "5:20",
                "5:24", "5:33", "5:34", "5:36", "5:40", "5:48", "6:03", "6:05", "6:06", "6:09", "6:10", "6:12", "6:17", "6:18",
                "6:20", "6:24", "6:33", "6:34", "6:36", "6:40", "6:48", "7:01", "7:02", "7:04", "7:08", "7:16", "7:32", "8:07",
                "8:11", "8:13", "8:14", "8:19", "8:21", "8:22", "8:25", "8:26", "8:28", "8:35", "8:37", "8:38", "8:41", "8:42",
                "8:44", "8:49", "8:50", "8:52", "8:56", "9:03", "9:05", "9:06", "9:09", "9:10", "9:12", "9:17", "9:18", "9:20",
                "9:24", "9:33", "9:34", "9:36", "9:40", "9:48", "10:03", "10:05", "10:06", "10:09", "10:10", "10:12", "10:17",
                "10:18", "10:20", "10:24", "10:33", "10:34", "10:36", "10:40", "10:48", "11:01", "11:02", "11:04", "11:08", "11:16",
                "11:32");
        Set<String> set = new HashSet<>(a);
        List<String> list = new LC401().readBinaryWatch(2);
        Collections.sort(list);
        System.out.println(set.size());
        System.out.println(list.size());
        for (String s : list) {
            if (set.add(s)) {
                System.out.println(s);
            }
        }
    }

    private List<String> ans = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        int[] time = new int[]{1, 2, 4, 8, 16, 32, 60, 120, 240, 480};
        dfs(time, 0, num, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] time, int k, int n, List<Integer> list) {
        if (list.size() == n) {
            int sum = 0;
            for (Integer val : list)
                sum += val;
            if (list.size()>1 && sum == 60) return;
            int minutes = sum % 60;
            int hours = sum / 60;
            String mm = minutes < 10 ? "0" + minutes : minutes + "";
            if (hours > 11) return;
            ans.add(hours + ":" + mm);
            return;
        }
        for (int i = k; i < time.length; i++) {
            list.add(time[i]);
            dfs(time, i + 1, n, list);
            list.remove(list.size() - 1);
        }
    }

    List<String> res = new ArrayList<String>();
    int[] watch = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    int[] onOff = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public List<String> readBinaryWatch2(int num)
    {
        if(num > 8) return res;
        dfs(num, 0, 0);
        return res;
    }

    public void dfs(int num, int onSum ,int start)
    {
        if(onSum == num)
        {
            addResult();
            return;
        }

        for(int i = start; i < watch.length; i++)
        {
            onOff[i] = 1;
            dfs(num, onSum + 1, i + 1);
            onOff[i] = 0;
        }
    }

    public void addResult()
    {
        int hour = 0;
        int minute = 0;
        for(int i = 0; i < onOff.length; i++)
        {
            if(onOff[i] == 1)
            {
                if(i < 4)
                {
                    hour += watch[i];
                }
                else
                {
                    minute += watch[i];
                }
            }
        }
        if(hour > 11 || minute > 59) return;
        String time = hour + ":" + ((minute < 10) ? "0"+minute : minute);
        res.add(time);
    }



}
