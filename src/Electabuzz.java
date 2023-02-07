import java.util.Random;

public class Electabuzz extends ElectricPokemon{



    //o(1)
    public Electabuzz(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, int currentAttackPoints, Attack[] attacks, double chargePercent) {
        super("electabuzz","electric", 1, 30, 30, 100, 75, null, 0);
    }



    //o(1)
    public void upgrade(){
        String newName;
        Random random = new Random();
        int attackDamage;

        newName = "Electivire";
        attackDamage = random.nextInt(50,120);
        Attack thunderPunch= new Attack("Thunder Punch",80, attackDamage);
        this.setCurrentLifePoints(this.getCurrentLifePoints()-20);
        this.setCurrentAttackPoints(this.getCurrentAttackPoints() -25);
        this.setLevel(2);
        this.setMaxLifePoints(35);
        this.setMaxAttackPoint(120);
        upgradeFromPokemon(newName,thunderPunch);
    }


}
