import java.util.Arrays;

public class Sort {
    // 冒泡排序

    // 每次找到一个最大或者最小值, 并放到合适的位置上, 借助相邻元素进行比较的方式来找
    // 从前往后遍历交换就是每次找最大元素
    // 从后往前遍历交换就是每次找最小元素

    public static void bubbleSort(int[] array) {
        // 采用每次找最小的方式进行排序, 从后往前比较交换
        // [0, bound) 为已排序区间
        // [bound, size) 为待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                // 处理未排序区间
                if (array[cur - 1] > array[cur]) {
                    int tmp = array[cur - 1];
                    array[cur - 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    public static void bubbleSort1(int[] array) {
        // 采用每次找最大的方式进行排序, 要从前往后找
        for (int bound = array.length - 1; bound > 0; bound--) {
            // [0, bound) 为已排序区间
            // [bound, size) 为待排序区间
            for (int cur = 0; cur < bound; cur++) {
                if (array[cur] > array[cur + 1]){
                    int tmp = array[cur + 1];
                    array[cur + 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 8, 7, 3, 6, 2};
        bubbleSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
