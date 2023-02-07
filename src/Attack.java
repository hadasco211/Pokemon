public class Attack {
    private String attack;
    private int attackCost;
    private int attackDamage;

    public Attack(String attack, int attackCost, int attackDamage){
        this.attack = attack;
        this.attackCost = attackCost;
        this.attackDamage = attackDamage;
    }

    public String toString (){
        return "attack:" + " " + this.attack + "\n" +
                "cost:" + " " + this.attackCost + "\n" +
                "damage:" + " " + this.attackDamage;
    }

    public String getAttack() {
        return attack;
    }

    public int getAttackCost() {
        return attackCost;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
