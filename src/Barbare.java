public class Barbare extends Personnage{
    private static final Weapon defaultHammer = new Hammer("Hache de pierre",0,7,0.9,1.4);
    private static final double dMoney = 50;
    private static final double dHealth = 80;
    private static final double dAttaque = 30;
    private static final double dSpeed = 10;
    private static final double dLvl = 1;
    private static final double dXp = 0;

    public Barbare(String name) {
        super(name, dMoney,dHealth,dAttaque,dSpeed,defaultHammer,dLvl,dXp);
    }
//suite
}
