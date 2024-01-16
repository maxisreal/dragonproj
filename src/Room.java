public class Room {
    private static Dragon[] a;
    private Room(){}
    private static Dragon thedragon;
    private static Player player;
    private static String names;
    public static void spawn(Player p){
        player = p;
        int random = (int)(Math.random()*5+1);
        a = new Dragon[random];
        names = "";
        a[0] = new Dragon();
        thedragon = a[0];
        for (int i = 1; i<random; i++){
            a[i] = new Dragon();
            while (a[i].getName().equals(a[i-1].getName())){
                a[i] = new Dragon();
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
            if (dragon.isDead()){
                dragon.aftermath(player);
                System.out.println("The dragon has been slayed.");
                return -1;
            }
            if (dragon.getName().toLowerCase().equals(getdragon)){
                thedragon = dragon;
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
            thedragon.aftermath(player);
            return -1;
        }
    }
    public static boolean findDragon(String dragon){
        for (Dragon drag : a){
            if (dragon.equalsIgnoreCase(drag.getName())){
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
    public static int dragonamt(){
        int b = 0;
        for (Dragon dragon : a){
            if (dragon.isDead()){
                b++;
            }
        }
        return a.length - b;
    }
    public static Dragon getThedragon(){
        return thedragon;
    }
    public static void update(){
        String temp = names;
        for (Dragon dragon : a){
            if (dragon.isDead()){
                names = temp.substring(0, temp.indexOf(dragon.getName()));
                if (temp.indexOf(dragon.getName()) + dragon.getName().length()+2<=temp.length()) {
                    names += temp.substring(temp.indexOf(dragon.getName()) + dragon.getName().length() + 2);
                } else {
                    names += temp.substring(temp.indexOf(dragon.getName()) + dragon.getName().length());
                }
                if (names.contains(", , ")) {
                    names = names.substring(0, names.indexOf(", , ")) + names.substring(names.indexOf(", , ") + 2);
                }
                //todo: FIX THIS
            }
        }
        if (dragonamt()==1&&names.contains("and")){
            names = names.substring(0, names.indexOf("and")) + names.substring(names.indexOf("and") + 3);
            names = Colors.RED + "Only " + names + " remains.";
        } else if (dragonamt()==2) {
            int c = 0;
            int b = 1;
            for (int i = 0; i<a.length; i++){
                if (!a[i].isDead() && c == 0){
                    c = i;
                } else {
                    b = i;
                }
            }
            names = Colors.RED + "Only " + a[c].getName() + " and " + a[b].getName() + " remain.";
        } else {
            names = Colors.RED + "Only " + names + " remain.";
        }
        //todo: names removes any dead dragons from itself
    }

}
