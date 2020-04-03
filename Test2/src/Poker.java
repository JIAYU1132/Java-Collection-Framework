import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//这是一张牌
class Card {
    private String rank; // 点数
    private String suit; // 花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" + this.suit + this.rank + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        // 1. 创建一副牌
        List<Card> poker = buyPoker();
        // 2. 洗牌
        // Collections 中的 shuffle 方法 可以打乱元素顺序
        Collections.shuffle(poker);
        // 3. 发牌, 三个玩家, 没人五张牌
        // 每个玩家就是一个 List, 直接把每个人的手牌放到 List 中
        // 把多个玩家的信息再放到一个 List 中
        // players 表示所有玩家
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        // 开始发牌
        // i 表示牌的编号, j 表示玩家编号
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                player.add(poker.remove(0));
                // remove 表示删除 List 中指定下标的元素, 返回删除的元素
                // remove 删除指定元素后, 后续元素移动到左侧(从索引中减去一个元素)
            }
        }
        // 发牌结束, 查看玩家手牌
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + players.get(i));
        }
    }

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();
        
        String[] suits = {"♥", "♠", "♣", "♦"};

        for (int i = 0; i < 4; i++) {
            // 这个循环来处理四种花色
            // 每种花色有 13 张牌
            for (int j = 0; j <= 10; j++) {
                // j 表示点数, 要将 int 转成 String, 使用 "" + j 或 String.valueOf(j) 来转换
                poker.add(new Card("" + j, suits[i]));
            }
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
            poker.add(new Card("A", suits[i]));
        }
        return poker;
    }
}
