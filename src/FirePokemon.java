import java.util.Random;

public abstract class FirePokemon extends Pokemon {

    //o(1)
    public FirePokemon() {

    }

    //o(1)
    public FirePokemon(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, double currentAttackPoints, Attack[] attacks) {
        super(pokemonName,kind, level, maxLifePoints, currentLifePoints, maxAttackPoint, currentAttackPoints, attacks);
    }

    //o(1)
    public void fireAttack(Pokemon pokemon){
        double probability = 0.25;
        Random random = new Random();
        if (probability > Math.random()){
            int damage = random.nextInt(3,10);
            loseLifePoints(damage,pokemon);
        }
    }
    public void charge(){}
    //o(1)
    public void loseLifePoints(int amount, Pokemon pokemon){
        int currentLifePoints = pokemon.getCurrentLifePoints();
        currentLifePoints -= amount;
        if (currentLifePoints < 0)
            currentLifePoints = 0;
    }

    public void special(){
        Random random = new Random();


        setCurrentAttackPoints(0);
        setCurrentLifePoints(getCurrentLifePoints()/2);
    }

}
