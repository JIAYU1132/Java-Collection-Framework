import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
    // 选择排序

    // 基于打擂台的思想, 从数组中找到一个最小值放到 bound 位置上, 然后把最小值放到合适的位置上

    public static void selectSort(int[] array) {
        // [0, bound) 为已排序区间
        // [bound, size) 为待排序区间
        for (int bound = 0; bound < array.length; bound++) {
            // 以 bound 位置的元素为擂主, 循环从待排序区间中取出元素和擂主进行比较
            // 如果打擂成功, 就和擂主交换位置
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    // 打擂成功
                    int tmp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = tmp;
                }
                }
            }
        }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 8, 6, 3};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    }

