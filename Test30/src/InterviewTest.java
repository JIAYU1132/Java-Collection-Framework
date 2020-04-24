import java.util.Stack;

public class InterviewTest {

    // 股票价格跨度(单调栈)

    // 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
    // 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
    // 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

    // 即, 求出最近的一个大于今天价格的日子
    // 1. 得到一个新的价格后, 将栈中的栈顶元素取出来, 和新的价格比一下
    // 2. 如果他小于等于新的价格, 把它的跨度记录下来
    // 3. 继续上一步的操作, 直到找到大于新的价格的元素, 用 tmp 累加计数跨度
    // 4. 最后将新的价格和他的跨度 span 入栈
    class StockSpanner {

        // 创建两个栈
        Stack<Integer> prices = new Stack<>(); // 存放价格

        Stack<Integer> span = new Stack<>(); // 存放跨度

        public StockSpanner() {

        }

        public int next(int price) {
            int tmp = 1; // 创建一个变量用来累加跨度
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                tmp += span.pop();
            }
            // 循环结束, 所有小于等于 price 的跨度都被累加起来了, 此时将 price 和它的跨度 tmp 入栈等待即可
            prices.push(price);
            span.push(tmp);
            return tmp;

        }
    }
}
