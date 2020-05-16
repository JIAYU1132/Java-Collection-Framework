import java.util.Arrays;

public class Sort {
    // 归并排序(非递归)

    private static void mergeByLoop(int[] array) {
        // 引入一个 gap 进行分组
        // 当 gap 等于 1 时, [0] [1] 进行合并, [2] [3] 进行合并, [4] [5] 进行合并
        // 当 gap 等于 2 时, [0 1] [2 3] 进行合并, [4 5] [6 7] 进行合并
        // 当 gap 等于 4 时, [0 1 2 3] 进行合并, [4 5 6 7] 进行合并
        for (int gap = 1; gap < array.length; gap *= 2) {
            // 下面程序没执行一次, 就完成了一次相邻两个组的合并
            for (int i = 0; i < array.length; i += gap * 2) {
                // 当前相邻组
                // [beg, mid)
                // [mid, end)
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                // 防止下标越界
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }

        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0;
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high) {
            if (array[cur1] <= array[cur2]) {
                output[outputIndex++] = array[cur1++];
            } else {
                output[outputIndex++] = array[cur2++];
            }
        }
        while (cur1 < mid) {
            output[outputIndex++] = array[cur1++];
        }
        while (cur2 < high) {
            output[outputIndex++] = array[cur2++];
        }
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 2, 9, 3, 6, 8};
        mergeByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
