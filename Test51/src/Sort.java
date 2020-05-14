import java.util.Arrays;

public class Sort {
    // 快速排序

//     思路:
//     待排序区间找一个基准值(通常取第一个或者最后一个元素)
//     以基准值为中心, 把整个区间分位三个部分, 左侧部分的元素都小于基准值, 右侧部分的元素都大于基准值
//     针对左侧整理好的区间和右侧整理好的区间, 进行递归, 重复刚才的步骤
//
//     整理区间的动作:
//     1. 取最右侧元素为基准值
//     2. 从左往右找一个大于基准值的元素
//     3. 从右往左找一个小于基准值的元素
//     4. 交换 left 和 right 位置的元素
//     5. 循环上面的动作, 直到 left 和 right 重合

    public static void quickSort(int[] array) {
        // 辅助完成递归过程
        // 为了代码简单, 将区间设置为前闭后闭区间
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间有 0 或 1 个元素, 不用排序, 直接返回
            return;
        }
        // 针对 [left, right] 区间进行整理
        int index = partition(array, left, right);
        // index 就是整理完毕后, left 和 right 重合的位置, 即基准值交换后的位置
        // 递归处理 index 的左侧部分和右侧部分
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right]; // 基准值定为最右侧元素
        while (i < j) {
            // 从左往右找比基准值大的元素
            while (i < j && array[i] <= base) {
                i++;
            }
            // 这个循环结束, i 要么和 j 重合, 要么指向比基准值大的元素

            // 从右往左找比基准值小的元素
            while (i < j && array[j] >= base) {
                j--;
            }
            // 这个循环结束, j 要么和 i 重合, 要么指向比基准值小的元素
            // 交换 i 和 j 的值
            swap(array, i, j);
        }
        // 此时 i 和 j 重合
        // 交换基准值和重合位置的元素
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9 , 2, 7, 3, 6, 8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
