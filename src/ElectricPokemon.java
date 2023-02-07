public abstract class ElectricPokemon extends Pokemon {
    private double chargePercent;

    //o(1)
    public ElectricPokemon(){

    }

    //o(1)
    public ElectricPokemon(String pokemonName,String kind, int level, int maxLifePoints, int currentLifePoints, int maxAttackPoint, double currentAttackPoints, Attack[] attacks, double chargePercent) {
        super(pokemonName,kind, level, maxLifePoints, currentLifePoints, maxAttackPoint, currentAttackPoints, attacks);
        this.chargePercent = chargePercent;
    }

    //o(1)
    public void charge(){
        if (this.getCurrentLifePoints() < 0.2 *this.getMaxLifePoints()) {
            this.chargePercent = 0;
        }else
            this.chargePercent += 0.05;
    }

    public void special(){
        setCurrentAttackPoints(getMaxAttackPoint());
        setCurrentLifePoints(getMaxLifePoints());
    }
}
