import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class DessertIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] itemList = {"Girlfriend", "Boyfriend", "Gameboy", "Makeup", "Boat", "Firestarter", "Water-filter", "Chair", "Bed", "Boots"};
        int[] itemListNumberOfPicks = new int[10];
        int amountOfAnswers = 0;
        System.out.println("Welcome to the dessert island simulator!!\nPlease write the amount of people you will be testing today. (I recommend 10 - 25 persons). ");

        //While loop der kun acceptere tal mellem 10-25 (Andre ting end integer vil dog crasher programmet).
        while (true) {
            try {
                amountOfAnswers = scanner.nextInt();
                if (amountOfAnswers >= 10 && amountOfAnswers <= 25) {
                    break;
                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception e) {
                scanner.nextLine();
                    System.out.println("I said i recommended a number between 10-25!");
            }
        }

        //Metode som opremser alle valgmulighederne
        System.out.println("The choices you can pick from are these:");
        callOptions(itemList);

        System.out.println("Now lets start the simulating");

        //Metode som scanner svar og tæller op i integer array.
        pickingItems(itemList, itemListNumberOfPicks, amountOfAnswers, scanner);

        //Viser resultatet
        System.out.println("The result of this simulator is: ");
        for (int x = 0; x < itemListNumberOfPicks.length; x++){
            String result = itemListNumberOfPicks[x] + " picks for " + itemList[x];
            System.out.println(result);
        }

        //Finder den værdi der har flest stemmer.
        int maxVærdi = itemListNumberOfPicks[0];
        for(int x = 0; x < itemList.length; x++){
            if (maxVærdi < itemListNumberOfPicks[x]){
                maxVærdi = itemListNumberOfPicks[x];
            }
        }

        //Udskriver de ting der har så mange stemmer som jeg fandt ovenfor (Altså hvis flere værdier har flest stemmer printer den alle med det antal stemmer).
        System.out.println("The most voted item(s) on the list was:");
        for(int x = 0; x < itemList.length; x++){
            if (maxVærdi == itemListNumberOfPicks[x]){
                System.out.println(itemList[x]);
            }
        }
    }

    //Metode som opremser alle valgmuligheder
    public static void callOptions (String[] itemList){
        for (int x = 0; x < itemList.length; x++){
            System.out.println((x + 1) + ". " + itemList[x]);
        }
    }

    //Metode som indtager input fra user og tildeler "point" til den respektive værdi som er blevet valgt.
    public static void pickingItems(String[] itemList, int[] itemListNumberOfPicks, int amountOfAnswers, Scanner scanner){
        int choice = 0;
        for (int x = 0; x < amountOfAnswers; x++){

            while (true) {
                try {
                    System.out.println("Person " + (x + 1) + " write what number item you want");
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 10){
                        throw new Exception();
                    }
                    itemListNumberOfPicks[choice - 1]++;
                    System.out.println("You choose: " + itemList[choice - 1] + "\n");
                    break;
                }
                catch (Exception e){
                    scanner.nextLine();
                    System.out.println("Please only write a number from the list");
                }

            }
        }
    }
}
