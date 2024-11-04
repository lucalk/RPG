public abstract class Weapon extends Item {
    protected double damage;
    protected double monster_damage_ratio;
    protected double obstacle_damage_ratio;

    public Weapon (String name, double price, double damage, double monsterRatio, double obstacleRatio) {
        super(name,price);
        this.damage = damage;
        this.monster_damage_ratio = monsterRatio;
        this.obstacle_damage_ratio = obstacleRatio;
    }

    public double getMonsterDamageRatio(){
        return this.monster_damage_ratio;
    }

    public double getObstacleDamageRatio(){
        return this.obstacle_damage_ratio;
    }

    public abstract String asciiArt();

    public void attack(Monster m){
        m.hit(this.damage * this.getMonsterDamageRatio());
    }

    public void attack(Obstacle o){
        o.hit(this.damage * this.getObstacleDamageRatio());
    }

    @Override
    public String toString(){
        return this.name + " : dégats " + this.damage + " DGT ";
    }
}
