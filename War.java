//Chaquille Browne
//CS110
//11/20/14
//Simulating the Game War


import javax.swing.*;           //For swing Classes
import java.awt.event.*;        // For Action Event
import java.awt.*;              //For Layout
import javax.swing.JOptionPane; //To display War message


/**
   This class simulates the Card Game War between
   two players
*/

public class War extends JFrame
{
   private JButton flip;            //To refrence a flip button
   private JButton war;             //To refrence a war button
   private ImageIcon back;          //To refrence image of back of card
   private ImageIcon frontOne;      //To refrence image of player one card
   private ImageIcon frontTwo;       //To refrence image of player two card
   private JLabel playerOne;        //player one's cards
   private JLabel playerTwo;        //Player two's cards
   private JLabel welcome;          //To welcome players to the game
   private Deck firstPlayer;        //Player one deck class
   private Deck secondPlayer;       //Player two deck class
   private int playerOneNumCards;   //Number of player one's cards
   private int playerTwoNumCards;   //Number of player two'a cards
   private int firstP;              //Card Number for first player 
   private int secondP;             //Card Number for second player
   private final int WIDTH = 770;   //How wide window will be 
   private final int HEIGHT = 600;  //How high window will be 
   
   
   /** 
      Construtor
   */
   
   public War()
   {
      setSize(WIDTH, HEIGHT);//Setting Size of window
      setTitle("I Declare War!");//Naming title of window
      
      setLayout(new BorderLayout());//Adding a BorderLayout manager to content pane

      //Creating panel for welcome message
      JPanel Welcome = new JPanel();
      welcome = new JLabel("Welcome to I Declare War!!!");
      welcome.setFont(new Font("HELVETICA",Font.ITALIC,36));
      Welcome.add(welcome);
      
      //Creating two instances of Deck class for both playes   
      firstPlayer = new Deck();
      secondPlayer = new Deck();
      
      //Getting numner of cards for each player
      playerOneNumCards = firstPlayer.NumberOfCards();
      playerTwoNumCards = secondPlayer.NumberOfCards();

      //Creating panel for Flip and war button
      JPanel flipButton = new JPanel();
      flip = new JButton("Flip");
      flip.addActionListener(new ButtonListener()); //Registering an event listener for flip button
      war = new JButton("War!");
      flipButton.add(war);
      flipButton.add(flip);
      
      //Adding welcome message and flipbutton to the content pane
      add(Welcome, BorderLayout.NORTH);
      add(flipButton, BorderLayout.SOUTH);
      
      //Creating images for both playes card(back only)
      back = new ImageIcon("back.jpg"); 
      playerOne = new JLabel(back);
      playerTwo = new JLabel(back);

      //Adding card images to the content pane
      add(playerOne, BorderLayout.WEST);
      add(playerTwo, BorderLayout.EAST);
      
      //Packing window
      pack();
      
      //Specifying what happens when the close button is closed
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setVisible(true); //Display Window
   }
   
   /**
      ButtonListener class inherits Deck class to simulate Game
   */
   private class ButtonListener extends Deck implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {    
         //Getting two different cards from Deck class   
         frontOne = firstPlayer.getCard();
         frontTwo = secondPlayer.getCard();
         
         if (playerOne.getIcon() == back && playerTwo.getIcon() == back)
         {  
            //Flipping the cards showing card image
            playerOne.setIcon(frontOne);
            playerTwo.setIcon(frontTwo);
            
            //Getting card values
            firstP = firstPlayer.getNumCard(frontOne);
            secondP = secondPlayer.getNumCard(frontTwo);
            
            //Taking one card away from each players deck
            playerOneNumCards --;
            playerTwoNumCards --;

            if (firstP == secondP) 
            {
               //Diplaying message for when war happens
               JOptionPane.showMessageDialog(null, "Time For WAR!!");
               
               //Taking two cards from each player
               playerOneNumCards -=2;
               playerTwoNumCards -=2;
               
               //Registering the war button
               war.addActionListener(new ButtonListener());    
            }
            
            //Giving two cards to player one if victor                    
            else if (firstP >= secondP)
            {
               playerOneNumCards += 2;
            }
            
            //Giving two cards to player 2 if player one isnt victor
            else
            {
               playerTwoNumCards += 2;
            }
         }
         
         //Placing back image again for next round
         else
         {
            playerOne.setIcon(back);
            playerTwo.setIcon(back);
         }
         
         //Counting the number of cards as game plays
         JPanel amount = new JPanel();
         JLabel amountOne = new JLabel("Player 1 Cards: " + playerOneNumCards);
         JLabel amountTwo = new JLabel("Player 2 Cards: " + playerTwoNumCards);
         amount.add(amountOne);
         amount.add(amountTwo);
         add(amount, BorderLayout.CENTER);

         
      }
   /**
      WarButtonListener method will make the war bunton function and declare who wins the 
      amount of cards
   */
   private class WarButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(firstP >= secondP)
         {
            JOptionPane.showMessageDialog(null, "Player 1 wins the War!!");
            playerOneNumCards +=4;
         }
               
         else
         {
            JOptionPane.showMessageDialog(null, "Player 2 wins the War!!");
            playerTwoNumCards +=4;
         }
      }
   }

   }

   
   
   public static void main(String[] args) throws ArrayIndexOutOfBoundsException
   {
      new War();
   }
}