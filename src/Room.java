public class Room {
    private static Dragon[] a;
    private Room(){}
    private static Dragon thedragon;
    private static String names;
    public static void spawn(){
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
    public static int attack(String dragon, int dmg){
        dragon = dragon.toLowerCase();
        for (int i = 0; i<a.length; i++){
            if (a[i].isDead()){
                a[i].aftermath();
                System.out.println("The dragon has been slayed.");
                return -1;
            }
            if (a[i].getName().toLowerCase().equals(dragon)){
                thedragon = a[i];
                a[i].recieve(dmg);
                return a[i].attack();
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
        for (int i = 0; i<a.length; i++){
            if (a[i].isDead()){
               names = names.substring(0, names.indexOf(a[i].getName()));
               names += names.substring(names.indexOf(a[i].getName()) + a[i].getName().length());
            }
        }
        if (dragonamt()==1){
            names = Colors.GREEN + "Only " + names.substring(0, names.length() - 2) + " remains.";
        } else if (dragonamt()==2) {
            names = Colors.GREEN + "Only " + a[0].getName() + " and " + a[1].getName() + " remain.";
        } else {
            names = Colors.GREEN + "Only " + names + " remain.";
        }
        //todo: names removes any dead dragons from itself
    }

}
