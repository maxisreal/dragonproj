import java.util.Scanner;
public class Hunter {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Sword sword = new Sword();
    private boolean lookaround;
    private boolean havePot;
    Player p1 = new Player(sword);
    public Hunter(){}
    public void start(){
        intro();
        if (turnback()) {
            menu();
        }
        while (replay()){
            if (turnback()) {
                menu();
            }
        }
    }
    private void intro(){
        System.out.println("So, you're going to fight a dragon.");
        System.out.println(Colors.RED + "You must have a death wish.");
        lookaround = false;
        havePot = false;
    }
    private boolean turnback() {
        System.out.println("____________________________________");
        System.out.println("(G)et going on your suicidal quest." + Colors.RESET);
        System.out.println(Colors.CYAN + "(T)urn back and reconsider your life options." + Colors.RESET);
        if (p1.getTopscore() > 0) {
            System.out.println(Colors.PURPLE + "(V)iew your top score." + Colors.RESET);
        }
        String choice = choose();
        if (choice.equals("t")) {
            System.out.println("Good on ye.");
            return false;
        } else if (choice.equals("g")) {
            System.out.println("No. Why? WHY? Why won't you listen to-" + Colors.GREEN);
            System.out.println("In the distance, you spot a cavern. It's derelict, looks abandoned,");
            System.out.println("and is in no state to house a dragon.");
            System.out.print("In the spirit of adventure, you boldly enter, ");
            System.out.println("hoping to find some goodies.");
            System.out.println("The cavern rumbles...");
            return true;
        } else if (choice.equals("v") && p1.getTopscore() > 0){
            System.out.println(Colors.PURPLE + "It's " + p1.getTopscore() + Colors.RESET);
            return false;
        } else {
            System.out.println("You're speaking nonsense. You're in no state to do this.");
            System.out.println(".......\n...I'm sending you home.");
            return false;
        }
    }
    private boolean replay(){
        System.out.print(Colors.GREEN + "Play again? y/n: " + Colors.RED);
        String choice = SCANNER.nextLine().toLowerCase();
        if (choice.length() != 0) {
            choice = choice.substring(0, 1);
        }
        if (choice.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    private void menu(){
        while (!p1.isDead&&Room.roomsCleared()<5) {
            Room.spawn(p1);
            lookaround = false;
            while (!Room.roomClear()&&!p1.isDead) {
                if (Room.dragonamt()>1) {
                    System.out.println(Colors.GREEN + "____________________________________");
                    System.out.println(Colors.RED + "(S)tab the dragons.");
                    if (!lookaround) {
                        System.out.println(Colors.BLUE + "(L)ook around.");
                    }
                    if (havePot){
                        System.out.println(Colors.YELLOW + "(G)et some health back.");
                    }
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
                            Room.update();
                        } else {
                            System.out.println("What?");
                        }
                        if (!p1.isDead) {
                            System.out.println(Room.getnames());
                        }
                    }
                    if (choice.equals("c")) {
                        System.out.print(Colors.RED + "Which dragon? " + Colors.RESET);
                        System.out.println(Room.dragonInfo(SCANNER.nextLine()));
                        System.out.println(Colors.YELLOW + Room.getnames() + Colors.GREEN);
                    }
                    if (choice.equals("l")&&!lookaround){
                        havePot = Room.lookaround();
                        lookaround = true;
                        System.out.println(Colors.YELLOW + Room.getnames() + Colors.GREEN);
                    }
                    if (choice.equals("g")&&havePot&&p1.getHp()<100){
                        Room.heal(p1);
                        havePot = false;
                    }
                } else {
                    Room.lastman();
                    onedragon();
                }
            }
            if (!p1.isDead) {
                p1.updatedragons(Room.deaddragons());
                System.out.println(Colors.GREEN + "Every dragon here is dead.");
                System.out.print("Being the headstrong idiot you are, you immediately rush into ");
                String room =  Room.getRoomName();
                System.out.println(Colors.RED + room + "." + Colors.RESET);
                room = room.substring(0,1).toUpperCase() + room.substring(1);
                System.out.println(Colors.RED + room + " rumbles..." + Colors.RESET);
            }
            if (Room.roomsCleared()==5){
                System.out.println(Colors.PURPLE + "you win congrats");
                p1.calculateScore();
            }
        }
        System.out.println(Colors.PURPLE + "The dragonslayer has become the dragonslayed.");
        System.out.println(Colors.RED + "You're dead! GAME OVER YEAH!");
    }
    private void onedragon() {
            System.out.println(Colors.GREEN + "____________________________________");
            System.out.println(Colors.RED + "(S)tab the dragon.");
            if (!lookaround) {
                System.out.println(Colors.BLUE + "(L)ook around.");
            }
            if (havePot){
                System.out.println(Colors.YELLOW + "(G)et some health back.");
            }
            System.out.println(Colors.PURPLE + "(C)heck out the dragon.");
            String choice = choose();
            if (choice.equals("s")) {
                p1.takeDamage(Room.attack(sword.getatk()), sword.getdodge());
            }
            if (choice.equals("c")) {
                System.out.println(Room.dragonInfo());
            }
            if (choice.equals("l")&&!lookaround){
                havePot = Room.lookaround();
                lookaround = true;
                System.out.println(Colors.YELLOW + Room.getnames() + Colors.GREEN);
            }
            if (choice.equals("g")&&havePot&&p1.getHp()<100){
                Room.heal(p1);
                havePot = false;
            }
        }
    private String choose() {
        System.out.print(Colors.RESET + "Choose: ");
        String choice = SCANNER.nextLine().toLowerCase();
        if (choice.length() != 0) {
            choice = choice.substring(0, 1);
        }
        return choice;
    }

}
