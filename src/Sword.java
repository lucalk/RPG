public class Sword extends Weapon{
    private static final double DAMAGE = 17;
    private static final double PRICE = 10;
    private static final String NAME = "Sword";
    private static final double Monster_Damage_Ratio = 0.8;
    private static final double Obstacle_Damage_Ratio = 1.2;

    public Sword() {
        super(NAME,PRICE,DAMAGE,Monster_Damage_Ratio,Obstacle_Damage_Ratio);
    }

    public Sword(String nom, int prix, int dommage, double monsterDR, double obstacleDR) {
        super(nom,prix,dommage,monsterDR,obstacleDR);
    }

    @Override
    public String asciiArt(){
        return
                "           (   ) \n" +
                        "            | | \n" +
                        "            | | \n" +
                        "           _____ \n" +
                        "         |_______| \n" +
                        "            | | \n" +
                        "           | | \n" +
                        "           | | \n" +
                        "           | | \n" +
                        "           | | \n" +
                        "           | | \n" +
                        "            |_| \n";
    }


    public double getMonsterDamageRatio(){
        return Monster_Damage_Ratio;
    }

    public double getObstacleDamageRatio(){
        return Obstacle_Damage_Ratio;
    }
}
