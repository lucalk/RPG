import java.util.ArrayList;
import java.util.Scanner;
public class Store extends Cell{
    private final ArrayList<Item> store;

    public Store(){
        this.store = new ArrayList<>();
        firstsWeapon();
        firstsPotions();
    }

    private void firstsWeapon(){
        Weapon laHache = new Bow("Tranche-cailloux",20,23,1.2,1.2);
        this.store.add(laHache);
        Weapon leMarteau = new Hammer("Le-Marteau",20,26,1.5,1.3);
        this.store.add(leMarteau);
        Weapon laLame = new Sword("Lame de la brise",20,20,1.1,1.3);
        this.store.add(laLame);
    }

    private void firstsPotions(){
        Potion mini = new Potion("Petite Potion",10,10);
        this.store.add(mini);
        Potion moyenne = new Potion("Moyenne Potion",12,15);
        this.store.add(moyenne);
        Potion grande = new Potion("Grande Potion",14,20);
        this.store.add(grande);
    }

    public ArrayList<Item> getStore(){
        return this.store;
    }

    public void printStore(){
        System.out.println("=== Vous entrez dans le magasin ===" );
        int p = 1;
        System.out.println("------------------------------------");
        for(Item item : getStore()){
            System.out.println(p +". " + item.name + " = " + item.price + " pièces");
            p++;
        }
        System.out.println("------------------------------------");
    }

    public void buyItem(Personnage personnage){
        Scanner scanner = new Scanner(System.in);
        printStore();

        boolean inStore = true;

        while(inStore){
            System.out.println("Voulez-vous acheter un item ?  (oui/non)");
            String choix = scanner.nextLine().toLowerCase();

            if(choix.equalsIgnoreCase("oui")){
                System.out.println("Votre solde est de " + personnage.getMoney() + " pièces");
                int place = 0;

                while (place < 1 || place > store.size()) { // Emplacement invalide
                    System.out.println("Veuillez entrer l'emplacement de l'item ");

                    if (scanner.hasNextInt()) {
                        place = scanner.nextInt();
                        scanner.nextLine();

                        if (place < 1 || place > store.size()) {
                            System.out.println("Emplacement inexistant. Veuillez réessayer.");
                        }
                    } else {
                        System.out.println("Veuillez saisir un nombre valide.");
                        scanner.nextLine();
                    }
                }

                // Emplacement valide
                Item itemSelected = store.get(place - 1);
                if (personnage.getMoney() >= itemSelected.price) {
                    personnage.addItem(itemSelected); // Ajout de l'item à l'inventaire
                    personnage.setMoney(personnage.getMoney() - itemSelected.price); // Paiement
                    System.out.println("Vous avez acheté : " + itemSelected.name + " pour " + itemSelected.price + " pièces");
                } else {
                    System.out.println("Vous n'avez pas assez d'argent !");
                }
            }else if(choix.equalsIgnoreCase("non")){
                inStore = false;
                System.out.println("Pas d'achat ... ");
                System.out.println("=== La sécurité vous à jeté dehors -_- ===");
            }
            }
    }
}
