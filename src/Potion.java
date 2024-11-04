public class Potion extends Item{
    private int effect;

    public Potion(String name, double price, int effect) {
        super(name, price);
        this.effect = effect;
    }

    public double getEffect(){
        return this.effect;
    }

    public void usePotion(Personnage j){
        j.setHealth(j.getHealth() + effect);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public String asciiArt() {
        return "";
    }
}
