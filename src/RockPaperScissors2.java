import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Initialisere et par variabler her så de er inden for scope senere i loops og if statements
        int player1Score = 0;
        int player2score = 0;
        String player1Name = "";
        String player2Name = "";
        String player1Move = "";
        String player2Move = "";

        //Metode der spørger om vi spiller single eller multiplayer
        System.out.println("Hello and welcome to the amazing game of Rock, Paper, Scissors!!!!!");
        boolean singlePlayer = singleOrMulti();

        //Metode der spørger bruger om navn. Hvis vi spiller multiplayer spørger den også bruger2 om navn. Ellers er bruger2's navn "Computer".
        System.out.println("Player 1. What is your name?");
        player1Name = namecheck();
        if (singlePlayer == false){
            System.out.println("Player 2. What is your name?");
            player2Name = namecheck();
        }
        else{
            player2Name = "Computer";
        }
        System.out.println("Alrighty then! Its " + player1Name + " versus " + player2Name);

        //Metode som spørger hvor mange runder vi skal spille. Tager kun imod ulige positive integers.
        System.out.println("What amount of rounds should we play best of?");
        int bestOf = getAmountOfRounds();
        int pointsToVictory = bestOf / 2 + 1;
        System.out.println("Alright so first to " + pointsToVictory + " wins. Good luck!");

        //Selve spillet starter her. Whileloop fortsætter indtil en af de 2 spillere har fået det førbestemte antal point.
        //Hvis multiplayer spørger den hver spiller hvad de vælger (Den kan ikke chrashe hvis de skriver andre ting end "rock", "paper" eller "scissor".
        //Hvis singleplayer spørger den bare player1 og giver computeren en tilfældig hånd.
        //efter hver iteration bliver scoren opdateret og vist på skærmen.
        while(player1Score < pointsToVictory && player2score < pointsToVictory){
            player1Move = playerMakeMove(player1Name);
            if(singlePlayer == true){
                player2Move = computerMakeMove();
            }
            else{
                player2Move = playerMakeMove(player2Name);
            }
            String result = getResult(player1Move, player2Move);

            switch (result){
                case "tie":
                    System.out.println("Its a tie. Nobody gets a point");
                    break;
                case "player 1":
                    System.out.println(player1Name + "'s " + player1Move + " wins over " + player2Name + "'s " +  player2Move);
                    player1Score++;
                    break;
                case "player 2":
                        System.out.println(player1Name + "'s " + player1Move + " looses to " + player2Name + "'s " +  player2Move);
                        player2score++;
                        break;
            }
            System.out.println("Score is now: \n" + player1Name + ": " + player1Score + "\n" + player2Name + ": " + player2score);

        }
        String winnerIs = player1Score > player2score ? player1Name + " is the winner!" : player2Name + " is the winner!";
        System.out.println(winnerIs);
    }

    public static boolean singleOrMulti(){
        Scanner scanner = new Scanner(System.in);
        boolean singlePlayer;
        System.out.println("Would you like to play singleplayer or multiplayer? Please write your answer>>");
        while (true){
            String singleOrMulti = scanner.nextLine();
            if(singleOrMulti.equalsIgnoreCase("single") || singleOrMulti.equalsIgnoreCase("singleplayer")){
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
        return singlePlayer;
    }

    public static String namecheck(){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (true){
            try {
                name = scanner.nextLine();
                for (int x = 0; x < name.length(); x++) {
                    char y = name.charAt(x);
                    if (!Character.isLetter(y)) {
                        throw new Exception();
                    }
                }
                break;
            }
            catch (Exception notAName){
                System.out.println("That is not a name. You cannot trick me mortal. Now write your real name!");
            }
        }
        System.out.println("Wierd name but ok.");
        return name;
    }

    public static boolean moveCheck (String move){
        move = move.toLowerCase();
        boolean moveValid = move.equals("rock") ? true : move.equals("paper") ? true : move.equals("scissor") ? true : false;
        return moveValid;
    }

    public static String getResult (String player1Move, String player2Move){
        if (player1Move.equals(player2Move)){
            return "tie";
        }
        else if (player1Move.equals("rock") && player2Move.equals("scissor")){
            return "player 1";
        }
        else if (player1Move.equals("paper") && player2Move.equals("rock")){
            return "player 1";
        }
        else if (player1Move.equals("scissor") && player2Move.equals("paper")){
            return "player 1";
        }
        else{
            return "player 2";
        }
    }

    public static String playerMakeMove(String name) {
        Scanner scanner = new Scanner(System.in);
        boolean isMoveValid = false;
        String playerMove = "";
        while (!isMoveValid) {
            System.out.println(name + " what do you choose?");
            playerMove = scanner.nextLine();
            isMoveValid = moveCheck(playerMove);
            if (isMoveValid == false){
                System.out.println("Try writing \"rock\", \"paper\" or \"scissor\"");
            }
        }
        return playerMove;
    }

    public static String computerMakeMove(){
        Random random = new Random();
        String computerMove = "";
        int randomRPS = random.nextInt(3);
        switch (randomRPS){
            case 0:
                computerMove = "rock";
                break;
            case 1:
                computerMove = "scissor";
                break;
            case 2:
                computerMove = "paper";
                break;
        }
        System.out.println("Computer chooses: " + computerMove);
        return computerMove;
    }

    public static int getAmountOfRounds(){
        Scanner scanner = new Scanner(System.in);
        int rounds;
        while (true){
            try{
                rounds = scanner.nextInt();
                if (rounds < 0 || (rounds % 2 == 0)){
                    throw new Exception();
                }
                else{
                    break;
                }
            }
            catch (Exception wrongInput){
                scanner.nextLine();
                System.out.println("Please only put in a odd number so we cannot have a draw");
            }
        }
        return rounds;
    }
}