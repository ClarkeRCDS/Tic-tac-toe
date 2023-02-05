import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //variable holds the current game progress
        int gameTime = 0;
        //holds which players turn it is
        int player;
        //new scanner
        Scanner inp = new Scanner(System.in);
        //new tic-tac-toe game object
        Game g = new Game();
        //runs the game until it is won or fills all nine spaces
        while(!(g.isWinner(1)) && !(g.isWinner(2)) && gameTime < 9){
            //changes the player turn
            if (g.getTurn()){
                player = 1;
            } else {
                player = 2;
            }
            //prints the initial grid and instructions to input
            g.print();
            gameTime++;
            System.out.println("Player " + player + " input: Write the coordinates for the space you want to play.");
            System.out.println("(1,1) and (3,3) represent the top left and bottom right of the board respectively");
            System.out.print("Ex: use one comma to separate the values like (x,y): ");
            String pos = inp.nextLine();
            //checks for valid input and asks again until it is valid
            if (g.isNum(pos)){
                g.play(pos);
            } else {
                while(!(g.isNum(pos))) {
                    g.print();
                    System.out.println();
                    System.out.println("Invalid input: make sure you use whole numbers between 1 and 3,");
                    System.out.print("use only one comma, and are not in another players space.");
                    pos = inp.nextLine();
                    if (g.isNum(pos)){
                        g.play(pos);
                        break;
                    }
                }
            }
        }
        //checks who wins and then prints the final score
        g.print();
        if (g.isWinner(1)){
            System.out.print("X wins!");
        } else if (g.isWinner(2)){
            System.out.print("O wins!");
        } else {
            System.out.print("Draw");
        }
        inp.close();
    }
}