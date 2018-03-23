class Human{
    private int health;
    private int strength;
    private int stealth;
    private int intelligence;

    public Human() {
        health = 3;
        strength = 3;
        stealth = 3;
        intelligence = 3;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }
    public int getStrength(){
        return strength;
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }
    public int getStealth(){
        return stealth;
    }

    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public int getIntelligence(){
        return intelligence;
    }

    public void decreaseHealth(int value){
        health = health - value;
    }

    public void increaseHealth(int value){
        health = health + value;
    }

    public void attack(Human human) {
        human.decreaseHealth(this.strength);
        System.out.println("Attacking Human: " + human.getHealth());
    }

}
