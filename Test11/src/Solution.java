//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

public class Solution {
    // 1. 要是可以三等分, 那么数组 A 中所有元素的和 sum 一定可以被 3 整除, 如果不行, 直接返回 false
    // 2. 将 sum 除以 3 , 计算出每部分的和
    // 3. 创建双指针, 从数组两边开始找和为 sum / 3 的临界点, 当两边找到后, 中间的和也是 sum / 3
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int left = 0;
        int leftSum = A[0];
        int right = A.length - 1;
        int rightSum = A[A.length - 1];
        // while 的循环条件中使用减一是因为要分成三个部分, 不减一会分成两个部分
        while (left < right - 1) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                // 三等分
                return true;
            }
            // 如果左边部分不相等
            if (leftSum != sum / 3) {
                // 更新 left 位置, 并且记录更新后的 leftSum 的值
                left++;
                leftSum += A[left];
            }
            // 如果右边部分不相等
            if (rightSum != sum / 3) {
                // 更新 right 的位置, 并记录更新后的 rightSum 的值
                right--;
                rightSum += A[right];
            }
        }
        // 找完还没找到, 返回 false
        return false;
    }
}
