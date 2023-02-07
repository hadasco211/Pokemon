import java.util.Random;

public class Charmander extends FirePokemon {


    //o(1)
    public Charmander(String charmander,String fire, int i, int i1, int i2, int i3, int i4, Object o) {
        super("Charmander","fire", 1, 80, 80, 40, 30, null);
    }


    //o(1)
    public void upgrade(){
        int level = this.getLevel();
        String newName;
        Random random = new Random();
        int attackDamage;
        switch (level){
            case 1:
                newName = "charmelon";
                attackDamage = random.nextInt(25,30);
                Attack flameTail= new Attack("Flame Tail",40, attackDamage);
                this.setCurrentLifePoints(this.getCurrentLifePoints()-20);
                this.setCurrentAttackPoints(this.getCurrentAttackPoints() -25);
                this.setLevel(2);
                this.setMaxLifePoints(90);
                this.setMaxAttackPoint(60);
                upgradeFromPokemon(newName,flameTail);
            case 2:
                newName = "charizard";
                attackDamage = 50;
                Attack fieryBlast  = new Attack("Fiery Blast",50,attackDamage);
                this.setCurrentLifePoints(this.getCurrentLifePoints()-30);
                this.setCurrentAttackPoints(this.getCurrentAttackPoints() -40);
                this.setLevel(3);
                this.setMaxLifePoints(130);
                this.setMaxAttackPoint(80);
                upgradeFromPokemon(newName,fieryBlast);
        }
    }

}
