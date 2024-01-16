public class Player {
    private int hp;
    public static int topscore;
    public boolean isDead;
    public Player(){
        hp = 100;
        //hp be 100
        isDead = false;
    }
    public void takeDamage(int dmg, int dodge) {
        if (!isDead) {
            hp -= dmg;
            if (hp < 0) {
                hp = 0;
                isDead = true;
                System.out.println("dead");
            }
            if (dmg == -1) {
                hp--;
            } else if (dmg == 0) {
                System.out.println("What?");
            } else {
                int random = (int) (Math.random() * 100 + 1);
                if (random <= dodge&&!isDead) {
                    System.out.println(Colors.CYAN + "You barely dodge " + dmg + " damage." + Colors.RESET);
                } else {
                    System.out.println(Colors.RED + "You get whacked for " + dmg + " damage.");
                    System.out.println("HP: " + hp + Colors.RESET);
                }
            }
        }
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

}
