package controller;


import entity.Card00;
import utils.Console00;

import java.util.List;

public class BackpackCommand00 implements Command00 {
    @Override
    public void load() {
        List<Card00> card00s = Broker00.getCards();
        if (card00s.size() == 0) {
            Console00.println("暂无抽卡历史");
            return;
        }

        for (Card00 card00 : card00s) {
            Console00.println(String.format("卡片%s(类型： %s, 等级： %s, 是否限定: %s)",
                    card00.getName(),
                    card00.getType().getMessage(),
                    card00.getLevel().getMessage(),
                    card00.getIsTop() == 1 ? "是" : "否"
            ));
        }
        Console00.println(String.format("目前抽卡%s次", card00s.size()));
    }

    @Override
    public String getName() {
        return "查看背包";
    }

    @Override
    public String type() {
        return "2";
    }
}
