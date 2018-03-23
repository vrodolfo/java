class Ninja extends Human {
    
    public Ninja(){
        super.setStealth(10);
    }

    public void steal(Human human) {
        human.decreaseHealth(super.getStealth());
        super.increaseHealth(super.getStealth());
        System.out.println("Stealing from Human: " + super.getHealth());
    }

    public void runAway() {
        super.decreaseHealth(10);
        System.out.println("Runing...New Health: " + super.getHealth());
    }
}
