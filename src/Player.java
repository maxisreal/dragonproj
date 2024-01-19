public class Player {
    private int hp;
    public static int topscore;
    public boolean isDead;
    public Sword sword;
    public int score;
    private int gold;
    private int damage;
    private int deaddragons;
    public Player(Sword sword){
        hp = 100;
        //hp be 100
        isDead = false;
        this.sword = sword;
        score = 0;
        deaddragons = 0;
        damage = 0;
    }
    public void takeDamage(int dmg, int dodge) {
        if (!isDead) {
            hp -= dmg;
            damage += dmg;
            if (hp < 0) {
                hp = 0;
                isDead = true;
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
    public Sword getSword(){
        return sword;
    }
    public void calculateScore() {
        score += hp;
        score += (sword.getdodge()-20)/3;
        score += deaddragons;
        score += gold;
        score += damage;
        if (score > topscore){
            topscore = score;
        }
        System.out.println(Colors.GREEN + "Score: " + Colors.YELLOW + score);
        System.out.print(Colors.PURPLE + "Top score: " + Colors.GREEN + topscore + Colors.RESET);
    }
    public int getTopscore(){
        return topscore;
    }
    public int getScore(){
        return score;
    }
    public void updatedragons(int a){
        deaddragons += a;
    }
    public void updategold(int a){
        gold += a;
    }

}
