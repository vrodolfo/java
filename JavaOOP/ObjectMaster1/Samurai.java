class Samurai extends Human {
    
    public void throwSomething(){
        System.out.println("Throwing Rocks.......");
        super.decreaseEnergyLevel(5);
    }

    public void eatBananas() {
        System.out.println("Eating Bananas");
        super.decreaseEnergyLevel(-10);
    }

    public void climb() {
        System.out.println("huhu hu climbing");
        super.decreaseEnergyLevel(10);
    }
}
