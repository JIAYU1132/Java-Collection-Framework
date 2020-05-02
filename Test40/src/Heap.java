import java.util.Arrays;

public class Heap {

    // 通过 size 指定 array 中哪些元素是有效的堆元素
    // index 指从哪个位置的下标开始查找
    // 左右子树都是堆, 才能进行向下调整
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        // 根据 parent 下标找到左子树
        while (child < size) {
            // 比较左右子树找到较小值
            if (child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            // 经过上面的比较, 已经不知道 child 是左子树还是右子树
            // 但是知道 child 下标一定对应左右子树最小值的下标

            // 用 child 位置元素下标和 parent 位置元素下标比较
            if (array[child] < array[parent]) {
                // 不符合规则, 交换父子节点
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 调整完毕, 跳出循环
                break;
            }
            // 更新 parent 和 child , 处理下一层的数据
            parent = child;
            child = parent * 2 + 1;
        }
    }
    // 建堆
    public static void creatHeap(int[] array, int size) {
        for (int i = (size - 1 - 1) / 2; i >= 0 ; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        creatHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
