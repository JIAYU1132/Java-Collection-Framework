import java.util.Arrays;
import java.util.Stack;

public class Sort {
    // 快速排序(非递归实现)

    // 借助栈来操作

    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        // 先把右边界入栈, 再把左边界入栈
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                return;
            }
            int index = partition(array, left, right);

            // 针对栈的后进先出规则
            // 先处理基准值右侧区间[index + 1, right]
            stack.push(right);
            stack.push(index - 1);

            // 再处理基准值左侧区间[left, index - 1]
            stack.push(index - 1);
            stack.push(left);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 4, 3, 6, 8, 9};
        quickSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
