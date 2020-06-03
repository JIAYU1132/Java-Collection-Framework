import java.util.HashSet;

public class Intersection {
    // 两个数组的交集
    // 给定两个数组，编写一个函数来计算它们的交集

//     思路:
//     HashSet 具有元素不重复, 不注重顺序的特点, 因此可以用 HashSet 来解决这个题
//     1. 把 nums1 中的元素全部存到 HashSet 中
//     2. 然后遍历 nums2, 与 HashSet 中的方法进行 contains 方法的比较

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            // 如果 nums2 中的元素在 set1 中存在, 就把这个元素加到 set2 中
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        // 此时只需要把 set2 返回即可
        int[] arr = new int[set2.size()];
        int i = 0;
        for (int cur : set2) {
            arr[i++] = cur;
        }
        return arr;
    }
}
