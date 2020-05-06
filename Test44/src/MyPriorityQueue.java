public class MyPriorityQueue {
    //优先级队列
    // 进队列按顺序, 出队列则是出堆顶元素, 大堆中最大的元素
    private int[] array = new int[100];
    private int size = 0;

    // 入队列

    //  将元素加到堆的最下方. 然后进行向上调整(向下调整)

    public void offer(int x) {
        array[size] = x;
        size++;
        shiftUp(array, size - 1, size);
        // 把新加入的元素进行向上调整
    }

    // 向上调整比向下调整简单, 只需要比较父子节点大小即可
    // 和向下调整不同的是,  size 这个参数没用上
    // 判定调整完成的界限是和 0 进行比较, 不需要知道整个堆多大
    public static void shiftUp(int[] array, int index, int size) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            // child = 0 时指向的是根节点
            if (array[parent] < array[child]) {
                // 当前不符合大堆要求
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 发现当前父节点比子节点大, 说明这个时候数组已经符合大堆的结构了
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 出队列

    // 要想删除堆顶元素, 即队首元素, 直接把堆底元素即数组的最后一个元素赋值到堆顶元素上
    // 同时 size-- 把最后一个元素删除掉
    // 接下来从新的堆顶元素出发进行向下调整即可

    public int poll() {
        // 下标为 0 的元素就是堆顶元素(队首元素)
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return oldValue;
    }

    public void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1; // 左子树下标
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                // 比较左右子树中较大的那个
                child = child + 1;
            }
            // 上述条件结束后, child 肯定对应左右子树中比较大的元素
            // 此时拿这个较大的 child 节点和 parent 节点比较一下
            if (array[child] > array[parent]) {
                // 交换父子节点的位置
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                // 已经符合堆的要求了
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 获取栈顶元素

    public int peek() {
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        myPriorityQueue.offer(9);
        myPriorityQueue.offer(5);
        myPriorityQueue.offer(2);
        myPriorityQueue.offer(7);
        myPriorityQueue.offer(3);
        myPriorityQueue.offer(6);
        myPriorityQueue.offer(8);

        while (!myPriorityQueue.isEmpty()) {
            int cur = myPriorityQueue.poll();
            System.out.println(cur);
        }
    }
}
