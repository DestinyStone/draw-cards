package core;

import cn.hutool.core.util.RandomUtil;
import entity.Card00;
import entity.Level00;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ProbabilityObserver00 extends Observer00 {

    // 抽卡次数
    private Integer count = 0;

    // 是否已经出过4星
    private boolean level4Lock = false;

    // 是否已经出过5星
    private boolean level5Lock = false;

    // 是否已经出过限定
    private boolean levelTopLock = false;

    private CardStock00 stock;

    private Map<Integer, Level00> probabilityPool = new ConcurrentHashMap<>();
    private Integer probabilityPoolLength = 0;
    public ProbabilityObserver00(CardStock00 stock){
        this.stock = stock;
        this.stock.attach(this);

        // 构建比例尺
        build();
    }

    public void build() {
        Level00[] enumConstants = Level00.class.getEnumConstants();
        for (Level00 enumConstant : enumConstants) {
            int value = (int)(enumConstant.getProbability() * 10000);
            for (int i = 0; i < value; i++) {
                probabilityPool.put(probabilityPoolLength++, enumConstant);
            }
        }
    }

    // 获取卡片
    public List<Card00> getCardByLevel(Level00 level00) {
        return stock.getCardPools().stream().filter(item -> {
            return Objects.equals(item.getLevel(), level00);
        }).collect(Collectors.toList());
    }

    public Card00 getCard() {
        Card00 card00 = null;
        // 如果已经到达160的倍数, 则获取限定
        if ((count + 1) % 160 == 0) {
            card00 = getOneTopCard();
        }
        // 如果已经到达80的倍数, 则获取5星
        else if ((count + 1) % 80 == 0) {
            card00 = getOneCardByLevel(Level00.LEVEL5);
        }
        // 如果已经到达10的倍数, 则获取4星
        else if ((count + 1) % 10 == 0) {
            card00 = getOneCardByLevel(Level00.LEVEL4);
        }else {
            int index = RandomUtil.randomInt(probabilityPoolLength);
            Level00 level00 = probabilityPool.get(index);
            card00 = getOneCardByLevel(level00);
        }

        if (card00 == null) {
            return getCard();
        }

        // 如果抽到限定
        if (Objects.equals(card00.getIsTop(), 1)) {
            levelTopLock = true;
        }
        // 如果抽到5星
        if (Objects.equals(card00.getLevel(), Level00.LEVEL5)) {
            level5Lock = true;
        }
        // 如果抽到4星
        if (Objects.equals(card00.getLevel(), Level00.LEVEL4)) {
            level4Lock = true;
        }
        return card00;
    }

    // 随机获取一个等级的卡片
    public Card00 getOneCardByLevel(Level00 level00) {
        List<Card00> card00ByLevel = getCardByLevel(level00);
        if  (card00ByLevel.size() == 0) {
            return null;
        }
        int index = RandomUtil.randomInt(card00ByLevel.size());
        return card00ByLevel.get(index);
    }

    // 随机获取限定
    public Card00 getOneTopCard() {
        List<Card00> collect = stock.getCardPools().stream().filter(item -> {
            return Objects.equals(item.getIsTop(), 1);
        }).collect(Collectors.toList());

        if (collect.size() == 0) {
            return null;
        }
        int index = RandomUtil.randomInt(collect.size());
        return collect.get(index);
    }

    @Override
    public void update(Card00 card00) {
        count+=1;
    }
}
