public class Sword {
    private int atkdmg;
    private int dodge;
    public Sword(){
        atkdmg = 10;
        dodge = 20;
    }
    public int getatk(){
        return atkdmg;
    }
    public int getdodge(){return dodge;}
    public void updateatk(int atk){
        atkdmg = atk;
    }
    public void updatedodge(int dodge){
        this.dodge = dodge;
    }

}
