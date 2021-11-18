import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class MastermindController {
    private final String OPTION_EXIT = "0";
    private final String OPTION_PLAY = "1";
    private final String OPTION_RULE = "2";

    private final String MENU_TEMPLATE = " 0. Exit\n 1. Play\n 2. Rule\n";
    private final String ERROR_MESSAGE = "*You entered an invalid option*%n";

    // NumbersGenerator [DONE]
    public String NumbersGenerator() {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        while (sb.length() < 4) {
            //boolean same_num_found = false;
            String temp_num = String.valueOf(rd.nextInt(10));
            if(sb.indexOf(temp_num) == -1){
                sb.append(temp_num);
            }
        }
        return sb.toString();
    }

    public void PrintGrid(ArrayList attempt_list, ArrayList checker_list){
        System.out.printf("---+------+-------%n");
        for(int counter = 0; counter < attempt_list.size(); counter++){
            System.out.printf("%2d | %s | %s%n", counter+1, attempt_list.get(counter), checker_list.get(counter));
        }
    }

    //Play
    public void Play(){
        String Answer = NumbersGenerator();
        String Attempt;
        boolean GetCorrectAnswer = false;
        ArrayList<String> AttemptList = new ArrayList<>(); //keep all the attempts
        ArrayList<String> CheckerList = new ArrayList<>(); //keep all the checkers
        while(!GetCorrectAnswer){
            //System.out.printf("Test Game has started: %s%n", Answer);
            String checker;
            Attempt = Toolkit.GetPlayerInput(Toolkit.GetInput("Please Enter 4 digits\n"));
            boolean attempted_answer = false;
            for(int Attempt_counter = 0; Attempt_counter < AttemptList.size(); Attempt_counter++){
                if(AttemptList.get(Attempt_counter) == Attempt){
                    System.out.printf("%s has been attempted%n", Attempt);
                    attempted_answer = true;
                    break;
                }
            }
            if(!attempted_answer) {
                AttemptList.add(Attempt); //Add the newest attempt into the list
                int correct_a = 0;
                int correct_b = 0;
                for(int index = 0; index < Attempt.length(); index++){
                    if(Answer.indexOf(Attempt.charAt(index)) != -1){
                        if(Attempt.charAt(index) == Answer.charAt(index)){
                            correct_a++;
                        }else{
                            correct_b++;
                        }
                    }
                }
                checker = String.valueOf(correct_a) + "A " + String.valueOf(correct_b) + "B";
                CheckerList.add(checker);
            }
            GetCorrectAnswer = Objects.equals(Attempt, Answer);
            PrintGrid(AttemptList, CheckerList); //PrintGrid() insert code here
        }
        System.out.printf("Congratulation!%n");
    }

    // Run [DONE]
    public void Run(){
        boolean running = true;
        while(running){
            switch(Toolkit.GetInput(MENU_TEMPLATE)){
                case OPTION_EXIT:
                    running = false;
                    break;
                case OPTION_PLAY:
                    Play();
                    break;
                case OPTION_RULE:
                    System.out.printf(Toolkit.GAME_RULE);
                    break;
                default:
                    System.out.printf(ERROR_MESSAGE);
            }
        }
    }
}
