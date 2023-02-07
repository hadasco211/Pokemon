import java.util.Random;

public class Blitzle extends ElectricPokemon{


    //o(1)
    public Blitzle(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, double currentAttackPoints, Attack[] attacks, double chargePercent) {
        super("blitzle","electric", 1, 90, 90, 35, 26.25, null, 0);
    }


    //o(1)
    public void upgrade() {
        String newName;
        Random random = new Random();
        int attackDamage;

        newName = "zebstrika";
        attackDamage = random.nextInt(30, 35);
        Attack zapKick = new Attack("Zap Kick", 30, attackDamage);
        this.setCurrentLifePoints(this.getCurrentLifePoints() - 20);
        this.setCurrentAttackPoints(this.getCurrentAttackPoints() - 25);
        this.setLevel(2);
        this.setMaxLifePoints(100);
        this.setMaxAttackPoint(50);
        upgradeFromPokemon(newName, zapKick);

    }

}