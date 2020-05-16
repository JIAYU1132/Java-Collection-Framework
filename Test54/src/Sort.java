import java.util.Arrays;

public class Sort {
    // 归并排序

    // 思路和合并两个有序区间一样

    // [low, mid) , [mid, high) , 把这两个有序区间合并成一个
    public static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0; // 记录当前 output 数组中被放入了多少元素
        int cur1 = low;
        int cur2 = mid;
        // 记录第一个和第二个区间的起始下标
        while (cur1 < mid && cur2 < high) {
            // 将元素按升序放到 output 数组中
            if (array[cur1] <= array[cur2]) {
                // 这里写成小于等于才能保证稳定性
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            } else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        // 循环结束后可能 cur1 或者 cur2 中有一个没有到达末尾, 直接把剩下的拷贝到 output 中
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            cur1++;
            outputIndex++;
        }
        while (cur2 < high) {
            output[outputIndex] = array[cur2];
            cur2++;
            outputIndex++;
        }
        // 把 output 中的元素再搬运回原来的数组
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    private static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            // 区间只有 0 个元素或者 1 个元素
            return;
        }
        int mid = (high + low) / 2;
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);
        // 此时左右区间已经是有序区间了，只需要借助 merge 进行合并即可
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 7, 3, 6, 8, 5, 10, 4, 11};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


