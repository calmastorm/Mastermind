import java.util.Scanner;
public class Toolkit {
    //LAUNCH MESSAGE
    public static String LAUNCH_MESSAGE = "========= Mastermind ========%n" +
            " Version v1.1  By calmastorm %n" +
            "=============================%n";
    public static String GAME_RULE = "========= Game Rules =========%n" +
            "You need to enter [4 digits]%n" +
            "each round and you will be told%n" +
            "A- Numbers of correct position%n" +
            "B- Numbers of correct digits%n" +
            "You win when you have 4A 0B.%n" +
            "==============================%n";

    // Use Scanner to receive an input and then return a string
    public static String GetInput(String instruction){
        System.out.printf(instruction);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    // Get a string and trim down everything unnecessary, return a playerInput -> "####"
    public static String GetPlayerInput(String input_string){
        if (input_string.equals("quit")) {
            return "quit";
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index < input_string.length(); index++){
            if(Character.isDigit(input_string.charAt(index))){ //Check if the character is digit
                sb.append(input_string.charAt(index));
            }else{
                continue;
            }
        }
        if(sb.length() == 4){
            return sb.toString();
        }else{
            System.out.printf("*You entered %d numbers instead of 4*%n", sb.length());
            return null;
        }
    }
}