import java.util.HashMap;
import java.util.Map;

public class Interview {
    // 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    // 思路:
    // 方法1. 通过 Map 来统计每个数字出现的次数, (Map<Integer, Integer> key 表示当前数字, value 表示这个数字出现的次数)
    // 再次遍历 Map 找到那个只出现一次的数字即可(value 等于 1 的数字)
    // 方法2. 按位异或的方式: a ^ b ^ a => b, 当所有的数字都异或完成, 最终得到的那个数就是只出现一次的数

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历数组, 完成统计
        for (int i : nums) {
            Integer tmp = map.get(i);
            if (tmp == null) {
                // 当前这个数字 map 中不存在, 新建一个键值对
                map.put(i, 1);
            } else {
                // 当前这个数字前面已经存在过了, 把 tmp + 1 即可
                map.put(i, tmp + 1);
            }
        }
        // 遍历 map, 找到出现次数为 1 的 key 值
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // getValue 得到的是 Integer 的包装类, 通过 equals 判定相当于对 1 进行自动装箱, 比较两个 Integer 的值
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
