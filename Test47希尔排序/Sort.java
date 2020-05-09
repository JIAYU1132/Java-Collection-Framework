import java.util.Arrays;

public class Sort {
    // 希尔排序

    // 进阶版的插入排序, 先分组, 针对每个组进行插入排序, 再分组, 逐渐缩小组的个数, 最终整个数组就接近有序了

    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            // 需要循环进行分组插排
            insertSortGap(array, gap);
            // 更新 gap 组数
            gap = gap / 2;
        }
        // 循环结束, 此时只剩一组元素, 直接排序即可
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        // [0, bound) 为已排序区间
        // [bound, size) 为待排序区间
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap; // 找到同组中的上一个元素
            for (; cur >= 0; cur -= gap) {
                // 同组中相邻元素下标值差 gap
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 6, 8, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
