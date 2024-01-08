public class Player {
    private int hp;
    public static int topscore;
    public boolean isDead;
    public Player(){
        hp = 100;
        isDead = false;
    }
    public void takeDamage(int dmg, int dodge){
        int random = (int)(Math.random()*100+1);
        if (random == dodge){
            System.out.println("You barely dodge " + dmg + " damage.");
        } else {
            System.out.println("You get whacked for " + dmg + " damage.");
            hp -= dmg;
        }
    }

}
