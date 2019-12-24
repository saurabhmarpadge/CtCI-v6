package deckofcards;

public enum Suit {
    Club(0), Heart(1), Spade(2),Diamond(3);

    private int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Suit getSuitFromValue(int value){
        switch (value){
            case 0:
                return Club;
            case 1:
                return Heart;
            case 2:
                return Spade;
            case 3:
                return Diamond;
            default:
                return Club;
        }
    }
}
