public class Bow extends Weapon{
    private static final double DAMAGE = 20;
    private static final double PRICE = 9.50;
    private static final String NAME = "Axe";
    private static final double Monster_Damage_Ratio = 0.8;
    private static final double Obstacle_Damage_Ratio = 1.2;

    public Bow(){
        super(NAME,PRICE,DAMAGE,Monster_Damage_Ratio,Obstacle_Damage_Ratio);
    }

    public Bow(String nom, int prix, int dommage, double monsterDR, double obstacleDR) {
        super(nom,prix,dommage,monsterDR,obstacleDR);
    }

    @Override
    public String asciiArt() {
        return
                        "           ()                       \n" +
                        "            ||>>>                   \n" +
                        "            ||   >>>                \n" +
                        "            ||      >>>             \n" +
                        "        |   ||         >>>          \n" +
                        "        - ----||--------------->>>       \n" +
                        "        |   ||         >>>          \n" +
                        "            ||      >>>             \n" +
                        "            ||   >>>                \n" +
                        "            ||>>>                   \n" +
                        "           ()                       \n";
    }

    public double getMonsterDamageRatio(){
        return Monster_Damage_Ratio;
    }

    public double getObstacleDamageRatio(){
        return Obstacle_Damage_Ratio;
    }
}