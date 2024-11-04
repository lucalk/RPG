public class Destructible extends Cell {
    private double pv;

    public Destructible(double p){
        this.pv = p;
    }

    public double getPv(){
        return this.pv;
    }

    public void hit(double d){
        this.pv -= d;
    }

    public boolean isDefeated(){
        return this.pv <= 0;
    }

    public void setLife(double d){
        this.pv = d;
    }
}
