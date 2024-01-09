public class Player {
    private int hp;
    public static int topscore;
    public boolean isDead;
    public Player(){
        hp = 100;
        isDead = false;
    }
    public void takeDamage(int dmg, int dodge) {
        if (dmg == -1) {
            System.out.println("You might want to move on.");
        } else {
            int random = (int) (Math.random() * 100 + 1);
            if (random <= dodge) {
                System.out.println(Colors.CYAN + "You barely dodge " + dmg + " damage." + Colors.RESET);
            } else {
                System.out.println(Colors.RED + "You get whacked for " + dmg + " damage." + Colors.RESET);
                hp -= dmg;
            }
        }
    }

}
