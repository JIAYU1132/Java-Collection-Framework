public class Interview {
    // 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素

    // 思路:
    // 1. 还是把所有的数字异或到一起, 最终得到 a ^ b
    // 2. a ^ b 肯定不为 0 , 可以从异或结果中找到值为 1 的 bit 位
    // 3. 根据这个 bit 位进行分组, 这个 bit 位为 1 的为一组, 这个 bit 位为 0 的为一组(此时 a 和 b 一定在不同组中)
    // 4. 此时由若干个数字组成的这两个数组, 其中每个数组中就只有一个数字出现一次, 其他都出现了两次

    public int[] singleNumber(int[] nums) {
        // 1. 先把所有的数字异或在一起
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        // 2. 此时的异或结果相当于 a ^ b , 值一定不为 0, 从中找到某位值为 1 的 bit 位
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
            // 循环结束, 此时 bit 左移 i 后的值, 就是要找的值为 1 的 bit 位
            // 进行分组
            int a = 0;
            int b = 0;
            for (int x : nums) {
                if ((x & (bit << i)) != 0) {
                    // 第一组, 指定位值为 1
                    a ^= x;
                } else {
                    // 第二组, 指定位值为 0
                    b ^= x;
                }
            }
            int[] arr = {a, b};
            return arr;
        }
}

