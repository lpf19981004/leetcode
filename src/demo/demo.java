package demo;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * @author liangpf
 * @Date 2019/9/18
 */
public class demo {
    public static void main(String[] args) {
        final int count = 10_0000;
        Random random = new Random();
//        List<Integer> list = new ArrayList<>();
//        for (long i = 0; i < count; i++) {
//            list.add(random.nextInt(count));
//        }
//        testListSpeed(count, list);
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(random.nextInt(count), random.nextInt(count));
        }

        testMapSpeed(count, map);


    }

    private static void testMapSpeed(int count, Map<Integer, Integer> map) {
        long start = System.nanoTime();
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            map.get(key);
            System.out.print("");
        }
        long end = System.nanoTime();
        double time = (double)(end-start)/1e9;
        System.out.println("使用keySet方式进行遍历:" + count + "个数据,耗时 " + time+"s");

        System.out.println("--------------------------------------------------");
        start = System.nanoTime();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.print("");
        }
        end = System.nanoTime();
        time = (double)(end-start)/1e9;
        System.out.println("使用entrySet方式进行遍历:" + count + "个数据,耗时 " + time+"s");

        System.out.println("--------------------------------------------------");
        start = System.nanoTime();
        map.forEach((k,v)-> System.out.print(""));
        end = System.nanoTime();
        time = (double)(end-start)/1e9;
        System.out.println("使用内部迭代forEach方式进行遍历:" + count + "个数据,耗时 " + time+"s");

    }

    // 测试集合的速度
    private static void testListSpeed(int count, Collection<Integer> list) {
        //=========传统方式进行外部迭代=========
        Instant begin = Instant.now();
//        for (int i=0;i<list.size();i++) {
//            list.get(i);
//            System.out.print("");
//        }
        System.out.println("--------------------------");
        Instant end = Instant.now();
        System.out.println("下标访问fori方式" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());

        //=========java8内部迭代，用lambda处理=========
        begin = Instant.now();
        for (Integer aLong : list) {
            System.out.print("");
        }
        System.out.println("--------------------------");
        end = Instant.now();
        System.out.println("增强for循环" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());

        //=========java8内部迭代，用lambda处理=========
        begin = Instant.now();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            System.out.print("");
        }
        System.out.println("--------------------------");
        end = Instant.now();
        System.out.println("iterator" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());


        //=========java8内部迭代，用lambda处理=========
        begin = Instant.now();
        list.forEach(i -> System.out.print(""));
        System.out.println("--------------------------");
        end = Instant.now();
        System.out.println("内部迭代forEach" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());
    }


}
