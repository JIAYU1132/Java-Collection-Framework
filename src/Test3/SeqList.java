package Test3;

import java.util.Objects;
    // 泛型类 就是一套代码可以被适用于多个场景, 相当于模板!
public class SeqList<E> {
    // E 这样的泛型参数是不能直接被实例化的, 当前还不知道 E 是啥类型
    private E[] data =(E[]) new Objects[100]; //先 new 一个 object 类
    private int size;

    public void add(E elem) {
        data[size] = elem;
        size++;
    }

    public E get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        SeqList<String> seqList = new SeqList<>();
        seqList.add("aaa");
        seqList.add("bbb");
        String str = seqList.get(0);
        // 这里的 add 和 get 方法返回值类型就是 <> 中的 String 类型

        SeqList<Animal> seqList1 = new SeqList<>();
        seqList1.add(new Animal());
        Animal animal = seqList1.get(0);
        // 这里的 add 和 get 方法返回值类型就是 <> 中的 String 类型
    }
}
