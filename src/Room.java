public class Room {
    private static Dragon[] a;
    private Room(){}
    public static void spawn(){
        int random = (int)(Math.random()*10+1);
        a = new Dragon[random];
        String names = "";
        a[0] = new Dragon();
        for (int i = 1; i<random-1; i++){
            a[i] = new Dragon();
            if (a[i].getName().equals(a[i-1].getName())){
                a[i] = new Dragon();
            }
            names += a[i].getName() + ", ";
        }
        a[random-1] = new Dragon();
        names += "and " + a[random-1].getName();
        if (random>2){
            System.out.println(random-1 + " dragons appear behind you.");
            System.out.println("Their names are " + names + ".");
        } else {
            System.out.println("A dragon appears behind you.");
            System.out.println("Its name is " + names + ".");
        }
    }
    public static int attack(String dragon, int dmg){
        dragon = dragon.toLowerCase();
        for (int i = 0; i<a.length; i++){
            if (a[i].getName().toLowerCase().equals(dragon)){
                a[i].recieve(dmg);
                return a[i].attack();
            }
        }
        return 0;
    }
    public static boolean roomClear(){
        for (int i = 0; i<a.length; i++){
            if (!a[i].isDead()){
                return false;
            }
        }
        return true;
    }

}
