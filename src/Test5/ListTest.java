package Test5;
//List接口常用方法
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // 1. 创建 List 实例
        // List 是一个接口, 无法直接实例化对象;
        List<String> list = new ArrayList<>();
        // 2. 新增元素
        list.add("c");
        list.add("c++");
        list.add("Java");
        list.add("PHP");
        list.add("Python");
        // 3. 打印整个 List
        System.out.println(list);
        // 4. 按照下标访问元素
        System.out.println(list.get(2));
        // 5. 根据下标修改元素
        list.set(0, "JavaScript");
        System.out.println(list);
        // 6. 使用 for 循环访问每个元素
        for (String s : list) {
            System.out.println(s);
        }
        // Collection 中的操作, List 同样可以使用
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 7. 使用 subList 获取子序列
        System.out.println("获取子序列: ");
        System.out.println(list.subList(1,3));
        // 8. 可以使用构造方法构造新的 List 对象
        List<String> list1 = new ArrayList<>(list);//相当于复制了一份 list;
        System.out.println(list1);
        list.set(0, "c#");
        System.out.println(list1);
    }
}
