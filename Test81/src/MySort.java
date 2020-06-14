import java.util.Arrays;

public class MySort {

    public static void main(String[] args) {
        int[] arr = new int[] {9, 2, 5, 7, 6, 8, 4, 10, 3, 15};
        // insertSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //shellSort(arr);
        //heapSort(arr);
        //quickSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 1. 插入排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > tmp) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    // 2. 选择排序(打擂台)
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    int tmp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    // 3. 冒泡排序
    public static void bubbleSort(int[] array){
        for (int bound = array.length - 1; bound > 0; bound--) {
            for (int cur = 0; cur < bound; cur++) {
                if (array[cur] > array[cur + 1]) {
                    int tmp = array[cur];
                    array[cur] = array[cur + 1];
                    array[cur + 1] = tmp;
                }
            }
        }
    }

    // 4. 希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur -= gap) {
                if (array[cur] > tmp) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = tmp;
        }
    }

    // 5. 堆排序
    public static void heapSort(int[] array) {
        creatHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            shifDown(array, array.length - i -1, 0);
        }
    }

    private static void shifDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child] < array[child + 1]) {
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

    // 6. 快速排序
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[left];
        while (i < j) {
            while (i < j && array[i] <= base) {
                i++;
            }
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array, i, j);
        }
        swap(array, i, left);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shifDown(array, array.length, i);
        }
    }

    // 7. 归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0,array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);
        merge(array, low, mid, high);
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
}
