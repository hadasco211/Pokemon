import java.util.Random;
public class Pikachu extends ElectricPokemon{


    //o(1)
    public Pikachu(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, double currentAttackPoints, Attack[] attacks, double chargePercent) {
        super("pichu","electric", 1, 40, 40, 30, 22.5, null, 0);
    }


    //o(1)
    public void upgrade(){
        int level = this.getLevel();
        String newName;
        Random random = new Random();
        int attackDamage;
        switch (level){
            case 1:
                newName = "Pikachu";
                attackDamage = random.nextInt(30,40);
                Attack electroBall= new Attack("Electro Ball",10, attackDamage);
                this.setCurrentLifePoints(this.getCurrentLifePoints()-20);
                this.setCurrentAttackPoints(this.getCurrentAttackPoints() -25);
                this.setLevel(2);
                this.setMaxLifePoints(50);
                this.setMaxAttackPoint(40);
                upgradeFromPokemon(newName,electroBall);
            case 2:
                newName = "raichu";
                attackDamage = random.nextInt(20,120);
                Attack electricSurfer  = new Attack("Electric Surfer",60,attackDamage);
                this.setCurrentLifePoints(this.getCurrentLifePoints()-30);
                this.setCurrentAttackPoints(this.getCurrentAttackPoints() -40);
                this.setLevel(3);
                this.setMaxLifePoints(120);
                this.setMaxAttackPoint(80);
                upgradeFromPokemon(newName,electricSurfer);
        }
    }




}
