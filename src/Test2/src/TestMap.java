import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        //1. 创建 Map 实例. 泛型的参数有两个, 第一个参数表是 key 类型, 第二个参数是 value 的类型
        // key value 这种结构最主要的目的就是根据 key 的值找到对应的 value
        Map<String, String> map = new HashMap<>();
        //2. 使用 size 方法获取元素个数(键值对个数)
        System.out.println(map.size());
        //3. 使用 isEmpty 方法查看是否为空
        System.out.println(map.isEmpty());
        // 4. 使用 put 方法, 把一些键值对存放进去
        map.put("1", "hehe");
        map.put("2", "haha");
        map.put("3", "heihei");
        // 如果插入的键值对 key 已存在, 就会覆盖原有的 value 值
        map.put("1","aaaaa");
        // 5. 使用 get 方法, 利用 key 查找对应的 value
        //   如果 key 不存在, 返回 null
        //   getOrDefault 方法, 如果 key 值没找到, 则返回 defaultValue(默认值)
        System.out.println(map.get("2"));
        System.out.println(map.get("4"));
        System.out.println(map.getOrDefault("4", "ooo"));
        // 6. 使用 containsKay 和 containsValue 查找某个值是否存在
        //   containsKey 查找效率高(推荐使用), containsValue 查找效率较低
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("haha"));
        System.out.println(map.containsValue("a"));
        // 7. 使用 for each 遍历 Map 中的所有键值对
        //   Entry : 表示一个"条目", 也就是一个键值对
        //   map.entrySet 获取到所有的键值对
        //   Map 中的元素顺序和插入顺序无关, 取决于具体的实现方式
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
