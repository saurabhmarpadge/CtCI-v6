package deckofcards;

import java.util.ArrayList;
import java.util.List;

public class BlackJackAutomator {

    private static final int HIT_UNTIL = 16;
    Deck<BlackJackCard> blackJackCardDeck;
    BlackJackHand[] blackJackHands;

   BlackJackAutomator(int noOfPlayers){
       blackJackCardDeck = new Deck<>();
       blackJackHands = new BlackJackHand[noOfPlayers];
       for(int idx=0;idx<noOfPlayers;idx++){
           blackJackHands[0] =  new BlackJackHand();
       }
   }

    public void initilizeDeck(){
        List<BlackJackCard> bjCards = new ArrayList<>();
        for(int cardFV=1;cardFV<=13;cardFV++){
            for(int suitV=0;suitV<=3;suitV++){
                bjCards.add(new BlackJackCard(cardFV,Suit.getSuitFromValue(suitV)));
            }
        }
        blackJackCardDeck.setDeckOfCards(bjCards);
        blackJackCardDeck.suffle();
    }

    public boolean dealInitial(){
       for(BlackJackHand hand:blackJackHands){
           BlackJackCard firstCard = blackJackCardDeck.dealCard();
           BlackJackCard secondCard = blackJackCardDeck.dealCard();
           if(firstCard==null||secondCard==null){
               return false;
           }
           hand.addCard(firstCard);
           hand.addCard(secondCard);
       }
       return true;
    }

    public List<Integer> getBlackJacks(){
       List<Integer> winners = new ArrayList<>();
        for(int handIdx=0;handIdx<blackJackHands.length;handIdx++){
            if(blackJackHands[handIdx].isBlackJack()){
                winners.add(handIdx);
            }
        }
        return winners;
    }

    public boolean playHand(BlackJackHand blackJackHand){
       while(blackJackHand.getScore()<HIT_UNTIL){
           BlackJackCard blackJackCard = blackJackCardDeck.dealCard();
           if(blackJackCard==null){
               return false;
           }
           blackJackHand.addCard(blackJackCard);
       }
       return true;
    }

    public boolean playAllHands(){
       for(BlackJackHand blackJackHand:blackJackHands){
           if(!playHand(blackJackHand)){
               return false;
           }
       }
       return true;
    }

    public List<Integer> getWinners(){
       List<Integer> winners = new ArrayList<>();
       int winningScore = 0;
       for(int handIdx=0;handIdx<blackJackHands.length;handIdx++){
           if(!blackJackHands[handIdx].busted()){
               if(blackJackHands[handIdx].getScore()>winningScore){
                   winningScore = blackJackHands[handIdx].getScore();
                   winners.clear();
                   winners.add(handIdx);
               } else if(blackJackHands[handIdx].getScore()>winningScore){
                   winners.add(handIdx);
               }
           }
       }
       return winners;
    }

}
