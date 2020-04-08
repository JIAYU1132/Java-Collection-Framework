import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Employee {
        public int id;

        public int importance;

        public List<Integer> subordinates;
    };

    // 先将给定 id 的员工入队, 加上其重要性, 再将其出队, 同时将其下属入队, 加上其重要性, 直至没有下属
    public class  Test {
        public int getImportance(List<Employee> employees, int id) {
            if (employees.size() == 0) {
                return 0;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(id);
            int result = 0;
            while (queue.size() != 0) {
                // 将 id 出队列
                int tmp = queue.poll();
                // 在员工 List 中找 id , 找到后加上其重要性, 并且将这个 id 的下属入队列
                for (Employee e : employees) {
                    if (id == e.id) {
                        result += e.importance;
                        for (Integer i : e.subordinates) {
                            // 此时 i 所指的是 id 对应的 Employee 类中的 subordinates 对象
                            if (i == null) {
                                return result;
                            }
                            queue.offer(i);
                    }
                    }
                }
            }
            return result;
        }
    }

