import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello and welcome to the amazing game of Rock, Paper, Scissors!!!!!");
        System.out.println("Would you like to play singleplayer or multiplayer? Please write your answer>>");
        boolean singlePlayer;

        //While løkke som spørger om man vil spille singleplayer eller multiplayer.
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

        System.out.println("alright lets play some multiplayer!!");
        System.out.println("Player 1, please write your name>>");
        String player1Name = namecheck(scanner);
        System.out.println("Player 2, the same for you good sir.");
        String player2Name = namecheck(scanner);
        System.out.println("Alright " + player1Name + " and " + player2Name + " lets play some RPS");
        System.out.println("The game is best of 3, so if you get 2 points you win.");

        int player1Score = 0;
        int player2score = 0;

        while (player1Score < 2 || player2score < 2){

            String move = makeMove(scanner);
            if (move.equals("player 1")){
                player1Score++;
            }
            else if (move.equals("player 2")){
                player2score++;
            }
        }
        String winnerIs = player1Score > player2score ? "Player 1 is the winner!" : "Player 2 is the winner!";
        System.out.println(winnerIs);







    }
    public static String makeMove(Scanner scanner){

        return "hej";
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
}
