import java.util.Random;

public class Salandit extends FirePokemon {



    //o(1)
    public Salandit(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, int currentAttackPoints, Attack[] attacks) {
        super("salandit","electric", 1, 100, 100, 60, 45, null);
    }



    //o(1)
    public void upgrade(){

        String newName  = "salazzle";;
        Random random = new Random();
        int attackDamage;
        attackDamage = random.nextInt(0,50);
        Attack fireClaws= new Attack("Fire Claws",10, attackDamage);
        this.setCurrentLifePoints(this.getCurrentLifePoints()-20);
        this.setCurrentAttackPoints(this.getCurrentAttackPoints() -25);
        this.setLevel(2);
        this.setMaxLifePoints(160);
        this.setMaxAttackPoint(80);
        upgradeFromPokemon(newName,fireClaws);

    }

}
