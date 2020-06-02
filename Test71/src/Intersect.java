import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersect {
//     两个数组的交集II
//     给定两个数组，编写一个函数来计算它们的交集
//     输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致

//     思路: 使用 HashMap 解决
//     1. 将 nums1 中的数和这个数出现的次数存到 Map 中
//     2. 遍历 nums2 如果当前数在 Map 中存在, 就把他存到 list 中

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // 如果这个数在 map 中不存在
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                // 这个数在 map 中存在, 就把他的 value 加 1
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            // 如果在 map 中找到这个值, 就把他的 value 减 1, 并把他加入到 list 中
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                list.add(nums2[i]);
            }
        }
        // 将这个 list 返回
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
