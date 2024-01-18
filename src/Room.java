public class Room {
    private static Dragon[] a;
    private Room(){}
    private static int b;
    private static Dragon thedragon;
    private static Player player;
    private static String names;
    private static boolean healthpot = false;
    private static String[] room = {"the lair", "the house", "the warehouse", "the castle", "the wall"};
    public static void spawn(Player p){
        b++;
        player = p;
        int random = (int)(Math.random()*5+1);
        a = new Dragon[random];
        names = "";
        a[0] = new Dragon(player);
        thedragon = a[0];
        for (int i = 1; i<random; i++){
            a[i] = new Dragon(player);
            while (a[i].getName().equals(a[i-1].getName())){
                a[i] = new Dragon(player);
            }
            // this code makes them all have the same name
            //todo: please implement a system where dragons with the same names all get hurt when you attack one
            //while (!a[i].getName().equals(a[i-1].getName())){
                //a[i] = new Dragon();
            //}
            names += a[i-1].getName() + ", ";
        }

        System.out.print(Colors.GREEN);
        if (random>2){
            names += "and " + a[random-1].getName();
            System.out.println(random + " dragons appear behind you.");
            System.out.println("Their names are " + names + ".");
        } else if (random == 2){
            names = a[0].getName() + " and " + a[1].getName();
            System.out.println(random + " dragons appear behind you.");
            System.out.println("Their names are " + names + ".");
        } else {
            names += a[0].getName();
            System.out.println("A dragon appears behind you.");
            System.out.println("Its name is " + names + ".");
        }
    }
    public static int attack(String getdragon, int dmg){
        getdragon = getdragon.toLowerCase();
        for (Dragon dragon : a){
            if (dragon.getName().toLowerCase().equals(getdragon)){
                if (dragon.isDead()){
                    dragon.aftermath();
                    System.out.println("The dragon has been slayed.");
                    return -1;
                }
                dragon.recieve(dmg);
                return dragon.attack();
            }
        }
        return 0;
    }
    public static int attack(int dmg){
        thedragon.recieve(dmg);
        if (!thedragon.isDead()) {
            return thedragon.attack();
        } else {
            thedragon.aftermath();
            return -1;
        }
    }
    public static boolean findDragon(String dragon){
        for (Dragon drag : a){
            if (dragon.equalsIgnoreCase(drag.getName())){
                thedragon = drag;
                return !drag.isDead();
            }
        }
        return false;
    }
    public static String dragonInfo(String dragon){
        dragon = dragon.toLowerCase();
        for (int i = 0; i<a.length; i++){
            if (a[i].getName().toLowerCase().equals(dragon)) {
                return a[i].dragonInfo();
            }
        }
        return "This dragon isn't here right now. I'll tell you later.";
    }
    public static String dragonInfo(){
        return thedragon.dragonInfo();
    }
    public static String getnames(){
        return names;
    }
    public static boolean roomClear(){
        int b = 0;
        for (Dragon dragon : a){
            if (dragon.isDead()){
                b++;
            }
        }
        return b == a.length;
    }
    public static boolean lookaround(){
        double random = Math.random()+1;
        if (random<=0.4){
            System.out.println(Colors.GREEN + "You found a health pot!");
            if (!healthpot) {
                System.out.println("Well, you're hanging onto that."+ Colors.RESET);
                healthpot = true;
            } else {
                System.out.println("Wait, you already have one. Nevermind." + Colors.RESET);
            }
        } else {
            System.out.println(Colors.GREEN + "Over in the corner, you find a spider stuck in its web.");
            System.out.println("The spider appears to have been trying to catch three flies at once,");
            System.out.println("and got itself tangled helplessly as a result.");
            System.out.println("This presents no irony to you in any way, shape or form.");
            System.out.println("You don't find anything else." + Colors.RESET);
        }
        return healthpot;
    }
    public static void heal(Player player){
        System.out.println(Colors.GREEN + "You greedily guzzle down your health pot.");
        player.setHp(50+player.getHp());
        System.out.println(Colors.RED + "HP: " + player.getHp() + Colors.RESET);
    }
    public static int dragonamt(){
        int b = 0;
        for (Dragon dragon : a){
            if (!dragon.isDead()){
                b++;
            }
        }
        return b;
    }
    public static int deaddragons(){
        int b = 0;
        for (Dragon dragon : a){
            if (dragon.isDead()){
                b++;
            }
        }
        return b;
    }
    public static Dragon getThedragon(){
        return thedragon;
    }
    public static void update(){
        names = "";
        for (int i = 1; i<a.length; i++){
            if (!a[i-1].isDead()){
                names += a[i-1].getName() + ", ";
            }
        }
        if (dragonamt()==1){
            if (names.equals("")){
                names = a[a.length-1].getName();
            }
            if (names.contains(", ")){
                names = names.substring(0, names.indexOf(",")) + names.substring(names.indexOf(",") + 1);
            }
            names = Colors.RED + "Only " + names + " remains.";
        } else if (dragonamt()==2){
            if (!a[a.length - 1].isDead()) {
                names = names.substring(0, names.indexOf(",")) + names.substring(names.indexOf(",") + 1);
                names += "and " + a[a.length - 1].getName();
            } else {
                names = names.substring(0, names.indexOf(",")) + "and" + names.substring(names.indexOf(",") + 1);
                names = names.substring(0, names.indexOf(",")) + names.substring(names.indexOf(",") + 1);
            }
            names = Colors.RED + "Only " + names + " remain.";
        } else {
            names += "and " + a[a.length-1].getName();
            names = Colors.RED + "Only " + names + " remain.";
        }
        //todo: names removes any dead dragons from itself
    }
    public static String getRoomName(){
        return room[b-1];
    }

}
