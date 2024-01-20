/*
 * Muhammad Qazi
 * Java 605.201.81 Fall
 * Module 9 - Project Two
*/

import java.util.Scanner;

/**
 * This class determines the value of the first two cards.
 * @author Muhammad Qazi.
 * @param This class features multiple variables of the ceiling of random numbers and the end result.
 * @return The class returns the combined-value of the first two cards.
*/
class Player2 extends BlackjackGameSimulator // This class pulls in the data for the first set of cards for both the player and the dealer.
{
    public static int getPlayerValue() // The method connects to an object and sends data of the randomly generated values of the first two cards.
    {
        int x = 0;
        int randomNumber1 = 13;
        int N = 0;
        {
            N = (int) ( randomNumber1 * Math.random() ) + 1;
            if (N == 1)
            {
                x = x + 11;
            }
            if (N == 2)
            {
                x = x + 2;
            }
            if (N == 3)
            {
                x = x + 3;
            }
            if (N == 4)
            {
                x = x + 4;
            }
            if (N == 5)
            {
                x = x + 5;
            }
            if (N == 6)
            {
                x = x + 6;
            }
            if (N == 7)
            {
                x = x + 7;
            }
            if (N == 8)
            {
                x = x + 8;
            }
            if (N == 9)
            {
                x = x + 9;
            }
            if (N == 10)
            {
                x = x + 10;
            }
            if (N == 11)
            {
                x = x + 10;
            }
            if (N == 12)
            {
                x = x + 10;
            }
            if (N == 13)
            {
                x = x + 10;
            }
            N = (int) ( randomNumber1 * Math.random() ) + 1;
            if (N == 1)
            {
                x = x + 11;
            }
            if (N == 2)
            {
                x = x + 2;
            }
            if (N == 3)
            {
                x = x + 3;
            }
            if (N == 4)
            {
                x = x + 4;
            }
            if (N == 5)
            {
                x = x + 5;
            }
            if (N == 6)
            {
                x = x + 6;
            }
            if (N == 7)
            {
                x = x + 7;
            }
            if (N == 8)
            {
                x = x + 8;
            }
            if (N == 9)
            {
                x = x + 9;
            }
            if (N == 10)
            {
                x = x + 10;
            }
            if (N == 11)
            {
                x = x + 10;
            }
            if (N == 12)
            {
                x = x + 10;
            }
            if (N == 13)
            {
                x = x + 10;
            }
        }
        return x;
    }
}
/**
 * This class determines the value of a single card.
 * @author Muhammad Qazi.
 * @param This class features multiple variables of the ceiling of random numbers and the end result.
 * @return The class returns the single-card value to the main class.
*/
class Player3 extends BlackjackGameSimulator // This class, similar to Player2, sends out data for the randomly generated value of one card, adding that value to the total value of x or x2 that already existed.
{
    public static int getPlayerValue2() // This method connects to an object that sends out the new value of the single card, adding it into the values of x and x2 that already existed.
    {
        int x = 0;
        int randomNumber1 = 13;
        int N = 0;
        {
            N = (int) ( randomNumber1 * Math.random() ) + 1;
            if (N == 1)
            {
                x = x + 11;
            }
            if (N == 2)
            {
                x = x + 2;
            }
            if (N == 3)
            {
                x = x + 3;
            }
            if (N == 4)
            {
                x = x + 4;
            }
            if (N == 5)
            {
                x = x + 5;
            }
            if (N == 6)
            {
                x = x + 6;
            }
            if (N == 7)
            {
                x = x + 7;
            }
            if (N == 8)
            {
                x = x + 8;
            }
            if (N == 9)
            {
                x = x + 9;
            }
            if (N == 10)
            {
                x = x + 10;
            }
            if (N == 11)
            {
                x = x + 10;
            }
            if (N == 12)
            {
                x = x + 10;
            }
            if (N == 13)
            {
                x = x + 10;
            }
        }
        return x;
    }
}
/**
 * This class builds the majority of the code.
 * @author Muhammad Qazi.
 * @param This class features multiple variables.
 * @return The class leads to the actual game.
*/
public class BlackjackGameSimulator
{
    public static void main( String [] args )
    {
        boolean playGame = true; // This sets the boolean to continue the game forever, unless the player opts to quit or runs out of money.
        int x = 0; // This sets the variable for the total value of the player cards.
        int x2 = 0; // This sets the total value of the dealer cards.
        int y = 0; // This sets the variable for the amount of money allocated to the player.
        y = 100;
        int z = 0; // This sets the variable that determines the amount of money that the player bets.
        z = 100;
        int a2 = 0; // This variable determines if the player wishes to continue playing or end the game.
        
        System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of 100 dollars." ) ;
        Scanner input = new Scanner( System.in );
        z = input.nextInt(); // The player can submit the amount of money to initially bet, prior to the start of the game.
        
        int randomNumber1 = 13;
        int N = 0;
        Player2 object1 = new Player2(); // The object here relates to the first class, to build the total-value of the first two cards, in the Player2 class.
        x = object1.getPlayerValue(); // This method allows for the generation for the initial value of the first two cards, for both the player and the dealer.
        Player3 object2 = new Player3(); // This object here, similar to the first one, builds the value of a single card, in the Player3 class.
        x2 = object1.getPlayerValue(); // This method allows for the system to add the value of a single card for the player or the dealer.
        int xx = 0; // The variable for this adds the value from the second object.
        int z2 = 0; // The "if" statement with this variable determines the player in the "do" statement that plays, prior to the turn changing.
        do
        {
            if (z2 == 0)
            {
            if (x == 21) // The player automatically wins if the first two cards equate to 21.
            {
                y = y + z;
                System.out.println( "The player wins the game with a combined total value of 21. Congratulations. To play again, enter in 1. To stop, enter in 2." ) ;
                a2 = input.nextInt();
                if (a2 != 1)
                {
                    playGame = false;
                }
                else
                {
                    x = object1.getPlayerValue();
                    System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of " + y + " dollars." ) ;
                    z = input.nextInt();
                }
            }
            else
            {
                if (x > 21) // The player automatically loses if the combined-value of the cards equates to a value higher than 21, if the player draws another card.
                {
                    y = y - z;
                    if (y == 0)
                    {
                        System.out.println( "The player ran out of money and lost with a combined card value of " + x + "." ) ;
                        playGame = false;
                    }
                    else
                    {
                    System.out.println( "The player obtains another card and loses the game with a total combined value of the cards of " + x + ". To play again, enter in 1. To stop, enter in 2." ) ;
                    a2 = input.nextInt();
                    if (a2 != 1)
                    {
                        playGame = false;
                    }
                    else
                    {
                        x = object1.getPlayerValue();
                        System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of " + y + " dollars." ) ;
                        z = input.nextInt();
                    }
                    }
                }
                else
                {
                    System.out.println( "The current combined player value of the cards exists as " + x + ". To continue playing with another card, input 1. To stop playing and stay, input 2." ) ;
                    int a = 0;
                    a = input.nextInt();
                    if (a == 1) // Assuming that the player wishes to draw another card, this then pulls in the value of a single card from the second object, adding it to the combined value of the cards.
                    {
                        xx = object2.getPlayerValue2();
                        x = x + xx;
                    }
                    else // The player can choose to "stay," and pass on the match to the dealer.
                    {
                        z2 = 1;
                    }
                }
            }
            }
            if (z2 == 1)
            {
            {
                {
                    {
                        if (x2 == 21) // The dealer automatically wins if the first two cards equate to 21, assuming that the player never won or lost.
                        {
                            y = y - z;
                            if (y == 0)
                            {
                                System.out.println( "The player ran out of money and lost with a combined card value of " + x + "." ) ;
                                playGame = false;
                            }
                            else
                            {
                            System.out.println( "The dealer wins the game with a combined total value of 21. To play again, enter in 1. To stop, enter in 2." ) ;
                            a2 = input.nextInt();
                            if (a2 != 1)
                            {
                                playGame = false;
                            }
                            else
                            {
                                x = object1.getPlayerValue();
                                System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of " + y + " dollars." ) ;
                                z = input.nextInt();
                                z2 = 0;
                            }
                            }
                        }
                        else
                        {
                            if (x2 > 21) // The dealer loses the match if their combined-value of the cards equates to a value higher than 21, after drawing another card.
                            {
                                y = y + z;
                                System.out.println( "The dealer obtains another card and loses the game with a total combined value of " + x2 + ". To play again, enter in 1. To stop, enter in 2." ) ;
                                a2 = input.nextInt();
                                if (a2 != 1)
                                {
                                    playGame = false;
                                }
                                else
                                {
                                    x = object1.getPlayerValue();
                                    System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of " + y + " dollars." ) ;
                                    z = input.nextInt();
                                    z2 = 0;
                                }
                            }
                            else
                            {
                                if (x2 == 17 || x2 == 18 || x2 == 19 || x2 == 20) // This determines the outcome of the match if the dealer "stays" due to a value of 17 or higher, under 21.
                                {
                                    if (x2 > x) // The dealer wins.
                                    {
                                        y = y - z;
                                        if (y == 0)
                                        {
                                            System.out.println( "The player ran out of money and lost with a combined card value of " + x + "." ) ;
                                            playGame = false;
                                        }
                                        else
                                        {
                                        System.out.println( "The game ended and the dealer won. The player card-value exists as " + x + " and the dealer card-value exists as " + x2 + ". The higher value wins if it is not over 21. To play again, enter in 1. To stop, enter in 2." ) ;
                                        }
                                    }
                                    else
                                    {
                                        if (x2 < x) // The dealer loses.
                                        {
                                            y = y + z;
                                            System.out.println( "The game ended and the player won. The player card-value exists as " + x + " and the dealer card-value exists as " + x2 + ". The higher value wins if it is not over 21. To play again, enter in 1. To stop, enter in 2." ) ;
                                        }
                                        else // The match concludes in a tie.
                                        {
                                            y = y + 0;
                                            System.out.println( "The game ended in a tie. The player card-value exists as " + x + " and the dealer card-value exists as " + x2 + ". The higher value wins if it is not over 21. To play again, enter in 1. To stop, enter in 2." ) ;
                                        }
                                    }
                                    a2 = input.nextInt();
                                    if (a2 != 1)
                                    {
                                        playGame = false;
                                    }
                                    else
                                    {
                                        x = object1.getPlayerValue();
                                        System.out.println( "Hello. To start the game of blackjack, please enter in the amount of money to bet, allocated from a total pool of " + y + " dollars." ) ;
                                        z = input.nextInt();
                                        z2 = 0;
                                    }
                                }
                                else // The dealer draws another card, assuming that their total card-value exists under 17.
                                {
                                    System.out.println( "The combined value of the cards of the dealer equates to " + x2 + ". The dealer can only ever draw another card if the game never ended." ) ;
                                    xx = object2.getPlayerValue2();
                                    x2 = x2 + xx;
                                }
                            }
                        }
                    }
                }
            }
            }
        } while (playGame); // Assuming that the player never ran out of money or opted to end the game, the game continues.
    }
}