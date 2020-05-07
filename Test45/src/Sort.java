import java.util.Arrays;

public class Sort {
    // 插入排序(升序)

    // 先把 bound 位置的元素取出来, 在前面区间找一个合适的位置, 同时搬运相关的元素

    public static void insertSort(int[] array) {
        // 通过 bound 划分出两个区间
        // [0, bound) 属于已排序区间
        // [bound, size) 属于待排序区间
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1; // cur 指向已排序区间的最后一个元素
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    // 排序完成, 此时就是 v 最好的位置
                    break;
                }
            }
            // 循环结束, cur 指向的是 v 最好位置的前后一个位置, 因为 cur--
            array[cur + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 8, 6, 3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
