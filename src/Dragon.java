public class Dragon {
    private int hp;
    private boolean isDead;
    private int power;
    private int dmg;
    private String name;
    private final String[] names = {"Claudia", "Clyde", "Stevie", "Steve", "Trelok", "Sayga", "Steven", "Bob", "Tira", "Joshua", "Chester", "Josh", "Eric"};
    public Dragon(){
        hp = 100;
        power = (int)(Math.random()*3+1);
        dmg = (int)((Math.random()*5+1)*power);
        isDead = false;
        name = names[(int)(Math.random()*names.length)];
    }
    public int recieve(int dmg){
        if (!isDead){
            hp -= dmg;
            if (hp<=0){
                hp = 0;
                isDead = true;
            }
            System.out.println("You hit " + name + " for " + dmg + " health, pissing it off.");
            return hp;
        } else {
            System.out.println("You beat the corpse of " + name + "pointlessly.");
            return hp;
        }
    }
    public int attack(){
        if (!isDead){
            System.out.println(name + " swipes back at you.");
            return dmg;
        } else {
            System.out.println(name + " cannot swipe back at you because it is dead.");
            return 0;
        }
    }

    public String getName(){
        return name;
    }
    public boolean isDead(){return isDead;}
    public String dragonInfo(){
        if (!isDead){
            return Colors.GREEN + name + " is rather large.\n" + name + "'s hobbies include:\n-Milking\n-Juicing\n-Burning\n-Reading\n-Burning again\n" + name + " has " + hp + " health." + Colors.RESET;
        } else {
            return Colors.RED + name + " is rather dead.\n" + name + "'s hobbies include:\n-Being dead\n-Lying there\n-Attracting flies\n-Rotting\n-Attracting maggots\n" + name + " is dead." + Colors.RESET;
        }
    }
    public void aftermath(){
        double random = Math.random()+1;
        if (random>0.8){
            
        }
    }
}
