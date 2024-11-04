public class Monster extends Destructible{
    private String name;
    //Valeur de base pour la vie
    private static final double LIFE = 50;
    private double damage;
    private double xpReward;
    private int level;

    public Monster(String name, double damage, double xpReward){
        super(LIFE);
        this.name = name;
        this.damage = damage;
        this.xpReward = xpReward;
    }

    public Monster(String name, double damage, double xpReward, double pv){
        super(pv);
        this.name = name;
        this.damage = damage;
        this.xpReward = xpReward;
    }

    public String getName(){
        return name;
    }
    public double getDamage(){
        return damage;
    }
    public double getXpReward(){
        return xpReward;
    }
}
