import java.util.*;
public class Game {
    private Personnage joueur;
    private Map donjon;

    public Game(Personnage joueur) {
        this.joueur = joueur;
        this.donjon = new Map(6,6);
    }

    public void start(Personnage j){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue sur EastBlue " + joueur.getName() + " !");

        boolean jeuEnCours = true;

        while(jeuEnCours){
            if(j.isDefeated()){
                jeuEnCours = false;
                System.out.println("Un autre deviendra le Roi des Pirates");
                break;
            }

            donjon.displayMap();//Afficher la map
            System.out.println("=== Position du joueur " + joueur.getName() + " : " + donjon.getJoueurX()+","+donjon.getJoueurY() + " ===");

            System.out.println(" == Que voulez-vous faire ? == ");
            System.out.println("------------------------------------");
            System.out.println("1. Se déplacer (haut|bas|gauche|droite)");
            System.out.println("2. Consulter l'inventaire");
            System.out.println("3. Quitter le jeu");
            System.out.println("4. Infos du joueur");
            System.out.println("------------------------------------");
            System.out.println("Alors ? : ");
            System.out.println("======");
            int choix = scanner.nextInt();
            System.out.println("======");

            switch (choix){
                case 1:
                    System.out.println("Saisir la direction que vous voulez (haut|bas|gauche|droite)");
                    String direction = scanner.next();
                    donjon.moveJoueur(joueur, direction);

                    if(donjon.isExitReached()){
                        System.out.println("Bien tu as trouvé RedLine");
                        jeuEnCours = false;
                    }
                    break;
                case 2:
                    joueur.showInventary();
                    break;
                case 3:
                    System.out.println("Tu ne peux pas devenir le Roi des Pirates si tu abandonnes");
                    jeuEnCours = false;
                    break;
                case 4:
                    j.info();
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
        scanner.close();
    }
}
