package deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {
    protected List<T> cards;

    Hand(){
        this.cards = new ArrayList<>();
    }

    public int getScore(){
        int score=0;
        for(T card:cards){
            score+=card.getCardValue();
        }
        return score;
    }

    public void addCard(T card){
        this.addCard(card);
    }
}
