package deckofcards;

public class BlackJackHand extends Hand<BlackJackCard>{

    @Override
    public int getScore(){
        int score=0;
        int aceCount=0;
        if(this.cards.size()==0){
            return 0;
        }
        for(BlackJackCard blackJackCard : cards){
            if(!blackJackCard.isAce()){
               if(blackJackCard.isFacecard()){
                   score+=10;
               } else {
                   score+=blackJackCard.faceValue;
               }
            }
            if(blackJackCard.isAce()){
                aceCount++;
            }
        }

        for(int idx=0;idx<aceCount;idx++){
            if(score+11>21){
                score+=1;
            } else {
                score+=11;
            }
        }
        return score;
    }

    public boolean busted(){
        return getScore()>21;
    }

    public boolean is21(){
        return getScore()==21;
    }


    public boolean isBlackJack(){
        return this.cards.size()==2 && (cards.get(0).isFacecard()&&cards.get(1).isAce()) && (cards.get(0).isAce()&&cards.get(1).isFacecard());
    }

}
