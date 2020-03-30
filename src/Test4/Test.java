package Test4;

import Test3.SeqList;

import java.util.Objects;

public class Test<E> {
    // 包装类
    // int => Integer;
    // char => Character;
    // 其他六种类型皆是将首字母大写即可;
        private E[] data = (E[]) new Objects[100]; //先 new 一个 object 类;
        private int size;

        public void add(E elem) {
            data[size] = elem;
            size++;
        }

        public E get(int index) {
            return data[index];
        }

        public static void main(String[] args) {
            SeqList<Integer> integerSeqList = new SeqList<>();
            // 装箱(boxing): 这个操作相当于把一个 int => Integer;
            // Integer num = new Integer(10);
            // Integer num = Integer.valueOf(10);// valueOf 是一个静态方法, 通过 类名. 调用;
            Integer num = 10; // 自动装箱(推荐): 直接把一个 int 赋值给 Integer, (编译器赋予包装类的特殊功能);
            num = integerSeqList.get(0);// 这是一个 Integer 类型;
            // 拆箱(unboxing): 相当于把 Integer => int;
            // int value = num.intValue // 手动拆箱;
            int value = num;// 自动拆箱(推荐);

            // 拆箱和装箱说白了就是类型转换;
            // 自动拆箱装箱, 也就是隐式类型转换;
        }
    }
