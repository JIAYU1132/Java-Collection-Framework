import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        // 1. 实例化 Set
        Set<String> set = new HashSet<>();
        // 2. 往 Set 中插入元素
        set.add("hello");
        set.add("word");
        set.add("java");
        // 3. 判断某个值是否存在
        System.out.println(set.contains("word"));
        // 4. 删除值
        set.remove("word");
        System.out.println(set.contains("word"));
        // 5. 遍历打印 set
        System.out.println(set);
        // 要想循环遍历 set 中的元素, 就需要使用迭代器
        // 迭代器的泛型参数, 要和集合类中保存的元素参数保存一致
        // 集合类内部自己实现自己版本的迭代器类
        // 不同的集合类, 内部的迭代器类型不同, 迭代方式也不同(迭代的实现细节也不同)(不用太过关注)
        // for each 代码底层也是依靠迭代器来实现的
        System.out.println("==========================");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
