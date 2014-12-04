//Chaquille Browne
//CS110
//11/20/14
//Deck Class for War card game

import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Deck
{
   private final int DECK = 52;           //Number of cards in a deck
   private final int PLAYER_CARDS = 26;   //Each player has 26 cards
   private int playerCard;                //Card Value
   private int playingCard;               //Card image
   private int number;                    //For getting card
   private Random rand;                   //For random numbers
   //Placing images of cards in a array list
   private ImageIcon[] cards = {new ImageIcon("2c.jpg"), new ImageIcon("2d.jpg"), new ImageIcon("2h.jpg"),new ImageIcon("2s.jpg"),
                                new ImageIcon("3c.jpg"), new ImageIcon("3d.jpg"), new ImageIcon("3h.jpg"),new ImageIcon("3s.jpg"),
                                new ImageIcon("4c.jpg"), new ImageIcon("4d.jpg"), new ImageIcon("4h.jpg"),new ImageIcon("4s.jpg"),                           
                                new ImageIcon("5c.jpg"), new ImageIcon("5d.jpg"), new ImageIcon("5h.jpg"),new ImageIcon("5s.jpg"),
                                new ImageIcon("6c.jpg"), new ImageIcon("6d.jpg"), new ImageIcon("6h.jpg"),new ImageIcon("6s.jpg"),
                                new ImageIcon("7c.jpg"), new ImageIcon("7d.jpg"), new ImageIcon("7h.jpg"),new ImageIcon("7s.jpg"),
                                new ImageIcon("8c.jpg"), new ImageIcon("8d.jpg"), new ImageIcon("8h.jpg"),new ImageIcon("8s.jpg"),
                                new ImageIcon("9c.jpg"), new ImageIcon("9d.jpg"), new ImageIcon("9h.jpg"),new ImageIcon("9s.jpg"),
                                new ImageIcon("10c.jpg"), new ImageIcon("10d.jpg"), new ImageIcon("10h.jpg"),new ImageIcon("10s.jpg"),
                                new ImageIcon("jackc.jpg"), new ImageIcon("jackd.jpg"), new ImageIcon("jackh.jpg"),new ImageIcon("jacks.jpg"),
                                new ImageIcon("queenc.jpg"), new ImageIcon("queend.jpg"), new ImageIcon("queenh.jpg"),new ImageIcon("queens.jpg"),
                                new ImageIcon("kingc.jpg"), new ImageIcon("kingd.jpg"), new ImageIcon("kingh.jpg"),new ImageIcon("kings.jpg"),
                                new ImageIcon("acec.jpg"), new ImageIcon("aced.jpg"), new ImageIcon("aceh.jpg"),new ImageIcon("aces.jpg")};
   
   /**
      Constructor to give 26 cards to the player 
   */
   
   public Deck() throws ArrayIndexOutOfBoundsException
   {
      playerOneCards = new ImageIcon[PLAYER_CARDS];

      rand = new Random();
      
      for(int index = 0; index < PLAYER_CARDS; index++)
      {
         number = rand.nextInt(DECK);
         playerOneCards[index] = cards[number];
         
      }
   }
   
   /**
      getCard method returns an ImageIcon from array list
   */
   public ImageIcon getCard() throws ArrayIndexOutOfBoundsException
   {
      rand = new Random();
      playingCard = rand.nextInt(DECK);
      return cards[playingCard];
   }
   
   /**
      getNumCard method accepts an imageicon as a arguement
      then searches through the array and assigns the card a 
      value to return back 
      
      @param card: image of the card
   */
   public int getNumCard(ImageIcon card)
   {
      if(card.equals(cards[0]) || card.equals(cards[1]) || card.equals(cards[2]) || card.equals(cards[3]))
         playerCard = 2;
         
      else if(card.equals(cards[4]) || card.equals(cards[5]) || card.equals(cards[6]) || card.equals(cards[7]))
         playerCard = 3;
        
      else if(card.equals(cards[8]) || card.equals(cards[9]) || card.equals(cards[10]) || card.equals(cards[11]))
         playerCard = 4;
         
      else if(card.equals(cards[12]) || card.equals(cards[13]) || card.equals(cards[14]) || card.equals(cards[15]))
         playerCard = 5;
         
      else if(card.equals(cards[16]) || card.equals(cards[17]) || card.equals(cards[18]) || card.equals(cards[19]))
         playerCard = 6;
      
      else if(card.equals(cards[20]) || card.equals(cards[21]) || card.equals(cards[22]) || card.equals(cards[23]))
         playerCard = 7;
         
      else if(card.equals(cards[24]) || card.equals(cards[25]) || card.equals(cards[26]) || card.equals(cards[27]))
         playerCard = 8;
         
      else if(card.equals(cards[28]) || card.equals(cards[29]) || card.equals(cards[30]) || card.equals(cards[31]))
         playerCard = 9;
         
      else if(card.equals(cards[32]) || card.equals(cards[33]) || card.equals(cards[34]) || card.equals(cards[35]))
         playerCard = 10;
         
      else if(card.equals(cards[36]) || card.equals(cards[37]) || card.equals(cards[38]) || card.equals(cards[39]))
         playerCard = 11;
      
      else if(card.equals(cards[40]) || card.equals(cards[41]) || card.equals(cards[42]) || card.equals(cards[43]))
         playerCard = 12;      
         
      else if(card.equals(cards[44]) || card.equals(cards[45]) || card.equals(cards[46]) || card.equals(cards[47]))
         playerCard = 13;
         
      else if(card.equals(cards[48]) || card.equals(cards[49]) || card.equals(cards[50]) || card.equals(cards[51]))
         playerCard = 14;
      
      return playerCard;
   }
   
   /**
      NumberofCards method returns the amount of 
      cards each player should have 
   */
   public int NumberOfCards()
   {
      return PLAYER_CARDS;
   } 
}