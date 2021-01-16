import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    private char position[] = new char[10];
    private char player;
    private char bot;

    public static void main(String[] args) {

    	TicTacToe TicTacToe = new TicTacToe();

        TicTacToe.boardInitialization();
        TicTacToe.play();
        TicTacToe.boardDisplay();

    }

    public void boardInitialization() {

        char positionInit[] = {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
        int i;

        for (i = 1; i < 10; i++) {

            position[i] = positionInit[i];

        }
    }

    public String boardDisplay() {

        System.out.println("\n\n\t\t" + position[1] + "   | " + position[2] + "  | " + position[3]);
        System.out.println(" \t\t    |    |   ");
        System.out.println(" \t\t ___|____|___ ");
        System.out.println("\t\t" + position[4] + "   | " + position[5] + "  | " + position[6]);
        System.out.println(" \t\t    |    |   ");
        System.out.println(" \t\t ___|____|___ ");
        System.out.println("\t\t" + position[7] + "   | " + position[8] + "  | " + position[9]);

        return "boardDisplay";
    }
    public  char getPlayer()
    {
        return player;
    }

    public void playerTurn() {

        if (player == 'x') {

            bot = 'o';

        } else if (player == 'o') {

            bot = 'x';
        }

    }
    
    public void play() {

        Random r = new Random();
        int spot;
        char blank = ' ';
        int spotTwo;
        int i = 0;
        int moves = 0;

        System.out.println("");
        System.out.println("Would you like to be x or o?");
        Scanner in = new Scanner(System.in);
        char player = in.next().charAt(0);

        if (player == 'x') {

            System.out.println("The bot will be o");
            bot = 'o';

        } else if (player == 'o') {

            System.out.println("The bot will be x");
            bot = 'x';
        }

        System.out.println("First player will go with the letter " + player);

        do {

            boardDisplay();

            System.out.println("\n\n Player " + player + " pick a position.");

            boolean positionTaken = true;
            while (positionTaken) {

                for (i = 0; i < 1; ++i ){
                    spot = in.nextInt();

                    positionTaken = checkPosition(spot);

                    if (positionTaken == false) {

                        position[spot] = player;

                        ++moves;

                    } else { --i;

                    }

                }if (moves < 9) {
                    for (i = 0; i < 1; ++i ) {

                        spotTwo = r.nextInt(9) + 1;

                        positionTaken = checkPositionBot(spotTwo);

                        if (positionTaken == false) {

                            position[spotTwo] = bot;

                            ++moves;


                        } else { --i;

                        }
                    }
                }
            }

            System.out.println("Nice move.");
            // playerTurn();
        } while (checkWinner() == blank );

    }

    public  boolean checkPosition(int spot) {

        if (position[spot] == 'x' || position[spot] == 'o')
        {
            System.out.println("That position is already taken, please choose another");
            return true;
        }
        else {
            return false;
        }

    }

    public  boolean checkPositionBot(int spot) {

        if (position[spot] == 'x' || position[spot] == 'o')
        {
            return true;
        }
        else {
            return false;
        }
    }

    public  char checkWinner() {
        char Winner = ' ';

        // Check if x wins
        if (position[1] == 'x' && position[2] == 'x' && position[3] == 'x') Winner = 'x';
        if (position[4] == 'x' && position[5] == 'x' && position[6] == 'x') Winner = 'x';
        if (position[7] == 'x' && position[8] == 'x' && position[9] == 'x') Winner = 'x';
        if (position[1] == 'x' && position[4] == 'x' && position[7] == 'x') Winner = 'x';
        if (position[2] == 'x' && position[5] == 'x' && position[8] == 'x') Winner = 'x';
        if (position[3] == 'x' && position[6] == 'x' && position[9] == 'x') Winner = 'x';
        if (position[1] == 'x' && position[5] == 'x' && position[9] == 'x') Winner = 'x';
        if (position[3] == 'x' && position[5] == 'x' && position[7] == 'x') Winner = 'x';
        if (Winner == 'x' ) {

            if(player == 'x' ){
                System.out.println(player + " wins the game.");

            } else

                bot  = 'x';

            System.out.println(bot + " wins the game.");
            return Winner;
        }

        // Check if o wins
        if (position[1] == 'o' && position[2] == 'o' && position[3] == 'o') Winner = 'o';
        if (position[4] == 'o' && position[5] == 'o' && position[6] == 'o') Winner = 'o';
        if (position[7] == 'o' && position[8] == 'o' && position[9] == 'o') Winner = 'o';
        if (position[1] == 'o' && position[4] == 'o' && position[7] == 'o') Winner = 'o';
        if (position[2] == 'o' && position[5] == 'o' && position[8] == 'o') Winner = 'o';
        if (position[3] == 'o' && position[6] == 'o' && position[9] == 'o') Winner = 'o';
        if (position[1] == 'o' && position[5] == 'o' && position[9] == 'o') Winner = 'o';
        if (position[3] == 'o' && position[5] == 'o' && position[7] == 'o') Winner = 'o';
        if (Winner == 'o' )
        {
            if(player == 'o' ) {
                System.out.println(player + " wins the game.");

            } else

                bot = 'o';

            System.out.println(bot + " wins the game.");

            return Winner; }

        // check for Tie
        for(int i = 1;i < 10; i++)
        {
            if(position[i]=='x' || position[i]=='o')
            {
                if(i==9)
                {
                    char Draw='D';
                    System.out.println(" Game is stalemate ");
                    return Draw;
                }
                continue;
            }
            else
                break;

        }
        return Winner;
    }

}
