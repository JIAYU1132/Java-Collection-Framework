import java.util.Arrays;

public class Sort {
    // 堆排序

    // 思路
    // 第一种: 建立一个小堆, 取最小值放到另外一个数组中, 循环取堆顶元素尾插到数组中即可(缺陷: 空间复杂度为O(N))
    // 第二种: 建立一个大堆, 把堆顶元素和堆的最后一个元素互换位置, 把最后一个元素从堆中去掉, 再向下调整
    //         最后得到一个升序的数组 (空间复杂度为 O(1))

    public static void heapSort(int[] array) {
        // 先建堆
        creatHeap(array);
        // 循环把堆顶元素交换到最后, 并调整堆
        // 循环的终止条件应该是 length - 1, 当堆中只剩一个元素时, 一定是有序的
        for (int i = 0; i < array.length - 1; i++) {
            // 交换堆顶元素和堆的最后一个元素
            // 堆的元素个数为 length - i , 因为堆一直在缩小, 交换到后面去的元素认为他已经排序好了, 和堆没关系了
            // 堆最后一个元素下标为 length - i - 1
            swap(array, 0, array.length - i - 1);
            // [0, array.length - i - 1) 是未排序区间
            // [array.length - i - 1, array.length) 是已排序区间
            shiftDown(array, array.length - i - 1, 0);
        }
    }

    // 建堆
    private static void creatHeap(int[] array) {
        // 从最后一个非叶子节点出发向前, 依次向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    // 交换
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 向下调整
    private static void shiftDown(int[] array, int heapLength, int index) {
        // 升序排序, 需要建大堆, 找出左右子树中的较大值, 再和根节点比较
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child] < array[child + 1]) {
                // child 没有 child + 1 大
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 6, 8, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
