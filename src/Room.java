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
        for (int i = 1; i<random-1; i++){
            a[i] = new Dragon();
            if (a[i].getName().equals(a[i-1].getName())||a[i]==null){
                a[i] = new Dragon();
            }
            names += a[i].getName() + ", ";
        }
        a[random-1] = new Dragon();
        if (random>2){
            names += "and " + a[random-1].getName();
            System.out.println(random-1 + " dragons appear behind you.");
            System.out.println("Their names are " + names + ".");
        } else {
            names += a[random-1].getName();
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
        return -1;
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

    public static int attack(int dmg){
        thedragon.recieve(dmg);
        return thedragon.attack();
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
        return a.length;
    }
    public static Dragon getThedragon(){
        return thedragon;
    }

}
