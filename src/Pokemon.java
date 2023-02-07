import java.util.Random;


public abstract class Pokemon {

    private String pokemonName;
    private String kind;
    private boolean turn;
    private int level;
    private int maxLifePoints;
    private int currentLifePoints;
    private int maxAttackPoint;
    private double currentAttackPoints;

    private Attack[] attacks;

    //o(1)
    public Pokemon(){

    }
    //o(1)
    public Pokemon(String pokemonName, String kind, int level,int maxLifePoints,int currentLifePoints,int maxAttackPoint,double currentAttackPoints,Attack[] attacks){
        this.pokemonName = pokemonName;
        this.kind = kind;
        this.level = level;
        this.turn = false;
        this.maxLifePoints = maxLifePoints;
        this.currentLifePoints = currentLifePoints;
        this.maxAttackPoint = maxAttackPoint;
        this.currentAttackPoints = currentAttackPoints;
        Attack kick = new Attack("kick",0,2);
        Attack[] attacks1 = {kick};
        this.attacks = attacks1;
    }


    //o(1)
    public String toString() {
        return "pokemon:" + " " + this.pokemonName + "\n" +
                "amount of life points:" + " " + this.currentLifePoints + "\n" +
                "amount of attack points:" + " " + this.currentAttackPoints;
    }

    public boolean isTurn() {
        return turn;
    }

    public String getKind() {
        return kind;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    //o(1)
    public int getCurrentLifePoints() {
        return currentLifePoints;
    }
    //o(1)
    public void setCurrentLifePoints(int currentLifePoints) {
        this.currentLifePoints = currentLifePoints;
    }

    //o(1)
    public int getMaxLifePoints() {
        return maxLifePoints;
    }
    //o(1)
    public int getLevel() {
        return level;
    }
    //o(1)
    public double getCurrentAttackPoints() {
        return currentAttackPoints;
    }
    //o(1)
    public void setCurrentAttackPoints(double currentAttackPoints) {
        this.currentAttackPoints = currentAttackPoints;
    }
    //o(1)
    public String getPokemonName() {
        return pokemonName;
    }
    //o(1)
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
    //o(1)
    public void setLevel(int level) {
        this.level = level;
    }
    //o(1)
    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }
    //o(1)
    public int getMaxAttackPoint() {
        return maxAttackPoint;
    }
    //o(1)
    public void setMaxAttackPoint(int maxAttackPoint) {
        this.maxAttackPoint = maxAttackPoint;
    }
    //o(1)
    public Attack[] getAttacks() {
        return attacks;
    }
    //o(1)
    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    //o(1)
    public Attack kick(){
        Attack kick = new Attack("kick",0,2);
        return kick;
    }

    //o(1)
    public void attackCost (int cost) {
        if (cost > getCurrentAttackPoints()){
            System.out.println("You don't have enough attack points");
        }else {
            double currentPoints = (getCurrentAttackPoints() - cost);
            setCurrentAttackPoints(currentPoints);
        }
    }

    public int getDamage(){
        int attackDamage = 0;
        for (int i = 0; i < this.attacks.length; i++) {
            attackDamage = this.attacks[i].getAttackDamage();
        }
        return attackDamage;
    }

    public int getAttackCost(){
        int attackCost = 0;
        for (int i = 0; i < this.attacks.length; i++) {
            attackCost = this.attacks[i].getAttackDamage();
        }
        return attackCost;
    }

    //o(n)
    public void upgradeFromPokemon(String pokemonName , Attack newAttack){
        this.setPokemonName(pokemonName);
        Attack[]newAttacks = new Attack[this.attacks.length+1];
        newAttacks[0] = newAttack;
        for (int i = 0; i < this.attacks.length; i++) {
            newAttacks[i + 1] = this.attacks[i];
        }
        setAttacks(newAttacks);
    }
    public abstract void upgrade();
    public abstract void charge();
    public abstract void special();

    //o(1)
    public static Pokemon randomPokemon() {
        Random random = new Random();
        Pokemon randomPokemonPick = null;
        int randomPokemon = random.nextInt(1, 6);
        switch (randomPokemon) {
            case 1:
                System.out.println("your pokemon is charmander");
                randomPokemonPick = new Charmander("Charmander","fire", 1, 80, 80, 40, 30, null);
                Attack scratch = new Attack("Scratch", 15, random.nextInt(25, 30));
                Attack[] charmanderAttacks = {scratch};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(), scratch);
                break;
            case 2:
                System.out.println("your pokemon is salandit");
                randomPokemonPick = new Salandit("salandit","fire", 1, 100, 100, 60, 45, null);
                Attack liveCoal = new Attack("Live Coal",10,random.nextInt(0,25));
                Attack[] salanditAttacks = {liveCoal};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(),liveCoal);
                break;
            case 3:
                System.out.println("your pokemon is moltres");
                randomPokemonPick = new Moltres("moltres","fire", 1, 120, 120, 60, 45, null);
                Attack assistingHeater = new Attack("Assisting Heater",30,random.nextInt(10,60));
                Attack fireWing = new Attack("Fire Wing",30,30);
                Attack[] moltresAttacks = {assistingHeater,fireWing};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(),assistingHeater);//TODO

                break;
            case 4:
                System.out.println("your pokemon is pikachu");
                randomPokemonPick = new Pikachu("pichu","electric", 1, 40, 40, 30, 22.5, null, 0);
                Attack quickAttack = new Attack("Quick Attack",5,10);
                Attack[] pichuAttacks = {quickAttack};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(),quickAttack);
                break;
            case 5:
                System.out.println("your pokemon is blitzle");
                randomPokemonPick = new Blitzle("blitzle","electric", 1, 90, 90, 35, 26.25, null, 0);
                Attack flop = new Attack("Flop",20,random.nextInt(20,25));
                Attack[] blitzleAttacks = {flop};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(),flop);
                break;
            case 6:
                System.out.println("your pokemon is electabuzz");
                randomPokemonPick = new Electabuzz("electabuzz","electric", 1, 30, 30, 100, 75, null, 0);
                int attackDamage = random.nextInt(40,50);
                Attack thunder = new Attack("Thunder",60, random.nextInt(40,50));
                Attack[] electabuzzAttacks = {thunder};
                randomPokemonPick.upgradeFromPokemon(randomPokemonPick.getPokemonName(),thunder);
                break;
        }
        return randomPokemonPick;
    }


    public void waitingTurn(){
        Random random = new Random();
        int bonus = random.nextInt(1,3);
        switch (bonus){
            case 1:
                int bonusLifePoints = random.nextInt(5,30);
                setCurrentLifePoints(bonusLifePoints);
                System.out.println("You got a bonus of life points" + bonusLifePoints);
                break;
            case 2:
                int bonusAttackPoints = random.nextInt(0,40);
                setCurrentAttackPoints(bonusAttackPoints);
                System.out.println("You got a bonus of attack points" + bonusAttackPoints);
                break;
            case 3:
                //TODO

        }
    }
}
