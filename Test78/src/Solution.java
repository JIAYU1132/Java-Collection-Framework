import java.util.HashSet;

public class Solution {
    // 存在重复元素 II
    // 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
    // 并且 i 和 j 的差的 绝对值 至多为 k

//     思路:
//     还是利用 HashSet 来实现
//     这里需要维护这个 set 的大小始终不大于 k , 如果大于 k, 就移除旧元素(最前面的数字)

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                // 如果找到相同的元素, 就直接返回 true, 因为经过维护, set 中最多只能存 k 个值,
                // 就保证了这两个相同元素的下标之差绝对值小于等于 k
                return true;
            } else {
                set.add(nums[i]);
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
