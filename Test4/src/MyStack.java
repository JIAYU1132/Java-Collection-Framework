public class MyStack {
    //后进先出
    private int[] array = new int[100];
    private int size = 0; // 记录栈中存在的有效数字

    // 入栈
    public void push(int x) {
        array[size] = x;
        size++;
    }

    // 取栈顶元素(最后进来的那个元素)
    public int peek() {
        return array[size - 1];
    }

    // 出栈
    public int pop() {
        int ret = array[size - 1];
        size--;
        return ret;
    }
}
