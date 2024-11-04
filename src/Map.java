import java.util.*;
public class Map {
    private Cell[][] place; // Represente le donjon
    private int joueurX;
    private int joueurY;

    private int exitX;
    private int exitY;

    public Map(int width, int height) {
        this.place = new Cell[width][height];
        initializeMap();

        // Emplacement initiale du joueur
        this.joueurX = 0;
        this.joueurY = 0;

        // Emplacement de la sortie
        this.exitX = width -1;
        this.exitY = height -1;
    }

    public int getJoueurX() {
        return joueurX;
    }
    public int getJoueurY() {
        return joueurY;
    }

    public void initializeMap() {
        //Initialiser la matrice avec des places vides
        for(int i = 0; i < place.length; i++) {
            for(int j = 0; j < place[i].length; j++) {
                place[i][j] = new Cell();
            }
        }

        for(int i = 0; i < place[0].length; i++) {
            place[i][1] = new Monster("Ptit pirate",5,3,7);
        }

        //Ajouter de cell
        place[1][0] = new Obstacle("Mur épais",50);
        place[1][2] = new Obstacle("Mur gris");
        place[2][2] = new Obstacle("Mur gris");
        place[2][1] = new Obstacle("Mur gris");
        place[2][4] = new Obstacle("Mur gris");
        place[3][4] = new Obstacle("Mur gris");
        place[3][5] = new Obstacle("Mur épais",40);
        place[4][4] = new Obstacle("Porte de fer",60);
        place[4][3] = new Obstacle("Porte de fer",60);

        place[0][5] = new Monster("Buggy le Clown",10,6);
        place[1][1] = new Monster("Don Krieg",12,90);
        place[1][4] = new Monster("Nezumi",6,4,7);
        place[4][5] = new Monster("Capitain Kuro",16,50,100);
        place[3][2] = new Monster("Alvida",10,5,10);
        place[3][3] = new Monster("Colonel Morgan",13,25);
        place[5][4] = new Monster("Arlong",20,60,120);

        place[0][4] = new Store();
        place[5][3] = new Store();
    }

    public boolean isExitReached(){
        return joueurX == exitX && joueurY == exitY;
    }

    // Symbole en fonction de l'instance
    public void displayMap(){
        System.out.println("------------------------------------");
        for(int i = 0; i < place.length; i++) {
            for(int j = 0; j < place[i].length; j++) {
                if(i == joueurY && j == joueurX) {
                    System.out.print("J "); //Joueur
                } else if (i == exitY && j == exitX) {
                    System.out.print("E ");
                }else if(place[i][j] instanceof Obstacle){
                    System.out.print("O ");
                }else if (place[i][j] instanceof Monster){
                    System.out.print("M ");
                }else if(place[i][j] instanceof Store){
                    System.out.print("S ");
                }else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }

    public void moveJoueur(Personnage joueur, String direction){
        switch (direction.toLowerCase()) {
            case "haut":
                if(joueurY > 0){
                    joueurY--;
                }
                break;
            case "bas" :
                if(joueurY < place.length-1){
                    joueurY++;
                }
                break;
            case "droite":
                if(joueurX < place[0].length-1){
                    joueurX++;
                }
                break;
            case "gauche":
                if(joueurX > 0){
                    joueurX--;
                }
                break;
            default:
                System.out.println("Direction invalide");
                return;
        }
        someTh(joueur); // Il y a quelque chose ?
    }

    // Le joueur rencontre quelque chose sur son chemin
    private void someTh(Personnage j){
        Cell currentCell = place[joueurY][joueurX];
        Scanner scanner = new Scanner(System.in);

        if (currentCell instanceof Obstacle){ // Rencontre un obstacle
            Obstacle obstacle = (Obstacle) currentCell;
            System.out.println("Il y a un obstacle à détruire");
            System.out.println("D'ou tu viens ? (haut|bas|gauche|droite)");
            String position = scanner.nextLine();
            System.out.println("Veux-tu fuire ? (oui/non)");
            String choix = scanner.nextLine();

            if(choix.equalsIgnoreCase("oui")){
                this.moveJoueur(j,position.toLowerCase());
                System.out.println("Ce n'est pas en fuyant que tu deviendras fort -_-");
            }else{
                obstacle.destroy(j);
                place[joueurY][joueurX] = new Cell();
                System.out.println("==========");
            }
        } else if (currentCell instanceof Monster){ // Rencontre un monstre
            Monster monster = (Monster) currentCell;
            System.out.println("Il y a un monstre à combattre");
            System.out.println("Veux-tu fuire ? (oui/non)");
            String choix = scanner.nextLine();

            if(choix.equalsIgnoreCase("non")){
                //Nouveau combat
                Fight combat = new Fight();
                combat.startFight(j,monster);

                if(monster.isDefeated()){
                    place[joueurY][joueurX] = new Cell();
                }
            }else if(choix.equalsIgnoreCase("oui")){
                System.out.println("Vers où ? (haut|bas|gauche|droite)");
                String position = scanner.nextLine();

                System.out.println("Fuite -> " + position.toLowerCase());
                this.moveJoueur(j,position.toLowerCase());

                System.out.println("Ce n'est pas en fuyant que tu deviendras fort -_-");
            }
        }else if(currentCell instanceof Store){ // Rencontre un store
            Store store = (Store) currentCell;
            System.out.println("Il y a un store");
            System.out.println("Voulez-vous y aller ? (oui/non)");
            String choix = scanner.nextLine();
            if(choix.equalsIgnoreCase("oui")){
                store.buyItem(j);
            }
        }
    }
}
