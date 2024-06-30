package controller;

import entity.Card00;
import utils.Console00;

import java.util.Objects;

public class CardCommand00 implements Command00 {
    @Override
    public void load() {
        Console00.println("1. 单抽");
        Console00.println("2. 十连抽");
        String type = Console00.keyInputString("请输入你的操作: ");
        if (Objects.equals(type, "1")) {
            getCard();
        }

        if (Objects.equals(type, "2")) {
            for (int i = 0; i < 10; i++) {
                getCard();
            }
        }
    }

    public void getCard() {
        Card00 card00 = Broker00.getCard();
        Broker00.addCard(card00);
    }

    @Override
    public String getName() {
        return "抽卡";
    }

    @Override
    public String type() {
        return "1";
    }
}
