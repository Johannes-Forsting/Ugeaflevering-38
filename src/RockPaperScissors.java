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
                System.out.println("So far the scoreline is: \nPLayer 1: " + player1Score + "\nPlayer 2: " + player2score);

            }
        }
        else {
            System.out.println("Alright " + player1Name + " you gonna play against the computer.\nBest of how many rounds? (Choose odd number)");
            int bestOfX = roundsCheck(scanner);
            int pointsToVictory = (bestOfX/2 + 1);

            System.out.println("We gonna play " + bestOfX + " rounds.\nWhat do you choose?");
            while (player1Score < pointsToVictory && player2score < pointsToVictory) {

            }

        }





        String winnerIs = player1Score > player2score ? "Player 1 is the winner!" : "Player 2 is the winner!";
        System.out.println(winnerIs);







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
