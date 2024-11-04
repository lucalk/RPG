import java.util.ArrayList;
import java.util.Scanner;
public abstract class Personnage {
    private String name;
    private double money;
    private double health;
    private double attaque;
    private double speed;
    private Weapon weapon;
    private double lvl;
    private double xp;
    private ArrayList<Item> inventaire;

    public Personnage(String name) {
        this.name = name;
        this.money = 50;
        this.health = 200;
        this.attaque = 20;
        this.speed = 10;
        this.weapon = null;
        this.lvl = 1;
        this.xp = 0;
        this.inventaire = new ArrayList<>();
    }

    public Personnage(String name, double money, double health, double attaque, double speed, Weapon weapon,double lvl, double xp) {
        this.name = name;
        this.money = money;
        this.health = health;
        this.attaque = attaque;
        this.speed = speed;
        this.weapon = weapon;
        this.lvl = lvl;
        this.xp = xp;
        this.inventaire = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttaque() {
        return attaque + (weapon.damage/2);
    }

    public double getSpeed() {
        return speed;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapon w){
        this.weapon = w;
    }

    public double getLvl(){
        return lvl;
    }

    public double getXp(){
        return xp;
    }

    public void setXp(double xp){
        this.xp = xp;
    }

    public ArrayList<Item> getInventaire() {
        return inventaire;
    }

    public void displayInvetaire(){
        int n=1;
        for (Item i : this.inventaire) {
            System.out.println(n + "." + i.getName() + " (" + i.getClass().getSimpleName()+")");
            n++;
        }
    }

    public void showInventary(){
        if (this.inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide");
            System.out.println("==========");
            return;//Fin de la methode
        }
        Scanner scanner = new Scanner(System.in);
        String choix;

        System.out.println("Votre inventaire !");
        System.out.println(this.money + " pièces");
        displayInvetaire();

        while(true){
            System.out.println("Voulez-vous utiliser un objet ? (YES/NO)");
            choix = scanner.nextLine().toUpperCase();

            if(choix.equals("NO")){
                System.out.println("Fermeture de l'inventaire");
                break;//fin
            }

            if(choix.equals("YES")){
                System.out.println("Saisir l'emplacement de l'objet à utiliser");
                //int index = scanner.nextInt();
                //scanner.nextLine();

                int index = -1;
                try{
                    index = scanner.nextInt();
                    scanner.nextLine();
                }catch (Exception e){
                    System.out.println("Veuillez entrer un emplacement existant");
                    scanner.nextLine();
                    continue;
                }

                if(index > 0 && index <= inventaire.size()){
                    Item itemCible = this.inventaire.get(index-1);
                    System.out.println("Objet choisit : " + itemCible.name);

                    if(itemCible instanceof Weapon){
                        useWeapon((Weapon) itemCible);
                    } else if(itemCible instanceof Potion){
                        usePotion((Potion) itemCible);
                        this.inventaire.remove(itemCible);
                    }
                    displayInvetaire();
                }else{
                    System.out.println("Emplacement d'objet inexistant");
                }
            }
        }
    }

    private void useWeapon(Weapon weapon){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous utiliser l'objet ? (oui/non)");
        String choixAction = scanner.nextLine().toLowerCase();
        if (choixAction.equals("oui")) {
            this.setWeapon(weapon);
            System.out.println("Nouvelle arme équipée : " + weapon.getName());
            System.out.println("===========");
        } else {
            System.out.println("Arme non équipée");
        }
    }

    private void usePotion(Potion potion){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous utiliser l'objet ? (oui/non)");
        String choixAction = scanner.nextLine().toLowerCase();
        if (choixAction.equals("oui")) {
            //this.setHealth(this.health + potion.getEffect());
            potion.usePotion(this);
            System.out.println(this.getName() + " obtient " + potion.getEffect() + " pv grâce à " + potion.getName());
        } else {
            System.out.println("Potion non utilisée");
        }
    }

    public void setMoney(double money){
        this.money = money;
    }

    public void info(){
        System.out.println("Nom : " + name);
        System.out.println("Argent : " + money);
        System.out.println("Vie : " + health);
        System.out.println("Attaque : " + attaque);
        System.out.println("Vitesse : " + speed);
        System.out.println("Arme : " + this.weapon.name +
                " ( "+this.weapon.damage + " | " + this.weapon.price + " | " + this.weapon.monster_damage_ratio + " | " + this.weapon.obstacle_damage_ratio + " ) ");
        System.out.println(this.weapon.asciiArt());
    }

    public void addItem(Item item){
        inventaire.add(item);
        System.out.println("Item " + item.getName() + " à été ajouté à l'inventaire");
    }

    public void getDamage(double damage){
        this.health = this.health - damage;
    }

    public boolean isDefeated(){
        return this.health <= 0;
    }
}
