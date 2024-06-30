package core;


import entity.Card00;

import java.util.ArrayList;
import java.util.List;

public class CardStock00 {
    private List<Card00> card00s = new ArrayList<>();
    private List<Card00> card00Pools = new ArrayList<>();
    private List<Observer00> observer00s = new ArrayList<>();
    public void addCard(Card00 card00) {
        card00s.add(card00);
        notifyAllObservers(card00);
    }

    public void addCardPool(Card00 card00) {
        card00Pools.add(card00);
    }

    public List<Card00> getCards() {
        return card00s;
    }

    public List<Card00> getCardPools() {
        return card00Pools;
    }

    public void attach(Observer00 observer00){
        observer00s.add(observer00);
    }


    public int getSize() {
        return card00s.size();
    }


    public void notifyAllObservers(Card00 card00){
        for (Observer00 observer00 : observer00s) {
            observer00.update(card00);
        }
    }

}
