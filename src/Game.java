public class Game {
    //tic-tac-toe array that holds number equivalents of X,O, and blank
    private int[][] arr = new int [3][3];
    //changes the players turn
    private boolean turn = true;
    //default constructor
    public Game() {
        //fills array
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[r].length; c++)
            {
                arr[r][c] = 0;
            }
        }
    }
//prints out the grid by converting the number array into a char array and printing it in a grid
    public void print(){
        char[][] board = new char [3][3];
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == 0) {
                    board[r][c] =' ';
                }else if (arr[r][c] == 1) {
                    board[r][c] = 'X';
                }else if (arr[r][c] == 2) {
                    board[r][c] = 'O';
                }
            }
        }
        System.out.println();
        for (int r = 0; r < board.length; r++)
        {
            if (r < board.length-1) {
                //underlines the line
                System.out.print("\033[4m");
            }
            for (int c = 0; c < board[r].length; c++)
            {
                if (c < board[r].length-1) {
                    System.out.print(board[r][c] + "|");
                } else {
                    System.out.print(board[r][c]);
                }
            }
            System.out.println();
            //removes underline
            System.out.print("\033[0m");
        }
    }
//checks if an input is a valid input. this checks if the space
//has already been filled, and if it has numbers that work with the grid
    public boolean isNum(String inp){
        if (inp.length() != 3){
            return false;
        }
        if (inp.charAt(1) != ','){
             return false;
        }
        if (inp.charAt(0) >= '1' && inp.charAt(0) <= '3' && inp.charAt(2) >= '1' && inp.charAt(2) <= '3'){
            int x = Integer.parseInt(inp.substring(0,1));
            int y = Integer.parseInt(inp.substring(2));
            if(arr[y-1][x-1] == 0)
            {
                return true;
            }
        }

        return false;
    }
    //changes an array value after checking the number input and changes the players turn
    public void play(String inp){
        int x = Integer.parseInt(inp.substring(0,1));
        int y = Integer.parseInt(inp.substring(2));

        if (turn){
            arr[y-1][x-1] = 1;
        } else {
            arr[y-1][x-1] = 2;
        }
        turn = !turn;
    }
//returns which player is next
    public boolean getTurn(){
        return turn;
    }
//checks if the X or O player has won by checking all the winning configurations
    public boolean isWinner(int player) {
        for (int r = 0; r <= 2; r++) {
            if (arr[r][0] == player && arr[r][1] == player && arr[r][2] == player) {
                return true;
            }
        }
        for (int c = 0; c <= 2; c++){
            if (arr[0][c] == player && arr[1][c] == player && arr[2][c] == player) {
                return true;
            }
        }
        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
            return true;
        }
        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
            return true;
        }
        return false;
    }
}
