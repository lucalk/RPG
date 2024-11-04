import java.util.Scanner;
public class Fight {

    public void startFight(Personnage joueur, Monster monstre){
        Scanner scanner = new Scanner(System.in);
        System.out.println(monstre.getName() + " apparait !");

        int tour = 1;
        while(!joueur.isDefeated() && !monstre.isDefeated()){
            System.out.println("---------------------------------------");
            System.out.println("Tour n°" + tour);
            displayHealth(joueur,monstre);
            System.out.println("Voulez-vous : 1.attaquer | 2.passer votre tour ?");
            int choix = scanner.nextInt();
            if(choix == 1){
                playerAttack(joueur,monstre);
            }else if(choix == 2){
                passTour();
            }else {
                System.out.println("Choix indexistant ! (1/2)");
                continue;// Reprends la boucle
            }

            if(!monstre.isDefeated()){
                monsterAttack(joueur,monstre);
            }

            if(monstre.isDefeated()){
                System.out.println("Vous avez vaincu " + monstre.getName());
                joueur.setXp(joueur.getXp() + monstre.getXpReward());
                System.out.println("Vous gagnez " + monstre.getXpReward() + " XP -_~ !");
            }

            if(joueur.isDefeated()){
                System.out.println("Vous avez été vaincu par " + monstre.getName());
            }
            tour++;
        }
    }

    private void displayHealth(Personnage j,Monster m){
        System.out.println("=== Vie des combattants ===");
        System.out.println(j.getName() + " possède " + j.getHealth() + " pv");
        System.out.println(m.getName() + " possède " + m.getPv() + " pv");
        System.out.println("============================");
    }

    private void playerAttack(Personnage j,Monster m){
        System.out.println("Attaque du joueur");
        m.hit(j.getAttaque()*j.getWeapon().getMonsterDamageRatio());
        System.out.println(m.getName() + " reçoit " + j.getAttaque() + " dégâts !");
    }

    private void monsterAttack(Personnage j,Monster m){
        System.out.println("Attaque du monstre");
        j.setHealth(j.getHealth() - m.getDamage());
        System.out.println(j.getName() + " reçoit " + m.getDamage() + " dégâts !");
    }

    private void passTour(){
        System.out.println("Vous passez votre tour");
    }
}
