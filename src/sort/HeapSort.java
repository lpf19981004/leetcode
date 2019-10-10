package sort;

import java.util.Arrays;

/**
 * @author liangpf
 * @Date 2019/10/8
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 8, 7, 6, 4, 181, -4, 66, 7, 99, 10, 0, 0, 0};
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr) {
        // 插入法对数组进行堆化
        // 1.构建大顶堆
        // 从堆的第一个非叶子节点开始调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        // 调整堆并下沉最大元素到数组尾部
        for (int i = arr.length - 1; i > 0; i--) {
            adjustHeap(arr, 0, i);
            swap(arr, 0, i);
        }
    }


    public static void heapSort2(int[] arr) {
        // 使用插入法构建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            adjustHeap(arr, 0, i);
            swap(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            int parent = ((cur - 1) / 2);
            while (arr[cur] > arr[parent]) {
                swap(arr, cur, parent);
                cur = parent;
                parent = ((cur - 1) / 2);
            }
        }
    }

    /**
     * 进行堆调整
     *
     * @param arr arr
     * @param end 起始下标
     * @param end 结束下标
     */
    private static void adjustHeap(int[] arr, int i, int end) {
        int left = i * 2 + 1;
        while (left < end) {
            int max = left;
            int parent = ((left - 1) >> 1);
            if (left + 1 < end && arr[left + 1] > arr[left]) {
                max++;
            }
            if (arr[max] > arr[parent]) {
                swap(arr, max, parent);
                parent = max;
            } else {
                break;
            }
            left = parent * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
