public class Room {
    private Room(){}
    public static void spawn(){
        int random = (int)(Math.random()*10+1);
        Dragon[] a = new Dragon[random];
        String names = "";
        for (int i = 0; i<random-1; i++){
            a[i] = new Dragon();
            names += a[i].getName() + ", ";
        }
        a[random-1] = new Dragon();
        names += "and " + a[random-1].getName();

        System.out.println(random + " dragons appear behind you.");
        System.out.println("Their names are " + names + ".");
    }

}
