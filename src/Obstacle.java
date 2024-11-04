public class Obstacle extends Destructible{
    private String type;
    private static final double LIFE = 30;
    private double currentLife;

    public Obstacle(String type) {
        super(LIFE);
        this.type = type;
        this.currentLife = LIFE;
    }

    public Obstacle(String type, double life) {
        super(life);
        this.type = type;
        this.currentLife = life;
    }

    public String getType(){
        return type;
    }

    public double getLife(){
        return currentLife;
    }

    public void setLife(double life){
        this.currentLife = life;
    }

    @Override
    public boolean isDefeated() {
        return currentLife <= 0;
    }

    public void destroy(Personnage j){
        while(!this.isDefeated()){
            this.setLife(this.getLife()-(j.getAttaque()*j.getWeapon().getObstacleDamageRatio()));
            System.out.println(j.getName() + " inflige des dégats à l'obstacle " + this.getType());
        }
        System.out.println(j.getName() + " à détruit l'obstacle " + this.getType());
    }
}
