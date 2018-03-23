class Dragon extends Mammal {

    public Dragon(){
        super.setEnergyLevel(300);
    }
    
    public void fly(){
        System.out.println("I wanna flyyyyy.......");
        super.decreaseEnergyLevel(50);
    }

    public void eatHumans() {
        System.out.println("Eating.....");
        super.decreaseEnergyLevel(-25);
    }

    public void attackTown() {
        System.out.println("Town on FIREEEEE");
        super.decreaseEnergyLevel(100);
    }
}
