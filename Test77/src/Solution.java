import java.util.HashSet;

public class Solution {

    // 存在重复元素I
    // 给定一个整数数组，判断是否存在重复元素。
    // 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

//     思路:
//     利用 HashSet 来实现
//      如果这个数字在 set 中不存在, 就将数字存到 set 中, 如果这个数字已经存在, 就直接返回这个 true
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                return true;
            }
        }
        return false;
    }
}
