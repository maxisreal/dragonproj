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
            names += a[i].getName() + ", ";
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
        for (Dragon dragon : a){
            if (dragon.isDead()){
               names = names.substring(0, names.indexOf(dragon.getName())) + names.substring(names.indexOf(dragon.getName())+dragon.getName().length()+1);
            }
        }
        //todo: names removes any dead dragons from itself
    }

}
