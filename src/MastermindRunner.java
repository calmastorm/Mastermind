
public class MastermindRunner {
    public static void main(String[] args){
        System.out.printf(Toolkit.LAUNCH_MESSAGE);
        System.out.println("Please enter the number option");
        MastermindController mm = new MastermindController();
        mm.Run();
        System.out.print("Goodbye");
    }
}