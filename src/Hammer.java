public class Hammer extends Weapon{
    private static final double DAMAGE = 23;
    private static final double PRICE = 8;
    private static final String NAME = "Hammer";
    private static final double Monster_Damage_Ratio = 1.3;
    private static final double Obstacle_Damage_Ratio = 1.1;

    public Hammer(){
        super(NAME,PRICE,DAMAGE,Monster_Damage_Ratio,Obstacle_Damage_Ratio);
    }

    public Hammer(String nom, int prix, int dommage, double monsterDR, double obstacleDR) {
        super(nom,prix,dommage,monsterDR,obstacleDR);
    }

    @Override
    public String asciiArt() {
        return
                        "          _______ \n" +
                        "        |         | \n" +
                        "        |_________| \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "            |_| \n";
    }

    public double getMonsterDamageRatio(){
        return Monster_Damage_Ratio;
    }

    public double getObstacleDamageRatio(){
        return Obstacle_Damage_Ratio;
    }
}
