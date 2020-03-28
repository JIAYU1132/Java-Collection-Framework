import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        //1. 创建 Collection
        Collection<String> collection = new ArrayList<>();
        //2. 使用 size 方法
        System.out.println(collection.size());
        //3. 使用 isEmpty 方法
        System.out.println(collection.isEmpty());
        //4. 使用 add 方法加入元素(默认尾插)
        collection.add("我");
        collection.add("爱");
        collection.add("你");
        //5. 再次调用 size 和 isEmpty 方法
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        //6. toArray 方法, 把 Collection 转换成数组
        Object[] array = collection.toArray();
        //得到的结果是 Object[]
        System.out.println(Arrays.toString(array));
        // 7. 也可以直接用 for 循环遍历集合中的所有元素
        for (String s : collection) {
            System.out.println(s);
        }
        //8. 使用 contains 方法判定元素是否存在
        System.out.println(collection.contains("爱"));
        //9. 使用 remove 方法删除元素
        collection.remove("我");
        System.out.println("删除以后: ");
        for (String s : collection) {
            System.out.println(s);
        }
        //10. 使用 clear 方法清空所有元素
        collection.clear();
        System.out.println("清空以后: ");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
    }
}
