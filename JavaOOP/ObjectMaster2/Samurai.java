class Samurai extends Human {
    public static int globalInt = 0;
    public Samurai(){
        super.setHealth(200);
        globalInt ++;
    }

    public void deathBlow(Human human) {
        human.setHealth(0);
        super.decreaseHealth(super.getHealth()/2);
        System.out.println("Killing Human: " + human.getHealth());
    }

    public void meditate() {
        super.increaseHealth(super.getHealth()*2);
        System.out.println("Healing...New Health: " + super.getHealth());
    }

    public void howMany() {
        System.out.println("Samurais: " + globalInt);
    }
}
