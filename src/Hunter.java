import java.util.Scanner;
public class Hunter {
    private static final Scanner SCANNER = new Scanner(System.in);
    public Hunter(){}
    public void start(){
        intro();
        if (turnback()) {
            menu();
        }
    }
    private void intro(){
        System.out.println("So, you're going to fight a dragon.");
        System.out.println(Colors.RED + "You must have a death wish.");
        Player p1 = new Player();
    }
    private boolean turnback(){
            System.out.println("____________________________________");
            System.out.println("(G)et going on your suicidal quest." + Colors.RESET);
            System.out.println(Colors.CYAN + "(T)urn back and reconsider your life options." + Colors.RESET);
            System.out.print("Choose: ");
            String choice = SCANNER.nextLine().toLowerCase();
            if (choice.length()!=0){
                choice = choice.substring(0, 1);
            }
            if (choice.equals("t")){
                System.out.println("Good on ye.");
                return false;
            } else if (choice.equals("g")){
                System.out.println("No. Why? WHY? Why won't you listen to-" + Colors.GREEN);
                System.out.println("In the distance, you spot a cavern. It's derelict, looks abandoned,");
                System.out.println("and is in no state to house a dragon.");
                System.out.println("In the spirit of adventure, you boldly enter,");
                System.out.print("hoping to find some goodies.");
                System.out.println("The cavern rumbles...");
                return true;
            } else {
                System.out.println("You're speaking nonsense. You're in no state to do this.");
                System.out.println(".......\n...I'm sending you home.");
                return false;
            }
    }

    private void menu(){
        Room.spawn();
    }
}
