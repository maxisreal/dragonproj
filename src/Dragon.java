public class Dragon {
    private int hp;
    private boolean isDead;
    private int power;
    private String name;
    private final String[] names = {"Claudia", "Clyde", "Stevie", "Steve", "Trelok", "Sayga", "Steven", "Bob", "Tira", "Joshua"};
    public Dragon(){
        hp = 100;
        power = (int)(Math.random()*3+1);
        isDead = false;
        name = names[(int)(Math.random()*names.length)];
    }
    public int attack(int damage){
        return 0;
        //placeholder
    }
    public String getName(){
        return name;
    }
}
