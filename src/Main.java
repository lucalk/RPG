public class Main {
    public static void main(String[] args) {
        Sword lame = new Sword("Fidèle compagnon",10,13,0.9,0.7);

        Samourai moiS = new Samourai("RZ");
        Barbare moiB = new Barbare("RZ");
        Archer moiA = new Archer("RZ");

        Game game = new Game(moiS);

        game.start(moiS);
    }
}