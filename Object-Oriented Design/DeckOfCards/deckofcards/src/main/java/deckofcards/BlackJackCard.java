package deckofcards;

public class BlackJackCard extends Card {
    public BlackJackCard(int fv, Suit s) {
        super(fv, s);
    }

    @Override
    public int getCardValue() {
        if(isAce()){
            return 1;
        } else if(isFacecard()){
            return 10;
        } else {
            return this.faceValue;
        }
    }

    public int minValue(){
        if(isAce()){
            return 1;
        } else {
            return getCardValue();
        }
    }

    public int maxValue(){
        if(isAce()){
            return 11;
        } else {
            return getCardValue();
        }
    }

}
