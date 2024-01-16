import java.util.Scanner;
public class Hunter {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Sword sword = new Sword();
    Player p1;
    public Hunter(){}
    public void start(){
        intro();
        if (turnback()) {
            menu();
        }
    }
    private void intro(){
        p1 = new Player();
        System.out.println("So, you're going to fight a dragon.");
        System.out.println(Colors.RED + "You must have a death wish.");
    }
    private boolean turnback(){
            System.out.println("____________________________________");
            System.out.println("(G)et going on your suicidal quest." + Colors.RESET);
            System.out.println(Colors.CYAN + "(T)urn back and reconsider your life options." + Colors.RESET);
            String choice = choose();
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
        while (!p1.isDead) {
            Room.spawn(p1);
            while (!Room.roomClear()) {
                if (Room.dragonamt()>1) {
                    System.out.println(Colors.GREEN + "____________________________________");
                    System.out.println(Colors.RED + "(S)tab the dragons.");
                    System.out.println(Colors.BLUE + "(L)ook around.");
                    System.out.println(Colors.PURPLE + "(C)heck out the dragons.");
                    String choice = choose();
                    if (choice.equals("s")) {
                        System.out.print(Colors.RED + "Which dragon? " + Colors.RESET);
                        String p = SCANNER.nextLine();
                        if (Room.findDragon(p)) {
                            p1.takeDamage(Room.attack(p, sword.getatk()), sword.getdodge());
                            while (!Room.getThedragon().isDead()&&!p1.isDead) {
                                onedragon();
                            }
                        } else {
                            System.out.println("What?");
                        }
                        Room.update();
                        System.out.println(Room.getnames());
                    }
                    if (choice.equals("c")) {
                        System.out.print(Colors.RED + "Which dragon? " + Colors.RESET);
                        System.out.println(Room.dragonInfo(SCANNER.nextLine()));
                        System.out.println(Colors.GREEN + Room.getnames() + " wait for you to attack." + Colors.GREEN);
                    }
                } else {
                    onedragon();
                }
            }
        }
        System.out.println(Colors.PURPLE + "The dragonslayer has become the dragonslayed.");
        System.out.println(Colors.RED + "You're dead!");
        System.out.println(Colors.GREEN + "The old man was right, you do have a death wish.");
    }
    private void onedragon(){
        System.out.println(Colors.GREEN + "____________________________________");
        System.out.println(Colors.RED + "(S)tab the dragon.");
        System.out.println(Colors.BLUE+ "(L)ook around.");
        System.out.println(Colors.PURPLE + "(C)heck out the dragon.");
        String choice = choose();
        if (choice.equals("s")) {
            p1.takeDamage(Room.attack(sword.getatk()), sword.getdodge());
        }
        if (choice.equals("c")) {
            System.out.println(Room.dragonInfo());
        }
    }
    private String choose(){
        System.out.print(Colors.RESET + "Choose: ");
        String choice = SCANNER.nextLine().toLowerCase();
        if (choice.length() != 0) {
            choice = choice.substring(0, 1);
        }
        return choice;
    }
}
