import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    public String suit;//花色
    public String rank;//数字

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "(" + suit +" " + rank + ")";
    }
}

public class CardDemo{
    public static final String[] SUITS = {"♥️","♠️","♣️","♦️"};

    public static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            for(int j = 2; j <= 10; j++){
                poker.add(new Card(SUITS[i],j + ""));
            }
            poker.add(new Card(SUITS[i],"J"));
            poker.add(new Card(SUITS[i],"Q"));
            poker.add(new Card(SUITS[i],"K"));
            poker.add(new Card(SUITS[i],"A"));
        }
        return poker;
    }
    public static void main(String[] args) {
        //创建一副牌
        System.out.println("创建一副牌");
        List<Card> poker = buyPoker();

        //洗牌
        Collections.shuffle(poker);
        System.out.println(poker);

        //1.发牌(假设3人 每人5张牌
        List<List<Card>> players = new ArrayList<>();
        //2.三个新增列表表示三个玩家的三副手牌
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        //3.把牌依次发给三个玩家
        for(int cardIndex = 0; cardIndex < 5; cardIndex++){
            for(int playIndex = 0; playIndex < 3; playIndex++){
                //把首张牌发给玩家
                List<Card> playerCards = players.get(playIndex);
                Card curCard = poker.remove(0);
                playerCards.add(curCard);
            }
        }
        //4.输出玩家的手牌
        System.out.println("玩家1：");
        System.out.println(players.get(0));
        System.out.println("玩家2：");
        System.out.println(players.get(1));
        System.out.println("玩家3：");
        System.out.println(players.get(2));
    }
}