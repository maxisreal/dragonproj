public class Player {
    private int hp;
    private Sword sword;
    public static int topscore;
    private boolean isDead;
    public Player(){
        hp = 100;
        sword = new Sword();
        isDead = false;
    }

}
