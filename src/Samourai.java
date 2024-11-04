public class Samourai extends Personnage{
    private static final Weapon defaultSword = new Sword("Fidele compagnon",0,5,0.8,1.2);
    private static final double dMoney = 50;
    private static final double dHealth = 70;
    private static final double dAttaque = 20;
    private static final double dSpeed = 15;
    private static final double dLvl = 1;
    private static final double dXp = 0;

    public Samourai(String name) {
        super(name, dMoney, dHealth, dAttaque, dSpeed, defaultSword, dLvl, dXp);
    }

    //Pour la suite
    public void scndAttack(Monster cible){
        cible.hit(getAttaque()/2);
    }


}
