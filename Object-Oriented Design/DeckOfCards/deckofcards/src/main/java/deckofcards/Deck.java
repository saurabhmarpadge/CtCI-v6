package deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Deck<T extends Card> {
    private List<T> cards;
    private int deckCardIndex;

    Deck(){
        this.cards = new ArrayList<>();
        this.deckCardIndex = 0;
    }

    public void setDeckOfCards(List<T> cards){
        this.cards = cards;
    }

    public void suffle(){
        for(int p1=0;p1<cards.size();p1++){
            int p2 = (int)Math.random()%this.cards.size();
            T cardFirst = this.cards.get(p1);
            T cardSecond = this.cards.get(p2);
            this.cards.set(p2,cardFirst);
            this.cards.set(p1,cardSecond);
        }
    }

    public T dealCard() {
        if(deckCardIndex>=this.cards.size()){
            return null;
        }
        T card = cards.get(this.deckCardIndex);
        deckCardIndex++;
        card.markUnAvailable();
        return card;
    }
}
