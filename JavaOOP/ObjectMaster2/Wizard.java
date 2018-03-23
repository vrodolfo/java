class Wizard extends Human {
    
    public Wizard(){
        super.setHealth(50);
        super.setIntelligence(8);
    }

    public void heal(Human human) {
        human.increaseHealth(super.getIntelligence());
        System.out.println("Healing Human: " + human.getHealth());
    }

    public void fireball(Human human) {
        human.decreaseHealth(super.getIntelligence()*3);
        System.out.println("Fireball Human: " + human.getHealth());
    }
}
