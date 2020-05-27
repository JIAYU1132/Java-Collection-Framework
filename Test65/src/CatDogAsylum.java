import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        Queue<Integer> cat = new LinkedList<>(); // 存放猫
        Queue<Integer> dog = new LinkedList<>(); // 存放狗
        Queue<Integer> animal = new LinkedList<>(); // 存放猫和狗, 为了处理第二个数字等于 0 的情况
        ArrayList array = new ArrayList(); // 存放收养的动物
        for (int i = 0; i < ope.length; i++) {
           if (ope[i][0] == 1) { // 第一个数等于 1, 表示有动物要进入收容所
                if (ope[i][1] < 0) { // 第二个数小于 0, 说明进入的是猫
                    cat.add(ope[i][1]);
                } else if (ope[i][1] > 0) { // 第二个数大于 0, 说明进入的是狗
                    dog.add(ope[i][1]);
                }
                // 再把猫和狗都存入 animal 中
               animal.add(ope[i][1]);
           }
           if (ope[i][0] == 2) { // 第一个数等于 2, 说明有人要收养动物了
               if (ope[i][1] == 0 && !animal.isEmpty()) { // 第二个数等于 0, 说明要收养的是最早进入收容所的动物, 即 animal 队列的队首元素
                   // 将这个元素加入到 array 中去
                   int tmp = animal.poll();
                   array.add(tmp);
                   // 此时还需要把 cat 和 dog 中的队首元素删除
                   if (tmp < 0) { // 要收养的是猫
                       cat.poll();
                   } else if (tmp > 0) { // 要收养的是狗
                       dog.poll();
                   }
               } else if (ope[i][1] == 1 && !dog.isEmpty()) { // 第二个数等于 1, 说明要收养的是狗
                    int tmp = dog.poll();
                    // 把这个元素加入到 array 中
                    array.add(tmp);
                    // 再把 animal 中的这个 dog 删掉
                    animal.remove(tmp);
               } else if (ope[i][1] == -1 && !cat.isEmpty()) { // 第二个数等于 -1, 说明要收养的是猫
                   int tmp = cat.poll();
                   array.add(tmp);
                   animal.remove(tmp);
               }
           }
        }
        return array;
    }
}
