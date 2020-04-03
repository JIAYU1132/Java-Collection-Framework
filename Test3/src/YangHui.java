import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        // 杨辉三角的特点:
        // 1. 第一行固定是一个 1
        // 2. 第二行也固定是两个 1
        // 3. 第 i 行, 首尾元素都是 1
        // 4. 第 i 行有 i 个元素
        // 5. 对于第 i 行来说, 第 j 列的值就是 i - 1 行的第 j - 1 列的值加第 j 列的值
        //    (i, j) = (i - 1, j) + (i - 1, j - 1)
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        // 1. 先准备第一行, 有一个元素 1
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        // 2. 准备第二行, 有两个元素 1
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        // 3. 处理第 i 行
        for (int row = 3; row <= numRows; row++) {
            // 要想知道 row 行, 就得获取到上一行的情况
            List<Integer> prevLine = result.get(row - 1 - 1);
            // 减两次 1 是因为题目中的行列数从 1 开始, 而下标从 0 开始
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 2; col < row; col++) {
                // 此处循环结束条件是 < 而不是 <= 是因为循环执行 row - 2 次, 第一列和最后一列不参与
                int curNum = prevLine.get(col - 1) + prevLine.get(col - 1 - 1);
                // 此处前者是 col 列的元素, 后者是 col - 1 列的元素
                //把 curNum 的值加入到 curLine 中去
                curLine.add(curNum);
            }
            // 在每一行的循环执行完以后, 进行最后一列元素的操作
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
