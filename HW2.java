import java.util.ArrayList;
 
import java.util.HashMap;

import java.util.Scanner;

/*

 * ID: B0444108

 * Name: 林維真

*/
 public class HW2 {
 
     public static void main(String[] args) {
 
         Scanner sc = new Scanner(System.in);
         System.out.print("input N(deck of cards):");
         String testn = sc.nextLine();
 
         int nDeck = Integer.parseInt(testn);
         Deck deck = new Deck(nDeck);
         //TODO: please check your output, make sure that you print all cards on your screen
         deck.printDeck();
 
         if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
             System.out.println("Well done!");
         } else {
             System.out.println("Error, please check your sourse code");
         }
     }
 
     /*
 
      * This method is used for checking your result, not a part of your HW2
 
      */
     private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
         //check the output 
         boolean isCorrect = true;
         HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
         for (Card card : allCards) {
             int suit = card.getSuit();
             int rank = card.getRank();
             if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
                 isCorrect = false;
                 break;
             }
             if (checkHash.containsKey(suit + "," + rank)) {
                 checkHash.put(suit + "," + rank,
                         checkHash.get(suit + "," + rank) + 1);
             } else {
                 checkHash.put(suit + "," + rank, 1);
             }
         }
         if (checkHash.keySet().size() == 52) {
             for (int value : checkHash.values()) {
                 if (value != nDeck) {
                     isCorrect = false;
                     break;
                 }
             }
         } else {
            isCorrect = false;
         }
         return isCorrect;
     }
 }
 
 /*
 
  * Description: Deck類別包含ArrayList<Card>類別的屬性cards、Deck建構子，printDeck、getAllCards兩個方法，
                 
 
  */
 class Deck {
 
     private ArrayList<Card> cards;
     //TODO:建構子依照使用者輸入的撲克牌副數，將每張撲克牌存入cards陣列
     public Deck(int nDeck) {
 
         cards = new ArrayList<Card>();
 
         //Hint: Use new Card(x,y) and 3 for loops to add card into deck
         for (int deck = 0; deck < nDeck; deck++) {
             for (int i = 1; i <= 4; i++) {
                 for (int j = 1; j <= 13; j++) {
                     Card card = new Card(i, j);
                     cards.add(card);
                 }
             }
 
         }
 
     }
 
     //TODO: 用cards的長度除52(一副牌52張)來得到撲克牌副數，再沿用card內的方法printCard來印出每張牌
     public void printDeck() {
 
 	//Hint: print all items in ArrayList<Card> cards, 
         //please implement and reuse printCard method in Card class
    	 for(Card x : cards){
    		 x.printCard();
    	 }
         /*for (int i = 0; i < (cards.size() / 52); i++) {
             Card card = new Card(1, 1);
             card.printCard();
         }*/
     }
 
     public ArrayList<Card> getAllCards() {
 
         return cards;
 
     }
 
 }
 
 /*
 
  * Description: Card類別包含suit(花色)、rank(牌階)兩種屬性，Card、printCard(印出整副牌)、getSuit、getRank四種方法
 
  */
 class Card {
 
     private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
 
     private int rank; //1~13
 
     public Card(int s, int r) {
 
         suit = s;
 
         rank = r;
 
     }
 
     //TODO: 1. Please implement the printCard method
     public void printCard() {
 
         //Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
         System.out.println(suit+","+rank);
    	 /*for (int i = 1; i <= 4; i++) {
             for (int j = 1; j <= 13; j++) {
                 System.out.println(i + "," + j);
             }
         }*/
     }
 
     public int getSuit() {
         return suit;
     }
 
     public int getRank() {
        return rank;
    }

 }