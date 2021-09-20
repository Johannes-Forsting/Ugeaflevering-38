import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to the amazing game of Rock, Paper, Scissors!!!!!");
        boolean singlePlayer;
        int player1Score = 0;
        int player2score = 0;

        //While løkke som spørger om man vil spille singleplayer eller multiplayer.
        System.out.println("Would you like to play singleplayer or multiplayer? Please write your answer>>");
        while (true){
            String singleOrMulti = scanner.nextLine();
            singleOrMulti = singleOrMulti.toLowerCase();
            if(singleOrMulti.equals("single") || singleOrMulti.equals("singleplayer")){
                singlePlayer = true;
                break;
            }
            else if (singleOrMulti.equals("multi") || singleOrMulti.equals("multiplayer")){
                singlePlayer = false;
                break;
            }
            else{
                System.out.println("I dont understand that. Please write \"singleplayer\" or \"multiplayer\"");
            }
        }
        String singleOrMulti = singlePlayer ? "alright lets play some singleplayer!!" : "alright lets play some multiplayer!!";
        System.out.println(singleOrMulti);
        System.out.println("Player 1, please write your name>>");
        String player1Name = namecheck(scanner);
        if (singlePlayer == false) {
            System.out.println("Player 2, the same for you good sir.");
            String player2Name = namecheck(scanner);
            System.out.println("Alright " + player1Name + " and " + player2Name + " lets play some RPS");
            System.out.println("The game is best of 3, so if you get 2 points you win.");

            while (player1Score < 2 && player2score < 2) {

                String multiplayerResult = makeMove(scanner);
                if (multiplayerResult.equals("player 1")) {
                    player1Score++;
                } else if (multiplayerResult.equals("player 2")) {
                    player2score++;
                }
                System.out.println("So far the scoreline is: \n" + player1Name + " " + player1Score + "\n" + player2Name + " " + player2score);

            }
        }
        else {
            System.out.println("Alright " + player1Name + " you gonna play against the computer.\nBest of how many rounds? (Choose odd number)");
            int bestOfX = roundsCheck(scanner);
            int pointsToVictory = (bestOfX/2 + 1);

            System.out.println("We gonna play best of " + bestOfX + " rounds. Lets begin!");
            while (player1Score < pointsToVictory && player2score < pointsToVictory) {
                String singleplayerMove = singleplayerMakeMove(scanner);
                String computerMove = computerMakeMove();
                String multiplayerResult = multiplayerresult(singleplayerMove, computerMove);
                if (multiplayerResult.equals("player 1")) {
                    player1Score++;
                } else if (multiplayerResult.equals("player 2")) {
                    player2score++;
                }
                System.out.println("So far the scoreline is:\n" + player1Name + player1Score + "\nComputer: " + player2score);


            }

        }





        String winnerIs = player1Score > player2score ? "Player 1 is the winner!" : "Player 2 is the winner!";
        System.out.println(winnerIs);







    }
    public static String multiplayerresult(String singleplayer, String multiplayer){
        String result;
        if (singleplayer.equals(multiplayer)){
            result = "Tie";
        }
        else if (singleplayer.equals("rock") && multiplayer.equals("scissor") || singleplayer.equals("paper") && multiplayer.equals("rock") ||singleplayer.equals("scissor") && multiplayer.equals("paper")){
            result = "player 1";
        }
        else{
            result = "player 2";
        }
        return result;
    }
    public static String singleplayerMakeMove(Scanner scanner){
        boolean isMoveValid = false;
        String player1Move = "";
        while (!isMoveValid) {
            System.out.println("Player 1 what do you choose?");
            player1Move = scanner.nextLine();
            player1Move = player1Move.toLowerCase();
            isMoveValid = moveCheck(player1Move);
        }
        return player1Move;
    }

    public static String computerMakeMove(){
        Random random = new Random();
        String computerMove = "";
        int randomRPS = random.nextInt(3);
        if (randomRPS == 0){
            computerMove = "rock";
        }
        else if (randomRPS == 1){
            computerMove = "scissor";
        }
        else {
            computerMove = "paper";
        }
        System.out.println("Computer chooses: " + computerMove);
        return computerMove;
    }


    public static String makeMove(Scanner scanner){
        boolean isMoveValid = false;
        String player1Move = "";
        String player2Move = "";
        String result;
        while (!isMoveValid) {
            System.out.println("Player 1 what do you choose?");
            player1Move = scanner.nextLine();
            player1Move = player1Move.toLowerCase();
            isMoveValid = moveCheck(player1Move);
        }
        isMoveValid = false;
        while (!isMoveValid) {
            System.out.println("Player 2 what do you choose?");
            player2Move = scanner.nextLine();
            player2Move = player2Move.toLowerCase();
            isMoveValid = moveCheck(player2Move);
        }

        if (player1Move.equals(player2Move)){
            result = "Tie";
        }
        else if (player1Move.equals("rock") && player2Move.equals("scissor") || player1Move.equals("paper") && player2Move.equals("rock") ||player1Move.equals("scissor") && player2Move.equals("paper")){
            result = "player 1";
        }
        else{
            result = "player 2";
        }
        return result;
    }

    public static boolean moveCheck (String move){
        boolean moveValid = move.equals("rock") ? true : move.equals("paper") ? true : move.equals("scissor") ? true : false;
        return moveValid;
    }


    public static String namecheck(Scanner scanner){
        boolean nameChecking = true;
        String name = "";
        while (nameChecking){
            nameChecking = false;
            name = scanner.nextLine();
            for (int x = 0; x < name.length(); x++){
                char y = name.charAt(x);
                if (!Character.isLetter(y) && !Character.isWhitespace(y)){
                    System.out.println("That is not a name. You cannot trick me mortal. Now write your real name!");
                    nameChecking = true;
                    break;
                }
            }
        }
        System.out.println("Wierd name but ok.");
        return name;
    }

    public static int roundsCheck(Scanner scanner){
        int rounds;
        while (true) {
            if (scanner.hasNextInt()) {
                rounds = scanner.nextInt();
                if (rounds % 2 == 1){
                    break;
                }
                else{
                    System.out.println("Only odd numbers please. Otherwise we can have a draw, and we dont want that.");
                }
            }
            else {
                System.out.println("That's not a number sir. Try again.");
                scanner.nextLine();
            }
        }
        return rounds;
    }
}
