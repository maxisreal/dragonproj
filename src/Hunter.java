import java.util.Scanner;
public class Hunter {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Sword sword = new Sword();
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
                System.out.print("In the spirit of adventure, you boldly enter, ");
                System.out.println("hoping to find some goodies.");
                System.out.println("The cavern rumbles...");
                return true;
            } else {
                System.out.println("You're speaking nonsense. You're in no state to do this.");
                System.out.println(".......\n...I'm sending you home.");
                return false;
            }
    }

    private void menu(){
        Player p1 = new Player();
        while (!p1.isDead) {
            Room.spawn();
            while (!Room.roomClear()) {
                System.out.println("____________________________________");
                System.out.println(Colors.RED + "(S)tab the dragons.");
                System.out.println(Colors.GREEN + "(L)ook around.");
                System.out.println(Colors.PURPLE + "(C)heck out the dragons.");
                System.out.print(Colors.RESET + "Choose: ");
                String choice = SCANNER.nextLine().toLowerCase();
                if (choice.length() != 0) {
                    choice = choice.substring(0, 1);
                }
                if (choice.equals("S")) {
                    System.out.print("Which dragon? ");
                    if (Room.attack(SCANNER.nextLine().toLowerCase(), sword.getatk())) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }

                }
            }
        }
    }
}