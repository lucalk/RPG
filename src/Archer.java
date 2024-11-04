public class Archer extends Personnage{
    private static final Weapon defaultBow = new Bow("Arc de Bois Sauvage",0,5,0.9,0.7);
    private static final double dMoney = 50;
    private static final double dHealth = 80;
    private static final double dAttaque = 10;
    private static final double dSpeed = 20;
    private static final double dLvl = 1;
    private static final double dXp = 0;

    public Archer(String name) {
        super(name, dMoney, dHealth, dAttaque, dSpeed, defaultBow, dLvl, dXp);
    }
//suite
}
