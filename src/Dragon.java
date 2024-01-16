public class Dragon {
    private int hp;
    private boolean isDead;
    private int power;
    private int dmg;
    private String name;
    private Player player;
    private final String[] names = {"Claudia", "Clyde", "Stevie", "Steve", "Trelok", "Sharon", "Steven", "Bob", "Tira", "Joshua", "Chester", "Josh", "Eric", "Rock", "Britney", "Kaizyle", "Nevaeh", "Phelony", "Abcde", "Moronica", "Scotthew"};
    public Dragon(Player player){
        this.player = player;
        hp = 100;
        power = (int)(Math.random()*3+1);
        dmg = (int)((Math.random()*5+1)*power);
        isDead = false;
        name = names[(int)(Math.random()*names.length)];
    }
    public int recieve(int dmg){
        if (!isDead&&!player.isDead){
            hp -= dmg;
            if (hp<=0){
                hp = 0;
                isDead = true;
                System.out.println(Colors.GREEN + "You deal a killing blow to " + name + ", killing it.");
            } else {
                System.out.println("You hit " + name + " for " + dmg + " health, pissing it off.");
            }
            return hp;
        } else {
            System.out.println(Colors.GREEN + "You beat the corpse of " + name + " pointlessly.");
            return hp;
        }
    }
    public int attack(){
        if (!isDead||hp<=0){
            System.out.println(name + " swipes back at you.");
            return dmg;
        } else {
            System.out.println(name + " cannot swipe back at you because it is dead.");
            return -1;
        }
    }

    public String getName(){
        return name;
    }
    public boolean isDead(){return isDead;}
    public String dragonInfo(){
        if (!isDead){
            return Colors.GREEN + name + " is rather large.\n" + name + "'s hobbies include:\n-Hating\n-Having a face only a mother could love\n-Burning\n-Reading\n-Burning again\n" + Colors.RED + name + " has " + hp + " health." + Colors.RESET;
        } else {
            return Colors.RED + name + " is rather dead.\n" + name + "'s hobbies include:\n-Being dead\n-Lying there\n-Attracting flies\n-Rotting\n-Attracting maggots\n"+ Colors.RED + name + " has the vitality of a corpse." + Colors.RESET;
        }
    }
    public void aftermath(){
        int random = (int)(Math.random()*4+1);
        System.out.print(Colors.GREEN);
        if (random==1){
            System.out.println("You get 50 gold.");
        } else if (random == 2){
            System.out.println("You get a sword upgrade.");
        } else if (random == 3) {
            System.out.println("You get nothing.");
        } else {
            System.out.println("You get 20 hp back.");
            player.setHp(player.getHp() + 20);
            System.out.println(Colors.RED + "HP: " + player.getHp() + Colors.RESET);
        }
    }
}
