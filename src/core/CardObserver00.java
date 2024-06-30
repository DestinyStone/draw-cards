package core;


import entity.Card00;
import utils.Console00;

public class CardObserver00 extends Observer00 {

    private CardStock00 stock;

    public CardObserver00(CardStock00 stock){
        this.stock = stock;
        this.stock.attach(this);
    }

    @Override
    public void update(Card00 card00) {
        Console00.println(String.format("获得卡片%s(类型： %s, 等级： %s, 是否限定: %s)",
                card00.getName(),
                card00.getType().getMessage(),
                card00.getLevel().getMessage(),
                card00.getIsTop() == 1 ? "是" : "否"
                ));
    }
}
