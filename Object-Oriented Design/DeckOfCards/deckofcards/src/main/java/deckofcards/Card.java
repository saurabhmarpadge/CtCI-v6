package deckofcards;

public abstract class Card {

    protected int faceValue;
    protected Suit suit;

    private boolean available;

    Card(int fv,Suit s){
        this.faceValue = fv;
        this.suit = s;
        this.available=true;
    }

    public abstract int getCardValue();

    public Suit getSuit(){
        return this.suit;
    }

    public boolean isAce(){
        return faceValue==1;
    }

    public boolean isFacecard(){
        return faceValue>=11&&faceValue<=13;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void markAvailable(){
        this.available = true;
    }

    public void markUnAvailable(){
        this.available = false;
    }

}
