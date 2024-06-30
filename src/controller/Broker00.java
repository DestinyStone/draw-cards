package controller;


import core.CardObserver00;
import core.CardStock00;
import core.ProbabilityObserver00;
import entity.Card00;
import entity.Level00;
import entity.Type00;
import utils.Console00;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Broker00 {
    private static List<Command00> strategys = Arrays.asList(
            new CardCommand00(),
            new BackpackCommand00(),
            new CloseCommand00()
    );

    private static CardStock00 stock = new CardStock00();
    public static CardObserver00 cardObserver00 = new CardObserver00(stock);
    public static ProbabilityObserver00 probabilityObserver = new ProbabilityObserver00(stock);

    public static Card00 getCard() {
        return Broker00.probabilityObserver.getCard();
    }

    public static void addCard(Card00 card00) {
        stock.addCard(card00);
    }

    public Broker00() {
        init();
    }

    public static List<Card00> getCards() {
        return stock.getCards();
    }

    public void trigger() {
        Console00.println("欢迎进入原神游戏抽卡系统");
        Console00.println("各抽卡概率如下");
        Level00[] enumConstants = Level00.class.getEnumConstants();
        for (Level00 enumConstant : enumConstants) {
            Console00.println(String.format("%s购卡概率为%s%%", enumConstant.getMessage(), enumConstant.getProbability() * 100));
        }
        while (true) {
            Console00.println("--------------------------------------------------");
            for (Command00 strategy : strategys) {
                Console00.println(String.format("%s. %s", strategy.type(), strategy.getName()));
            }

            String type00 = Console00.keyInputString("请输入你的操作: ");

            for (Command00 strategy : strategys) {
                if (Objects.equals(type00, strategy.type())) {
                    strategy.load();
                }
            }
        }
    }

    private void init() {
        stock.addCardPool(new Card00("人物1-1", Level00.LEVEL1, Type00.FIGURE));
        stock.addCardPool(new Card00("人物1-2", Level00.LEVEL1, Type00.FIGURE));
        stock.addCardPool(new Card00("人物1-3", Level00.LEVEL1, Type00.FIGURE));
        stock.addCardPool(new Card00("人物1-4", Level00.LEVEL1, Type00.FIGURE));
        stock.addCardPool(new Card00("人物1-5", Level00.LEVEL1, Type00.FIGURE));
        stock.addCardPool(new Card00("人物2-1", Level00.LEVEL2, Type00.FIGURE));
        stock.addCardPool(new Card00("人物2-2", Level00.LEVEL2, Type00.FIGURE));
        stock.addCardPool(new Card00("人物2-3", Level00.LEVEL2, Type00.FIGURE));
        stock.addCardPool(new Card00("人物2-4", Level00.LEVEL2, Type00.FIGURE));
        stock.addCardPool(new Card00("人物2-5", Level00.LEVEL2, Type00.FIGURE));
        stock.addCardPool(new Card00("人物3-1", Level00.LEVEL3, Type00.FIGURE));
        stock.addCardPool(new Card00("人物3-2", Level00.LEVEL3, Type00.FIGURE));
        stock.addCardPool(new Card00("人物3-3", Level00.LEVEL3, Type00.FIGURE));
        stock.addCardPool(new Card00("人物3-4", Level00.LEVEL3, Type00.FIGURE));
        stock.addCardPool(new Card00("人物3-5", Level00.LEVEL3, Type00.FIGURE));
        stock.addCardPool(new Card00("人物4-1", Level00.LEVEL4, Type00.FIGURE));
        stock.addCardPool(new Card00("人物4-2", Level00.LEVEL4, Type00.FIGURE));
        stock.addCardPool(new Card00("人物4-3", Level00.LEVEL4, Type00.FIGURE));
        stock.addCardPool(new Card00("人物4-4", Level00.LEVEL4, Type00.FIGURE));
        stock.addCardPool(new Card00("人物4-5", Level00.LEVEL4, Type00.FIGURE));
        stock.addCardPool(new Card00("人物5-1", Level00.LEVEL5, Type00.FIGURE));
        stock.addCardPool(new Card00("人物5-2", Level00.LEVEL5, Type00.FIGURE));
        stock.addCardPool(new Card00("人物5-3", Level00.LEVEL5, Type00.FIGURE));
        stock.addCardPool(new Card00("人物5-4", Level00.LEVEL5, Type00.FIGURE));
        stock.addCardPool(new Card00("人物5-5", Level00.LEVEL5, Type00.FIGURE));
        stock.addCardPool(new Card00("武器1-1", Level00.LEVEL1, Type00.ARMS));
        stock.addCardPool(new Card00("武器1-2", Level00.LEVEL1, Type00.ARMS));
        stock.addCardPool(new Card00("武器1-3", Level00.LEVEL1, Type00.ARMS));
        stock.addCardPool(new Card00("武器1-4", Level00.LEVEL1, Type00.ARMS));
        stock.addCardPool(new Card00("武器1-5", Level00.LEVEL1, Type00.ARMS));
        stock.addCardPool(new Card00("武器2-1", Level00.LEVEL2, Type00.ARMS));
        stock.addCardPool(new Card00("武器2-2", Level00.LEVEL2, Type00.ARMS));
        stock.addCardPool(new Card00("武器2-3", Level00.LEVEL2, Type00.ARMS));
        stock.addCardPool(new Card00("武器2-4", Level00.LEVEL2, Type00.ARMS));
        stock.addCardPool(new Card00("武器2-5", Level00.LEVEL2, Type00.ARMS));
        stock.addCardPool(new Card00("武器3-1", Level00.LEVEL3, Type00.ARMS));
        stock.addCardPool(new Card00("武器3-2", Level00.LEVEL3, Type00.ARMS));
        stock.addCardPool(new Card00("武器3-3", Level00.LEVEL3, Type00.ARMS));
        stock.addCardPool(new Card00("武器3-4", Level00.LEVEL3, Type00.ARMS));
        stock.addCardPool(new Card00("武器3-5", Level00.LEVEL3, Type00.ARMS));
        stock.addCardPool(new Card00("武器4-1", Level00.LEVEL4, Type00.ARMS));
        stock.addCardPool(new Card00("武器4-2", Level00.LEVEL4, Type00.ARMS));
        stock.addCardPool(new Card00("武器4-3", Level00.LEVEL4, Type00.ARMS));
        stock.addCardPool(new Card00("武器4-4", Level00.LEVEL4, Type00.ARMS));
        stock.addCardPool(new Card00("武器4-5", Level00.LEVEL4, Type00.ARMS));
        stock.addCardPool(new Card00("武器5-1", Level00.LEVEL5, Type00.ARMS));
        stock.addCardPool(new Card00("武器5-2", Level00.LEVEL5, Type00.ARMS));
        stock.addCardPool(new Card00("武器5-3", Level00.LEVEL5, Type00.ARMS));
        stock.addCardPool(new Card00("武器5-4", Level00.LEVEL5, Type00.ARMS));
        stock.addCardPool(new Card00("武器5-5", Level00.LEVEL5, Type00.ARMS));
        stock.addCardPool(new Card00("易阳", Level00.LEVEL5, Type00.FIGURE, 1));
    }
}
